import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            HashMap<Integer, HashSet<Integer>> columnSets = new HashMap<>();
            for (int i = 0; i < n; i++) {
                columnSets.put(i, new HashSet<>());
            }

            boolean[] hasColRepeat = new boolean[n];

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasRowRepeat = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    if (!hasRowRepeat && !rowSet.add(value)) {
                        rowRepeats++;
                        hasRowRepeat = true;
                    }

                    if (!hasColRepeat[j] && !columnSets.get(j).add(value)) {
                        colRepeats++;
                        hasColRepeat[j] = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}