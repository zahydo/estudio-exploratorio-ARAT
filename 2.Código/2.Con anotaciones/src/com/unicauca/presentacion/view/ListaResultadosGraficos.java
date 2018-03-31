package com.unicauca.presentacion.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListaResultadosGraficos extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnRegresar;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JTable tblResultados;
	private DefaultTableModel modelo;

	public ListaResultadosGraficos() {

	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public void setBtnRegresar(JButton btnRegresar) {
		this.btnRegresar = btnRegresar;
	}

	public JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public JTable getTblResultados() {
		return tblResultados;
	}

	public void setTblResultados(JTable tblResultados) {
		this.tblResultados = tblResultados;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
}
