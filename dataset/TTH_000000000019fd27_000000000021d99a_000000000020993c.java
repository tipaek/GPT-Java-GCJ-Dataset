import java.io.*;
import java.util.*;

public class Solution {
    
  public static void main(String[] args)  throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] matrix = new int[n][n];
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					matrix[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int trace = 0;
			for(int k=0; k<n; k++) {
				trace+=matrix[k][k];
			}
			int col = 0,row = 0;
			ArrayList<HashSet<Integer>> rowset = new ArrayList<>();
			ArrayList<HashSet<Integer>> colset = new ArrayList<>();
			for(int j=0; j<n; j++) {
				rowset.add(new HashSet<Integer>());
				colset.add(new HashSet<Integer>());
			}
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					rowset.get(j).add(matrix[j][k]);
					colset.get(k).add(matrix[j][k]);
				}
			}
			for(int j=0; j<n; j++) {
				col += colset.get(j).size()==n ? 0:1;
				row += rowset.get(j).size()==n ? 0:1;
			}
			sb.append("Case #"+(i+1)+": "+" "+trace+" "+row+" "+col+"\n");
		    
		}
		System.out.print(sb.toString());
	}

}
