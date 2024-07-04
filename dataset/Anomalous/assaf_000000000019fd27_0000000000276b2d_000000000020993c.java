import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());
    private final CaseInput input;

    public Solution(CaseInput input) {
        this.input = input;
    }

    public static void main(String[] args) {
        CaseReader caseReader = new CaseReader(System.in);
        while (caseReader.hasNext()) {
            CaseInput input = caseReader.next();
            log.fine("case " + input.label);

            String result = new Solution(input).calculate();
            System.out.println(input.formatResult(result));
        }
    }

    public String calculate() {
        int trace = IntStream.range(0, input.matrix.length)
                             .map(i -> input.matrix[i][i])
                             .sum();

        int rowDups = IntStream.range(0, input.matrix.length)
                               .map(i -> {
                                   Set<Integer> set = new HashSet<>();
                                   Arrays.stream(input.matrix[i]).forEach(set::add);
                                   return set.size() == input.matrix.length ? 0 : 1;
                               })
                               .sum();

        int colDups = IntStream.range(0, input.matrix.length)
                               .map(i -> {
                                   Set<Integer> set = new HashSet<>();
                                   IntStream.range(0, input.matrix.length)
                                            .forEach(j -> set.add(input.matrix[j][i]));
                                   return set.size() == input.matrix.length ? 0 : 1;
                               })
                               .sum();

        return String.format("%d %d %d", trace, rowDups, colDups);
    }

    public static class CaseReader {
        private final Scanner scanner;
        private final int totalCases;
        private int currentCase = 0;

        public CaseReader(InputStream in) {
            this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
            this.totalCases = this.scanner.nextInt();
            log.finest("Total Cases: " + this.totalCases);
        }

        public boolean hasNext() {
            return currentCase < totalCases;
        }

        public CaseInput next() {
            return CaseInput.read(scanner).label(String.valueOf(++currentCase));
        }
    }

    public static class CaseInput {
        public String label;
        private final Set<String> properties = new LinkedHashSet<>();
        public Integer[][] matrix;

        public CaseInput label(String label) {
            this.label = label;
            return this;
        }

        public String formatResult(String result) {
            return String.format("Case #%s: %s", label, result);
        }

        @Override
        public String toString() {
            String values = properties.stream()
                                      .map(prop -> String.format("%s=%s", prop, get(prop)))
                                      .collect(Collectors.joining(","));
            return String.format("%s: %s", label, values);
        }

        public Object get(String prop) {
            try {
                return this.getClass().getField(prop).get(this);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public void set(String prop, Object value) {
            try {
                this.getClass().getField(prop).set(this, value);
                properties.add(prop);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public static CaseInput read(Scanner in) {
            CaseInput input = new CaseInput();
            input.set("matrix", readIntegerArray2(in));
            return input;
        }

        public static Integer[] readIntegerArray(Scanner in) {
            int length = in.nextInt();
            return readIntegerArray(in, length);
        }

        public static Integer[][] readIntegerArray2(Scanner in) {
            int length = in.nextInt();
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < length; i++) {
                array[i] = readIntegerArray(in, length);
            }
            return array;
        }

        public static Integer[] readIntegerArray(Scanner in, int length) {
            return readArray(in, Integer.class, in::nextInt, length);
        }

        public static String[] readStringArray(Scanner in) {
            int length = in.nextInt();
            return readStringArray(in, length);
        }

        public static String[] readStringArray(Scanner in, int length) {
            return readArray(in, String.class, in::next, length);
        }

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> supplier) {
            int length = in.nextInt();
            return readArray(in, elementType, supplier, length);
        }

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> supplier, int length) {
            T[] array = (T[]) Array.newInstance(elementType, length);
            IntStream.range(0, length).forEach(i -> array[i] = supplier.get());
            return array;
        }
    }
}