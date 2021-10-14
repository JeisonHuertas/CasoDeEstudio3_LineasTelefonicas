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
	// asociaciones con panelLineas
	private PanelLinea panelLinea1;
	private PanelLinea panelLinea2;
	private PanelLinea panelLinea3;
	private PanelTotales panelTotales;
	private PanelReiniciar panelReiniciar;
	private PanelLineaCelular panelLineaCelular;
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
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panelLinea1 = new PanelLinea(this,255,62,0,1);
		panelLinea1.setBounds(5, 5, 360, 229);
		contentPane.add(panelLinea1);
		panelLinea2 = new PanelLinea(this,0,212,37,2);
		panelLinea2.setBounds(370, 5, 360, 229);
		contentPane.add(panelLinea2);
		panelLinea3 = new PanelLinea(this,0,111,255,3);
		panelLinea3.setBounds(735, 5, 360, 229);
		contentPane.add(panelLinea3);
		panelLineaCelular = new PanelLineaCelular(this);
		panelLineaCelular.setBounds(5, 239, 440, 229);
		contentPane.add(panelLineaCelular);
		panelTotales = new PanelTotales();
		panelTotales.setBounds(455, 239, 430, 229);
		contentPane.add(panelTotales);
		panelReiniciar = new PanelReiniciar(this);
		panelReiniciar.setBounds(895, 239, 200, 229);
		contentPane.add(panelReiniciar);
		
	}
	public Empresa darEmpresa() {
		return empresa;
	}
	public void actualizarTotales() {
		panelTotales.actualizar(empresa);
	}
	public void reiniciarLineasAlternativas() {
		empresa.reiniciarLineasAlternativas();
		panelLineaCelular.actualizar(darEmpresa().darLineaCelular());
		actualizarTotales();
		
	}
	public void reiniciarLineasNoAlternativas() {
		empresa.reiniciarLineasNoAlternativas();
		panelLinea1.actualizar(darEmpresa().darLinea1());
		panelLinea2.actualizar(darEmpresa().darLinea2());
		panelLinea3.actualizar(darEmpresa().darLinea3());
		actualizarTotales();
	}
}
