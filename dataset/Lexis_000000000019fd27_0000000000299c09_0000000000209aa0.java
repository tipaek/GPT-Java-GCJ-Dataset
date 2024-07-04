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
                for (List<Integer> integers : matrix) {
                    StringBuilder sb = new StringBuilder();
                    for (int d = 0; d < matrix.size(); d++) {
                        if (d != 0) sb.append(" ");
                        sb.append(integers.get(d));
                    }
                    System.out.println(sb.toString());
                }
            }
        }

    }

    public List<List<Integer>> process(int n, int trace) {
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> matrix = generate(n, i);
            matrix = test(new ArrayList<>(), matrix, trace);
            if (matrix != null)
                return matrix;
        }
        return null;
    }

    private static List<List<Integer>> test(List<List<Integer>> base, List<List<Integer>> toTest, int trace) {
        if (toTest.isEmpty()) {
            if (calcDiagSum(base) == trace)
                return base;
            if (calcDiagSum2(base) == trace)
                return diagInverse(base);
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

    public static List<List<Integer>> generate(int n, int number) {
        LinkedList<Integer> digits = new LinkedList<>();
        digits.add(number);
        for (int i = 1; i <= n; i++) {
            if (i != number)
                digits.add(i);
        }

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
