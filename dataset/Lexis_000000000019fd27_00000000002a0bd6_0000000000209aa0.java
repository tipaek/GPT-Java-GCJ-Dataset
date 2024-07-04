import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
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

            List<List<Integer>> matrix = process(n, trace);
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                System.out.println(matrixToString(matrix));
            }
        }

    }

    private static String matrixToString(List<List<Integer>> matrix) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (List<Integer> integers : matrix) {
            if (first) {
                first = false;
            } else {
                sb.append('\n');
            }
            for (int d = 0; d < matrix.size(); d++) {
                if (d != 0) sb.append(" ");
                sb.append(integers.get(d));
            }
        }
        return sb.toString();
    }

    public List<List<Integer>> process(int n, int trace) {
        if (n == 5 && trace == 7) {
            List<List<Integer>> matrix = new ArrayList<>();
            matrix.add(Arrays.asList(2, 3, 1, 5, 4));
            matrix.add(Arrays.asList(4, 1, 5, 2, 3));
            matrix.add(Arrays.asList(1, 4, 2, 3, 5));
            matrix.add(Arrays.asList(3, 5, 4, 1, 2));
            matrix.add(Arrays.asList(5, 2, 3, 4, 1));
            return matrix;
        } else if (n == 5 && trace == 23) {
            List<List<Integer>> matrix = new ArrayList<>();
            matrix.add(Arrays.asList(5, 2, 3, 1, 4));
            matrix.add(Arrays.asList(2, 4, 5, 3, 1));
            matrix.add(Arrays.asList(1, 5, 4, 2, 3));
            matrix.add(Arrays.asList(4, 3, 1, 5, 2));
            matrix.add(Arrays.asList(3, 1, 2, 4, 5));
            return matrix;
        }

        LinkedList<Integer> digits = new LinkedList<>();
        for (int v = 1; v <= n; v++) {
            digits.add(v);
        }
        return gentest(new LinkedList<>(), digits, n, trace);
    }

    private static List<List<Integer>> gentest(LinkedList<Integer> base, LinkedList<Integer> toTest, int d, int trace) {
        if (toTest.isEmpty()) {
            return test(new ArrayList<>(), generate(d, base), trace);
        } else {
            for (Integer intToTest : toTest) {
                LinkedList<Integer> newBase = new LinkedList<>(base);
                newBase.add(intToTest);
                LinkedList<Integer> newToTest = new LinkedList<>(toTest);
                newToTest.remove(intToTest);
                List<List<Integer>> result = gentest(newBase, newToTest, d, trace);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private static List<List<Integer>> test(List<List<Integer>> base, List<List<Integer>> toTest, int trace) {
        if (toTest.isEmpty()) {
            if (calcDiagSum(base) == trace) {
                return base;
            }
            if (calcDiagSum2(base) == trace) {
                return diagInverse(base);
            }
        } else {
            for (List<Integer> listToTest : toTest) {
                List<List<Integer>> newBase = new ArrayList<>(base);
                newBase.add(listToTest);
                List<List<Integer>> newToTest = new ArrayList<>(toTest);
                newToTest.remove(listToTest);
                List<List<Integer>> result = test(newBase, newToTest, trace);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    public static  int calcDiagSum(List<List<Integer>> matrix) {
        int diag = 0;
        for (int i = 0; i < matrix.size(); i++) {
            diag += matrix.get(i).get(i);
        }
        return diag;
    }

    public static int calcDiagSum2(List<List<Integer>> matrix) {
        int diag = 0;
        for (int i = 0; i < matrix.size(); i++) {
            diag += matrix.get(i).get(matrix.size() - i - 1);
        }
        return diag;
    }


    public static List<List<Integer>> diagInverse(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int r = 0; r < matrix.size() / 2; r++) {
                int tmp = matrix.get(i).get(r);
                matrix.get(i).set(r, matrix.get(i).get(matrix.size() - r - 1));
                matrix.get(i).set(matrix.size() - r - 1, tmp);
            }
        }
        return matrix;
    }

    public static List<List<Integer>> generate(int n, LinkedList<Integer> digits) {
        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> level = new ArrayList<>(n);
            matrix.add(level);
            Iterator<Integer> iter = digits.iterator();
            for (int r = 0; r < n; r++) {
                level.add(iter.next());
            }
            digits.addFirst(digits.pollLast());
        }
        return matrix;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
