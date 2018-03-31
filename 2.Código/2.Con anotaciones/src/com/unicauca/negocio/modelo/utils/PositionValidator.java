package com.unicauca.negocio.modelo.utils;

import com.unicauca.negocio.modelo.tableros.Tablero;

public class PositionValidator implements WinnerChecker {
	private Tablero tablero;

	public PositionValidator(Tablero tab) {
		this.tablero = tab;
	}

	// ------------------------------ Metodos para validar ganador
	// -----------------------

	private boolean checkHorizontal(int jugador) {
		boolean flag = false;

		int counter = 0;
		while (!flag) {

			for (int w = 0; tablero.getFilas() > w; w += 1) {
				for (int h = 0; tablero.getColumnas() > h; h += 1) {
					if (tablero.getMatrizTablero()[w][h] == jugador) {
						counter += 1;
					} else {
						counter = 0;
					}
					if (counter >= tablero.getNumeroCasillas()) {
						flag = true;
					}
				}
			}
			break;
		}
		return flag;
	}

	private boolean checkVertical(int jugador) {
		boolean flag = false;

		int counter = 0;
		while (!flag) {

			for (int h = 0; tablero.getColumnas() > h; h += 1) {
				for (int w = 0; tablero.getFilas() > w; w += 1) {
					if (tablero.getMatrizTablero()[w][h] == jugador) {
						counter += 1;
					} else {
						counter = 0;
					}
					if (counter >= tablero.getNumeroCasillas()) {
						flag = true;
					}
				}
			}
			break;
		}
		return flag;
	}

	private boolean check_ArribaIzq_AbajoDer(int jugador) {
		boolean flag = false;

		int counter = 0;

		boolean check = false;

		int checkColumn = 1;
		int checkRow = 1;

		while (!flag) {
			for (int w = 0; w < tablero.getFilas(); w += 1) {
				for (int h = 0; h < tablero.getColumnas(); h += 1) {
					if (tablero.getMatrizTablero()[w][h] == jugador) {
						counter += 1;
						check = true;
						while (check) {
							if (w + checkRow < tablero.getFilas() && h + checkColumn < tablero.getColumnas()) {
								if (tablero.getMatrizTablero()[w + checkRow][h + checkColumn] == jugador) {
									counter += 1;
								}
							}

							checkColumn += 1;
							checkRow += 1;

							if (checkRow == 0 || checkColumn == tablero.getColumnas() - 1) {
								check = false;
								break;
							}

							if (counter >= tablero.getNumeroCasillas()) {
								check = false;
								flag = true;
								break;
							}
						}
					}
					if (counter >= tablero.getNumeroCasillas()) {
						flag = true;
						break;
					}

					counter = 0;
					checkColumn = 1;
					checkRow = 1;
				}
			}
			break;
		}
		return flag;
	}

	private boolean check_AbajoIzq_ArribaDer(int jugador) {
		boolean flag = false;

		int counter = 0;

		boolean check = false;

		int checkColumn = 1;
		int checkRow = 1;

		while (!flag) {
			for (int w = 0; tablero.getFilas() > w; w += 1) {
				for (int h = 0; tablero.getColumnas() > h; h += 1) {
					if (tablero.getMatrizTablero()[w][h] == jugador) {
						counter += 1;
						check = true;
						while (check) {
							if (w - checkRow >= 0 && h + checkColumn < tablero.getColumnas()) {
								if (tablero.getMatrizTablero()[w - checkRow][h + checkColumn] == jugador) {
									counter += 1;
								}
							}

							checkColumn += 1;
							checkRow += 1;

							if (checkColumn == tablero.getColumnas() - 1 || checkRow == 0) {
								check = false;
								break;
							}

							if (counter >= tablero.getNumeroCasillas()) {
								check = false;
								flag = true;
								break;
							}
						}
					}
					if (counter >= tablero.getNumeroCasillas()) {
						flag = true;
						break;
					}

					counter = 0;
					checkColumn = 1;
					checkRow = 1;
				}
			}
			break;
		}
		return flag;
	}

	@Override
	public boolean isWinner(int jugador) {
		boolean flag = false;

		if (checkVertical(jugador) || checkHorizontal(jugador) || check_ArribaIzq_AbajoDer(jugador)
				|| check_AbajoIzq_ArribaDer(jugador)) {
			flag = true;
		}
		return flag;
	}
}
