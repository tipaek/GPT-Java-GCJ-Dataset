import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int x = 0; x < t; x++) {

			int n = sc.nextInt();
			
			int[] s = new int[n];
			int[] e = new int[n];
			
			for(int i=0; i < n; i++) {
				s[i] = sc.nextInt();
				e[i] = sc.nextInt();
			}
			
			
			int[] cam = new int[1441];
			int[] jam = new int[1441];
			
			for(int i=0; i < 1441; i++) {
				cam[i] = 0;
				jam[i] = 0;
			}
			
			boolean impossible = false;
			StringBuilder sDash = new StringBuilder();
			
			for(int i=0; i < n; i++) {
				
				int start = s[i];
				int end = e[i];
				//System.out.println("Processing " + s[i] + ": " + e[i]);
				
				boolean containsCam = false;
				boolean containsJam = false;
				
				for(int j=start; j < end; j++) {
					if (cam[j] == 1) { 
						containsCam = true;
					}
					if (jam[j] == 1) {
						containsJam = true;
					}
				}
				//System.out.println("Contains Cam:  " + containsCam);
				//System.out.println("Contains Jam:  " + containsJam);
				
				if (containsCam && containsJam) {
					impossible = true;
					break;
				}
				
				if (!containsCam && !containsJam) {
					for(int j=start; j < end; j++) {
						cam[j] = 1;
					}
					sDash.append("C");
				} else if (containsCam) {
					for(int j=start; j < end; j++) {
						jam[j] = 1;
					}
					sDash.append("J");
				} else if (containsJam) {
					for(int j=start; j < end; j++) {
						cam[j] = 1;
					}
					sDash.append("C");
				}
				
			}
			
			String sOut = sDash.toString();
			
			if (impossible) sOut = "IMPOSSIBLE";
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
}