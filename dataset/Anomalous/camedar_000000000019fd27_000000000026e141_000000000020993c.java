import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int diagSum = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;

            List<Set<String>> cols = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));
            scanner.nextLine();

            for (int j = 0; j < n; j++) {
                String[] lineElems = scanner.nextLine().split(" ");
                diagSum += Integer.parseInt(lineElems[j]);

                Set<String> row = new HashSet<>(Arrays.asList(lineElems));
                if (row.size() != n) {
                    rowsWithDuplicates++;
                }

                for (int k = 0; k < n; k++) {
                    cols.set(k, new HashSet<>(cols.get(k)));
                    cols.get(k).add(lineElems[k]);
                }
            }

            for (Set<String> col : cols) {
                if (col.size() != n) {
                    colsWithDuplicates++;
                }
            }

            System.out.println("Case #" + i + ": " + diagSum + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }
}