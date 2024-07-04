import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testCases; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {
        int size = in.nextInt();
        int trace = 0;
        int duplicateRows = 0;
        Map<Integer, List<Integer>> columnIntMaps = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Set<Integer> rowInts = new HashSet<>();
            boolean currentDouble = false;
            for (int j = 0; j < size; j++) {
                int currentInt = in.nextInt();

                List<Integer> colInts = columnIntMaps.computeIfAbsent(j, k -> new ArrayList<>());
                colInts.add(currentInt);

                if (!currentDouble && rowInts.contains(currentInt)) {
                    currentDouble = true;
                    duplicateRows++;
                } else {
                    rowInts.add(currentInt);
                }
                if (i == j) {
                    trace += currentInt;
                }
            }
        }
        int duplicateCols = columnIntMaps.values().stream()
                .map(list -> list.size() == new HashSet<>(list).size() ? 0 : 1)
                .reduce(0, Integer::sum);
        System.out.println(String.format("Case #%d: %d %d %d", caseNr, trace, duplicateRows, duplicateCols));
    }
}
