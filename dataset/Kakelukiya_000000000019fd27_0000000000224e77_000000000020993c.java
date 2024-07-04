import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[][] array = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int element = in.nextInt();
                    array[row][col] = element;
                }
            }
            int trace = 0;
            for (int j = 0; j < size; j++) {
                trace += array[j][j];
            }
            // k r c
            int rowDup = 0;
            for (int row = 0; row < size; row++) {
                Set<Integer> uniques = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    int element = array[row][col];
                    if (uniques.contains(element)) {
                        rowDup++;
                        break;
                    } else {
                        uniques.add(element);
                    }
                }
            }

            int colDup = 0;
            for (int col = 0; col < size; col++) {
                Set<Integer> uniques = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    int element = array[row][col];
                    if (uniques.contains(element)) {
                        colDup++;
                        break;
                    } else {
                        uniques.add(element);
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowDup + " " + colDup);
        }
    }
}