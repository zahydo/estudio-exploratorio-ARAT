/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.negocio.modelo.utils;

/**
 *
 * @author sahydo
 */
public interface WinnerChecker {
	/**
	 *
	 * @param jugador
	 *            Determina el jugador a evaluar si es ganador
	 * @return verdadero si el jugador es ganador, falso en caso contrario
	 */
	public abstract boolean isWinner(int jugador);
}
