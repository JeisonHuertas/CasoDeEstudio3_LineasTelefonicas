package com.interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mundo.Empresa;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelTotales extends JPanel {
	private JTextField txtValorTotal;
	private JTextField txtTotalLlamadas;
	private JTextField txtTotalMinutos;
	private JTextField txtCostoPromedioMinuto;

	/**
	 * Create the panel.
	 */
	public PanelTotales() {
		setBorder(new TitledBorder(null, "Totales", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.CYAN));
		setLayout(new GridLayout(4, 2, 5, 2));
		
		JLabel lblNewLabel = new JLabel("VALOR TOTAL");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL LLAMADAS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1);
		
		txtTotalLlamadas = new JTextField();
		txtTotalLlamadas.setEditable(false);
		add(txtTotalLlamadas);
		txtTotalLlamadas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL MINUTOS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_2);
		
		txtTotalMinutos = new JTextField();
		txtTotalMinutos.setEditable(false);
		add(txtTotalMinutos);
		txtTotalMinutos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("COSTO PROMEDIO MINUTO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_3);
		
		txtCostoPromedioMinuto = new JTextField();
		txtCostoPromedioMinuto.setEditable(false);
		add(txtCostoPromedioMinuto);
		txtCostoPromedioMinuto.setColumns(10);

	}
	public void actualizar(Empresa empresa) {
		 DecimalFormat df = new DecimalFormat("#.000");
		double valorTotal = empresa.darTotalCostoLlamadasDesdeLineasAlternativas() + empresa.darTotalCostoLlamadasDesdeLineasNoAlternativas();
		int totalMinutos = empresa.darTotalMinutosDesdeLineasAlternativas() + empresa.darTotalMinutosDesdeLineasNoAlternativas();
		txtValorTotal.setText(formatearValor(valorTotal));
		txtTotalLlamadas.setText(formatearValorEntero(empresa.darTotalNumeroLlamadasDesdeLineasAlternativas() + empresa.darTotalNumeroLlamadasDesdeLineasNoAlternativas()));
		txtTotalMinutos.setText(formatearValorEntero(totalMinutos));
		txtCostoPromedioMinuto.setText(df.format( valorTotal / totalMinutos));
	}
	private String formatearValor(double valor) {
		return Double.toString(valor);
	}
	private String formatearValorEntero(int valor) {
		return Integer.toString(valor);
	}
}
