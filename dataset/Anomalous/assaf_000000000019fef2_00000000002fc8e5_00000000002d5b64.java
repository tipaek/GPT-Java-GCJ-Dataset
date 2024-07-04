import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class Solution {
    private static final Logger LOGGER = Logger.getLogger(Solution.class.getName());

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
            LOGGER.fine("Processing case " + input.label);
            Solution solution = new Solution(input);
            solution.interact();
        }
    }

    public void interact() {
        List<Pair> operations = calculate();
        out.println(input.formatResult(String.valueOf(operations.size())));
        operations.forEach(op -> out.println(op));
        out.flush();
    }

    private List<Pair> calculate() {
        List<Pair> deck = new ArrayList<>();
        List<Pair> operations = new ArrayList<>();

        for (int suit = 0; suit < input.suits; ++suit) {
            for (int rank = 0; rank < input.ranks; ++rank) {
                deck.add(new Pair(rank + 1, suit + 1));
            }
        }

        for (int i = deck.size() - 1; i > 0; i--) {
            LOGGER.finest("Current deck: " + deck);

            int desiredRank = i / input.suits + 1;
            Pair currentCard = deck.get(i);

            if (currentCard.first == desiredRank) {
                LOGGER.finest("Card is in correct position: " + currentCard);
                continue;
            }

            for (int j = 0; j < i; ++j) {
                Pair otherCard = deck.get(j);
                if (otherCard.first == desiredRank) {
                    operations.add(new Pair(j + 1, i - j));
                    LOGGER.finest(String.format("Switching %d %d", j + 1, i - j));
                    
                    List<Pair> updatedDeck = new ArrayList<>();
                    updatedDeck.addAll(deck.subList(j + 1, i + 1));
                    updatedDeck.addAll(deck.subList(0, j + 1));
                    updatedDeck.addAll(deck.subList(i + 1, deck.size()));
                    deck = updatedDeck;
                    LOGGER.finest("Updated deck: " + deck);
                    break;
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
            return String.format("%d %d", first, second);
        }
    }

    public static class CaseReader {
        private final Scanner scanner;
        private final int cases;
        private int currentCase = 0;

        public CaseReader(InputStream in) {
            this.scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
            this.cases = this.scanner.nextInt();
            LOGGER.finest("Total cases: " + this.cases);
        }

        public boolean hasNext() {
            return currentCase < cases;
        }

        public CaseInput next() {
            return CaseInput.read(scanner).label(String.valueOf(++currentCase));
        }
    }

    public static class CaseInput {
        private String label;
        private final Set<String> properties = new LinkedHashSet<>();
        private final Scanner scanner;
        public int ranks;
        public int suits;

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
                return getClass().getField(property).get(this);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public void set(String property, Object value) {
            try {
                getClass().getField(property).set(this, value);
                properties.add(property);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }

        public static CaseInput read(Scanner scanner) {
            CaseInput input = new CaseInput(scanner);
            input.set("ranks", scanner.nextInt());
            input.set("suits", scanner.nextInt());
            return input;
        }

        public static Integer[] readIntegerArray(Scanner scanner) {
            return readIntegerArray(scanner, scanner.nextInt());
        }

        public static Integer[][] readIntegerArray2(Scanner scanner) {
            return readIntegerArray2(scanner, 0);
        }

        public static Integer[][] readIntegerArray2(Scanner scanner, int internalLength) {
            int length = scanner.nextInt();
            if (internalLength == 0) {
                internalLength = length;
            }
            Integer[][] array = new Integer[length][];
            for (int i = 0; i < length; i++) {
                array[i] = readIntegerArray(scanner, internalLength);
            }
            return array;
        }

        public static Integer[] readIntegerArray(Scanner scanner, int length) {
            return readArray(scanner, Integer.class, scanner::nextInt, length);
        }

        public static String[] readStringArray(Scanner scanner) {
            return readStringArray(scanner, scanner.nextInt());
        }

        public static String[] readStringArray(Scanner scanner, int length) {
            return readArray(scanner, String.class, scanner::next, length);
        }

        public static <T> T[] readArray(Scanner scanner, Class<T> elementType, Supplier<T> supplier) {
            return readArray(scanner, elementType, supplier, scanner.nextInt());
        }

        public static <T> T[] readArray(Scanner scanner, Class<T> elementType, Supplier<T> supplier, int length) {
            T[] array = (T[]) Array.newInstance(elementType, length);
            IntStream.range(0, length).forEach(i -> array[i] = supplier.get());
            return array;
        }
    }
}