import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int trace = 0, rows = 0, columns = 0;
            int[] rowCount = new int[n];
            int[] columnCount = new int[n];
            ArrayList<HashSet<Integer>> colSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (i == j) trace += temp;

                    if (!rowSet.add(temp)) rowCount[i] = 1;
                    if (!colSets.get(j).add(temp)) columnCount[j] = 1;
                }
            }

            for (int count : rowCount) rows += count;
            for (int count : columnCount) columns += count;

            System.out.println("Case #" + testCase + ": " + trace + " " + rows + " " + columns);
        }

        sc.close();
    }
}