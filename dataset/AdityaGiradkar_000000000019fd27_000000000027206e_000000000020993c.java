import java.util.*;
import java.io.*;

public class Solution {

    public static void trace(int T){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[][] mat = new int[N][N];
        int[][] transMat = new int[N][N];
        int[] checkRow = new int[N];
        int[] checkCol = new int[N];
        int repeatRow = 0, repeatCol = 0, traceMat = 0;
        int flagRow = 0, flagCol = 0;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = scan.nextInt();
                transMat[j][i] = mat[i][j];
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0;  j<N; j++){
                checkRow[mat[i][j]-1]++;
                checkCol[transMat[i][j]-1]++;
                if(i == j){
                    traceMat = traceMat + mat[i][j];
                }
            }
            for(int k=0; k<N; k++) {
                if (checkRow[k] > 1 && flagRow==0) {
                    repeatRow++;
                    flagRow = 1;
                }
                if (checkCol[k] > 1 && flagCol==0) {
                    repeatCol++;
                    flagCol=1;
                }
                checkCol[k] = 0;
                checkRow[k] = 0;
            }
            flagCol =0;
            flagRow =0;

        }
        T = T+1;
        System.out.println("Case #" + T + ": " + traceMat + " " + repeatRow + " " + repeatCol);
    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i=0; i<T; i++){
            trace(i);
        }
    }
}

