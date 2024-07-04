import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class LongArrSolver implements Solver {

        long[] slices;
        int numDiners;

        public LongArrSolver(Scanner scanner) {
            numDiners = Integer.parseInt(scanner.nextLine().split(" ")[1]);
            String[] tokens = scanner.nextLine().trim().split(" ");
            slices = new long[tokens.length];
            for (int j=0; j<tokens.length; ++j) {
                slices[j] = Long.parseLong(tokens[j]);
            }
        }

        @Override
        public String solve() {
            Map<Long, Integer> numToCount = new HashMap<>();
            for (long l : slices) {
                if (!numToCount.containsKey(l))
                    numToCount.put(l, 1);
                else
                    numToCount.put(l, numToCount.get(l) + 1);
            }

            List<Map.Entry<Long, Integer>> sortedSlices = numToCount.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            int maxNum = sortedSlices.get(sortedSlices.size() - 1).getValue();
            if (maxNum >= numDiners) return "0";

            if (numDiners == 2) return "1";

            for (long l : slices) {
                if (numToCount.containsKey(l*2)) return "1";
            }

            return "2";
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new LongArrSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
//         testCases();
    }

    public static void testCases() {
        String input = "4\n" +
                "1 3\n" +
                "1\n" +
                "5 2\n" +
                "10 5 359999999999 123456789 10\n" +
                "2 3\n" +
                "8 4\n" +
                "3 2\n" +
                "1 2 3";
        handleInput(new Scanner(input));
    }
}
