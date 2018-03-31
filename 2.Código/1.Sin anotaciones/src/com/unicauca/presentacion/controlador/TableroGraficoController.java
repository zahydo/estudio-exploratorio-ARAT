package com.unicauca.presentacion.controlador;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.unicauca.datos.Result;
import com.unicauca.negocio.modelo.patrones.observer.Observer;
import com.unicauca.presentacion.controlador.reflection.ReflectionController;
import com.unicauca.presentacion.view.ListaResultadosGraficos;
import com.unicauca.presentacion.view.TableroGrafico;

/**
 * @author Sahydo
 * @version 1.5
 * @since 2018-02-28
 */
public class TableroGraficoController implements Observer {

	private JuegoController juegoController;
	private TableroGrafico tableroView;
	private ListaResultadosGraficos resultadosView;

	public TableroGraficoController() {
		this.tableroView = new TableroGrafico();
		this.tableroView.setVisible(true);
		this.juegoController = new JuegoController(this);
	}

	public String getJuegoSeleccionado() {
		return tableroView.getCmbSeleccionJuego().getSelectedItem().toString();
	}

	public int getNumeroCasillas() {
		return Integer.parseInt(tableroView.getSpinnerNumeroCasillas().getValue().toString());
	}

	public JuegoController getJuegoController() {
		return juegoController;
	}

	public void setJuegoController(JuegoController juegoController) {
		this.juegoController = juegoController;
	}

	public TableroGrafico getTableroView() {
		return tableroView;
	}

	public void setTableroView(TableroGrafico tableroView) {
		this.tableroView = tableroView;
	}

	public ListaResultadosGraficos getResultadosView() {
		return resultadosView;
	}

	public void setResultadosView(ListaResultadosGraficos resultadosView) {
		this.resultadosView = resultadosView;
	}

	public void initBoardView() {
		removeAll();
		crearBarraDeOpciones();
		crearTablero();
		crearBarraInformativa();
	}

	/**
	 * M�todo para crear los componentes gr�ficos de la barra de opciones (Superior)
	 */
	private void crearBarraDeOpciones() {
		tableroView.getJpGui().setBorder(new EmptyBorder(10, 10, 10, 10));
		tableroView.setJtbTools(new JToolBar());
		tableroView.getJtbTools().setFloatable(false);
		tableroView.getJtbTools().setMargin(new Insets(10, 10, 10, 10));
		tableroView.getJpGui().add(tableroView.getJtbTools(), BorderLayout.PAGE_START);
		tableroView.setSpinnerNumeroCasillas(new javax.swing.JSpinner());
		tableroView.getSpinnerNumeroCasillas().setModel(new javax.swing.SpinnerNumberModel(3, 3, 5, 1));
		((JSpinner.DefaultEditor) tableroView.getSpinnerNumeroCasillas().getEditor()).getTextField().setEditable(false);
		tableroView.getJtbTools().add(new JLabel("Numero de casillas: "));
		tableroView.getJtbTools().add(tableroView.getSpinnerNumeroCasillas());
		tableroView.getJtbTools().addSeparator();
		tableroView.setCmbSeleccionJuego(new JComboBox<>(ReflectionController.getListaJuegos().toArray()));
		if (juegoController.getJuego() != null) {
			tableroView.getCmbSeleccionJuego().setSelectedItem(juegoController.getJuego().getNombre());
		}
		tableroView.getJtbTools().add(new JLabel("Seleccione el juego: "));
		tableroView.getJtbTools().add(tableroView.getCmbSeleccionJuego());
		tableroView.getJtbTools().addSeparator();
		tableroView.setBtnJugar(new JButton());
		tableroView.getBtnJugar().setText("Jugar");
		tableroView.getBtnJugar().setName("iniciarJuego");
		;
		tableroView.getBtnJugar().addActionListener(juegoController);
		tableroView.getJtbTools().add(tableroView.getBtnJugar());
		tableroView.getJtbTools().addSeparator();
		tableroView.setBtnResultados(new JButton());
		tableroView.getBtnResultados().setText("Resultados");
		tableroView.getBtnResultados().setName("resultados");
		;
		tableroView.getBtnResultados().addActionListener(juegoController);
		tableroView.getJtbTools().add(tableroView.getBtnResultados());
	}

