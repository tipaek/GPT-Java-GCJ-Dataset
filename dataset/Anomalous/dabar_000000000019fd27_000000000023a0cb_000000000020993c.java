import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            List<String> data = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                data.add(scanner.nextLine());
            }
            TestCase testCase = new TestCase(size, data);
            int[] result = testCase.getResult();
            System.out.printf("Case #%d: %d %d %d%n", i + 1, result[0], result[1], result[2]);
        }
    }

    public static class TestCase {
        private final int size;
        private final List<String> data;

        public TestCase(int size, List<String> data) {
            this.size = size;
            this.data = data;
        }

        public int[] getResult() {
            int trace = 0;
            int rows = 0;
            int cols = 0;
            Set<String> rowSet = new HashSet<>();
            boolean[] colDupFound = new boolean[size];
            Set<String>[] colSets = new HashSet[size];
            for (int i = 0; i < size; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < size; i++) {
                rowSet.clear();
                boolean rowDupFound = false;
                String[] values = data.get(i).split(" ");
                trace += Integer.parseInt(values[i]);

                for (int j = 0; j < size; j++) {
                    if (!rowDupFound && !rowSet.add(values[j])) {
                        rows++;
                        rowDupFound = true;
                    }
                    if (!colDupFound[j] && !colSets[j].add(values[j])) {
                        cols++;
                        colDupFound[j] = true;
                    }
                }
            }

            return new int[]{trace, rows, cols};
        }
    }
}