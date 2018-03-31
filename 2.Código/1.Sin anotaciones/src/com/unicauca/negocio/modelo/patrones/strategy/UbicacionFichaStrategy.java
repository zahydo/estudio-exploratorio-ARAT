package com.unicauca.negocio.modelo.patrones.strategy;

/**
 * Patron estrategia para determinar la ubicacion de la ficha dependiendo del
 * juego seleccionado
 * 
 * @author Sahydo
 * 
 */
public interface UbicacionFichaStrategy {
	/**
	 * @param posicion
	 *            Determina la posicion que marca un jugador "x,y"
	 * @param turno
	 *            Determina el turno de los jugadores en la jugada
	 */
	public abstract void ubicarFicha(String posicion, int turno);
}
