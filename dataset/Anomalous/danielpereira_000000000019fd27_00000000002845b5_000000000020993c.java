import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            Set<String>[] columnSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                columnSets[i] = new HashSet<>();
            }

            int diagonalSum = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            for (int row = 0; row < n; row++) {
                String[] elements = reader.readLine().split(" ");
                Set<String> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    String element = elements[col];
                    columnSets[col].add(element);
                    rowSet.add(element);
                    if (row == col) {
                        diagonalSum += Integer.parseInt(element);
                    }
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            for (Set<String> columnSet : columnSets) {
                if (columnSet.size() < n) {
                    columnRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, diagonalSum, rowRepeats, columnRepeats);
        }
    }
}