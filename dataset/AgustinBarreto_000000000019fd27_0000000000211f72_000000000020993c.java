import java.util.Scanner;

public class Solution {
	int x;
	int k;
	int c;
	int r;
	int n;
	int[][] l;
	public void Answer() {
		Scanner S = new Scanner(System.in);
		n = S.nextInt();
		int[][]l = new int[n*n][n*n];
		for (int i = 0; i < l.length; i++) {
				k += l[i][i];
		}
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l.length; j++) {
				if (l[i][j]==l[i][j+1]) {
					r++;
				}
			}
		}
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l.length; j++) {
				if (l[i][j]==l[i][j*i]) {
					c++;
				}
			}
		}
		System.out.printf("Case#x:k,r,c",x,k,r,c);
	}
	public void Main() {
		Scanner S = new Scanner(System.in);
		x = S.nextInt();
		for (int i = 0; i < x; i++) {
			Answer();
		}
	}
   
}



