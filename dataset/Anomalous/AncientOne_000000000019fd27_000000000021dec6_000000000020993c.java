import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int[][] copyMat = new int[n][n];
            int dRow = 0, dCol = 0, trace = 0;
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = sc.nextInt();
                    copyMat[j][k] = mat[j][k];
                    if (j == k) {
                        trace += mat[j][k];
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] rowCheck = new boolean[n];
                for (int k = 0; k < n; k++) {
                    int x = mat[j][k] - 1;
                    if (rowCheck[x]) {
                        dRow++;
                        break;
                    } else {
                        rowCheck[x] = true;
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n];
                for (int k = 0; k < n; k++) {
                    int x = copyMat[k][j] - 1;
                    if (colCheck[x]) {
                        dCol++;
                        break;
                    } else {
                        colCheck[x] = true;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + dRow + " " + dCol);
        }
    }
}