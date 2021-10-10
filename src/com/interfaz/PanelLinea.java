package com.interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class PanelLinea extends JPanel {
	private JTextField txtValorTotalLinea;
	private JTextField txtTotalLlamadas;
	private JTextField txtTotalMinutos;
	private JTextField textField_3;
	private JCheckBox chckLocal;
	private JCheckBox chckLargaDistancia;
	private JCheckBox chckCelular;
	private Interfaz principal;
	
	public PanelLinea(Interfaz principal) {
		this.principal = principal;
	}

	/**
	 * Create the panel.
	 */
	public PanelLinea(int R,int G, int B,String numeroLinea) {
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3);
		
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
		btnAgregarLlamada.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarLlamada.setBackground(new Color(R,G,B));
		add(btnAgregarLlamada);
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);

	}
}
