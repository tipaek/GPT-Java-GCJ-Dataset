import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {

            int n = scanner.nextInt();

            int lines = 0;
            int columns = 0;
            int diag = 0;
            Set<Integer>[] columnSets = new Set[n];

            for (int i = 0; i < n; i++) {
                Set<Integer> numbers = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    int val = scanner.nextInt();
                    numbers.add(val);
                    if (i == j) {
                        diag += val;
                    }
                    if (columnSets[j] == null) {
                        columnSets[j] = new HashSet<>();
                    }

                    columnSets[j].add(val);
                }
                if (numbers.size() < n) {
                    lines++;
                }
            }

            for (Set<Integer> set : columnSets) {
                if (set.size() < n)
                    columns++;
            }

            System.out.println("Case #" + c + ": " + diag + " " + lines + " " + columns);
        }
    }
}