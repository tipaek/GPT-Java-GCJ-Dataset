import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            solve(i, in.nextInt(), in);
        }
    }

    private static void solve(int numTest, int size, Scanner in) {
        int trace = 0;
        List<Set<Integer>> rows = IntStream.range(0, size)
                                           .mapToObj(unused -> new HashSet<Integer>(size))
                                           .collect(Collectors.toCollection(() -> new ArrayList<>(size)));
        List<Set<Integer>> cols = IntStream.range(0, size)
                                           .mapToObj(unused -> new HashSet<Integer>(size))
                                           .collect(Collectors.toCollection(() -> new ArrayList<>(size)));
        for (int numRow = 0; numRow < size; numRow++) {
            for (int numCol = 0; numCol < size; numCol++) {
                int curr = in.nextInt();

                rows.get(numRow).add(curr);
                cols.get(numCol).add(curr);

                if (numRow == numCol) {
                    trace += curr;
                }
            }
        }
        long numBrokenRows = rows.stream().filter(s -> s.size() < size).count();
        long numBrokenCols = cols.stream().filter(s -> s.size() < size).count();
        System.out.format("Case #%d: %d %d %d%n", numTest, trace, numBrokenRows, numBrokenCols);
    }
}
