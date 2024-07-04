import java.util.Scanner;

public class Solution {
	private static final Scanner sc = new Scanner(System.in);
	private static String[] REPLACE = new String[] {
			"0", 
			"\\(1\\)", 
			"\\(\\(2\\)\\)", 
			"\\(\\(\\(3\\)\\)\\)", 
			"\\(\\(\\(\\(4\\)\\)\\)\\)", 
			"\\(\\(\\(\\(\\(5\\)\\)\\)\\)\\)", 
			"\\(\\(\\(\\(\\(\\(6\\)\\)\\)\\)\\)\\)", 
			"\\(\\(\\(\\(\\(\\(\\(7\\)\\)\\)\\)\\)\\)\\)", 
			"\\(\\(\\(\\(\\(\\(\\(\\(8\\)\\)\\)\\)\\)\\)\\)\\)", 
			"\\(\\(\\(\\(\\(\\(\\(\\(\\(9\\)\\)\\)\\)\\)\\)\\)\\)\\)"
	};

	public static void main(String[] args) {
		int ncases = sc.nextInt();
		sc.nextLine();
		for (int ncase = 1; ncase <= ncases; ncase++) {
			String s = sc.nextLine();
			for (int i=1; i<REPLACE.length; i++) {
				s = s.replaceAll(Integer.toString(i), REPLACE[i]);
			}
			while (s.indexOf(")(") >= 0) s = s.replaceAll("\\)\\(", "");
			System.out.println(String.format("Case #%d: %s", ncase, s));
		}
	}
}