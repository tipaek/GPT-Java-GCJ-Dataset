import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++) {
            int size = scan.nextInt();
            int[][] square = new int[size][size];
            for(int row = 0; row < size; row++) {
                for(int col = 0; col < size; col++) {
                    square[row][col] = scan.nextInt();
                }
            }
            int trace = 0;
            for(int d = 0; d < size; d++) {
                trace+=square[d][d];
            }
            int dupRows = 0;
            for(int row = 0; row < size; row++) {
                int[] usedVals = new int[size];
                for(int col = 0; col < size; col++) {
                    if(usedVals[square[row][col]-1]==1) {
                        dupRows++;
                        break;
                    } else {
                        usedVals[square[row][col]-1] = 1;
                    }
                }
            }
            int dupCols = 0;
            for(int col = 0; col < size; col++) {
                int[] usedVals = new int[size];
                for(int row = 0; row < size; row++) {
                    if(usedVals[square[row][col]-1]==1) {
                        dupCols++;
                        break;
                    } else {
                        usedVals[square[row][col]-1] = 1;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i+1, trace, dupRows, dupCols);
        }
    }
}
