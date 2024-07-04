
import java.util.*;
import java.io.*;

public class Solution {
	
	public static void createString(String depths, int caseNum) {
		StringBuilder sb = new StringBuilder();
		
		int current = 0;
		int previous = 0;
		int total_paren = 0;
		
		int i = 0;
		while( i < depths.length()) {
			current = Character.getNumericValue(depths.charAt(i));
			if(i > 0) {
				previous = Character.getNumericValue(depths.charAt(i-1));
			}
			
			if(current == previous) {
				sb.append(depths.charAt(i));
			}
			else if(current > previous) {
				total_paren = 0;
				while(Math.abs(current - previous) > total_paren) {
					sb.append("(");
					total_paren++;
				}
				sb.append(depths.charAt(i));
			}
			else if(current < previous) {
				total_paren = 0;
				while(total_paren < Math.abs(current - previous)) {
					sb.append(")");
					total_paren++;
				}
				sb.append(depths.charAt(i));
			}
			i++;
		}
		
		total_paren = 0;
		while(total_paren < current) {
			sb.append(")");
			total_paren++;
		}
		
		System.out.println("Case #" + caseNum + ": " + sb.toString());
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= t; ++i) {
			String n = in.nextLine();
			createString(n, i);
		}
	}

}
