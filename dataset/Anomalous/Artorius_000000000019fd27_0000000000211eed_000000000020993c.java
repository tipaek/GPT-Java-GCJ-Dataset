import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = input.nextInt();
            int trace = 0;
            List<Set<Integer>> columnValues = new ArrayList<>(size);
            int rowWithRepeats = 0;

            for (int r = 0; r < size; r++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    int element = input.nextInt();
                    if (r == c) {
                        trace += element;
                    }

                    if (r == 0) {
                        columnValues.add(new HashSet<>(size));
                    }
                    columnValues.get(c).add(element);
                    rowValues.add(element);
                }

                if (rowValues.size() != size) {
                    rowWithRepeats++;
                }
            }

            long columnsWithRepeats = columnValues.stream()
                                                  .filter(v -> v.size() != size)
                                                  .count();

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowWithRepeats, columnsWithRepeats);
        }
    }
}