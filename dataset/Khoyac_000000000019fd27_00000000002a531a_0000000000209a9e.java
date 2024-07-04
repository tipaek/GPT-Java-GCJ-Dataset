import java.util.Scanner;

public class Solution {
	
	static  Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

       

        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < t; i++) {

        	if (b == 10 ) {
        		int[] cadena = new int[b];

        		for (int j = 0; j < b; j++) {
        			System.out.println( (j+1) );
        			cadena[j] = sc.nextInt();
        		}

        		imprimirCadena(cadena);

        		String sol = sc.next();
        		if (sol.equals("N")) {
        			break;
        		}
        	} else if ( b == 20 ){
        		
        		int[] cadena = new int[b];
        		int[] auxdena = new int[b];
        		int f;
        		
        		llenarArray(cadena);
        		
        		for (int j = 0; j < 5; j++) {
        			System.out.println( (j+1) );
        			cadena[j] = sc.nextInt();
				}
        		
        		for (int j = 0; j < 5; j++) {
        			System.out.println( (20-j) );
        			cadena[19-j] = sc.nextInt();
				}
        		
        		llamarCuatro(auxdena);
        		
        		f = comprobarFluctuacion(cadena, auxdena);
        		
        		if (f != 0 ) {
        			arreglarCadena(cadena, f);
        		}
        		
        		for (int j = 5; j < 11; j++) {
        			System.out.println( (j+1) );
        			cadena[j] = sc.nextInt();
				}
        		
        		llamarCuatro(auxdena);
        		
        		f = comprobarFluctuacion(cadena, auxdena);
        		
        		if (f != 0 ) {
        			arreglarCadena(cadena, f);
        		}
        		
        		for (int j = 11; j < 15; j++) {
        			System.out.println( (j+1) );
        			cadena[j] = sc.nextInt();
				}
        		
        		imprimirCadena(cadena);
        		
        		String sol = sc.next();
        		if (sol.equals("N")) {
        			break;
        		}
        		
        	} else {
        		break;
        	}
        }

	}
	
	public static void llamarCuatro(int[] v ) {
		
		System.out.println(1);
		v[0] = sc.nextInt();
		System.out.println(3);
		v[2] = sc.nextInt();
		System.out.println(20);
		v[19] = sc.nextInt();
		System.out.println(18);
		v[17] = sc.nextInt();
		
	}
	
	public static int comprobarFluctuacion(int[] v, int[] a) {
		
		if ( v[0] == a[0] && v[2] == a[2] && a[19] == v[19] && v[17] == a[17] ) {
			return 0;
		}
		
		if ( v[0] == a[19] && v[2] == a[17] ) {
			return 1;
		}
		
		if ( 	((v[0] == 0 && a[0] == 1) || (v[0] == 1 && a[0] == 0)) && 
				((v[2] == 0 && a[2] == 1) || (v[2] == 1 && a[2] == 0)) &&
				((v[19] == 0 && a[19] == 1) || (v[19] == 1 && a[19] == 0)) &&
				((v[17] == 0 && a[17] == 1) || (v[17] == 1 && a[17] == 0))
			) {
			return 2;
		}
		
		return 3;
	}
	
	public static void arreglarCadena(int[] v, int f ) {
		switch (f) {
		case 1:
			invertirCadena( v );
			break;
		case 2:
			cambiarNumero(v);
			break;
		case 3:
			invertirCadena( v );
			cambiarNumero(v);
			break;
		}
	}
	
	public static void invertirCadena(int[] v) {
		int aux;
		for (int i = 0; i < v.length; i++) {
			aux = v[i];
			v[i] = v[v.length-i-1];
			v[v.length-i-1] = aux;
		}
	}
	
	public static void cambiarNumero(int[] v) {
		for (int i = 0; i < v.length; i++) {
			if (v[i] == 0 ) {
				v[i] = 1;
			} else {
				v[i] = 0;
			}
		}
	}
	
	public static void llenarArray(int[] v ) {
		for (int i = 0; i < v.length; i++) {
			v[i] = 2;
		}
	}
	
	public static void imprimirCadena(int[] cadena) {
		for (int j = 0; j < cadena.length; j++) {
			System.out.print(cadena[j]);
		}
		System.out.println();
	}

}

