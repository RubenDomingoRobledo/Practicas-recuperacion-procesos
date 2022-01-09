package com.psp.ejercicio5;

class ContadorSync2 {

	private int contador = 0;

	public int getCuenta() {
		return contador;
	}

	public int incrementa() {
		this.contador++;
		return contador;
	}

}