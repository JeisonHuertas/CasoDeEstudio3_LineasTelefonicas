package com.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mundo.Empresa;

import java.awt.GridLayout;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	// asociaciones con paneles lineas 1,2 y3
	private PanelLinea panelLinea1;
	private PanelLinea panelLinea2;
	private PanelLinea panelLinea3;
	private PanelLineaCelular panelLineaCelular;
	private PanelTotales panelTotales;
	private PanelReiniciar panelReiniciar;
	private Empresa empresa;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		empresa = new Empresa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 3, 5, 5));
		
		panelLinea1 = new PanelLinea(255,204,0,"1");
		contentPane.add(panelLinea1);
		panelLinea2 = new PanelLinea(0,212,37,"2");
		contentPane.add(panelLinea2);
		panelLinea3 = new PanelLinea(0,111,255,"3");
		contentPane.add(panelLinea3);
		panelLineaCelular = new PanelLineaCelular(this);
		contentPane.add(panelLineaCelular);
		panelTotales = new PanelTotales();
		contentPane.add(panelTotales);
		panelReiniciar = new PanelReiniciar();
		contentPane.add(panelReiniciar);
		
	}
	
	public void agregarLlamada(int numeroLinea, JTextField txtMinutosLlamadas, JCheckBox chckLocal, JCheckBox chckLargaDistancia,  JCheckBox chckCelular) {
		int minutos = Integer.parseInt(txtMinutosLlamadas.getText());
		
		if (!chckLocal.isSelected() && !chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
			return;
		}
		else if (chckLocal.isSelected() && !chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
			if (numeroLinea == 1) {
				empresa.agregarLlamadaLocalLinea1(minutos);
			}else if (numeroLinea == 2) {
				empresa.agregarLlamadaLocalLinea2(minutos);
			}else if (numeroLinea == 3) {
				empresa.agregarLlamadaLocalLinea3(minutos);
			}
		}
		else if (!chckLocal.isSelected() && chckLargaDistancia.isSelected() && !chckCelular.isSelected()) {
			if (numeroLinea == 1) {
				empresa.agregarLlamadaLargaDistanciaLinea1(minutos);
			}else if (numeroLinea == 2) {
				empresa.agregarLlamadaLargaDistanciaLinea2(minutos);
			}else if (numeroLinea == 3) {
				empresa.agregarLlamadaLargaDistanciaLinea3(minutos);
			}
		}
		else if (!chckLocal.isSelected() && !chckLargaDistancia.isSelected() && chckCelular.isSelected()) {
			if (numeroLinea == 1) {
				empresa.agregarLlamadaCelularLinea1(minutos);
			}else if (numeroLinea == 2) {
				empresa.agregarLlamadaCelularLinea2(minutos);
			}else if (numeroLinea == 3) {
				empresa.agregarLlamadaCelularLinea3(minutos);
			}
		}
		else {
			chckLocal.setSelected(false);
			chckLargaDistancia.setSelected(false);
			chckCelular.setSelected(false);
		}
	}
	/*
	public void actualizar( JTextField txtMinutosLlamadas, JCheckBox chckLocal, JCheckBox chckLargaDistancia,  JCheckBox chckCelular) {
		panelLinea1.actualizar(empresa.darLinea1());
		txtMinutosLlamadas.setText("");
		chckLocal.setSelected(false);
		chckLargaDistancia.setSelected(false);
		chckCelular.setSelected(false);
	} 
	*/
}
