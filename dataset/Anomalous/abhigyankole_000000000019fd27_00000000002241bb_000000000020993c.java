import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder result = new StringBuilder();
        int testCases = sc.nextInt();
        long caseNumber = 1;

        while (testCases-- > 0) {
            int n = sc.nextInt();
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];
            Set<Integer> duplicateRows = new HashSet<>();
            Set<Integer> duplicateCols = new HashSet<>();
            long trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long element = sc.nextLong();
                    if (i == j) {
                        trace += element;
                    }
                    if (rowCheck[i][(int) element]) {
                        duplicateRows.add(i);
                    }
                    rowCheck[i][(int) element] = true;
                    if (colCheck[j][(int) element]) {
                        duplicateCols.add(j);
                    }
                    colCheck[j][(int) element] = true;
                }
            }

            result.append("Case #").append(caseNumber).append(": ").append(trace)
                  .append(" ").append(duplicateRows.size()).append(" ").append(duplicateCols.size())
                  .append("\n");
            caseNumber++;
        }

        System.out.print(result.toString().trim());
        sc.close();
    }
}