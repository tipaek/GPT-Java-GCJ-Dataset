import java.util.*;
import java.io.*;
import java. util. Collection;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc
    for (int p = 1; p <= t; p++) {
        int number = in.nextInt();
        int[][] array = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                array[i][j] = in.nextInt();
            }
        }
        int trace = 0;
        for (int j = 0; j < number; j++) {
            trace += array[j][j];
        }
        int rows = 0;
        int columns = 0;
        Set<Integer> setrow = new HashSet<Integer>();
        Set<Integer> setcolumn = new HashSet<Integer>();
        for (int k = 0; k < number; k++) {
            setrow.clear();
            setcolumn.clear();
            for (int m = 0; m < number; m++) {
                if (setrow.contains(array[k][m])) {
                    rows++;
                    break;
                }
                setrow.add(array[k][m]);
            }
            for (int n = 0; n < number; n++) {
                if (setcolumn.contains(array[n][k])) {
                    columns++;
                    break;
                }
                setcolumn.add(array[n][k]);
            }
        }
        System.out.println("Case #" + p + ": " + trace + " " + rows + " " + columns);
    }
 }
}