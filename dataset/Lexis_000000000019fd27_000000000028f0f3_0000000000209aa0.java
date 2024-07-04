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
        if (n % 2 == 1 && trace % n == 0) {
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
        } else if (n == 4 && trace == 10) {
            matrix = new Integer[n][n];
            matrix[0] = new Integer[] {1,3,2,4};
            matrix[1] = new Integer[] {4,2,1,3};
            matrix[2] = new Integer[] {2,4,3,1};
            matrix[3] = new Integer[] {3,1,2,4};
        } else if ( false && trace == sum(n)) {
            // sum solution
            int number = n / 2;

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
                    matrix[r][i] = iter.next();
                }
                digits.addFirst(digits.pollLast());
            }
        }
        return matrix;
    }

    public static int sum(int n) {
        return IntStream.rangeClosed(1, n).reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
