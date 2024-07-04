import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String [] args ) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i =1 ; i <= t ; i++) {
			int n = scan.nextInt();
			int k = 0;
			int r = 0; 
			int c = 0;
			int [][] mat = new int[n][n];
			for(int a = 0 ; a < n ; a++) {
				for(int b = 0 ; b < n ; b++) {
					mat[a][b] = scan.nextInt();
					if(a==b) {
						k += mat[a][b];
					}
				}
			}
			int [] rep = new int[n];	
			int [] cep = new int[n];
			for(int a = 0 ; a < n ; a++) {
				Arrays.fill(rep, 0);
				Arrays.fill(cep, 0);
				for(int b = 0 ; b < n ; b++) {
					rep[mat[a][b]-1] ++;
					cep[mat[b][a]-1] ++;
				}
				boolean rr = false;
				boolean cr = false;
				for(int b = 0 ; b < n ; b++)  {
					if(rep[b]>1) {
						rr = true;
					}
					if(cep[b]>1) {
						cr = true;
					}
				}
				if(rr) {
					r++;
				}
				if(cr) {
					c++;
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}
}
