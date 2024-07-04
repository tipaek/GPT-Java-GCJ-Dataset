import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int s = sc.nextInt();
            int[][] arr = new int[s][s];
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + caseNum + ": " + calculateTrace(s, arr) + " " + countDuplicateRows(s, arr) + " " + countDuplicateColumns(s, arr));
        }
    }

    private static int calculateTrace(int s, int[][] arr) {
        int traceSum = 0;
        for (int i = 0; i < s; i++) {
            traceSum += arr[i][i];
        }
        return traceSum;
    }

    private static int countDuplicateRows(int s, int[][] arr) {
        int duplicateRowCount = 0;
        for (int i = 0; i < s; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < s; j++) {
                rowSet.add(arr[i][j]);
            }
            if (rowSet.size() < s) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int s, int[][] arr) {
        int duplicateColumnCount = 0;
        for (int i = 0; i < s; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < s; j++) {
                columnSet.add(arr[j][i]);
            }
            if (columnSet.size() < s) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }
}