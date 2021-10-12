package com.interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.mundo.LineaTelefonica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLinea extends JPanel {
	private JTextField txtValorTotalLinea;
	private JTextField txtTotalLlamadas;
	private JTextField txtTotalMinutos;
	private JTextField txtMinutosLlamadas;
	private JCheckBox chckLocal;
	private JCheckBox chckLargaDistancia;
	private JCheckBox chckCelular;
	private Interfaz principal;
	
	public PanelLinea(Interfaz principal, int R, int G, int B, int numeroLinea) {
		this(R,G,B,numeroLinea);
		this.principal = principal;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelLinea( int R, int G, int B, int numeroLinea) {
		setBorder(new TitledBorder(null, "Linea " + numeroLinea, TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(R,G,B)));
		setLayout(new GridLayout(6, 3, 5, 2));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total Linea");
		lblNewLabel_1.setForeground(new Color(R,G,B));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1);
		
		txtValorTotalLinea = new JTextField();
		txtValorTotalLinea.setEditable(false);
		txtValorTotalLinea.setColumns(10);
		add(txtValorTotalLinea);
		
		JLabel lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Llamadas");
		lblNewLabel_1_1.setForeground(new Color(R,G,B));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1);
		
		txtTotalLlamadas = new JTextField();
		txtTotalLlamadas.setEditable(false);
		txtTotalLlamadas.setColumns(10);
		add(txtTotalLlamadas);
		
		JLabel lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Minutos");
		lblNewLabel_1_2.setForeground(new Color(R,G,B));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_2);
		
		txtTotalMinutos = new JTextField();
		txtTotalMinutos.setEditable(false);
		txtTotalMinutos.setColumns(10);
		add(txtTotalMinutos);
		
		JLabel lblNewLabel_4 = new JLabel("Minutos Llamada");
		lblNewLabel_4.setForeground(new Color(R,G,B));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_4);
		
		txtMinutosLlamadas = new JTextField();
		txtMinutosLlamadas.setColumns(10);
		add(txtMinutosLlamadas);
		
		JLabel lblNewLabel_5 = new JLabel("");
		add(lblNewLabel_5);
		
		chckLocal = new JCheckBox("Local");
		chckLocal.setFont(new Font("Arial", Font.BOLD, 12));
		add(chckLocal);
		
		chckLargaDistancia = new JCheckBox("Larga Distancia");
		chckLargaDistancia.setFont(new Font("Arial", Font.BOLD, 12));
		add(chckLargaDistancia);
		
		chckCelular = new JCheckBox("Celular");
		chckCelular.setFont(new Font("Arial", Font.BOLD, 12));
		add(chckCelular);
		
		JLabel lblNewLabel_6 = new JLabel("");
		add(lblNewLabel_6);
		
		JButton btnAgregarLlamada = new JButton("Agregar Llamada");
		btnAgregarLlamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int minutos = 0;
				if(txtMinutosLlamadas.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Ingrese la cantidad de minutos", "warning", JOptionPane.WARNING_MESSAGE);
				}else {
					 minutos = Integer.parseInt(txtMinutosLlamadas.getText());
				}
				
				if (!chckLocal.isSelected() && !chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
					JOptionPane.showMessageDialog(null, "Seleccione una opcion", "warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if (chckLocal.isSelected() && !chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
					if (numeroLinea == 1) {
						principal.darEmpresa().agregarLlamadaLocalLinea1(minutos);
						actualizar(principal.darEmpresa().darLinea1());
					}else if (numeroLinea == 2) {
						principal.darEmpresa().agregarLlamadaLocalLinea2(minutos);
						actualizar(principal.darEmpresa().darLinea2());
					}else if (numeroLinea == 3) {
						principal.darEmpresa().agregarLlamadaLocalLinea3(minutos);
						actualizar(principal.darEmpresa().darLinea3());
					}
				}
				else if (!chckLocal.isSelected() && chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
					if (numeroLinea == 1) {
						principal.darEmpresa().agregarLlamadaLargaDistanciaLinea1(minutos);
						actualizar(principal.darEmpresa().darLinea1());
					}else if (numeroLinea == 2) {
						principal.darEmpresa().agregarLlamadaLargaDistanciaLinea2(minutos);
						actualizar(principal.darEmpresa().darLinea2());
					}else if (numeroLinea == 3) {
						principal.darEmpresa().agregarLlamadaLargaDistanciaLinea3(minutos);
						actualizar(principal.darEmpresa().darLinea3());
					}
				}
				else if (!chckLocal.isSelected() && !chckLargaDistancia.isSelected() && chckCelular.isSelected()) {
					if (numeroLinea == 1) {
						principal.darEmpresa().agregarLlamadaCelularLinea1(minutos);
						actualizar(principal.darEmpresa().darLinea1());
					}else if (numeroLinea == 2) {
						principal.darEmpresa().agregarLlamadaCelularLinea2(minutos);
						actualizar(principal.darEmpresa().darLinea2());
					}else if (numeroLinea == 3) {
						principal.darEmpresa().agregarLlamadaCelularLinea3(minutos);
						actualizar(principal.darEmpresa().darLinea3());
					}
				}
				else {
					chckLocal.setSelected(false);
					chckLargaDistancia.setSelected(false);
					chckCelular.setSelected(false);
				}
				txtMinutosLlamadas.setText("");
				chckLocal.setSelected(false);
				chckLargaDistancia.setSelected(false);
				chckCelular.setSelected(false);
			}
		});
		btnAgregarLlamada.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarLlamada.setBackground(new Color(R,G,B));
		add(btnAgregarLlamada);
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);

	}
	public void actualizar(LineaTelefonica linea) {
		txtValorTotalLinea.setText(formatearValor(linea.darCostoLlamadas()));
		txtTotalLlamadas.setText(formatearValorEntero(linea.darNumeroLlamadas()));
		txtTotalMinutos .setText(formatearValorEntero(linea.darNumeroMinutos()));
	}
	private String formatearValor(double valor) {
		return Double.toString(valor);
	}
	private String formatearValorEntero(int valor) {
		return Integer.toString(valor);
	}
}
