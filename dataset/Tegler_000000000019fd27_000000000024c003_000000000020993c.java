
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(scan.readLine());
		
		for(int outerloop = 0; outerloop<T;outerloop++){
			int trace = 0;
			int n = Integer.parseInt(scan.readLine());
			int[][] mat = new int[n][n];
			
			for(int i = 0; i<n;i++){
				String[] inp = scan.readLine().split(" ");
				for(int j = 0; j<n;j++){
					mat[i][j] = Integer.parseInt(inp[j])-1;
					if(i==j){
						trace += mat[i][j] +1;
					}
				}
			}

			int rowDup = 0;
			for(int i = 0;i<n;i++){
				boolean[] set = new boolean[n];
				for(int j = 0;j<n;j++){
					if(set[mat[i][j]]){
						rowDup++;
						break;
					}
					set[mat[i][j]] = true;
				}
			}
			
			int colDup = 0;
			for(int i = 0;i<n;i++){
				boolean[] set = new boolean[n];
				for(int j = 0;j<n;j++){
					if(set[mat[j][i]]){
						colDup++;
						break;
					}
					set[mat[j][i]] = true;
				}
			}
			
			System.out.println("Case #" + (outerloop+1) + ": " + trace + " " + rowDup + " " + colDup);
		}
		

	}

}
