import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i=1;i<=tests;i++) {
            int matrixSize = in.nextInt();
			int sum = 0, dupCol = 0, dupRow = 0;
			int[][] matrix = new int[matrixSize][matrixSize];
			for(int j=0;j<matrixSize;j++){
                for(int k=0;k<matrixSize;k++){
					matrix[j][k] = in.nextInt();					
					if(j == k){
						sum += matrix[j][k];
					}
				}
            }
			for(int j=0;j<matrixSize;j++){
				int[] rowM = new int[matrixSize];
                for(int k=0;k<matrixSize;k++){
					if(rowM[matrix[j][k] - 1] != 0){
						dupRow++;
						break;
					}
					else {
						rowM[matrix[j][k] - 1] = matrix[j][k];
					}
				}
            }
			for(int j=0;j<matrixSize;j++){
				int[] colM = new int[matrixSize];
                for(int k=0;k<matrixSize;k++){
					if(colM[matrix[k][j] - 1] != 0){
						dupCol++;
						break;
					}
					else{
						colM[matrix[k][j] - 1] = matrix[k][j];
					}
				}
			}

            System.out.println("Case #"+i+": "+sum+" "+dupRow+" "+dupCol);
        }
    }
}