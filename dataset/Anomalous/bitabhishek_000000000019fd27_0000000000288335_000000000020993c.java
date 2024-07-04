import java.util.*;

class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int trace = 0;
            int n = scanner.nextInt();
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> cols = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    rows.get(i).add(num);
                    cols.get(j).add(num);

                    if (i == j) {
                        trace += num;
                    }
                }
            }

            int rowCount = countIncompleteSets(rows, n);
            int colCount = countIncompleteSets(cols, n);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber++, trace, rowCount, colCount);
        }
    }

    private static int countIncompleteSets(List<Set<Integer>> sets, int expectedSize) {
        int count = 0;
        for (Set<Integer> set : sets) {
            if (set.size() != expectedSize) {
                count++;
            }
        }
        return count;
    }
}