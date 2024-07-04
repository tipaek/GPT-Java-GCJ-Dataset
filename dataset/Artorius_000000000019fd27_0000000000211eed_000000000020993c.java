import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            final int size = input.nextInt();
            int trace = 0;
            final List<Set<Integer>> columnValues = new ArrayList<>(size);
            int rowWithRepeats = 0;

            for(int r = 0; r < size; ++r) {
                final Set<Integer> rowValues = new HashSet<>();
                for(int c = 0; c < size; ++c) {
                    final int element = input.nextInt();
                    if(r == c) {
                        trace += element;
                    }

                    if(r == 0) {
                        columnValues.add(new HashSet<>(size));
                    }
                    columnValues.get(c).add(element);
                    rowValues.add(element);
                }

                if(rowValues.size() != size) {
                    ++rowWithRepeats;
                }
            }

            System.out.println(String.format(
                    "Case #%d: %d %d %d",
                    t, trace, rowWithRepeats,
                    columnValues.stream().filter(v -> v.size() != size).count()
            ));
        }
    }
}