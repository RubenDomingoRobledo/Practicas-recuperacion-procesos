package com.psp.ejercicio6;

//logica para un productor consumidor que cuenta el numero de numeros pares
public class VariableCompartida {
	
	private boolean available = false;

	   private int amount = 0;

	   public synchronized int consumir() {
	      amount++;
	    //  System.out.println("numero de pares "+ amount);
	      // hemos consumido el par y lo marcamos como consumido
	      available = false;
	      return amount;
	   }

	   public synchronized void producir(int value) {
	      // se ha producido el par y lo marcamos como producido
	      available = true;
	   }

	   public long getAmount() {
	      return amount;
	   }

	   public boolean isAvailable() {
	      return available;
	   }

}
