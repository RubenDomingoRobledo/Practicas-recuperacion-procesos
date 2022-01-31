package com.psp.ejercicio7;

class Contador {

	private int contador = 0;

	public synchronized int getCuenta() {
		return contador;
	}

	public synchronized int incrementa() {
		this.contador++;
		return contador;
	}
}