import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int caseNum = 1;
        while(t --> 0){
            int n = scan.nextInt();
            int rowCount = 0;
            int colCount = 0;
            int trace = 0;
            int[][] mat = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    mat[i][j] = scan.nextInt();
                }
            }
            for(int i = 0;i<n;i++){
                boolean[] repeatRows = new boolean[n];
                boolean[] repeatCols = new boolean[n];
                for(int j = 0;j<n;j++){
                    repeatRows[mat[i][j] - 1] = true;
                    repeatCols[mat[j][i] - 1] = true;
                    if(i == j){
                        trace += mat[i][j];
                    }
                }
                for(boolean b : repeatRows){
                    if(!b){
                        rowCount++;
                        break;
                    }
                }
                for(boolean b : repeatCols){
                    if(!b){
                        colCount++;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, rowCount, colCount);
            caseNum++;
        }
    }
}
