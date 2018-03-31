package com.unicauca.ejemplo.sockets;
/**
 * @author sahydo
 * */
public class MainCliente {

	public static void main(String[] args) {
		SocketCliente cliente = new SocketCliente();
		Persona persona = new Persona("5165465", "Otros nombres", "Otros apellidos", 26);
		if (cliente.sendData(persona)) {
			System.out.println("Informacion enviada al servidor:");
			System.out.println(persona.getIdentificacion());
			System.out.println(persona.getNombres());
			System.out.println(persona.getApellidos());
			System.out.println(persona.getEdad());
		}
		SocketCliente cliente2 = new SocketCliente();
		Persona otraPersona = cliente2.receiveData();
		if (otraPersona!=null) {
			System.out.println("Informacion recibida desde el servidor:");
			System.out.println(otraPersona.getIdentificacion());
			System.out.println(otraPersona.getNombres());
			System.out.println(otraPersona.getApellidos());
			System.out.println(otraPersona.getEdad());
		}
	}
}
