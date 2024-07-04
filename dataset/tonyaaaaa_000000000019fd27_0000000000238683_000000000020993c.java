import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = scan.nextInt();

            int trace = 0;
            int rowsWithDuplicates = 0;
            List<Set<Integer>> colSets = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    int cell = scan.nextInt();
                    if (row == col) trace += cell;
                    rowSet.add(cell);
                    if (row == 0) colSets.add(new HashSet<>());
                    colSets.get(col).add(cell);
                }
                if (rowSet.size() < n) rowsWithDuplicates++;
            }
            int colsWithDuplicates = (int) colSets.stream().filter(colSet -> colSet.size() < n).count();

            System.out.println("Case #" + test + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }
}