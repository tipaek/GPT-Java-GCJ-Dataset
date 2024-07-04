import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
    private static final Logger log = Logger.getLogger("Solution");
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
        CaseReader in = new CaseReader(System.in);
        while (in.hasNext()) {
            CaseInput input = in.next();
            log.fine("case " + input.label);
            new Solution(input).interact();
        }
    }

    public void interact() {
        List<Pair> operations = calculate();
        out.println(input.formatResult(String.valueOf(operations.size())));
        operations.forEach(op -> out.println(op.toString()));
        out.flush();
    }

    private List<Pair> calculate() {
        List<Pair> deck = new ArrayList<>();
        for (int suit = 0; suit < input.suits; suit++) {
            for (int rank = 0; rank < input.ranks; rank++) {
                deck.add(new Pair(rank + 1, suit + 1));
            }
        }
        return calculateFrom(deck);
    }

    private List<Pair> calculateFrom(List<Pair> deck) {
        List<Pair> operations = new ArrayList<>();
        for (int i = deck.size() - 1; i > 0; i--) {
            log.finest("Current deck: " + deck);
            int desiredRank = i / input.suits + 1;
            Pair currentCard = deck.get(i);

            if (currentCard.first == desiredRank) {
                log.finest("card is in correct position: " + currentCard);
                deck.remove(i);
                continue;
            }

            log.finest("Looking for replacement card with rank " + desiredRank);
            List<Pair> bestOps = null;
            for (int j = 0; j < i; j++) {
                Pair otherCard = deck.get(j);
                if (otherCard.first == desiredRank) {
                    log.finest("found candidate in pos " + (j + 1) + ": " + otherCard);
                    List<Pair> updatedDeck = new ArrayList<>(deck.subList(j + 1, i + 1));
                    updatedDeck.addAll(deck.subList(0, j));
                    log.finest("Updated deck: " + updatedDeck);

                    List<Pair> ops = calculateFrom(updatedDeck);
                    log.finest("candidate " + j + " ops: " + ops);
                    if (bestOps == null || ops.size() + 1 < bestOps.size()) {
                        bestOps = new ArrayList<>();
                        bestOps.add(new Pair(j + 1, i - j));
                        bestOps.addAll(ops);
                    }
                }
                if (bestOps != null) {
                    return bestOps;
                }
            }
        }
        return operations;
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
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
        private final Scanner in;
        public int ranks;
        public int suits;

        public CaseInput(Scanner in) {
            this.in = in;
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
            return label + ": " + props.stream()
                    .map(prop -> String.format("%s=%s", prop, get(prop)))
                    .collect(Collectors.joining(","));
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
            CaseInput input = new CaseInput(in);
            input.set("ranks", in.nextInt());
            input.set("suits", in.nextInt());
            return input;
        }

        public static Integer[] readIntegerArray(Scanner in) {
            return readIntegerArray(in, in.nextInt());
        }

        public static Integer[][] readIntegerArray2(Scanner in) {
            return readIntegerArray2(in, 0);
        }

        public static Integer[][] readIntegerArray2(Scanner in, int internalLength) {
            int length = in.nextInt();
            if (internalLength == 0) internalLength = length;
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < array.length; i++) {
                array[i] = readIntegerArray(in, internalLength);
            }
            return array;
        }

        public static Integer[] readIntegerArray(Scanner in, int length) {
            return readArray(in, Integer.class, in::nextInt, length);
        }

        public static String[] readStringArray(Scanner in) {
            return readStringArray(in, in.nextInt());
        }

        public static String[] readStringArray(Scanner in, int length) {
            return readArray(in, String.class, in::next, length);
        }

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each) {
            return readArray(in, elementType, each, in.nextInt());
        }

        public static <T> T[] readArray(Scanner in, Class<T> elementType, Supplier<T> each, int length) {
            T[] values = (T[]) Array.newInstance(elementType, length);
            IntStream.range(0, length).forEach(i -> values[i] = each.get());
            return values;
        }
    }
}