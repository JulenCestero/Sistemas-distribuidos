package Ejercicio_3;
import java.io.*;

public class Ejercicio_3 {

	public static void main(String[] args) throws IOException{
		int x1;
		long Fact;
		String str1;
		BufferedReader InBuf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***Factorial of a number***\r");
		System.out.println("Choose the number: ");
		str1 = InBuf.readLine();
		x1 = Integer.parseInt(str1);
		Fact = x1;
		for(int ii = x1 - 1; ii > 0; ii--){
			Fact *= ii;
		}
		System.out.println("\rFactorial of " + x1 + " is: " + Fact);
	}

}
