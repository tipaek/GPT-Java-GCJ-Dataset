import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		long cases = entrada.nextLong();
		entrada.nextLine();
		for(long cont = 1; cont<=cases; cont++) {
			
			String teste = entrada.nextLine();
			String aux = "";
			String numStr = "";
			String left = "";
			String rigth = "";
			
			for(int index = 0; index<teste.length(); index++) {
				
				teste.charAt(index);
				Character c = teste.charAt(index);
				Integer num = Integer.parseInt(""+c);
				numStr += num;
				
				left=addLeft(num, left);
				rigth=addRight(num, rigth);
			}			
			
			aux = left + numStr + rigth;
			
			System.out.println("Case #" + cont + ": " + aux);
		}
	}
	
	public static String addLeft(int num, String s) {
		
		for(int i = 0; i<num; i++) {
			s+="(";
		}
		
		return s;
		
	}
	
	public static String addRight(int num, String s) {
		
		for(int i = 0; i<num; i++) {
			s+=")";
		}
		
		return s;
		
	}

}
