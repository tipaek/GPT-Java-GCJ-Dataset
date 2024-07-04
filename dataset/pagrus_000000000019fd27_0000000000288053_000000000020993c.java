import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            int n = s.nextInt();
            int[][] matrix = new int[n][n];

            Set<Integer> repeatRows = new HashSet<>();
            for (int i = 0; i < n; i++) {
                Set<Integer> rowNums = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int number = s.nextInt();
                    if (!rowNums.add(number)) {
                        repeatRows.add(i);
                    }
                    matrix[i][j] = number;
                }
            }

            int trace = IntStream.range(0, n).map(i -> matrix[i][i]).sum();

            Set<Integer> repeatCols = new HashSet<>();
            for (int j = 0; j < n; j++) {
                Set<Integer> colNums = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colNums.add(matrix[i][j])) {
                        repeatCols.add(j);
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d\n", t, trace, repeatRows.size(), repeatCols.size());
        }
    }

}