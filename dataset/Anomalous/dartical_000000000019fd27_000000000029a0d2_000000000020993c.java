import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static int t = in.nextInt();

    public static void main(String[] args) {
        for (int loop = 1; loop <= t; loop++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int r = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    r++;
                }
            }

            int c = 0;
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    c++;
                }
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + loop + ": " + trace + " " + r + " " + c);
        }
    }

    public static boolean hasDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}