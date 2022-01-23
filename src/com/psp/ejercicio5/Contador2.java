package com.psp.ejercicio5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador2 {

	private int contador = 0;
	private Lock lock = new ReentrantLock();

	public int getCuenta() {
		return contador;
	}

	public int incrementa() {
		lock.lock();
		try {
			this.contador++;
			return contador;
		}
		finally {
			lock.unlock();
		}
	}
}