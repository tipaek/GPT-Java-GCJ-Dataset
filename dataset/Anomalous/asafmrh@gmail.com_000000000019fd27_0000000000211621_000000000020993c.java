import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int num = scanner.nextInt();
                    rowSums[row] += num;
                    colSums[col] += num;
                    if (row == col) {
                        trace += num;
                    }
                }
            }
            
            int expectedSum = calculateSum(n);
            int duplicateRows = countDuplicates(rowSums, expectedSum);
            int duplicateCols = countDuplicates(colSums, expectedSum);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    private static int countDuplicates(int[] array, int expectedSum) {
        int count = 0;
        for (int value : array) {
            if (value != expectedSum) {
                count++;
            }
        }
        return count;
    }
}