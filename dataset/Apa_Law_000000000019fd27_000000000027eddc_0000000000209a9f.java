import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer pruebas = Integer.parseInt(sc.nextLine());
		for(int i=0;i<pruebas;i++) {
			String[] s = sc.nextLine().split("");
			int[] numeros = new int[s.length];
			for(int i2=0;i2<s.length;i2++) {
				numeros[i2] = Integer.parseInt(s[i2]);
			}
			String res = "";
			for(int i2=0; i2<numeros.length;i2++) {
				Integer numero = numeros[i2];
				if(i2==0) {
					for(int par=0;par<numero;par++) {
						res = res + "(";
					}
					res = res + numero;
					if(i2==numeros.length-1) {
						for(int par=0;par<numero;par++) {
							res = res + ")";
						}
					}
				}else{
					Integer resta = numeros[i2-1]-numero;
					if(resta>0) {
						for(int i3=0;i3<resta;i3++) {
							res = res + ")";
						}
						res = res + numero;
					}else{
						resta = Math.abs(resta);
						for(int i3=0;i3<resta;i3++) {
							res = res + "(";
						}
						res = res + numero;
					}
					if(i2==numeros.length-1) {
						for(int f=0;f<numero;f++) {
							res = res + ")";
						}
					}
				
				}
			}
			System.out.println("Case #" + (i+1) + ": " + res);
			
		}
		sc.close();
	}
	

}