import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> colSets = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    rowSets.get(i).add(value);
                    colSets.get(j).add(value);
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (rowSets.get(i).size() != n) {
                    rowDuplicates++;
                }
                if (colSets.get(i).size() != n) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}