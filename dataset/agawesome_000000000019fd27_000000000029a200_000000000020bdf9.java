import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] start;
		int[] end;
		char[] assign;
		boolean cam;
		boolean jam;
		boolean poss;
		
		for (int i = 0; i < n; i++) {
			
			int size = scanner.nextInt();
			
			start = new int[size];
			end = new int[size];
			assign = new char[size];
			cam = false;
			jam = false;
			poss = true;
			
			for (int j = 0; j < size; j++) {
				start[j] = scanner.nextInt();
				end[j] = scanner.nextInt();
			}
			
			
			for (int j = 0; j <= (24*60); j++) {
				
				for (int k = 0; k < size; k++) {
					
					if (end[k] == j) {
						
						if (assign[k] == 'C') cam = false;
						if (assign[k] == 'J') jam = false;
						
					}
					
				}
				
				for (int k = 0; k < size; k++) {
					
					if (start[k] == j) {
						
						if (!cam) {
							cam = true;
							assign[k] = 'C';
						} else if (!jam) {
							jam = true;
							assign[k] = 'J';
						} else {
							poss = false;
							break;
						}
						
						
					}
					
				}
				
				
				
				if (!poss) break;
				
				
				
			}
			
			System.out.print("Case #" + (i + 1) + ": ");
			
			if (!poss) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			
			for (char x : assign) System.out.print(x);
			System.out.println();
			
			
		}
		
		
	}

}
