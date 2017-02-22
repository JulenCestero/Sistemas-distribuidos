package Ejercicios_0_1;

public class Ejercicio_1 {
	public static void main(String[] args) {
		float x1 = 0, x2 = 0;
		if(args.length < 2){
			System.out.println("Two numbers are missing.. ");
		}
		else{
			x1 = Float.parseFloat(args[0]);
			x2 = Float.parseFloat(args[1]);
			if (x1 > x2) System.out.println("Mayor: " + x1);
			else if (x1 < x2) System.out.println("Mayor: " + x2);
			else if (x1 == x2) System.out.println("Iguales");
			System.out.println("Otra forma: ");
			System.out.println("El mayor es: " + Math.max(x1, x2));
		}
	}
}
