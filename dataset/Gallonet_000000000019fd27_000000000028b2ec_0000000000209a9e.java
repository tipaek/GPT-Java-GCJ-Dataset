import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < t; i++) {

        	if (b == 10 ) {
        		int[] cadena = new int[b];

        		for (int j = 0; j < b; j++) {
        			System.out.println( (j+1) );
        			cadena[j] = sc.nextInt();
        		}

        		for (int j = 0; j < b; j++) {
        			System.out.print(cadena[j]);
        		}
        		System.out.println();

        		String sol = sc.next();
        		if (sol.equals("N")) {
        			break;
        		}
        	}
        }

	}

}
