import java.util.Scanner;

public class P4_ESAbATAd {
	
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
        		
        		pedirNumeros(cadena, 1, 5);
        		
        		pedirNumeros(cadena, 16, 20);
        		
        		llamarCuatro(auxdena);
        		
        		f = comprobarFluctuacion(cadena, auxdena, 0, 1, 19, 18);
        		
        		if (f != 0 ) {
        			arreglarCadena(cadena, f);
        		}
        		
        		pedirNumeros(cadena, 6, 11);
        		
        		llamarCuatro(auxdena);
        		
        		f = comprobarFluctuacion(cadena, auxdena, 0, 4, 19, 15);
        		
        		if (f != 0 ) {
        			arreglarCadena(cadena, f);
        		}
        		
        		pedirNumeros(cadena, 12, 15);
        		
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
		System.out.println(19);
		v[19] = sc.nextInt();
		System.out.println(17);
		v[17] = sc.nextInt();
		
	}
	
	public static int comprobarFluctuacion(int[] v, int[] y, int a, int b, int z, int x) {
		
		if ( v[a] == y[a] && v[b] == y[b] && y[z] == v[z] && v[x] == y[x] ) {
			return 0;
		}
		
		if ( v[a] == y[z] && v[b] == y[x] ) {
			return 1;
		}
		
		if ( 	((v[a] == 0 && y[a] == 1) || (v[a] == 1 && y[a] == 0)) && 
				((v[b] == 0 && y[b] == 1) || (v[b] == 1 && y[b] == 0)) &&
				((v[z] == 0 && y[z] == 1) || (v[z] == 1 && y[z] == 0)) &&
				((v[x] == 0 && y[x] == 1) || (v[x] == 1 && y[x] == 0))
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
	
	public static void pedirNumeros(int[] v, int a, int b ) {
		for (int j = a; j <= b; j++) {
			System.out.println( (j) );
			v[j-1] = sc.nextInt();
		}
	}

}
