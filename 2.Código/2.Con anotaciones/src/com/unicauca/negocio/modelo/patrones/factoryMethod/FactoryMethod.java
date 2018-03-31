package com.unicauca.negocio.modelo.patrones.factoryMethod;

import com.unicauca.negocio.modelo.juegos.Juego;
import com.unicauca.negocio.modelo.tableros.Tablero;

/**
 * @author Sahydo
 */
public class FactoryMethod {
	/**
	 * @param classname
	 *            Determina el nombre de la clase a instanciar
	 * @param filas
	 *            Determina el numero de filas del tablero
	 * @param columnas
	 *            Determina el numero de columnas del tablero
	 * @param length
	 *            Determina el numero de casillas continuas para ganar un juego
	 * @return Tablero con atributos inicializados
	 * 
	 * 
	 */
	public static Tablero fabricarTablero(String classname, int filas, int columnas, int length) {
		try {
			Class<?> class_tablero = Class.forName(classname);
			Tablero tablero = (Tablero) class_tablero.newInstance();
			tablero.setMatrizTablero(new int[filas][columnas]);
			tablero.setFilas(filas);
			tablero.setColumnas(columnas);
			tablero.setNumeroCasillas(length);
			tablero.setCasillasDisponibles(filas * columnas);
			return tablero;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	/**
	 * @param classname
	 *            Determina el nombre del Juego a instanciar
	 * @return
	 * 
	 */
	public static Juego fabricarJuego(String classname) {
		Juego juego = null;
		try {
			juego = (Juego) Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			System.out.println("Problema al instanciar el tipo de juego: " + e.toString());
		} catch (IllegalAccessException e) {
			System.out.println("Acceso ilegal: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("No se encuentra la clase con el nombre: " + classname + ". " + e.toString());
		}
		return juego;
	}
}
