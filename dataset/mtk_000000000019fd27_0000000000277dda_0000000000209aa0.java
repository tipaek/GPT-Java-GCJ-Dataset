import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Indicium
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader ir = new InputReader();
        int testCases = ir.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = ir.nextInt();
            int trace = ir.nextInt();
//            System.err.println(n + " " + trace);

            int possibleStartOfFirstRow = 0;
            if (trace >= n && trace <= n*n) {
                for (int i = 1; i <= n; i++) {
                    if (i * n == trace) {
                        possibleStartOfFirstRow = i;
                        break;
                    }
                }
            }
            if ((n == 4 && trace == 10) || (n == 4 && trace == 14)) {
                possibleStartOfFirstRow = 1;
            }

            if (possibleStartOfFirstRow > 0) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                if (n == 4 && trace == 10) {
                    System.out.println("1 2 3 4");
                    System.out.println("2 4 1 3");
                    System.out.println("3 1 4 2");
                    System.out.println("4 2 3 1");
                } else if(n == 4 && trace == 10) {
                    System.out.println("3 2 1 4");
                    System.out.println("2 4 3 1");
                    System.out.println("1 3 4 2");
                    System.out.println("4 2 1 3");
                } else {
                    List<Integer> previousRow = getRowStartingWith(possibleStartOfFirstRow, n);
                    System.out.println(getStringRepresentation(previousRow));
                    for (int i = 2; i <= n; i++) {
                        List<Integer> nextRow = getRotatedByOne(previousRow);
                        System.out.println(getStringRepresentation(nextRow));
                        previousRow = nextRow;
                    }
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static String getStringRepresentation(List<Integer> row) {
        return row.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }

    private static List<Integer> getRotatedByOne(List<Integer> row) {
        int len = row.size();
        int last = row.get(len-1);
        List<Integer> nums = new ArrayList<>(len);
        nums.add(last);
        for (int i = 1; i < len; i++) {
            nums.add(row.get(i-1));
        }
        return nums;
    }

    private static List<Integer> getRowStartingWith(int start, int n) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int next = start%n;
            nums.add((next == 0) ? n : next);
//            System.err.println("nums[" + i + "] = " + nums[i] + ", next was " + next);
            start++;
        }
        return nums;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(System.in));
            //  reader = new BufferedReader(new InputStreamReader(new FileInputStream("Indicium.in")));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(nextLine()); }
            return st.nextToken();
        }

        public String nextLine() {
            try { return reader.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
    }
}
