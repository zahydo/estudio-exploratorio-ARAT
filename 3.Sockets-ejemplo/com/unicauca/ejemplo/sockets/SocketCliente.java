package com.unicauca.ejemplo.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Sahydo
 */
public class SocketCliente {
	private final String HOST = "localhost";
	private final int PUERTO = 5000;
	private Socket sc;
	private DataOutputStream salidaEncabezado;

	private ObjectInputStream objectEntrada;
	private ObjectOutputStream objectSalida;

	public SocketCliente() {
		try {
			sc = new Socket(HOST, PUERTO);
			salidaEncabezado = new DataOutputStream(sc.getOutputStream());
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer conexión con el socket servidor");
		} catch (IOException e) {
			System.out.println("No se puedo establecer la conexión al socket servidor");
		}
	}

	public boolean sendData(Persona persona) {
		boolean flag = false;
		try {
			salidaEncabezado.writeUTF("send");
			objectSalida = new ObjectOutputStream(sc.getOutputStream());
			objectSalida.writeObject(persona);
			//sc.close();
			flag = true;
			return flag;
		} catch (IOException e1) {
			System.out.println("No se puede establecer conexion con el servidor");
			return flag;
		}
	}

	public Persona receiveData() {
		Persona persona = null;
		try {
			salidaEncabezado.writeUTF("receive");
			objectEntrada = new ObjectInputStream(sc.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			persona = (Persona) objectEntrada.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return persona;
	}

}
