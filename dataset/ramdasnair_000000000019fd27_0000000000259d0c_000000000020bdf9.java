import java.util.Scanner;
import java.util.*;

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
			
			int[] sol = new int[n];
			
			boolean impossible = false;
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i < n; i++) {
				int start = s[i];
				int end = e[i];
				
				boolean camOccupied = false;
				boolean jamOccupied = false;
				
				for(int j=start; j < end; j++) {
					if (cam[j] == 1) {
						camOccupied = true;
					}
					
					if (jam[j] == 1) {
						jamOccupied = true;
					}
				}
				
				if (camOccupied && jamOccupied) {
					impossible = true;
					break;
				}
				
				if (!camOccupied) {
					for(int k=start; k < end; k++) {
						cam[k] = 1;
					}
					sb.append('C');
					continue;
				}
				
				if (!jamOccupied) {
					for(int l=start; l < end; l++) {
						jam[l] = 1;
					}
					sb.append('J');
				}
			}
			
			String sOut = sb.toString();
			
			if (impossible) {
				sOut = "IMPOSSIBLE";
			}
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
	
}
