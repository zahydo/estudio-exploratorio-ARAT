package com.unicauca.datos;

import java.io.Serializable;

public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombreJuego;
	private int filas;
	private int columnas;
	private int ganador;
	private String ganadorName;
	private int jugador1;
	private int jugador2;
	private int[][] matrizTablero;
	private int numeroCasillas;

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public String getGanadorName() {
		return ganadorName;
	}

	public void setGanadorName(String ganadorName) {
		this.ganadorName = ganadorName;
	}

	public int getJugador1() {
		return jugador1;
	}

	public void setJugador1(int jugador1) {
		this.jugador1 = jugador1;
	}

	public int getJugador2() {
		return jugador2;
	}

	public void setJugador2(int jugador2) {
		this.jugador2 = jugador2;
	}

	public int[][] getMatrizTablero() {
		return matrizTablero;
	}

	public void setMatrizTablero(int[][] matrizTablero) {
		this.matrizTablero = matrizTablero;
	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}

	public void setNumeroCasillas(int numeroCasillas) {
		this.numeroCasillas = numeroCasillas;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
