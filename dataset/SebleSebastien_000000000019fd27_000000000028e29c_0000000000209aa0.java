import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author schenevotot
 */
public class Solution {

    private static final boolean DEBUG = false;

    private Map<Integer, List<List<Integer>>> lsPerN = new HashMap<>(4);
    private Map<Integer, List<List<Integer>>> permPerN = new HashMap<>(4);
    private Map<Integer, List<List<List<Integer>>>> allMatrixPerN = new HashMap<>(4);

    public Solution() {

    }


    public String solve(String line) {
        String[] s = line.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<List<List<Integer>>> allMatrix = allMatrixPerN.get(n);
        for (List<List<Integer>> matrix : allMatrix) {
            if (trace(matrix) == k) {
                return "POSSIBLE\n" + toString(matrix);
            }
        }

        return "IMPOSSIBLE";
    }

    private String toString(List<List<Integer>> matrix) {
        StringBuilder res = new StringBuilder();
        int i = 1;
        for (List<Integer> row : matrix) {
            int j = 1;
            for (Integer value : row) {
                res.append(value);
                if (j < matrix.size()) {
                    res.append(" ");
                }
                j++;
            }
            if (i < matrix.size()) {
                res.append("\n");
            }
            i++;
        }
        return res.toString();
    }

    private void generateAllLS() {
        for (int i = 2; i < 6; i++) {
            lsPerN.put(i, generateLS(i));
        }
    }

    private void generateAllMatrix() {

        for (int i = 2; i < 6; i++) {

            List<List<List<Integer>>> listOfAllPossibleMatrix = new ArrayList<>();

            for (List<Integer> permutation : permPerN.get(i)) {
                List<List<Integer>> matrix = new ArrayList<>();
                for (Integer toTake : permutation) {
                    matrix.add(lsPerN.get(i).get(toTake - 1));
                }
                listOfAllPossibleMatrix.add(matrix);
            }
            allMatrixPerN.put(i, listOfAllPossibleMatrix);
        }
    }

    private void generateAllPerm() {

        List<Stream<Integer>> collect = Permutations.of(Arrays.asList(1, 2)).collect(Collectors.toList());
        List<List<Integer>> permutations = new ArrayList<>();
        for (Stream<Integer> stream : collect) {
            List<Integer> collect1 = stream.collect(Collectors.toList());
            permutations.add(collect1);
        }

        permPerN.put(2, permutations);

        collect = Permutations.of(Arrays.asList(1, 2, 3)).collect(Collectors.toList());
        permutations = new ArrayList<>();
        for (Stream<Integer> stream : collect) {
            List<Integer> collect1 = stream.collect(Collectors.toList());
            permutations.add(collect1);
        }

        permPerN.put(3, permutations);

        collect = Permutations.of(Arrays.asList(1, 2, 3, 4)).collect(Collectors.toList());
        permutations = new ArrayList<>();
        for (Stream<Integer> stream : collect) {
            List<Integer> collect1 = stream.collect(Collectors.toList());
            permutations.add(collect1);
        }

        permPerN.put(4, permutations);

        collect = Permutations.of(Arrays.asList(1, 2, 3, 4, 5)).collect(Collectors.toList());
        permutations = new ArrayList<>();
        for (Stream<Integer> stream : collect) {
            List<Integer> collect1 = stream.collect(Collectors.toList());
            permutations.add(collect1);
        }

        permPerN.put(5, permutations);

    }


    private List<List<Integer>> generateLS(int n) {
        List<List<Integer>> ls = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(n);
            ls.add(row);
            for (int j = 0; j < n; j++) {
                row.add((i + j) % n + 1);
            }

        }
        return ls;
    }

    private int trace(List<List<Integer>> matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.size(); i++) {
            trace += matrix.get(i).get(i);
        }
        return trace;
    }

    public static class Permutations {

        public static <T> Stream<Stream<T>> of(final List<T> items) {
            return IntStream.range(0, factorial(items.size())).mapToObj(i -> permutation(i, items).stream());
        }

        private static int factorial(final int num) {
            return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
        }

        private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
            if (input.isEmpty()) {
                return output;
            }

            final int factorial = factorial(input.size() - 1);
            output.add(input.remove(count / factorial));
            return permutation(count % factorial, input, output);
        }

        private static <T> List<T> permutation(final int count, final List<T> items) {
            return permutation(count, new LinkedList<>(items), new ArrayList<>());
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Solution solver;

        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(Objects.requireNonNull(classLoader.getResource("Matrix-1.in")).getPath()) : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            scanner.nextLine();

            solver = new Solution();
            solver.generateAllLS();
            solver.generateAllPerm();
            solver.generateAllMatrix();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String line = scanner.nextLine();
                String result = solver.solve(line);

                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
        //System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}