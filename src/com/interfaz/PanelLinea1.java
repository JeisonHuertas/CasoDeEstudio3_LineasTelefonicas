package com.interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.mundo.LineaTelefonica;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLinea1 extends JPanel {
	private JTextField txtValorTotalLinea;
	private JTextField txtTotalLlamadas;
	private JTextField txtTotalMinutos;
	private JTextField txtMinutosLlamadas;
	private JCheckBox chckLocal;
	private JCheckBox chckLargaDistancia;
	private JCheckBox chckCelular;
	// Asociacion con la clase Empresa
	private Interfaz principal;
	
	public PanelLinea1(Interfaz principal) {
		this();
		this.principal = principal;
	}

	/**
	 * Create the panel.
	 */
	public PanelLinea1() {
		setBorder(new TitledBorder(null, "Linea 1", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.ORANGE));
		setLayout(new GridLayout(6, 3, 5, 2));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total Linea");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1);
		
		txtValorTotalLinea = new JTextField();
		txtValorTotalLinea.setEditable(false);
		txtValorTotalLinea.setColumns(10);
		add(txtValorTotalLinea);
		
		JLabel lblNewLabel_2 = new JLabel("");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Llamadas");
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1);
		
		txtTotalLlamadas = new JTextField();
		txtTotalLlamadas.setEditable(false);
		txtTotalLlamadas.setColumns(10);
		add(txtTotalLlamadas);
		
		JLabel lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Minutos");
		lblNewLabel_1_2.setForeground(Color.ORANGE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_2);
		
		txtTotalMinutos = new JTextField();
		txtTotalMinutos.setEditable(false);
		txtTotalMinutos.setColumns(10);
		add(txtTotalMinutos);
		
		JLabel lblNewLabel_4 = new JLabel("Minutos Llamada");
		lblNewLabel_4.setForeground(Color.ORANGE);
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
				principal.agregarLlamada(1, txtMinutosLlamadas, chckLocal, chckLargaDistancia, chckCelular);
				principal.actualizar(txtMinutosLlamadas, chckLocal, chckLargaDistancia, chckCelular);
				
			}
		});
		btnAgregarLlamada.setBackground(Color.ORANGE);
		btnAgregarLlamada.setFont(new Font("Arial", Font.BOLD, 12));
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
