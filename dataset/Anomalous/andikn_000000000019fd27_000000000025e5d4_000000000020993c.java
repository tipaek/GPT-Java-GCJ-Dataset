import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            HashSet<Integer>[] columns = new HashSet[n];
            for (int i = 0; i < n; i++) {
                columns[i] = new HashSet<>();
            }

            boolean[] colRepeated = new boolean[n];

            for (int i = 0; i < n; i++) {
                HashSet<Integer> row = new HashSet<>();
                boolean rowRepeated = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    if (!rowRepeated && row.contains(value)) {
                        rowRepeats++;
                        rowRepeated = true;
                    }
                    row.add(value);

                    if (!colRepeated[j] && columns[j].contains(value)) {
                        colRepeats++;
                        colRepeated[j] = true;
                    }
                    columns[j].add(value);
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}