	/**
	 * Metodo para crear los componentes graficos de la barra Informativa (Inferior)
	 */
	private void crearBarraInformativa() {
		if (juegoController.getJuego() != null) {
			tableroView.setJtbInfo(new JToolBar());
			tableroView.getJtbInfo().setFloatable(false);
			tableroView.getJtbInfo().add(new JLabel("Juego seleccionado: " + juegoController.getJuego().getNombre()));
			tableroView.getJtbInfo().addSeparator();
			tableroView.getJtbInfo().add(new JLabel("" + juegoController.getNumeroCasillas() + " casillas"));
			tableroView.getJtbInfo().addSeparator();
			tableroView.getJtbInfo().add(new JLabel("Turno: jugador" + juegoController.getTurno()));
			tableroView.getJpGui().add(tableroView.getJtbInfo(), BorderLayout.PAGE_END);
			tableroView.getJtbInfo().addSeparator();
			tableroView.setBtnReiniciar(new JButton());
			tableroView.getBtnReiniciar().setText("Reiniciar");
			tableroView.getBtnReiniciar().setName("reiniciar");
			;
			tableroView.getBtnReiniciar().addActionListener(juegoController);
			tableroView.getJtbInfo().add(tableroView.getBtnReiniciar());
		}
	}

	/**
	 * Metodo para crear los componentes graficos del Tablero
	 */
	private void crearTablero() {
		if (juegoController.getJuego() != null) {
			tableroView.setBtnButtonSquares(new JButton[juegoController.getFilas()][juegoController.getColumnas()]);
			tableroView.setPnlBoard(new JPanel(new GridLayout(0, juegoController.getColumnas())) {

				private static final long serialVersionUID = 1L;

				@Override
				public final Dimension getPreferredSize() {
					Dimension d = super.getPreferredSize();
					Dimension prefSize = null;
					Component c = getParent();
					if (c == null) {
						prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
					} else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
						prefSize = c.getSize();
					} else {
						prefSize = d;
					}
					int w = (int) prefSize.getWidth();
					int h = (int) prefSize.getHeight();
					int s = (w > h ? h : w);
					return new Dimension(s, s);
				}
			});
			tableroView.getPnlBoard()
					.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
			JPanel boardConstrain = new JPanel(new GridBagLayout());
			boardConstrain.add(tableroView.getPnlBoard());
			tableroView.getJpGui().add(boardConstrain);
			Insets buttonMargin = new Insets(0, 0, 0, 0);
			for (int i = 0; i < tableroView.getBtnButtonSquares().length; i++) {
				for (int j = 0; j < tableroView.getBtnButtonSquares()[i].length; j++) {
					JButton b = new JButton();
					b.setName(i + "," + j);
					b.setMargin(buttonMargin);
					b.addMouseListener(juegoController);
					if (juegoController.getMatrizTablero()[i][j] == juegoController.getJugador1()) {
						b.setBackground(Color.white);
						tableroView.getBtnButtonSquares()[i][j] = b;
					} else if (juegoController.getMatrizTablero()[i][j] == juegoController.getJugador2()) {
						b.setBackground(Color.black);
						tableroView.getBtnButtonSquares()[i][j] = b;
					} else {
						tableroView.getBtnButtonSquares()[i][j] = b;
					}
				}
			}
			for (int i = 0; i < juegoController.getFilas(); i++) {
				for (int j = 0; j < juegoController.getColumnas(); j++) {
					tableroView.getPnlBoard().add(tableroView.getBtnButtonSquares()[i][j]);
				}
			}
		}

	}

	public void mostrarMensajeReiniciarJuego() {
		int input = JOptionPane.showConfirmDialog(null, "Quieres reiniciar el juego?", "Reiniciar juego",
				JOptionPane.DEFAULT_OPTION);
		if (input == 0) {
			juegoController.setJuego(null);
			juegoController.iniciarJuego();
		}
	}

	public void mostrarMensajeGuardarJuego() {
		int input = JOptionPane.showConfirmDialog(null,
				"Jugador : " + juegoController.getJuego().getGanador() + " gana, Quieres guardar el juego?",
				"Guardar juego", JOptionPane.DEFAULT_OPTION);
		if (input == 0) {
			String name = JOptionPane.showInputDialog("Ingresa tu nombre");
			if (name != null) {
				juegoController.getJuego().setNombreGanador(name);
				if (juegoController.guardarJuego()) {
					JOptionPane.showMessageDialog(null, "Felicitaciones " + name + ", juego guardado.");
				} else {
					mostrarMensajeErrorAccesoDatos();
				}
			}
		}
		juegoController.setJuego(null);
		juegoController.iniciarJuego();
	}

	public void mostrarMensajeErrorAccesoDatos() {
		JOptionPane.showMessageDialog(null, "No se puede acceder a los datos");
	}

	public void mostrarMensajeEmpate() {
		JOptionPane.showMessageDialog(null, "El juego termina en empate");
		juegoController.iniciarJuego();
	}

	private void removeAll() {
		tableroView.getJpGui().removeAll();
	}

	/**
	 * Metodo implementado de Observer para actualizar la vista cada que cambia el
	 * juego y el tableroView
	 */
	@Override
	public void update() {
		initBoardView();
	}

	public void initResultsView() {
		resultadosView = new ListaResultadosGraficos();
		resultadosView.setjLabel1(new javax.swing.JLabel());
		resultadosView.setjScrollPane1(new javax.swing.JScrollPane());
		resultadosView.setTblResultados(new javax.swing.JTable());
		resultadosView.setBtnRegresar(new javax.swing.JButton());
		resultadosView.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		resultadosView.getjLabel1().setText("Resultados");

		resultadosView.getTblResultados().setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null } }, new String[] { "Title 1", "Title 2" }));

		resultadosView.getjScrollPane1().setViewportView(resultadosView.getTblResultados());

		resultadosView.getBtnRegresar().setText("Regresar");
		resultadosView.getBtnRegresar().addActionListener(juegoController);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(resultadosView.getContentPane());
		resultadosView.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(
										resultadosView.getjScrollPane1(), javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(212, 212, 212)
										.addComponent(resultadosView.getjLabel1()))
								.addGroup(layout.createSequentialGroup().addGap(208, 208, 208)
										.addComponent(resultadosView.getBtnRegresar())))
						.addContainerGap(26, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(resultadosView.getjLabel1())
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(resultadosView.getjScrollPane1(), javax.swing.GroupLayout.PREFERRED_SIZE, 314,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(resultadosView.getBtnRegresar()).addContainerGap(18, Short.MAX_VALUE)));

		resultadosView.pack();
		resultadosView.setModelo(new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		});
		resultadosView.getTblResultados().setModel(resultadosView.getModelo());
		resultadosView.pack();
		resultadosView.setMinimumSize(resultadosView.getSize());
		resultadosView.setLocationRelativeTo(null);
		resultadosView.setVisible(true);
	}

	public void crearTablaResultados(ArrayList<Result> res) {
		try {
			resultadosView.getModelo().addColumn("#");
			resultadosView.getModelo().addColumn("Ganador");
			resultadosView.getModelo().addColumn("Filas");
			resultadosView.getModelo().addColumn("Columnas");
			resultadosView.getModelo().addColumn("Juego");
			resultadosView.getModelo().addColumn("Num.Casillas");
			Object[] fila = new Object[6];
			for (int i = 0; i < res.size(); i++) {
				fila[0] = res.get(i).getId();
				fila[1] = res.get(i).getGanadorName();
				fila[2] = res.get(i).getFilas();
				fila[3] = res.get(i).getColumnas();
				fila[4] = res.get(i).getNombreJuego();
				fila[5] = res.get(i).getNumeroCasillas();
				resultadosView.getModelo().addRow(fila);
			}
			String[] columnas = new String[6];
			columnas[0] = "#";
			columnas[1] = "Ganador";
			columnas[2] = "Filas";
			columnas[3] = "Columnas";
			columnas[4] = "Juego";
			columnas[5] = "Num.Casillas";

			resultadosView.getModelo().setColumnIdentifiers(columnas);

		} catch (Exception e) {
		}
	}

}