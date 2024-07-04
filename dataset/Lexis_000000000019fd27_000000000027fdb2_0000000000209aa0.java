import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String line = reader.readLine();
            String[] parts = line.split(" ", -1);
            int n = Integer.parseInt(parts[0]);
            int trace = Integer.parseInt(parts[1]);

            Integer[][] matrix = process(n, trace);
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (Integer[] integers : matrix) {
                    StringBuilder sb = new StringBuilder();
                    for (int d = 0; d < matrix.length; d++) {
                        if (d != 0) sb.append(" ");
                        sb.append(integers[d]);
                    }
                    System.out.println(sb.toString());
                }
            }
        }

    }

    public Integer[][] process(int n, int trace) {
        // test one of numbers
        Integer[][] matrix = null;
        if (trace % n == 0) {
            // can be solved through number
            int number = trace / n;

            LinkedList<Integer> digits = new LinkedList<>();
            digits.add(number);
            for (int i = 1; i <= n; i++) {
                if (i != number)
                    digits.add(i);
            }

            matrix = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                Iterator<Integer> iter = digits.iterator();
                for (int r = 0; r < n; r++) {
                    matrix[i][r] = iter.next();
                }
                digits.addFirst(digits.pollLast());
            }
        } else if (trace == factorial(n)) {
            // factorial solution
            matrix = new Integer[n][n];
            int v = 1;
            for (int i = 0; i < n; i++) {
                for (int r = 0; r < n; r++) {
                    matrix[i][r] = v;
                    if (v == 1) {
                        v = n;
                    } else {
                        v++;
                    }
                }
            }
        }
        return matrix;
    }

    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
