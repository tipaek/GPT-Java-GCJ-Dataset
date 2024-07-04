import java.util.*;

public class Prob1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = 0;
			int[][] matrix = new int[n][n];
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					matrix[a][b] = sc.nextInt();
					if(a==b) {
						k+=matrix[a][b];
					}
				}
			}
			int ansR = 0, ansC = 0;
			for(int r = 0; r < n; r++) {
				boolean[] used = new boolean[n];
				boolean broken = false;
				for(int j = 0; j < n; j++) {
					if(!used[matrix[r][j]-1]) {
						used[matrix[r][j]-1] = true;
					}else {
						ansR++;
						break;
					}
				}
			}
			for(int c = 0; c < n; c++) {
				boolean[] used = new boolean[n];
				boolean broken = false;
				for(int j = 0; j < n; j++) {
					if(!used[matrix[j][c]-1]) {
						used[matrix[j][c]-1] = true;
					}else {
						ansC++;
						break;
					}
				}
			}
			System.out.println("Case #" + (i+1)+": " + k + " " + ansR + " " + ansC);
		}
		sc.close();
	}
	
}
