package com.unicauca.ejemplo.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author sahydo
 * */
public class SocketServer implements Runnable {
	private final int puerto = 5000;
	private DataInputStream entrada;
	private Socket so;
	private ServerSocket sc;
	private ObjectInputStream objectEntrada;
	private ObjectOutputStream objectSalida;

	public void initServer() {
		try {
			sc = new ServerSocket(puerto);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				System.out.println("Esperando una conexion:");
				so = sc.accept();
				Thread socket = new Thread(this);
				socket.start();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void sendData() {
		Persona persona = new Persona("1055245635", "Pepito Alberto", "Perez", 23);
		try {
			objectSalida = new ObjectOutputStream(so.getOutputStream());
			objectSalida.writeObject(persona);
			System.out.println("Enviando informacion desde el servidor:");
			System.out.println(persona.getIdentificacion());
			System.out.println(persona.getNombres());
			System.out.println(persona.getApellidos());
			System.out.println(persona.getEdad());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void receiveData() {
		try {
			objectEntrada = new ObjectInputStream(so.getInputStream());
			Persona persona = (Persona) objectEntrada.readObject();
			System.out.println("Recibiendo informacion en el servidor:");
			System.out.println(persona.getIdentificacion());
			System.out.println(persona.getNombres());
			System.out.println(persona.getApellidos());
			System.out.println(persona.getEdad());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String option;
		System.out.println("Un cliente se ha conectado.");
		System.out.println("Confirmando conexion al cliente....");
		try {
			entrada = new DataInputStream(so.getInputStream());
			option = entrada.readUTF();
			if (option.equals("send")) {
				receiveData();
			} else if (option.equals("receive")) {
				sendData();
			} else {
				System.out.println(option);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}