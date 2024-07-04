import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }

            int trace = 0;
            Set<Integer> duplicateRowIndex = new HashSet<>();
            Set<Integer> duplicateColumnIndex = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int ij = sc.nextInt();

                    Set<Integer> row_i = rows.get(i);
                    Set<Integer> column_j = columns.get(j);

                    if (!row_i.add(ij)) {
                        duplicateRowIndex.add(i);
                    }

                    if (!column_j.add(ij)) {
                        duplicateColumnIndex.add(j);
                    }

                    if (i == j) {
                        trace += ij;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", test_case, trace, duplicateRowIndex.size(), duplicateColumnIndex.size());
        }
    }
}