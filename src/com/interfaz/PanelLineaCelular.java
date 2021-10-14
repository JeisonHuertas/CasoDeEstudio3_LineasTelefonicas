package com.interfaz;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.mundo.LineaCelular;
import com.mundo.LineaTelefonica;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class PanelLineaCelular extends JPanel {
	private JTextField txtValorTotalLinea;
	private JTextField txtNumeroLlamadas;
	private JTextField txtMinutosLocales;
	private JTextField txtSaldoLocal;
	private JTextField txtMinutosCelular;
	private JTextField txtMinutosLlamadas;
	private JTextField txtSaldoLocalDisponible;
	private JCheckBox chckLocal;
	private JCheckBox chckCelular;
	private Interfaz principal;
	private JTextField txtCostoPromedio;
	
	/**
	 * Create the panel.
	 */
	public PanelLineaCelular(Interfaz principal) {
		this.principal = principal;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Linea Celular", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.MAGENTA));
		setLayout(new GridLayout(6, 3, 5, 2));
		chckLocal = new JCheckBox("Local");
		chckLocal.setFont(new Font("Arial", Font.BOLD, 12));
		add(chckLocal);
		JLabel lblNewLabel = new JLabel("Valor Total Linea");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel);
		txtValorTotalLinea = new JTextField();
		txtValorTotalLinea.setEditable(false);
		add(txtValorTotalLinea);
		txtValorTotalLinea.setColumns(10);
		
		chckCelular = new JCheckBox("Celular");
		chckCelular.setFont(new Font("Arial", Font.BOLD, 12));
		add(chckCelular);
		
		JLabel lblNewLabel_1 = new JLabel("Numero Llamadas");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1);

		txtNumeroLlamadas = new JTextField();
		txtNumeroLlamadas.setEditable(false);
		add(txtNumeroLlamadas);
		txtNumeroLlamadas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SALDO LOCAL");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Minutos Locales");
		lblNewLabel_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1);
		
		txtMinutosLocales = new JTextField();
		txtMinutosLocales.setEditable(false);
		add(txtMinutosLocales);
		txtMinutosLocales.setColumns(10);
		
		
		txtSaldoLocalDisponible = new JTextField();
		txtSaldoLocalDisponible.setEditable(false);
		txtSaldoLocalDisponible.setText(Double.toString(principal.darEmpresa().darLineaCelular().darSaldoDisponibleLocal()));
		add(txtSaldoLocalDisponible);
		txtSaldoLocalDisponible.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Minutos Celular");
		lblNewLabel_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1_1);
		
		txtMinutosCelular = new JTextField();
		txtMinutosCelular.setEditable(false);
		txtMinutosCelular.setColumns(10);
		add(txtMinutosCelular);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo Promedio");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Minutos Llamada");
		lblNewLabel_1_1_1_2.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		add(lblNewLabel_1_1_1_2);
		
		txtMinutosLlamadas = new JTextField();
		add(txtMinutosLlamadas);
		txtMinutosLlamadas.setColumns(10);
		
		txtCostoPromedio = new JTextField();
		txtCostoPromedio.setEditable(false);
		add(txtCostoPromedio);
		txtCostoPromedio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		add(lblNewLabel_3);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int minutos = 0;
				if(txtMinutosLlamadas.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Ingrese la cantidad de minutos", "warning", JOptionPane.WARNING_MESSAGE);
				}else {
					 minutos = Integer.parseInt(txtMinutosLlamadas.getText());
				}
				if (!chckLocal.isSelected() && !chckCelular.isSelected()) {
					JOptionPane.showMessageDialog(null, "Seleccione una opcion", "warning", JOptionPane.WARNING_MESSAGE);
					return;
				}else if(chckLocal.isSelected() && !chckCelular.isSelected()) {
					
					principal.darEmpresa().agregarLlamadaLocalLineaCelular1(minutos);
					actualizar(principal.darEmpresa().darLineaCelular());
				}else if(!chckLocal.isSelected() && chckCelular.isSelected()) {
					principal.darEmpresa().agregarLlamadaCelularLineaCelular1(minutos);
					actualizar(principal.darEmpresa().darLineaCelular());
				}else {
					JOptionPane.showMessageDialog(null, "Solo seleccione una opcion", "warning", JOptionPane.WARNING_MESSAGE);
					chckLocal.setSelected(false);
					chckCelular.setSelected(false);
				}
				
			}
		});
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregar.setBackground(Color.MAGENTA);
		add(btnAgregar);
	}
	public void actualizar(LineaCelular linea) {
		txtValorTotalLinea.setText(formatearValor(linea.darCostoLlamadas()));
		txtNumeroLlamadas.setText(formatearValorEntero(linea.darNumeroLlamadas()));
		txtMinutosLocales .setText(formatearValorEntero(linea.darNumeroMinutosLocal()));
		txtMinutosCelular.setText(formatearValorEntero(linea.darNumeroMinutosCelular()));
		txtSaldoLocalDisponible.setText(formatearValor(linea.darSaldoDisponibleLocal()));
		 DecimalFormat df = new DecimalFormat("#.000");
		 String cPromedio = df.format(principal.darEmpresa().darCostoPromedioMinutosDesdeLineasAlternativas());
		 if (principal.darEmpresa().darTotalMinutosDesdeLineasAlternativas() == 0 ) {
			 txtCostoPromedio.setForeground(Color.RED);
				txtCostoPromedio.setFont(new Font("Arial", Font.BOLD, 12));
			 txtCostoPromedio.setText("Realize una llamada!!!");
		 }else {
			 txtCostoPromedio.setFont(new Font("Tahoma", Font.PLAIN, 11));
			 txtCostoPromedio.setForeground(Color.BLACK);
			 txtCostoPromedio.setText(cPromedio);
		 }
		principal.actualizarTotales();
	}
	private String formatearValor(double valor) {
		return Double.toString(valor);
	}
	private String formatearValorEntero(int valor) {
		return Integer.toString(valor);
	}
}
