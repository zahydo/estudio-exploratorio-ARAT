package com.unicauca.negocio.modelo.juegos;

import java.util.ArrayList;

import com.unicauca.datos.DataAccessStrategy;
import com.unicauca.datos.FileManager;
import com.unicauca.datos.Result;
import com.unicauca.negocio.modelo.patrones.factoryMethod.FactoryMethod;
import com.unicauca.negocio.modelo.patrones.observer.Observer;
import com.unicauca.negocio.modelo.patrones.observer.Subject;
import com.unicauca.negocio.modelo.tableros.Tablero;
import com.unicauca.negocio.modelo.utils.PositionValidator;
import com.unicauca.negocio.modelo.utils.WinnerChecker;

/**
 * @author Sahydo
 * 
 *         Clase abstracta que representa un Juego y hereda los m�todos de una
 *         clase observada
 */
public abstract class Juego extends Subject {
	protected String nombre;
	protected int filas;
	protected int columnas;
	protected int jugador1 = 1;
	protected int jugador2 = 2;
	protected int ganador;
	protected int turno;
	protected String nombreGanador;
	protected Tablero tablero;
	protected WinnerChecker validador;
	protected DataAccessStrategy accesoDatos;

	public Juego() {
		// Configuración por defecto
		this.setFilas(6);
		this.setColumnas(7);
		this.setJugador1(1);
		this.setJugador2(2);

	}
	// -------------- Getters and Setters -----------------

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

	public String getNombreGanador() {
		return nombreGanador;
	}

	public void setNombreGanador(String ganadorName) {
		this.nombreGanador = ganadorName;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombreJuego) {
		this.nombre = nombreJuego;
	}

	public WinnerChecker getValidador() {
		return validador;
	}

	public void setValidador(PositionValidator validator) {
		this.validador = validator;
	}

	public DataAccessStrategy getAccesoDatos() {
		return accesoDatos;
	}

	public void setAccesoDatos(DataAccessStrategy accesoDatos) {
		this.accesoDatos = accesoDatos;
	}
	// --------------------- M�todos de la l�gica de negocio
	// ------------------------------

	/**
	 * @return Determina el ganador de un juego
	 */
	public abstract int evaluarGanador();

	/**
	 * @return int Determina el turno correspondiente en una partida
	 * 
	 */
	public int procesarTurno() {
		this.setGanador(evaluarGanador());
		if (this.getGanador() != 0) {
			return this.getGanador();
		} else {
			if (tablero.getCasillasDisponibles() > 0) {

				cambiarTurno();
				return 0;
			} else {
				return -1;
			}
		}
	}

	private void cambiarTurno() {
		if (tablero.isFichaMovida()) {
			if (turno == this.getJugador1()) {
				turno = this.getJugador2();
			} else if (turno == this.getJugador2()) {
				turno = this.getJugador1();
			} else {
				turno = this.getJugador1();
			}
		}
	}

	/**
	 * @param observer
	 *            Observador que debe estar pendiente del juego y del tablero
	 * @param length
	 *            N�mero de casillas para ganar un juego
	 * 
	 */
	public boolean iniciarJuego(Observer observer, int length) {
		boolean flag = false;
		this.addObserver(observer);
		String boardPackage = "com.unicauca.negocio.modelo.tableros.Tablero_";
		String nombreTablero = boardPackage + this.getClass().getSimpleName();
		tablero = FactoryMethod.fabricarTablero(nombreTablero, this.getFilas(), this.getColumnas(), length);
		if (tablero != null) {
			validador = new PositionValidator(tablero);
			turno = jugador1;
			flag = true;
		} else {
			System.out.println("Debes crear la clase que hereda de Tablero con el nombre Tablero_<tipoJuego>");
		}
		return flag;
	}

	public boolean guardarJuego() {
		boolean flag;
		Result resultado = new Result();
		resultado.setNombreJuego(this.getNombre());
		resultado.setFilas(this.getFilas());
		resultado.setColumnas(this.getColumnas());
		resultado.setGanador(this.getGanador());
		resultado.setJugador1(this.getJugador1());
		resultado.setJugador2(this.getJugador2());
		resultado.setGanadorName(this.getNombreGanador());
		resultado.setMatrizTablero(this.getTablero().getMatrizTablero());
		resultado.setNumeroCasillas(this.getTablero().getNumeroCasillas());
		try {
			accesoDatos = new FileManager();
			flag = accesoDatos.saveData(resultado);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public ArrayList<Result> getResultados() {
		ArrayList<Result> results;
		try {
			accesoDatos = new FileManager();
			results = accesoDatos.getResults();
		} catch (Exception e) {
			return null;
		}
		return results;
	}
}
