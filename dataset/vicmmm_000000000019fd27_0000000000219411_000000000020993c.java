import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fst = reader.readLine();
		int T = Integer.parseInt(fst);

		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<T;i++) {
			String s = reader.readLine();
			int n = Integer.parseInt(s);
//			System.out.println(i+" "+n);
			
			
			int[][] square = new int[n][n];
			int R = 0, C = 0, k = 0;
			
			// n*n matrix
			for(int r=0;r<n;r++) {
				String rowstr = reader.readLine();
				String[] ss = rowstr.split(" ");
				
				for(int c=0;c<n;c++) {
					int num = Integer.parseInt(ss[c]);
					square[r][c] = num;
				}
			}
			
			Set<Integer> set = new HashSet<>();

			for(int r=0;r<n;r++) {
				set = new HashSet<>();
				for(int c=0;c<n;c++) {
					if(!set.add(square[r][c])) {
						R ++;
						break;
					}
				}
			}
			
			for(int c=0;c<n;c++) {
				set = new HashSet<>();
				for(int r=0;r<n;r++) {
					if(!set.add(square[r][c])) {
						C ++;
						break;
					}
				}
			}
			
			for(int r=0;r<n;r++) k += square[r][r];
			
			sb.append("Case #"+(i+1)+": "+k+" "+R+" "+C+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
