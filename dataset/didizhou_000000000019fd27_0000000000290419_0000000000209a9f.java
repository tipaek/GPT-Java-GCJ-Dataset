import java.util.*;
public class Solution {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for(int i = 0; i < t; i++) {
			String s = kb.next();
			int curr = 0;
			int prev = 0;
			String out = new String("");
			for(int j = 0; j < s.length(); j++) {
				prev = curr;
				curr = Integer.parseInt(s.substring(j, j+1));
				if(prev > curr) {
					for(int k = 0; k < prev - curr; k++) {
						out = out+")";
					}
				}
				else if(prev < curr) {
					for(int k = 0; k < curr - prev; k++) {
						out = out+"(";
					}
				}
				out = out+""+curr;
			}
			for(int k = 0; k < curr; k++) {
				out = out+")";
			}
			System.out.println("Case #"+(i+1)+": "+out);
		}
	}
}