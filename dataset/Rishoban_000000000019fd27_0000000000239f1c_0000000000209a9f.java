import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static String makeParenthesis(String s) {
		String h = "";
		
		int intial = s.charAt(0) - '0';
		int last = s.charAt(s.length()-1) - '0';
		String str = new String(new char[intial]).replace("\0", "(");
		h = h + str + intial;
		int remain = 0;
		for(int i = 1;i < s.length(); i++) {
			int a = s.charAt(i) - '0';
			int b = s.charAt(i-1) - '0';
			if(a == b) {
				h = h + a;
			}else {
				if(b > a) {
					
					int adjancy = b - a;
					String str1 = new String(new char[adjancy]).replace("\0", ")");
					h = h + str1 + a;
					remain = a;
				}else {
					int diff = a-b;
					String str2 = new String(new char[diff]).replace("\0", "(");
					h = h + str2 + a;
				}
			}
		}
		String str3 = new String(new char[last]).replace("\0", ")");
		h = h+ str3;
		return h;
	}

	public static void main(String[] args) {

		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String t1 = in.nextLine();
		int g = Integer.parseInt(t1);
		
		for(int l = 1;l <= g; ++l) {
			String f = in.nextLine();
			System.out.println("Case #" + l + ": " + makeParenthesis(f));
			
		}
		

	}

}
