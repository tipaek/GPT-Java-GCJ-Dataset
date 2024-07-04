import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int square = in.nextInt();
            int[][] array = new int[square][square];
            int rowCount = 0;
            int colCount = 0;
            int diag = 0;
            for (int j = 0; j < square; j ++){
                for (int k = 0; k < square; k++) {
                  array[j][k] = in.nextInt();
                  if (j == k){
                      diag += array[j][k];
                  }
                }
            }
            for (int j = 0; j < square; j ++){
                Set<Integer> rowSet = new HashSet<Integer>();
                for (int k = 0; k < square; k++) {
                    if (rowSet.contains(array[j][k])){
                        rowCount++;
                        break;
                    }
                    rowSet.add(array[j][k]);
                }
            }

            for (int j = 0; j < square; j ++){
                Set<Integer> colSet = new HashSet<Integer>();
                for (int k = 0; k < square; k++) {
                    if (colSet.contains(array[k][j])){
                        colCount++;
                        break;
                    }
                    colSet.add(array[k][j]);
                }
            }
//            System.out.println(Arrays.deepToString(array));
            System.out.println(String.format("Case #%d: %d  %d %d", i, diag, rowCount, colCount));
        }
    }
}
