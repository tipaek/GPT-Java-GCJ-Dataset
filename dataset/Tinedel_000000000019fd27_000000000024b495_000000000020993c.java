import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Res {
        int trace = 0;
        long cols = 0;
        long rows = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine(); // skip line to test case
            int[][] nextCase = readCase(n, in);
            Res res = solve(nextCase);
            System.out.printf("Case #%d: %d %d %d%n", i, res.trace, res.rows, res.cols);
        }
    }

    private static Res solve(int[][] nextCase) {
        Res res = new Res();
        int length = nextCase.length;
        List<BitSet> rows = new ArrayList<>(length);
        List<BitSet> cols = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            rows.add(new BitSet(length));
            cols.add(new BitSet(length));
        }

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                rows.get(row).set(nextCase[row][col] - 1);
                cols.get(col).set(nextCase[row][col] - 1);
                if (row == col) res.trace += nextCase[row][col];
            }
        }

        res.rows = rows.stream().filter(bs -> notAllNsSeen(bs, length)).count();
        res.cols = cols.stream().filter(bs -> notAllNsSeen(bs, length)).count();

        return res;
    }

    private static boolean notAllNsSeen(BitSet bs, int length) {
        int nextClearBit = bs.nextClearBit(0);
        return nextClearBit != -1 && nextClearBit < length;
    }

    private static int[][] readCase(int n, Scanner in) {
        int[][] ints = new int[n][];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            ints[i] = Arrays.stream(s.split("\\s+")).filter(el -> !el.isEmpty()).mapToInt(Integer::valueOf).toArray();
        }
        return ints;
    }
}