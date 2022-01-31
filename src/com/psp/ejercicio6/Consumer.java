package com.psp.ejercicio6;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer extends Thread{
	
	private final VariableCompartida variableCompartida;
	   private final AtomicInteger numeroDeProductoresCorriendo;

	   public Consumer(VariableCompartida variableCompartida, AtomicInteger numeroDeProductoresCorriendo) {
	      this.variableCompartida = variableCompartida;
	      this.numeroDeProductoresCorriendo = numeroDeProductoresCorriendo;
	   }

	   public void run() {
	      while(this.numeroDeProductoresCorriendo.get()>0){
	         synchronized (variableCompartida) {
	            while (!variableCompartida.isAvailable() && numeroDeProductoresCorriendo.get()>1) {
	               try {
	                  variableCompartida.wait();
	               } catch (InterruptedException e) {
	                  e.printStackTrace();
	               }
	            }
	            int value = variableCompartida.consumir();

	            variableCompartida.notifyAll();

	            System.out.println("Consumer " + this.getId() + " got: " + value);

	         }
	      }
	   }

}
