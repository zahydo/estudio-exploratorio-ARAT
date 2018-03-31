package com.unicauca.presentacion.view;

import com.unicauca.presentacion.controlador.TableroGraficoController;

public class Main {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TableroGraficoController boardController = new TableroGraficoController();
				boardController.initBoardView();
			}
		});
	}

}
