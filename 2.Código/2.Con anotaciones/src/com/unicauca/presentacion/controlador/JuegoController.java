package com.unicauca.presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import org.unicauca.annotations.model.Rationale;

import com.unicauca.datos.Result;
import com.unicauca.negocio.modelo.juegos.Juego;
import com.unicauca.negocio.modelo.patrones.factoryMethod.FactoryMethod;

public class JuegoController implements ActionListener, MouseListener {
	private Juego juego;
	private final TableroGraficoController tableroGraficoController;

	public JuegoController(TableroGraficoController controller) {
		this.tableroGraficoController = controller;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public int getFilas() {
		return juego.getFilas();
	}

	public int getColumnas() {
		return juego.getColumnas();
	}

	public int[][] getMatrizTablero() {
		return juego.getTablero().getMatrizTablero();
	}

	public int getJugador1() {
		return juego.getJugador1();
	}

	public int getJugador2() {
		return juego.getJugador2();
	}

	public int getNumeroCasillas() {
		return juego.getTablero().getNumeroCasillas();
	}

	public int getTurno() {
		return juego.getTurno();
	}

	@Rationale(componentName = "actionPerformed", id = "mtd-actionPerformed", motivation = "Mantenibilidad -> Separaci�n de responsabilidades", justification = "Este m�todo captura las peticiones del usuario y ejecuta la acci�n que corresponda al bot�n presionado.")
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String buttonText = arg0.getActionCommand();
		switch (buttonText) {
		case "Jugar":
			iniciarJuego();
			break;
		case "Reiniciar":
			iniciarJuego();
			break;
		case "Resultados":
			ArrayList<Result> resultados = getResultados();
			if (resultados != null) {
				tableroGraficoController.initResultsView();
				tableroGraficoController.crearTablaResultados(resultados);
				tableroGraficoController.getTableroView().setVisible(false);

			} else {
				tableroGraficoController.mostrarMensajeErrorAccesoDatos();
			}
			break;
		case "Regresar":
			tableroGraficoController.getResultadosView().dispose();
			tableroGraficoController.getTableroView().setVisible(true);
			break;
		default:
			break;
		}
	}

	@Rationale(componentName = "mouseClicked", id = "mtd-mouseClicked", motivation = "Mantenibilidad -> Separaci�n de responsabilidades", justification = "Este m�todo captura la posici�n de la jugada en la matr�z de botones del 'TableroGrafico', ubica la ficha, procesa el turno y actualiza el tablero"
			+ "y notifica a los observadores para actualizar la Vista")
	@Override
	public void mouseClicked(MouseEvent e) {
		juego.getTablero().ubicarFicha(e.getComponent().getName(), juego.getTurno());
		int response = juego.procesarTurno();
		juego.notifyObservers();
		if (response > 0) {
			tableroGraficoController.mostrarMensajeGuardarJuego();
		}
		if (response < 0) {
			tableroGraficoController.mostrarMensajeEmpate();
		}

	}

	public void iniciarJuego() {
		if (juego == null) {
			String gamesPackage = "com.unicauca.negocio.modelo.juegos.";
			String juegoSeleccionado = tableroGraficoController.getJuegoSeleccionado();
			String classname = gamesPackage + juegoSeleccionado;
			int length = tableroGraficoController.getNumeroCasillas();
			juego = FactoryMethod.fabricarJuego(classname);
			juego.setNombre(juegoSeleccionado);
			if (juego.iniciarJuego(tableroGraficoController, length)) {
				tableroGraficoController.initBoardView();
			}
		} else {
			tableroGraficoController.mostrarMensajeReiniciarJuego();
		}

	}

	public boolean guardarJuego() {
		return juego.guardarJuego();
	}

	public ArrayList<Result> getResultados() {
		return juego.getResultados();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
