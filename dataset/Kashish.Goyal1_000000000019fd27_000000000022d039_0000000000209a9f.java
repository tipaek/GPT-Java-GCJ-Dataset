import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     t  = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			String str = sc.next();
			String out = "";
			int    opening = 0;
			for (int j = 0; j < str.length(); j++) {
				int num = Integer.parseInt(str.charAt(j)+"");
				while (opening < num) {
					out += "(";
					opening++;
				}
				while (opening > num) {
					out += ")";
					opening--;
				}
				out += num;
			}
			while (opening > 0) {
				out += ")";
				opening--;
			}
			System.out.println("Case #" + i + ": " + out);
		}
		sc.close();
	}
}
