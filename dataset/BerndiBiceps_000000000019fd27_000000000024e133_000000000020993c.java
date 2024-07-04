import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 0; i < tests; i++){
            int n = in.nextInt();

            int [][] mat = new int[n][n];
            int sum = 0;

            for (int row = 0; row < n; row++){
                for (int col = 0; col < n; col++){
                    mat[row][col] = in.nextInt();
                    if (row == col){
                        sum += mat[row][col];
                    }
                }
            }

            int ncol = 0;
            int nrow = 0;

            for (int row = 0; row < n; row++){

                ArrayList<Integer> rowNums = new ArrayList<>();

                for (int col = 0; col < n; col++){
                    if (rowNums.contains(mat[row][col])){
                        nrow++;
                        rowNums = new ArrayList<>();
                        break;
                    } else {
                        rowNums.add(mat[row][col]);
                    }
                }
            }

            for (int col = 0; col < n; col++){

                ArrayList<Integer> colNums = new ArrayList<>();

                for (int row = 0; row < n; row++){
                    if (colNums.contains(mat[row][col])){
                        ncol++;
                        colNums = new ArrayList<>();
                        break;
                    } else {
                        colNums.add(mat[row][col]);
                    }
                }
            }

            System.out.println(String.format("Case #%d, %d, %d, %d", i+1, sum, nrow, ncol));

        }


    }
}