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
            log.fine("case " + input.getLabel());

            Solution solution = new Solution(input);
            solution.interact();
        }
    }

    public void interact() {
        out.println(String.format("Case #%s:", input.getLabel()));

        int sum = input.getSum();
        out.println("1 1");
        sum--;

        int line = 2;
        while (sum > 0) {
            if (sum >= line - 1) {
                out.println(String.format("%d %d", line, 2));
                sum -= line - 1;
            } else {
                out.println(String.format("%d %d", line - 1, 1));
                sum--;
            }
            line++;
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
            CaseInput input = CaseInput.read(scanner).setLabel(String.valueOf(++currentCase));
            return input;
        }
    }

    public static class CaseInput {
        private String label;
        private final Set<String> properties = new LinkedHashSet<>();
        private final Scanner in;
        private int sum;

        public CaseInput(Scanner in) {
            this.in = in;
        }

        public CaseInput setLabel(String label) {
            this.label = label;
            return this;
        }

        public String getLabel() {
            return label;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public static CaseInput read(Scanner in) {
            CaseInput input = new CaseInput(in);
            input.setSum(in.nextInt());
            return input;
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
                return this.getClass().getDeclaredField(prop).get(this);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public void set(String prop, Object value) {
            try {
                this.getClass().getDeclaredField(prop).set(this, value);
                properties.add(prop);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public static Integer[] readIntegerArray(Scanner in) {
            int length = in.nextInt();
            return readIntegerArray(in, length);
        }

        public static Integer[][] readIntegerArray2(Scanner in) {
            return readIntegerArray2(in, 0);
        }

        public static Integer[][] readIntegerArray2(Scanner in, int internalLength) {
            int length = in.nextInt();
            if (internalLength == 0) {
                internalLength = length;
            }
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < array.length; ++i) {
                array[i] = readIntegerArray(in, internalLength);
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

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each) {
            int length = in.nextInt();
            return readArray(in, elementType, each, length);
        }

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each, int length) {
            T[] values = (T[]) Array.newInstance(elementType, length);
            IntStream.range(0, length).forEach(i -> values[i] = each.get());
            return values;
        }
    }
}