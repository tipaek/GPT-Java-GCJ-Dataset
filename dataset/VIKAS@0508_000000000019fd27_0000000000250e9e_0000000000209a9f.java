import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			String res = "";
			char op = '(';
			char cp = ')';
			int opc = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') {
					while (opc != 0) {
						res += cp;
						opc--;
					}
					res += str.charAt(i);
				} else {
					if (i == 0) {
						int pt = str.charAt(i) - 48;
						while (pt != 0) {
							res += op;
							pt--;
							opc++;
						}
						res += str.charAt(i);
					} else if (i != 0 && str.charAt(i) >= str.charAt(i - 1)) {
						int pt = str.charAt(i) - str.charAt(i - 1);
						while (pt != 0) {
							res += op;
							opc++;
							pt--;
						}
						res += str.charAt(i);
					} else if (i != 0 && str.charAt(i) < str.charAt(i - 1)) {
						int pt = str.charAt(i - 1) - str.charAt(i);
						while (pt != 0) {
							res += cp;
							opc--;
							pt--;
						}
						res += str.charAt(i);
					}
				}

			}
			while (opc != 0) {
				res += cp;
				opc--;
			}

			System.out.println(res);
		}
	}

}
