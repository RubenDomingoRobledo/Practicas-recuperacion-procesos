package com.psp.ejercicio5;

class ContadorSync1 {

	private int contador = 0;

	public int getCuenta() {
		return contador;
	}

	public int incrementa() {
		this.contador++;
		return contador;
	}

}