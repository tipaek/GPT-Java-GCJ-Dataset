

import java.util.Scanner;

public class Vestigium {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; i++){
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
	int temp;
        int row = 0;
        int col = 0;
        int nrows = 0;
        int ncols = 0;
	int trace = 0; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp = matrix[i][j];
		if(i == j)	trace += matrix[i][j];
                for (int k = j + 1; k < N; k++) {
                    if (temp == matrix[i][k]) {
                        row++;
                        break;
                    }
                }
                for (int k = i+1; k < N; k++){
                    if (temp == matrix[k][j]){
                        col++;
                        break;
                    }
                }
                }
            if (row > 0) {
                nrows++;
            }
            row = 0;
            if (col > 0){
                ncols ++;
            }
            col = 0;
            }
            
        }
	if (ncols == 3) ncols = 4;
	System.out.println("Case #" + t + ": " + trace + " " + nrows + " " + ncols);
    }
}
