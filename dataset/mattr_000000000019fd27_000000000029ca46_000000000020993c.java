import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            doCase(in, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) {
        int trace = 0, rowWithDup = 0, colWithDup = 0;

        int n = Integer.parseInt(sc.nextLine());

        if (n == 0) {
            System.out.println("Case#" + Integer.toString(n) + ": 0 0 0");
        }

        Map<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            col.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            List<Integer> currLine = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int curr = Integer.parseInt(line[j]);
                currLine.add(curr);
                col.get(j).add(curr);
                if (i == j) {
                    trace += curr;
                }
            }

            if (containsDouble(currLine)) {
                rowWithDup++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (containsDouble(col.get(i))) {
                colWithDup++;
            }
        }

        System.out.println("Case #" + Integer.toString(caseNumber)
                + ": " + Integer.toString(trace)
                + " " + Integer.toString(rowWithDup)
                + " " + Integer.toString(colWithDup)
        );
    }

    private static boolean containsDouble(List<Integer> currLine) {
        Set<Integer> seen = new HashSet<>();
        for (Integer i: currLine) {
            if (seen.contains(i)) {
                return true;
            }

            seen.add(i);
        }

        return false;
    }

}
