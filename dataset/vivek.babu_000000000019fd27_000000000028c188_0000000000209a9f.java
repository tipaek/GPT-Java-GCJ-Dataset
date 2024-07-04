import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int tcase = 1;
		while(t-- > 0) {
			String s = br.readLine();
			int closBrac = 0;
			int prev = 0;
			int curr,i,j;
			StringBuilder str = new StringBuilder();
			for(i = 0; i<s.length(); i++) {
				curr = s.charAt(i)-'0';
				if(curr==prev) {
					str.append(curr);
				}else if(curr>prev) {
					for(j=0; j<(curr-prev); j++) {
						str.append("(");
					}
					str.append(curr);
					closBrac = curr;
					prev = curr;
				}else {
					
					for(j=0; j<(prev-curr); j++) {
						str.append(")");
					}
					str.append(curr);
					closBrac = curr;
					prev = curr;
				}
			}
			
			for(i=0; i<closBrac; i++) {
				str.append(")");
			}
			
			System.out.println("Case #"+tcase+": "+str);
			
			tcase++;
		}
	}
}
