package com.psp.ejercicio4;

class Contador {
	private int contador = 0;

	public int getCuenta() {
		return contador;
	}

	public synchronized int incrementaPares() {
		this.contador++;
		return contador;
	}
}