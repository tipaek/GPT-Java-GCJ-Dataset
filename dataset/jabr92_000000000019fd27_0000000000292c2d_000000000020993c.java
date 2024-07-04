import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.*;


class Solution {

    private static final int inputLimit = 500;


    public static void main(String[] args) {
        Vestigum.solve(getInputs());
    }


    private static Stream<String> getInputs() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            final List<String> s = new ArrayList<>();
            while (in.hasNextLine()) {
                s.add(in.nextLine());
            }
            return s.stream();
        }
    }


    private static int getIntFromLine(String line) {
        return Integer.parseInt(line.trim());
    }


    private static class Vestigum {

        static final AtomicInteger lineCount = new AtomicInteger();
        static final AtomicInteger solutionCount = new AtomicInteger();
        static final AtomicInteger matrixSize = new AtomicInteger();

        static final List<List<Integer>> rows = new ArrayList<>();
        static final List<List<Integer>> columns = new ArrayList<>();
        private static final Pattern WHITESPACE = Pattern.compile("\\s");


        static void initializeMatrix(int size) {
            rows.clear();
            columns.clear();
            IntStream.range(0, size).forEach(i -> {
                rows.add(new ArrayList<>());
                columns.add(new ArrayList<>());

            });
        }


        static void addMatrixValues(String line) {
            final AtomicInteger colCount = new AtomicInteger();
            Arrays.stream(WHITESPACE.split(line))
                    .mapToInt(Integer::parseInt)
                    .forEach(i -> {
                        rows.get(lineCount.get() - 2).add(i);
                        columns.get(colCount.getAndIncrement()).add(i);
                    });
        }


        static int numWithRepeats(List<List<Integer>> values) {
            return (int) values.stream()
                    .filter(l -> {
                                Set<Integer> s = new HashSet<>(l);
                                return l.size() != s.size();
                            }
                    ).count();
        }


        static int getTrace() {
            int ret = 0;
            for (int i = 0; i < matrixSize.get(); i++) {
                ret += rows.get(i).get(i);
            }
            return ret;
        }


        static void outputLine() {
            System.out.println(
                    "Case #" + solutionCount.incrementAndGet()
                    + ": " + getTrace() + " "
                    + numWithRepeats(rows) + " "
                    + numWithRepeats(columns)
            );
        }


        static void solve(Stream<String> inputs) {
            inputs.skip(1) // the number of input cases
                    .forEach(line -> {
                        if (lineCount.getAndIncrement() == 0) {
                            int size = getIntFromLine(line);
                            matrixSize.set(size);
                            initializeMatrix(size);
                        } else if (lineCount.get() - 2 < matrixSize.get()) {
                            addMatrixValues(line);
                        } else {
                            outputLine();
                            lineCount.set(0);
                        }
                    });
        }

    }

}
