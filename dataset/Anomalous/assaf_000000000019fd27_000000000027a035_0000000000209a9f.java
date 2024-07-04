import java.io.*;
import java.lang.reflect.*;
import java.text.StringCharacterIterator;
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
        CaseReader in = new CaseReader(System.in);
        while (in.hasNext()) {
            CaseInput input = in.next();
            log.fine("case " + input.label);

            String result = new Solution(input).calculate();

            System.out.println(input.formatResult(result));
        }
    }

    public String calculate() {
        StringBuilder output = new StringBuilder();
        int nestingLevel = 0;

        for (StringCharacterIterator it = new StringCharacterIterator(input.digits);
             it.current() != StringCharacterIterator.DONE;
             it.next()) {
            int digit = it.current() - '0';
            while (nestingLevel < digit) {
                nestingLevel++;
                output.append("(");
            }
            while (nestingLevel > digit) {
                nestingLevel--;
                output.append(")");
            }
            output.append(it.current());
        }

        while (nestingLevel > 0) {
            nestingLevel--;
            output.append(")");
        }

        return output.toString();
    }

    public int calcDamage(int beam, char[] program, int start, int end) {
        int total = 0;
        for (int i = start; i < end; ++i) {
            if (program[i] == 'S') {
                total += beam;
            } else if (program[i] == 'C') {
                beam *= 2;
            } else {
                throw new IllegalArgumentException("Unexpected input");
            }
        }
        return total;
    }

    public static class CaseReader {
        private final Scanner scanner;
        private final int cases;
        private int current = 0;

        public CaseReader(InputStream in) {
            this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
            this.cases = this.scanner.nextInt();
            log.finest("Cases: " + this.cases);
        }

        public boolean hasNext() {
            return current < cases;
        }

        public CaseInput next() {
            return CaseInput.read(scanner).label(String.valueOf(++current));
        }
    }

    public static class CaseInput {
        public String label;
        private final Set<String> props = new LinkedHashSet<>();
        public String digits;

        public CaseInput label(String label) {
            this.label = label;
            return this;
        }

        public String formatResult(String result) {
            return String.format("Case #%s: %s", label, result);
        }

        @Override
        public String toString() {
            String values = props.stream()
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
                props.add(prop);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public static CaseInput read(Scanner in) {
            CaseInput input = new CaseInput();
            input.set("digits", in.next());
            return input;
        }

        public static Integer[] readIntegerArray(Scanner in) {
            int length = in.nextInt();
            return readIntegerArray(in, length);
        }

        public static Integer[][] readIntegerArray2(Scanner in) {
            int length = in.nextInt();
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < array.length; ++i) {
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