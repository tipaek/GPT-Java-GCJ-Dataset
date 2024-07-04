import java.util.*;
import java.io.*;

public class cj1 {

    private static boolean hasRowRepeats(int[] arr) {
        int[] counts = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
            if(counts[arr[i]]>1) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean hasColRepeats(int[][] arr, int row) {
        int[] counts = new int[arr[0].length + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i][row]]++;
            if(counts[arr[i][row]]>1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int n = 0;
        int[][] arr;
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            arr = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) {
                        sum += arr[j][k];
                    }
                }
            }
            int rowRepeats = 0;
            for (int j = 0; j < n; j++) {
                if (hasRowRepeats(arr[j])) {
                    rowRepeats++;
                }
            }
            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                if (hasColRepeats(arr, j)) {
                    colRepeats++;
                }
            }
            System.out.println("Case #" + i + ": " + sum + " " + rowRepeats + " " + colRepeats);
        }

        in.close();
      }
    }