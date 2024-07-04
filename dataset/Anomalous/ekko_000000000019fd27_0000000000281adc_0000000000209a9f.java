import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNo = 1; caseNo <= testCases; ++caseNo) {
            String inputLine = scanner.nextLine();
            solveNestingDepth(caseNo, inputLine);
        }
    }

    private static void solveNestingDepth(int caseNo, String inputLine) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : inputLine.toCharArray()) {
            int num = ch - '0';
            if (currentDepth > num) {
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
            } else {
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
            }
            result.append(ch);
        }
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }
        System.out.println("Case #" + caseNo + ": " + result);
    }

    private static void solveVestigium(int caseNo, int n) {
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] columns = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }

        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateColumns = new HashSet<>();
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (!rows[i].add(value)) duplicateRows.add(i);
                if (!columns[j].add(value)) duplicateColumns.add(j);
                if (i == j) trace += value;
            }
        }

        System.out.println("Case #" + caseNo + ": " + trace + " " + duplicateRows.size() + " " + duplicateColumns.size());
    }
}