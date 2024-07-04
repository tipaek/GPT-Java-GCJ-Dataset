// Arup Guha
// Pascal Walk
// 4/10/2020

import java.util.*;

public class Solution {

	public static int[][] combo;
	
	public static void main(String[] args) {
		
		combo = new int[32][32];
		for (int i=0; i<32; i++) {
			combo[i][0] = 1;
			combo[i][i] = 1;
		}
		for (int i=2; i<32; i++)
			for (int j=1; j<i; j++)
				combo[i][j] = combo[i-1][j-1] + combo[i-1][j];
			
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		// Process cases.
		for (int loop=1; loop<=nC; loop++) {
		
			int n = stdin.nextInt();

			// Ta da!
			System.out.println("Case #"+loop+":");
			go(n);
		}
	}
	
	public static void go(int n) {
		
		if (n < 500) {
			for (int i=0; i<n; i++)
				System.out.println((i+1)+" "+1);
		}
		
		else {
			
			int sub = n - 35;
			if (sub%2 == 1) sub--;
			ArrayList<Integer> locs = new ArrayList<Integer>();
			for (int i=0; i<30; i++)
				if ((sub & (1<<i)) != 0)
					locs.add(i);
				
			ArrayList<Integer> places = new ArrayList<Integer>();
			places.add(1001);
			
			
			for (int i=0; i<locs.size(); i++) {
				
				int prev = places.get(places.size()-1);
				int pR = prev/1000;
				int pC = prev%1000;
				int nextRow = locs.get(i)+1;
				
				// Crawl left
				if (pC == 1) {
					for (int j=pR+1; j<=nextRow; j++)
						places.add(1000*j+1);
					for (int j=2; j<=nextRow; j++)
						places.add(1000*nextRow+j);
				}
				
				// Crawl right.
				else {
					for (int j=pR+1; j<=nextRow; j++)
						places.add(1000*j+j);
					for (int j=nextRow-1; j>=1; j--)
						places.add(1000*nextRow+j);
				}
			}
			
			int sum = 0;
			for (int i=0; i<places.size(); i++) {
				int code = places.get(i);
				int row = code/1000-1;
				int col = code%1000-1;
				sum += combo[row][col];
			}
			
			//System.out.println("sum is "+sum);
			
			int need = n - sum;
			int code = places.get(places.size()-1);
			int cR = code/1000;
			int cC = code%1000;
			
			if (cC == 1) {
				for (int i=0; i<need; i++) {
					places.add(1000*(cR+i+1) + 1);
				}
			}
			else {
				for (int i=0; i<need; i++) {
					places.add(1000*(cR+i+1) + (cR+i+1));
				}				
			}
				
			for (int i=0; i<places.size(); i++) {
				code = places.get(i);
				int r = code/1000;
				int c = code%1000;
				System.out.println(r+" "+c);
			}
			//System.out.println("size is "+places.size());
			
		}
	}
}