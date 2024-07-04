import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int size = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            List<Set<Integer>> columnSets = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                columnSets.add(new HashSet<>());
            }

            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);
                    columnSets.get(col).add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() < size) {
                    duplicateRows++;
                }
            }

            for (Set<Integer> colSet : columnSets) {
                if (colSet.size() < size) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}