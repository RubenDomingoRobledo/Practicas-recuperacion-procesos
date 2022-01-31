package com.psp.ejercicio6;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread{

	private final int start;
	   private final int end;
	   private final VariableCompartida variableCompartida;
	   private final AtomicInteger numeroDeProductoresCorriendo;

	   public Producer(VariableCompartida variableCompartida, int start, int end, AtomicInteger numeroDeProductoresCorriendo) {
	      this.variableCompartida = variableCompartida;
	      this.start = start;
	      this.end = end;
	      this.numeroDeProductoresCorriendo = numeroDeProductoresCorriendo;
	      this.numeroDeProductoresCorriendo.incrementAndGet();
	   }

	   public void run() {
	      for (int i = this.start; i <= this.end; i++) {
	         if (i%2==0) {
	            synchronized (variableCompartida) {
	               while (variableCompartida.isAvailable()) {
	                  try {
	                     variableCompartida.wait();
	                  } catch (InterruptedException e) {
	                     e.printStackTrace();
	                  }
	               }
	               variableCompartida.producir(i);
	               System.out.println("Producer " + this.getId() + " put: " + i);
	               variableCompartida.notifyAll();
	            }
	         }
	      }
	   }
}
