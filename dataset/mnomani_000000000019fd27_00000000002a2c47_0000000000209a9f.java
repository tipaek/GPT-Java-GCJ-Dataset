import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int c = 1;
		for(; t > 0; t--) {
			String s = sc.next();
	
			String out = ""+s.charAt(0);
			
			for(int i = 0; i < Integer.parseInt(String.valueOf(s.charAt(0))); i++) {
				out = "(" + out + ")";
			}
			
			for(int i = 1; i < s.length(); i++) {
				if(s.charAt(i) >= s.charAt(i-1)) {
					int diff = s.charAt(i) - s.charAt(i-1);
					int numChars = 0;
					int j = 0;
					for(; numChars < i; j++) {
						if(out.charAt(j) != '(' && out.charAt(j) != ')')
							numChars++;
					}
	
					String add = "";
					String addB = "";
					for(int k = 0; k < diff; k++) {
						add += "(";
						addB += ")";
					}
					out = out.substring(0,j) + add + s.charAt(i) + out.substring(j) + addB;
				} else {
					int diff =  s.charAt(i-1) - s.charAt(i);
					int numChars = 0;
					int j = 0;
					for(; numChars < i; j++) {
						if(out.charAt(j) != '(' && out.charAt(j) != ')')
							numChars++;
					}
					out = out.substring(0,j+diff) + s.charAt(i) + out.substring(j+diff);
				}
			}
			System.out.println("Case #" + c + ": " + out);
			c++;
		}

	}

}
