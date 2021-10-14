package com.interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelReiniciar extends JPanel {
	
	private Interfaz principal;
	
	public PanelReiniciar(Interfaz principal) {
		this();
		this.principal = principal;
	}

	/**
	 * Create the panel.
	 */
	public PanelReiniciar() {
		setBorder(new TitledBorder(null, "Reiniciar", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLACK));
		setLayout(new GridLayout(2, 1, 5, 2));
		
		JButton btnReiniciarAlternativas = new JButton("Alternativas");
		btnReiniciarAlternativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.reiniciarLineasAlternativas();
			}
		});
		btnReiniciarAlternativas.setFont(new Font("Arial", Font.BOLD, 12));
		btnReiniciarAlternativas.setBackground(Color.YELLOW);
		add(btnReiniciarAlternativas);
		
		JButton btnReiniciarNoAlternativas = new JButton("No Alternativas");
		btnReiniciarNoAlternativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.reiniciarLineasNoAlternativas();
			}
		});
		btnReiniciarNoAlternativas.setFont(new Font("Arial", Font.BOLD, 12));
		btnReiniciarNoAlternativas.setBackground(Color.YELLOW);
		add(btnReiniciarNoAlternativas);

	}

}
