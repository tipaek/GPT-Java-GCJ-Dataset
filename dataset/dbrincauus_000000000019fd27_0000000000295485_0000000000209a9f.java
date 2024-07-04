
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Integer casos = Integer.parseInt(sc.nextLine());
		
		Integer i = 0;
		String res = "";
		while(i<casos) {
			Integer caso = i+1;
			res += "Case #" + caso + ": ";
			String linea = sc.nextLine();
			String line = "";
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == '0') {
					line += "0";
				}
				if(linea.charAt(j) == '1') {
					line += "(1)";
				}
				if(linea.charAt(j) == '2') {
					line += "((2))";
				}
				if(linea.charAt(j) == '3') {
					line += "(((3)))";
				}
				if(linea.charAt(j) == '4') {
					line += "((((4))))";
				}
				if(linea.charAt(j) == '5') {
					line += "(((((5)))))";
				}
				if(linea.charAt(j) == '6') {
					line += "((((((6))))))";
				}
				if(linea.charAt(j) == '7') {
					line += "(((((((7)))))))";
				}
				if(linea.charAt(j) == '8') {
					line += "((((((((8))))))))";
				}
				if(linea.charAt(j) == '9') {
					line += "(((((((((9)))))))))";
				}
			}
			
			while(line.contains(")(")) {
				line.replace(")(", "");
			}
			
			res += line;
			res += "\n";
			i++;
		} sc.close();
		System.out.println(res);
	}

}
