package com.mundo;

public class LineaTelefonica {
	protected int numeroLlamadas;
	protected int numeroMinutos;
	private double costoLlamadas;
	
	public LineaTelefonica() {
		this.numeroLlamadas = 0;
		this.numeroMinutos = 0;
		this.costoLlamadas = 0;
		
	}
	public void reiniciar() {
		this.numeroLlamadas = 0;
		this.numeroMinutos = 0;
		this.costoLlamadas = 0;
	}
	public double darCostoLlamadas() {
		return costoLlamadas;
	}
	public int darNumeroLlamadas() {
		return numeroLlamadas;
	}
	public int darNumeroMinutos() {
		return numeroMinutos;
	}
	public void modificarCostoLlamada(double pCostoLlamadas) {
		this.costoLlamadas += pCostoLlamadas;
	}
	public void agregarLlamadaLocal(int minutos) {
		this.costoLlamadas += minutos*35;
		this.numeroMinutos += minutos;
		this.numeroLlamadas += 1;
	}
	public void agregarLlamadaLargaDistancia(int minutos) {
		this.costoLlamadas += minutos*380;
		this.numeroMinutos += minutos;
		this.numeroLlamadas += 1;
	}
	public void agregarLlamadaCelular(int minutos) {
		this.costoLlamadas += minutos*999;
		this.numeroMinutos += minutos;
		this.numeroLlamadas += 1;
	}
	

}
