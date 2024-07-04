import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static boolean testMode = false;

	public static void main(String[] args) {
		if (testMode)
			try {
				System.setIn(new FileInputStream(
						System.getProperty("user.dir")+"/src/solution/"+"jam2020_q1.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Scanner sc = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));
		int t = sc.nextInt();
		sc.nextLine();
		for (int i=1; i<=t; i++){
			String s = sc.nextLine();
			System.out.println("Case #"+i+": "+solve(s));
		}
		sc.close();
	}
	
	private static String solve(String s) {
		StringBuilder res = new StringBuilder();
		int depth = 0;
		for (int i=0; i<s.length(); i++) {
			int num = s.charAt(i)-'0';
			while (depth<num) {
				res.append("(");
				depth++;
			}
			while (depth>num) {
				res.append(")");
				depth--;
			}
			res.append(s.charAt(i));
		}
		while (depth>0) {
			res.append(")");
			depth--;
		}
		return res.toString();
	}
}
