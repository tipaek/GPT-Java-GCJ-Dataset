import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	
	static class comp implements Comparator<String> {
	 
		public int compare (String x, String y) {
			
			
			if (x.length() < y.length()) return -1;
			
			return 1;
			
		}
	}

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m;
		String[] strs;
		String hold;
		
		boolean works;
		
		for (int i = 1; i < n + 1; i++) {
			
			
			m = scanner.nextInt();
			strs = new String[m];
			int diff;
			
			works = true;
			
			for (int j = 0; j < m; j++) {
				
				hold = scanner.next();
				hold = hold.substring(1, hold.length());
				
				strs[j] = hold;
				
			}
			
			Arrays.sort(strs, new comp());
			
			for (int j = 1; j < m; j++) {
				
				diff = strs[j].length() - strs[j - 1].length();
				
				if (strs[j].length() == strs[j - 1].length()) {
					
					if (!(strs[j].equals(strs[j - 1]))) {
						
						System.out.println("Case #" + i + ": *");
						works = false;
						break;
						
					}
					
				} else {
					
					if (!(strs[j].substring(diff).equals(strs[j - 1]))) {
						
						System.out.println("Case #" + i + ": *");
						works = false;
						break;
						
					}
					
				}
				
				/*
				if (!(strs[i].substring(diff).equals(strs[j - 1]))) {
					
					System.out.println("Case #" + i + ": *");
					works = false;
					break;
					
				}
				*/
				
				/*
				if (!(strs[j].contains(strs[j - 1]))) {
					
					System.out.println("Case #" + i + ": *");
					works = false;
					
				} 
				*/
			}
			
			
			if (works) {
				System.out.println("Case #" + i + ": " + strs[strs.length - 1]);
			}
			
			
			
		}
		
	}
	

}
