import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); //Test Cases
		for (int i = 1; i <= t; ++i) {
			String str = in.next();
			
			StringBuffer buffer = new StringBuffer();
			
			for (int o = 0; o < str.length(); o++) {
				int digitUno = Integer.valueOf(str.substring(o, o+1));
				if (o == 0) {
					annadirParentesis(buffer, digitUno, true);
				}
				
				if (o < (str.length()-1)) {
					int digitDos = Integer.valueOf(str.substring(o+1, o+2));
					int resta = digitUno - digitDos;
					
					if (resta < 0) {
						buffer.append(digitUno);
						annadirParentesis(buffer, resta * -1  , true);
					} else if (resta == 0) {
						buffer.append(digitUno);
					} else if (resta > 0) {
						buffer.append(digitUno);
						annadirParentesis(buffer, resta, false);
					}
				} else {
					buffer.append(digitUno);
				}
				
				if (o == (str.length()-1)) {
					annadirParentesis(buffer, digitUno, false);
				}
			}
			
			System.out.println("Case #" + i + ": " + buffer.toString());
		}
	}
	
	public static void annadirParentesis(StringBuffer buffer, int size, boolean apertura) {
		for (int o = 0; o < size; o++) {
			if (apertura) {
				buffer.append("(");
			} else {
				buffer.append(")");
			}
		}
	}
	
}

