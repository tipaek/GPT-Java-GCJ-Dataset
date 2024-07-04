import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int n = in.nextInt();
            int[][] array = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    array[j][k] = in.nextInt();
                }
            }

            getRes(index, n, array);
        }
    }

    private static void getRes(int index, int n, int[][] array) {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> countC = new HashMap<>();
            HashMap<Integer, Integer> countR = new HashMap<>();
            for (int j = 0; j < n; j++) {
                countC.put(array[i][j], countC.getOrDefault(array[i][j], 0) + 1);
                countR.put(array[j][i], countR.getOrDefault(array[j][i], 0) + 1);
            }
            for (int key : countC.keySet()) {
                if (countC.get(key) > 1) {
                    r++;
                    break;
                }
            }
            for (int key : countR.keySet()) {
                if (countR.get(key) > 1) {
                    c++;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            k += array[i][i];
        }

        System.out.println("Case #" + index + ": " + k + " " + r + " " + c);
    }
}