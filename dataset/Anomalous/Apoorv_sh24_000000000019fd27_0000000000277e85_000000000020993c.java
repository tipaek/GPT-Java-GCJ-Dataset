import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int s = sc.nextInt();
            int[][] arr = new int[s][s];
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int traceValue = calculateTrace(s, arr);
            int rowCount = countDuplicateRows(s, arr);
            int columnCount = countDuplicateColumns(s, arr);
            System.out.println("Case #" + x + ": " + traceValue + " " + rowCount + " " + columnCount);
        }
    }

    private static int calculateTrace(int s, int[][] arr) {
        int sum = 0;
        for (int i = 0; i < s; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int s, int[][] arr) {
        int duplicateRowCount = 0;
        for (int i = 0; i < s; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < s; j++) {
                uniqueElements.add(arr[i][j]);
            }
            if (uniqueElements.size() < s) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int s, int[][] arr) {
        int duplicateColumnCount = 0;
        for (int i = 0; i < s; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < s; j++) {
                uniqueElements.add(arr[j][i]);
            }
            if (uniqueElements.size() < s) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }
}