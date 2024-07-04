import java.io.*;

public class Solution {
	static PrintWriter pw;
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			int N = Integer.parseInt(stdReader.readLine());
			int[][] matrix = new int[N][N];//r,c
			for(int j = 0 ; j < N ; j++) {
				String[] strs = stdReader.readLine().split(" ");
				for(int k = 0 ; k < N ; k++) {
					matrix[j][k] = Integer.parseInt(strs[k]);
				}
			}
			int kcount = 0;
			int rcount = 0;
			int ccount = 0;
			for(int j = 0 ; j < N ; j++) {
				kcount += matrix[j][j];
			}
			
			//row check
			for(int j = 0 ; j < N ; j++) {
				boolean[] used = new boolean[N];
				for(int k = 0 ; k < N ; k++) {
					if(!used[matrix[j][k] - 1]) {
						used[matrix[j][k] - 1] = true;
					}else {
						rcount++;
						break;
					}
				}
			}
			
			//col check
			for(int j = 0 ; j < N ; j++) {
				boolean[] used = new boolean[N];
				for(int k = 0 ; k < N ; k++) {
					if(!used[matrix[k][j] - 1]) {
						used[matrix[k][j] - 1] = true;
					}else {
						ccount++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+kcount+" "+rcount+" "+ccount);
		}
		stdReader.close();
	}
}