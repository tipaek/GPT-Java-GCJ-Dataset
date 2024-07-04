import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    private final CaseInput input;
    private final PrintWriter out;

    public Solution(CaseInput input) {
        this(input, new PrintWriter(System.out));
    }

    public Solution(CaseInput input, PrintWriter out) {
        this.input = input;
        this.out = out;
    }

    public static void main(String[] args) {
        CaseReader caseReader = new CaseReader(System.in);

        while (caseReader.hasNext()) {
            CaseInput input = caseReader.next();
            log.fine("Processing case " + input.label);

            Solution solution = new Solution(input);
            solution.interact();
        }
    }

    public void interact() {
        out.printf("Case #%s:%n", input.label);

        int sum = input.sum;
        if (sum == 1) {
            out.println("1 1");
        } else {
            int line = 1;
            while (sum > line) {
                out.printf("%d %d%n", line, 1);
                sum--;
                line++;
            }
            if (sum > 0) {
                out.printf("%d %d%n", line, 2);
            }
        }

        out.flush();
    }

    public static class CaseReader {
        private final Scanner scanner;
        private final int totalCases;
        private int currentCase = 0;

        public CaseReader(InputStream in) {
            this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
            this.totalCases = this.scanner.nextInt();
            log.finest("Total cases: " + this.totalCases);
        }

        public boolean hasNext() {
            return currentCase < totalCases;
        }

        public CaseInput next() {
            CaseInput input = CaseInput.read(scanner).label(String.valueOf(++currentCase));
            return input;
        }
    }

    public static class CaseInput {
        public String label;
        private final Set<String> properties = new LinkedHashSet<>();
        private final Scanner scanner;
        public int sum;

        public CaseInput(Scanner scanner) {
            this.scanner = scanner;
        }

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

        public Object get(String property) {
            try {
                return this.getClass().getField(property).get(this);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public void set(String property, Object value) {
            try {
                this.getClass().getField(property).set(this, value);
                properties.add(property);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public static CaseInput read(Scanner scanner) {
            CaseInput input = new CaseInput(scanner);
            input.set("sum", scanner.nextInt());
            return input;
        }

        public static Integer[] readIntegerArray(Scanner scanner) {
            int length = scanner.nextInt();
            return readIntegerArray(scanner, length);
        }

        public static Integer[][] readIntegerArray2(Scanner scanner) {
            return readIntegerArray2(scanner, 0);
        }

        public static Integer[][] readIntegerArray2(Scanner scanner, int innerLength) {
            int length = scanner.nextInt();
            if (innerLength == 0) {
                innerLength = length;
            }
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < length; ++i) {
                array[i] = readIntegerArray(scanner, innerLength);
            }
            return array;
        }

        public static Integer[] readIntegerArray(Scanner scanner, int length) {
            return readArray(scanner, Integer.class, scanner::nextInt, length);
        }

        public static String[] readStringArray(Scanner scanner) {
            int length = scanner.nextInt();
            return readStringArray(scanner, length);
        }

        public static String[] readStringArray(Scanner scanner, int length) {
            return readArray(scanner, String.class, scanner::next, length);
        }

        public static <T> T[] readArray(Scanner scanner, Class<T> elementType, Supplier<T> supplier) {
            int length = scanner.nextInt();
            return readArray(scanner, elementType, supplier, length);
        }

        public static <T> T[] readArray(Scanner scanner, Class<T> elementType, Supplier<T> supplier, int length) {
            T[] array = (T[]) Array.newInstance(elementType, length);
            IntStream.range(0, length).forEach(i -> array[i] = supplier.get());
            return array;
        }
    }
}