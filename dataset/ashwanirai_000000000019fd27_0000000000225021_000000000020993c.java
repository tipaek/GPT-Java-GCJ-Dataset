
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T ; t++) {
			int N = sc.nextInt();
			int matrix[][] = new int[N][N];
			long trace = 0;
			long rowc = 0;
			long colc = 0;
			for(int i = 0 ; i < N; i++) {
				HashSet<Integer> row = new HashSet<Integer>();
				boolean rflag = false;
				for(int j = 0 ; j < N ; j++) {
					int data = sc.nextInt();
					matrix[i][j] = data;
					if(row.contains(data)!=true) {
						row.add(data);
					}
					else {
						rflag = true;
					}
					if(i == j) {
						trace+=data;
					}
				}
				if(rflag == true)
					rowc++;
			}
			
			for(int c = 0 ; c < N ; c++) {
				HashSet<Integer> col = new HashSet<>();
				boolean cflag = false;
				for(int r = 0 ; r < N  ; r++) {
					int data = matrix[r][c];
					if(col.contains(data)) {
						cflag = true;
					}
					else {
						col.add(data);
					}
				}
				if(cflag == true) {
					colc++;
				}
			}
			
			System.out.println("Case #"+t+": "+trace+" "+rowc+" "+colc);
			
		}
	}
}
