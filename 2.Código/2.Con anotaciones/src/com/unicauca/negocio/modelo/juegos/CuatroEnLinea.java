package com.unicauca.negocio.modelo.juegos;

public class CuatroEnLinea extends Juego {

	public CuatroEnLinea() {
		super();
	}

	@Override
	public int evaluarGanador() {
		if (validador.isWinner(this.getJugador1())) {
			return this.getJugador1();
		} else if (validador.isWinner(this.getJugador2())) {
			return this.getJugador2();
		} else {
			return 0;
		}
	}

}
