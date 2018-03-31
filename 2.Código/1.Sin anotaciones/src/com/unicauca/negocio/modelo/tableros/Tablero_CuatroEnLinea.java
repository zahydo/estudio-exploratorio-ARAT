package com.unicauca.negocio.modelo.tableros;

/**
 * @author Sahydo
 */
public class Tablero_CuatroEnLinea extends Tablero {

	@Override
	public void ubicarFicha(String posicion, int turno) {
		String[] posicions = posicion.split(",");
		int fila = Integer.parseInt(posicions[0]);
		int columna = Integer.parseInt(posicions[1]);
		if (this.getMatrizTablero()[fila][columna] == 0) {
			for (int i = 0; i < this.getFilas(); i++) {
				if (i == this.getFilas() - 1 && this.getMatrizTablero()[i][columna] == 0) {
					this.getMatrizTablero()[i][columna] = turno;
					this.setFichaMovida(true);
					this.setCasillasDisponibles(getCasillasDisponibles() - 1);
				} else if (this.getMatrizTablero()[i][columna] == 0 && (this.getMatrizTablero()[i + 1][columna] != 0)) {
					this.getMatrizTablero()[i][columna] = turno;
					this.setFichaMovida(true);
					this.setCasillasDisponibles(getCasillasDisponibles() - 1);
				}
			}
		} else {
			this.setFichaMovida(false);
		}
	}

}