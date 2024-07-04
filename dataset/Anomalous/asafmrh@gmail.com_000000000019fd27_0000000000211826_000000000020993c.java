import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[] rows = new int[n];
            int[] cols = new int[n];
            int trace = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int number = in.nextInt();
                    rows[j] += number;
                    cols[k] += number;
                    if (j == k) {
                        trace += number;
                    }
                }
            }
            int expectedSum = calculateSum(n);
            int rowDuplicates = countDuplicates(rows, expectedSum);
            int colDuplicates = countDuplicates(cols, expectedSum);
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    private static int countDuplicates(int[] arr, int expectedSum) {
        int duplicates = 0;
        for (int value : arr) {
            if (value != expectedSum) {
                duplicates++;
            }
        }
        return duplicates;
    }
}