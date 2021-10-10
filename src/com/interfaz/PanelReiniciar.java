package com.interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;

public class PanelReiniciar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelReiniciar() {
		setBorder(new TitledBorder(null, "Reiniciar", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLACK));
		setLayout(new GridLayout(2, 1, 5, 2));
		
		JButton btnReiniciarAlternativas = new JButton("Alternativas");
		btnReiniciarAlternativas.setFont(new Font("Arial", Font.BOLD, 12));
		btnReiniciarAlternativas.setBackground(Color.YELLOW);
		add(btnReiniciarAlternativas);
		
		JButton btnReiniciarNoAlternativas = new JButton("No Alternativas");
		btnReiniciarNoAlternativas.setFont(new Font("Arial", Font.BOLD, 12));
		btnReiniciarNoAlternativas.setBackground(Color.YELLOW);
		add(btnReiniciarNoAlternativas);

	}

}
