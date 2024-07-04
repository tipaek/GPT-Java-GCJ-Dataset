import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.valueOf(sc.nextLine());
		for(int t =1; t<=T;t++) {
			int N = Integer.valueOf(sc.nextLine());
			int trace = 0;
			int r = 0;
			int c = 0;
			boolean[] cols = new boolean[N];
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				String[] numbers = line.split(" ");
				boolean ln = false;
				for(int j=0; j<N; j++) {
					mat[i][j] = Integer.valueOf(numbers[j]);
					if(i==j) {
						trace+=mat[i][j];
					}
					if(!ln) {
						for(int k=0; k<j; k++) {
							if(mat[i][k]==mat[i][j]) {
								r++;
								ln = true;
								break;
							}
						}
					}
					if(!cols[j]) {
						for (int k = 0; k < i; k++) {
							if(mat[k][j]==mat[i][j]) {
								c++;
								cols[j] = true;
								break;
							}
						}
					}
				}
			}
			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
		}
		
		sc.close();
	}

}
