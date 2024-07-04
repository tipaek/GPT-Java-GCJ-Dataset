import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt();
            int repeatedRows = 0;
            int repeatedCols = 0;
            int k = 0;

            List<Set<Integer>> matrix =
                    Stream.generate(() -> new HashSet<Integer>())
                            .limit(n)
                            .collect(Collectors.toList());
            for (int i = 0; i < n; i++) {
                Set<Integer> row = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int temp = in.nextInt();
                    matrix.get(j).add(temp);
                    row.add(temp);
                    if (i == j) {
                        k += temp;
                    }
                }
                if (row.size() != n) {
                    repeatedRows++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matrix.get(i).size() != n) {
                    repeatedCols++;
                }
            }

            System.out.println(String.format("Case #%s: %s %s %s",
                    testCase, k, repeatedRows, repeatedCols));
        }
    }
}