package com.unicauca.presentacion.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;

/**
 *
 * @author Usuario
 */
public class TableroGrafico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpGui = new JPanel(new BorderLayout(3, 3));
	private JButton[][] btnButtonSquares;
	private JPanel pnlBoard;
	private JComboBox<Object> cmbSeleccionJuego;
	private JSpinner spinnerNumeroCasillas;
	private JToolBar jtbTools;
	private JToolBar jtbInfo;
	private JButton btnJugar;
	private JButton btnReiniciar;
	private JButton btnResultados;

	public TableroGrafico() {
		this.jpGui.setPreferredSize(new Dimension(800, 600));
		this.getContentPane().add(getJpGui());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setMinimumSize(getSize());
		this.setLocationRelativeTo(null);
	}

	public JButton[][] getBtnButtonSquares() {
		return btnButtonSquares;
	}

	public void setBtnButtonSquares(JButton[][] btnButtonSquares) {
		this.btnButtonSquares = btnButtonSquares;
	}

	public JPanel getPnlBoard() {
		return pnlBoard;
	}

	public void setPnlBoard(JPanel pnlBoard) {
		this.pnlBoard = pnlBoard;
	}

	public JComboBox<Object> getCmbSeleccionJuego() {
		return cmbSeleccionJuego;
	}

	public void setCmbSeleccionJuego(JComboBox<Object> cmbSeleccionJuego) {
		this.cmbSeleccionJuego = cmbSeleccionJuego;
	}

	public JSpinner getSpinnerNumeroCasillas() {
		return spinnerNumeroCasillas;
	}

	public void setSpinnerNumeroCasillas(JSpinner spinnerNumeroCasillas) {
		this.spinnerNumeroCasillas = spinnerNumeroCasillas;
	}

	public void setJpGui(JPanel jpGui) {
		this.jpGui = jpGui;
	}

	public JComponent getJpGui() {
		return jpGui;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JToolBar getJtbTools() {
		return jtbTools;
	}

	public void setJtbTools(JToolBar jtbTools) {
		this.jtbTools = jtbTools;
	}

	public JToolBar getJtbInfo() {
		return jtbInfo;
	}

	public void setJtbInfo(JToolBar jtbInfo) {
		this.jtbInfo = jtbInfo;
	}

	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}

	public void setBtnReiniciar(JButton btnReiniciar) {
		this.btnReiniciar = btnReiniciar;
	}

	public JButton getBtnResultados() {
		return btnResultados;
	}

	public void setBtnResultados(JButton btnResultados) {
		this.btnResultados = btnResultados;
	}

}
