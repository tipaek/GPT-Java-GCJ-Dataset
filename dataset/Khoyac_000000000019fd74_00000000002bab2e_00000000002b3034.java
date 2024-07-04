package Clasificatorio;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int x = sc.nextInt();

		for (int i = 0; i < x; i++) {
			int palabras = sc.nextInt();
			sc.nextLine();
			char[] res = new char[140];
			boolean valida = true;
 			for (int j = 0; j < palabras; j++) {
				String palabra = sc.nextLine();
				String[] partida = new String[2];
				
				
				if ( !palabra.substring(0,1).equals("*") ) {
					partida = palabra.split("\\*");

					if (partida[0].length() > 0 ) {
						for (int k = 0; k < partida[0].length(); k++) {
							if ( res[k] == (char) 0 || res[k] == partida[0].charAt(k)  ) {
								res[k] = partida[0].charAt(k);
							} else {
								valida = false;
							}
						}
					} else if ( partida[1].length() > 0 ) {
						for (int k =  0; k < partida[1].length()-1; k++) {
							if ( res[139 - k] == (char) 0 || res[139 - k] == partida[1].charAt(partida[1].length() - 1 - k)  ) {
								res[139 - k] = partida[1].charAt(partida[1].length() -1 - k);
							} else {
								valida = false;
							}
						}
					}
					//System.out.println("A");
				} else {
					partida[0] = palabra.substring(0, palabra.length());
					for (int k =  0; k < partida[0].length()-1; k++) {
						if ( res[139 - k] == (char) 0 || res[139 - k] == partida[0].charAt(partida[0].length() - 1 - k)  ) {
							res[139 - k] = partida[0].charAt(partida[0].length() -1 - k);
						} else {
							valida = false;
						}
					}
					//System.out.println("B");
				}
				
			}

 			if ( valida ) {
				System.out.print("Case #" + (i+1) + ": ");
				for (int k = 0; k < 140; k++) {
					if ( res[k] != (char) 0 ) {
						System.out.print(res[k]);
					}
				}
				System.out.println();

			} else {
				System.out.println("Case #" + (i+1) + ": *");
			}
		}

	}

}
