import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int i = 1; i <= T; ++i) {
            int nums = in.nextInt();
            boolean[][] visitedCol = new boolean[nums+1][nums+1];
            boolean[] visitedColSum = new boolean[nums+1];
            int colDup = 0, rowDup = 0, sum = 0;
            for (int row = 0; row < nums; row++){
                boolean[] visitedRow = new boolean[nums+1];
                boolean isInRow = false;
                for (int col = 0; col < nums; col++){
                    int v = in.nextInt();
                    if (visitedRow[v]){
                        isInRow = true;
                    }
                    visitedRow[v] = true;
                    if (row == col){
                        sum += v;
                    }
                    if (visitedCol[col][v]){
                        visitedColSum[col] = true;
                    }
                    visitedCol[col][v] = true;
                }
                if (isInRow){
                    rowDup++;
                }
            }
            for (boolean v : visitedColSum){
                if (v){
                    colDup++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i, sum, rowDup, colDup);
        }
    }
}