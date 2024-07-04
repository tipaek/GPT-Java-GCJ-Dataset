import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a =0;
		while(a<t) {
			String s = in.next();
	
			String newStr = "";
			int opened = 0;
			for(int i=0;i<s.length();i++) {
				if (Integer.valueOf(s.charAt(i)-'0') > opened) {
					int x = Integer.valueOf(s.charAt(i)-'0');
					int z = x - opened;
					for (int q =0;q<z;q++) {
						newStr = newStr + '(';
					}
					newStr = newStr + Integer.valueOf(s.charAt(i)-'0');
					opened = z + opened;
				}
				else if (Integer.valueOf(s.charAt(i)-'0') < opened) {
					int x = Integer.valueOf(s.charAt(i)-'0');
					int z = opened - x;
					for (int q =0;q<z;q++) {
						newStr = newStr + ')';
					}
					newStr = newStr + Integer.valueOf(s.charAt(i)-'0');
					opened = x;
				}
				else if (Integer.valueOf(s.charAt(i)-'0') == opened) {
					newStr = newStr + Integer.valueOf(s.charAt(i)-'0');
				}

			}
			for(int i =0;i<opened;i++) {
				newStr = newStr + ')';
			}
			
			System.out.println("Case #"+(a+1)+": "+newStr);
			a = a+1;
			
		}
			
	}
}
