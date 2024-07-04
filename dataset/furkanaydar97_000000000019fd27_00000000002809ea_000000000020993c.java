import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int N, cur;
		for(int t=0 ; t<T ; t++) {
			N = sc.nextInt();
			int trace = 0, repeatedElemRow = 0, repeatedElemCol = 0;
			boolean[][] columnHash = new boolean[N+5][N+5];
			boolean[] columnCheckFlag = new boolean[N+5];
			for(int i=0 ; i<N ; i++) {
				boolean[] rowHash = new boolean[N+5];
				boolean rowCheckFlag = false;
				for(int j=0 ; j<N ; j++) {
					cur = sc.nextInt();
					if(i==j) {
						trace += cur;
					}
					if (!rowCheckFlag && rowHash[cur]) {
						repeatedElemRow++;
						rowCheckFlag = true;
					}
					rowHash[cur] = true;
					if(!columnCheckFlag[j] && columnHash[j][cur]) {
						repeatedElemCol++;
						columnCheckFlag[j] = true;
					}
					columnHash[j][cur] = true;
				}
			}
			System.out.println("Case #" + Integer.toString(t+1) + ": " + Integer.toString(trace) + " " + 
					Integer.toString(repeatedElemRow) + " " + Integer.toString(repeatedElemCol));
		}
	}
}
