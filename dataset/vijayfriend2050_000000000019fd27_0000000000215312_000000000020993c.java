import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int x = 1; x <= T; ++x) {
			int k = 0;
			int r = 0;
			int c = 0;
			int N = in.nextInt();
			int[][] matrix = new int[N][N];
			for(int i=0; i<N; i++){
				Set<Integer> uniqSet = new HashSet<>();
				boolean checkRow = true;
				for (int j=0;j<N; j++){
					int num = in.nextInt();
					if(i==j){
						k+=num;
					}
					matrix[i][j]=num;
					if(checkRow){
						if (!uniqSet.contains(num)){
							uniqSet.add(num);
						} else {
							checkRow = false;
							r++;
						}
					}
				}
			}
			// column check
			for (int j=0;j<N;j++){
				Set<Integer> uniqSet = new HashSet<>();
				for (int i=0; i<N; i++){
					int num = matrix[i][j];
					
					if (!uniqSet.contains(num)){
						uniqSet.add(num);
					} else {
						c++;
						break;
					}
				}
			}
			
			System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
		}
	}
}
