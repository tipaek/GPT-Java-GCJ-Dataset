import java.util.Scanner;
public class solution{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int sum = 0;
			int row = 0;
			int col = 0;
			for(int r = 0;r<N;r++) {
				for(int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			for(int j = 0;j < N ; j++) {
				sum += map[j][j];
				boolean same_row = true;
				boolean same_col = true;
				for(int k = 0;k < N; k++) {
					if(k<N-1) {
						if(map[j][k] != map[j][k+1]) {
							same_col = false;
							break;
						}
						if(map[k][j] != map[k+1][j]) {
							same_row = false;
							break;
						}
					}
					
				}
				if(same_row)	row++;
				if(same_col)	col++;
			}
			System.out.println("#"+i+" "+sum+" "+row+" "+col);
			
		}
	}
}