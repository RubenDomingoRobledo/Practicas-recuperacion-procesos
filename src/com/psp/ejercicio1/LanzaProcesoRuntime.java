package com.psp.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzaProcesoRuntime {
	public static void main(String[] args) {
		String[] command = {"cmd.exe","/c","ver/ ?"};
		try {
			Process ps = Runtime.getRuntime().exec(command);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		    String line;
		    while((line = reader.readLine()) != null){
                System.out.println(line);
            }
		    System.out.println("Valor de salida del proceso: " + ps.exitValue());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
