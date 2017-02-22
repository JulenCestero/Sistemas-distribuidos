package Ejercicio_5;
import java.io.*;

public class Ejercicio_5 {
	double area;
	public static void main(String[] args) throws IOException{
		double radio, area;
		Ejercicio_5 ej = new Ejercicio_5();
		if (args.length < 1){
			BufferedReader InBuf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Intro radio: ");
			radio = Double.parseDouble(InBuf.readLine());
			
		}
		else{
			radio = Double.parseDouble(args[0]);
		}
		area = ej.Area(radio);
		System.out.println("Circle area of r=" + radio + "m is: " + area + "m2.");
		area = ej.area;
		System.out.println("Circle area of r=" + radio + "m is: " + area + "Has.");
	}
	public double Area(double rd){
		double area;
		area = Math.PI * Math.pow(rd, 2.0);
		this.area = area / 10000;
		return area;
	}

}
