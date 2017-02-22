package Ejercicio_4;
import java.io.*;

public class Ejercicio_4 {

	public static void main(String[] args) throws IOException{
		int x1;
		char c;
		double val;
		String str1 = "";
		System.out.println("***Automatic number generation***\r");
		System.out.print("Intro number of numbers: ");
		while((c = (char)System.in.read()) != '\r'){
			if(c >= '0' && c <= '9'){
				str1 = str1 + c;
			}
		}
		x1 = Integer.parseInt(str1);
		while((x1--) > 0){
			val = Math.random();
			val *= 10.0;
			System.out.println("Number: " + val);
		}
	}

}
