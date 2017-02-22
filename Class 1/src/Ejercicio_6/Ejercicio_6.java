package Ejercicio_6;
import java.io.*;

public class Ejercicio_6 {

	public static void main(String[] args) throws IOException{
		double radio, base, altura;
		Figura[] figuras = new Figura[2];
		BufferedReader InBuf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Intro circle radio: ");
		radio = Double.parseDouble(InBuf.readLine());
		figuras[0] = new Circulo("Circulo", radio);
		
		System.out.print("Intro triangle base: ");
		base = Double.parseDouble(InBuf.readLine());
		System.out.print("Intro triangle height: ");
		altura = Double.parseDouble(InBuf.readLine());
		figuras[1] = new Triangulo("Triangulo", base, altura);
		
		for(int ii = 0; ii < 2; ii++){
			System.out.println("Area of " + figuras[ii].nombre + " = " + figuras[ii].Area() + "m2");
		}
	}

}

abstract class Figura
{
	public String nombre;
	public Figura(String nombre){
		this.nombre = nombre;
	}	
	public abstract double Area();
}

class Triangulo extends Figura
{
	public double base, altura;
	
	public Triangulo(String nombre, double base, double altura){
		super(nombre);
		this.base = base;
		this.altura = altura;		
	}
	public double Area(){
		return base * altura / 2f;
	}
}

class Circulo extends Figura
{
	public double radio;
	
	public Circulo(String nombre, double radio){
		super(nombre);
		this.radio = radio;		
	}
	public double Area(){
		return(Math.PI * Math.pow(radio, 2));
	}
	
}