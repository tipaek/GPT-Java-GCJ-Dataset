import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static int[] compute(int[][] mat){
        int trace = 0;
        for (int i=0; i<mat.length; i++){
            trace += mat[i][i];
        }
        
        int s = 0;
        for (int i=1; i<=mat.length; i++){
            s = s + i;
        }
        
        int r = 0;
        int c = 0;
        for (int i=0; i<mat.length; i++){
            boolean naturalR = true;
            boolean naturalC = true;
            HashSet<Integer> hsR = new HashSet<Integer>();
            HashSet<Integer> hsC = new HashSet<Integer>();
            
            for (int j = 0; j<mat.length; j++){
                if (hsR.contains(mat[i][j])) {
                		naturalR = false;
                } else {
                		hsR.add(mat[i][j]);
                }
                
                if (hsC.contains(mat[j][i])) {
	            		naturalC = false;
	            } else {
	            		hsC.add(mat[j][i]);
	            }
            }
            if (!naturalR){
                r++;
            }
            if (!naturalC){
                c++;
            }
        }
        return new int[]{trace, r, c};
    }
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
		    int n = scanner.nextInt();
		    int[][] mat = new int[n][n];
		    for (int x = 0; x < n; x++){
		        for (int y=0; y<n; y++){
		            mat[x][y] = scanner.nextInt();
		        }
		    }
			int[] result = compute(mat);
			System.out.println("Case #" + (i+1) + ": " + result[0] + " " + result[1] + " " + result[2]);
		}

	}
}