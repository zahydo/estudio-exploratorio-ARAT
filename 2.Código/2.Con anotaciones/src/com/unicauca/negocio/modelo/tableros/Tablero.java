package com.unicauca.negocio.modelo.tableros;

import com.unicauca.negocio.modelo.patrones.strategy.UbicacionFichaStrategy;

/**
 * @author Sahydo 
 */
public abstract class Tablero implements UbicacionFichaStrategy {
	protected boolean fichaMovida = false;
	protected int filas;
	protected int columnas;
	protected int[][] matrizTablero;
	protected int numeroCasillas;
	protected int casillasDisponibles;

	public boolean isFichaMovida() {
		return fichaMovida;
	}

	public void setFichaMovida(boolean fichaMovida) {
		this.fichaMovida = fichaMovida;
	}

	public int[][] getMatrizTablero() {
		return matrizTablero;
	}

	public void setMatrizTablero(int[][] tab) {
		matrizTablero = tab;
	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}

	public void setNumeroCasillas(int numeroCasillas) {
		this.numeroCasillas = numeroCasillas;
	}

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

	public int getCasillasDisponibles() {
		return casillasDisponibles;
	}

	public void setCasillasDisponibles(int casillasDisponibles) {
		this.casillasDisponibles = casillasDisponibles;
	}

}
