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
			
			int[] sol = new int[n];
			
			boolean impossible = false;
			
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
						sol[i] = 1;
					}
				} else {
					for(int k=start; k < end; k++) {
						jam[k] = 1;
						sol[i] = 2;
					}
				}
			}
			
			String sOut = "";
			
			if (impossible) {
				sOut = "IMPOSSIBLE";
			} else {
				for(int i=0; i < n; i++) {
					if (sol[i] == 1) {
						sOut += "C";
					} else if (sol[i] == 2) {
						sOut += "J";
					}
				}
			}
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
	
}
