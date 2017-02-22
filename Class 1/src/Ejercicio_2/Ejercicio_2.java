package Ejercicio_2;
import java.io.*;

public class Ejercicio_2 {

	public static void main(String[] args) throws IOException {
		float x1 = 0, x2 = 0;
		String str1, str2;
		BufferedReader InBuf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("First number: ");
		str1 = InBuf.readLine();
		x1 = Float.parseFloat(str1);
		System.out.println("Second number: ");
		str2 = InBuf.readLine();
		x2 = Float.parseFloat(str2);
		System.out.println("The highest one is: " + (int)Math.max(x1, x2));
	}

}
