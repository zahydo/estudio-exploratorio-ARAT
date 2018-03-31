package com.unicauca.presentacion.view;

import org.unicauca.annotations.model.util.reports.RationaleClient;

import com.unicauca.presentacion.controlador.TableroGraficoController;

public class Main {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TableroGraficoController boardController = new TableroGraficoController();
				boardController.initBoardView();
				RationaleClient.createReport("com");
			}
		});
	}

}
