import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();

            int trace = 0;
            List<Set<Integer>> seenRow = new ArrayList<>();
            List<Set<Integer>> seenCol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                seenRow.add(new HashSet<>());
                seenCol.add(new HashSet<>());
            }

            Set<Integer> duplicateRow = new HashSet<>();
            Set<Integer> duplicateCol = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int element = scanner.nextInt();
                    if (i == j) {
                        trace += element;
                    }
                    if (seenRow.get(i).contains(element)) {
                        duplicateRow.add(i);
                    }
                    if (seenCol.get(j).contains(element)) {
                        duplicateCol.add(j);
                    }
                    seenRow.get(i).add(element);
                    seenCol.get(j).add(element);
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, duplicateRow.size(), duplicateCol.size());
        }
    }

}
