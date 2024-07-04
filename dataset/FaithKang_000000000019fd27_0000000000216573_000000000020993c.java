import java.util.LinkedList;
import java.util.Scanner;
public class Solution {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
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
				boolean same_row = false;
				boolean same_col = false;
				LinkedList<Integer> r = new LinkedList<Integer>();
				LinkedList<Integer> c = new LinkedList<Integer>();
				r.add(map[j][0]);
				c.add(map[0][j]);
//				System.out.println("num_c : "+num_c);
				
				for(int k = 1;k < N; k++) {
					
					if(r.contains(map[j][k])) {
						same_row = true;
						
					}
					else {
						r.add(map[j][k]);
					}
					if(c.contains(map[k][j])) {
//						System.out.println("different col"+map[k][j]);
						same_col = true;
						
					}
					else {
						c.add(map[k][j]);
					}
					
					
				}
				if(same_row)	row++;
				if(same_col)	col++;
			}
			System.out.println("#"+(i+1)+" "+sum+" "+row+" "+col);
			
		}
	}
}
