package com.psp.ejercicio6;

public class Contador {
	private int contador = 0;

	public synchronized int getCuenta() {
		return contador;
	}

	public synchronized int incrementaPares() {
		this.contador++;
		return contador;
	}
}