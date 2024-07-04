

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	int testCase;
	int[][][] matrixList;
	final static String CASE_= "Case #";
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCase = Integer.parseInt(br.readLine());
			matrixList = new int[testCase+1][][];
			
			for (int i=1; i<=testCase; i++) {
				int N = Integer.parseInt(br.readLine());
				matrixList[i] = new int[N+1][N+1];
				for (int j=1; j<=N; j++) {
					String[] split = br.readLine().split("\\s");
					for (int k=1; k<=N; k++) {
						matrixList[i][j][k] = Integer.parseInt(split[k-1]);
					}
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solve(int index) {
		int[][] matrix = matrixList[index];
		int k=0,r=0,c=0;
		
		for (int i=1; i < matrix.length; i++) {
			k += matrix[i][i];
		}
		
		for (int i=1; i<matrix.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j=1; j<matrix.length; j++) {
				if (set.contains(matrix[i][j])) {
					r++;
					break;
				}
				set.add(matrix[i][j]);
			}
		}
		
		for (int i=1; i<matrix.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j=1; j<matrix.length; j++) {
				if (set.contains(matrix[j][i])) {
					c++;
					break;
				}
				set.add(matrix[j][i]);
			}
		}
		
		System.out.println(CASE_+index+": "+k+" "+r+" "+c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution m = new Solution();
		m.input();
		for (int i=1; i<=m.testCase; i++) {
			m.solve(i);
		}
		
	}

}
