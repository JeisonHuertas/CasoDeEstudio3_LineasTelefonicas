package com.mundo;

public class LineaCelular extends LineaTelefonica{
	private int numeroMinutosLocal;
	private int numeroMinutosCelular;
	private double saldoDisponibleLocal;
	
	public LineaCelular() {
		this.numeroMinutosLocal = 0;
		this.numeroMinutosCelular = 0;
		this.saldoDisponibleLocal = 50000;
		this.numeroLlamadas = 0;
		this.numeroMinutos = 0;
	}
	public int darNumeroMinutosLocal() {
		return numeroMinutosLocal;
	}
	public int darNumeroMinutosCelular() {
		return numeroMinutosCelular;
	}
	public double darSaldoDisponibleLocal() {
		return saldoDisponibleLocal;
	}
	public double calcularCostoLlamadasLocal() {
		return   numeroMinutosLocal* 20;
	}
	public void agregarLlamadaLocal(int minutos) {
		this.numeroMinutosLocal += minutos;
		this.numeroMinutos += minutos;
		this.numeroLlamadas += 1;
	}
	public void agregarLlamadaCelular(int minutos) {
		this.numeroMinutosCelular += minutos;
		this.numeroMinutos += minutos;
		this.numeroLlamadas += 1;
	}
	
}
