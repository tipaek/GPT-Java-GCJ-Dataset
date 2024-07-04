import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int x = 1; 
		
		for(int i = 0; i < cases; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] latin = new int[n][n];
			int sum = 0;
			int rows = 0;
			int columns = 0;
			
			for(int k = 0; k < n; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				HashSet<Integer> r = new HashSet<>();
				
				for(int l = 0; st.hasMoreTokens(); l++) {
					latin[k][l] = Integer.parseInt(st.nextToken());
					if(l == k) {
						sum += latin[k][l];
					}
					r.add(latin[k][l]);
				}
				if(r.size() != n) {
					rows++; 
				}
			}
			
			for(int c = 0; c < n; c++) {
				HashSet<Integer> col = new HashSet<>();
				for(int r = 0; r < n; r++) {
					if(col.contains(latin[r][c])) {
						columns++;
						break;
					}else {
						col.add(latin[r][c]);
					}
				}
			}
			
			System.out.println("Case #" + x + ": " + sum + " " + rows + " " + columns);
			x++;
		}

	}

}
