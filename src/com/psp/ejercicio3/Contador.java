package com.psp.ejercicio3;

public class Contador {
	private int contador = 0;

	public int getCuenta() {
		return contador;
	}

	public synchronized int incrementaPares() {
		this.contador++;
		return contador;
	}
}