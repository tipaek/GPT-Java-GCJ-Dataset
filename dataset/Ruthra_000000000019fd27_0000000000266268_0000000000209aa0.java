import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	static int t = s.nextInt();
	public static void main(String[] args) {

		
		int[] a = new int[t];
		int[] b = new int[t];
		for (int i = 0; i < t; i++) {
			a[i] = s.nextInt();
			b[i] = s.nextInt();
			check(a[i], b[i], i);
		}
	/*	for(int i=0;i<t;i++){
			check(a[i], b[i], i);
		}*/
	}

	private static void check(int a, int b, int caseNo) {
		int k = 2, i, j, sum = 0, act = 1;
		int[][] mat = new int[a][a];
		if (a == b) {
			k = 1;
		} if(k > a*a){
			k = a+1;
		}
		while (k <= a) {sum=0;
			act = k;
			for (i = 0; i < a; i++) {
				for (j = 0; j < a; j++) {
					if (i > 0 && j == 0) {
						k = mat[i - 1][a - 1];
					}
					mat[i][j] = k;
					if (k >= a) {
						k = 1;
					} else {
						k++;
					}
					if (i == j) {
						sum += mat[i][j];
					}
				}
			}
			if (sum == b) {
				act = 0;
				break;
			}
			k = act+1;
		}
		String type = "IMPOSSIBLE";

		if (act == 0) {
			type = "POSSIBLE";
			System.out.println("Case #" + (caseNo + 1) + ": " + type);
			for (i = 0; i < a; i++) {
				for (j = 0; j < a; j++) {
					System.out.print(mat[i][j] + " ");
				}if(i+1!=a){
				System.out.println();}
			}
		} else {
			System.out.println("Case #" + (caseNo + 1) + ": " + type);
		}

	}

}
