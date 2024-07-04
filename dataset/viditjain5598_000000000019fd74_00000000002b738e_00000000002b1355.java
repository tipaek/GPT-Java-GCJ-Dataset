import java.util.*;
import java.math.*;

public class Solution{
	
	static boolean isEliminated(int[][] mat, int i, int j){
		int m = mat.length;
		if(m==0) return false;
		int n = mat[0].length;
		int l = 0;
		if(mat[i][j]==0){
			return false;
		}
		Integer a = mat[i][j];
		Integer avg = 0;
		for(int k=i+1; k<m; k++){
			if(mat[k][j]!=0){
				avg += mat[k][j];
				l++;
				break;
			}
		}
		for(int k=j+1; k<n; k++){
			if(mat[i][k]!=0){
				avg += mat[i][k];
				l++;
				break;
			}
		}
		for(int k=i-1; k>=0; k--){
			if(mat[k][j]!=0){
				avg += mat[k][j];
				l++;
				break;
			}
		}
		for(int k=j-1; k>=0; k--){
			if(mat[i][k]!=0){
				avg += mat[i][k];
				l++;
				break;
			}
		}
		return (l*a)<avg;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int tt=1; tt<=T; tt++){
			int m = in.nextInt();
			int n = in.nextInt();
			int[][] mat = new int[m][n];
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					mat[i][j] = in.nextInt();
				}
			}
			long y=0;
			while(true){
				boolean zero_el = true;
				int[][] temp = new int[m][n];
				for(int i=0; i<m; i++){
					for(int j=0; j<n; j++){
						y += mat[i][j];
						if(isEliminated(mat, i, j)){
							temp[i][j] = 0;
							zero_el = false;
						}else{
							temp[i][j] = mat[i][j];
						}
					}
				}
				mat = temp;
				if(zero_el) break;
			}
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Case #" + tt + ": " + y);
		}
	}
}