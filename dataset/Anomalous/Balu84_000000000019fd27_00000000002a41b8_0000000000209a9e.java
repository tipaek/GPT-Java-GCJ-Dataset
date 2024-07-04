import java.util.*;

public class Solution {
    private static final int MAX_QUERIES = 150;
    private static final byte ONE = 1;
    private static final String ONE_STR = "1";
    private static final byte ZERO = 0;
    private static final String ERROR = "N";
    private static final String OK_SOLUTION = "Y";
    private static final String NULL = "?";
    private static final byte NULL_BYTE = -1;
    private static final int QUANTUM_FLUCTUATION_PERIOD = 10;

    private static class Bit {
        public final byte value;
        public final int queryNumber;
        public final int position;
        public boolean needsFluctuation;

        public Bit(int position, byte value, int queryNumber) {
            this.position = position;
            this.value = value;
            this.queryNumber = queryNumber;
            this.needsFluctuation = false;
        }

        public boolean wasFluctuated() {
            return queryNumber % QUANTUM_FLUCTUATION_PERIOD == 1;
        }

        @Override
        public String toString() {
            return "Bit{" + "value=" + value + ", queryNumber=" + queryNumber + ", position=" + position + '}';
        }
    }

    private enum QuantumFluctuation {
        COMPLEMENTED, REVERSED, COMPLEMENTED_AND_REVERSED, NOTHING, UNKNOWN
    }

    private static class TooManyQueriesException extends RuntimeException {
        //
    }

    private static class MalformedQueryException extends RuntimeException {
        //
    }

    private static class Database {
        public final int size;
        private int queryCount;
        private final Scanner input;

        public Database(int size, Scanner input) {
            this.size = size;
            this.input = input;
            this.queryCount = 0;
        }

        public Bit query(int position) {
            incrementQueryCount();
            if (queryCount > MAX_QUERIES) {
                throw new TooManyQueriesException();
            }
            System.out.println(position);
            String response = input.next().trim();
            if (ERROR.equals(response)) {
                throw new MalformedQueryException();
            }
            byte value = Byte.parseByte(response);
            return new Bit(position, value, queryCount);
        }

        public String getResponseForSolution(String solution) {
            return input.next().trim();
        }

        private void incrementQueryCount() {
            queryCount++;
        }

        public int getQueryCount() {
            return queryCount;
        }
    }

    private static class MockedDatabase extends Database {
        private final byte[] originalArray;
        private byte[] array;

        public MockedDatabase(int size, Scanner input) {
            super(size, input);
            this.originalArray = generateTestArray(size);
            this.array = Arrays.copyOf(originalArray, originalArray.length);
            testPrint(Arrays.toString(array) + " : original");
        }

        @Override
        public Bit query(int position) {
            incrementQueryCount();
            if (getQueryCount() > MAX_QUERIES) {
                throw new TooManyQueriesException();
            }
            testPrint("Query at position:" + position + ", number of queries: " + getQueryCount());
            if (getQueryCount() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                array = quantumFluctuation(array);
                testPrint("Fluctuated array: " + Arrays.toString(array));
            }
            if (position < 1 || position > size) {
                throw new MalformedQueryException();
            }
            return new Bit(position, array[position - 1], getQueryCount());
        }

        @Override
        public String getResponseForSolution(String solution) {
            StringBuilder sb = new StringBuilder();
            for (byte bit : array) {
                sb.append(bit);
            }
            testPrint(solution + " : solution\n" + sb.toString() + " : current array");
            return sb.toString().equals(solution) ? OK_SOLUTION : ERROR;
        }

        public byte[] getCurrentArray() {
            return array;
        }

        public byte[] getOriginalArray() {
            return originalArray;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        try {
            for (int testCase = 1; testCase <= T; testCase++) {
                Bit[] solution = new Bit[B];
                Bit[] previousSolution = null;
                Database db = new Database(B, input);
                int start = 1;
                int end = B;
                int iterations = MAX_QUERIES / QUANTUM_FLUCTUATION_PERIOD;
                for (int tries = 0; tries <= iterations; tries++) {
                    for (int i = 0; i < QUANTUM_FLUCTUATION_PERIOD; i++) {
                        Bit currentBit;
                        if (i % 2 == 0) {
                            currentBit = db.query(start);
                            solution[start - 1] = currentBit;
                            start++;
                        } else {
                            currentBit = db.query(end);
                            solution[end - 1] = currentBit;
                            end--;
                        }
                        if (previousSolution != null) {
                            QuantumFluctuation guess = guessFluctuation(solution, previousSolution);
                            if (guess != QuantumFluctuation.UNKNOWN) {
                                previousSolution = null;
                                applyFluctuation(solution, guess);
                                start = findNextQueryPosition(solution, true);
                                end = findNextQueryPosition(solution, false);
                            }
                        }
                    }
                    String currentSolution = getSolution(solution);
                    testPrint(currentSolution);
                    if (!currentSolution.contains(NULL)) {
                        System.out.println(currentSolution);
                        String judgeResponse = db.getResponseForSolution(currentSolution);
                        if (ERROR.equals(judgeResponse)) {
                            throw new MalformedQueryException();
                        } else if (OK_SOLUTION.equals(judgeResponse)) {
                            break;
                        }
                    } else {
                        markForFluctuation(solution);
                        previousSolution = Arrays.copyOf(solution, solution.length);
                        start = 1;
                        end = B;
                    }
                }
            }
        } catch (MalformedQueryException | TooManyQueriesException e) {
            // Handle exceptions gracefully
        }
    }

    private static QuantumFluctuation guessFluctuation(Bit[] solution, Bit[] previousSolution) {
        Bit[] fixedSolution = Arrays.copyOf(solution, solution.length);
        for (int i = 0; i < fixedSolution.length; i++) {
            if (fixedSolution[i] != null && fixedSolution[i].needsFluctuation) {
                fixedSolution[i] = null;
            }
        }
        String currentSolution = getSolution(fixedSolution);
        String prevSolution = getSolution(previousSolution);
        byte[] prevSolutionBytes = convertStringSolution(prevSolution);
        List<QuantumFluctuation> guesses = new ArrayList<>();
        if (mightMatchSolutions(currentSolution, getSolution(complement(prevSolutionBytes)))) {
            guesses.add(QuantumFluctuation.COMPLEMENTED);
        }
        if (mightMatchSolutions(currentSolution, getSolution(reverse(prevSolutionBytes)))) {
            guesses.add(QuantumFluctuation.REVERSED);
        }
        if (mightMatchSolutions(currentSolution, getSolution(complementAndReverse(prevSolutionBytes)))) {
            guesses.add(QuantumFluctuation.COMPLEMENTED_AND_REVERSED);
        }
        if (mightMatchSolutions(currentSolution, prevSolution)) {
            guesses.add(QuantumFluctuation.NOTHING);
        }
        testPrint("Guessed fluctuations: " + guesses);
        return guesses.size() == 1 ? guesses.get(0) : QuantumFluctuation.UNKNOWN;
    }

    private static boolean mightMatchSolutions(String currentSolution, String previousSolution) {
        for (int i = 0; i < currentSolution.length(); i++) {
            String bit = currentSolution.substring(i, i + 1);
            if (!NULL.equals(bit) && !bit.equals(previousSolution.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static byte[] convertStringSolution(String solutionStr) {
        byte[] solution = new byte[solutionStr.length()];
        for (int i = 0; i < solutionStr.length(); i++) {
            String bit = solutionStr.substring(i, i + 1);
            solution[i] = NULL.equals(bit) ? NULL_BYTE : Byte.parseByte(bit);
        }
        return solution;
    }

    private static String getSolution(Bit[] solution) {
        StringBuilder sb = new StringBuilder();
        for (Bit bit : solution) {
            sb.append(bit == null || bit.value == NULL_BYTE ? NULL : bit.value);
        }
        return sb.toString();
    }

    private static String getSolution(byte[] solution) {
        StringBuilder sb = new StringBuilder();
        for (byte bit : solution) {
            sb.append(bit == NULL_BYTE ? NULL : bit);
        }
        return sb.toString();
    }

    private static byte[] quantumFluctuation(byte[] array) {
        byte[] newArray = Arrays.copyOf(array, array.length);
        double event = Math.random() * 100;
        if (event < 25) {
            testPrint("complement");
            return complement(newArray);
        } else if (event < 50) {
            testPrint("reverse");
            return reverse(newArray);
        } else if (event < 75) {
            testPrint("complementAndReverse");
            return complementAndReverse(newArray);
        } else {
            testPrint("doNothing");
            return newArray;
        }
    }

    private static byte[] generateTestArray(int size) {
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) Math.round(Math.random());
        }
        return array;
    }

    private static byte[] complement(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != NULL_BYTE) {
                array[i] = (byte) (array[i] == ZERO ? ONE : ZERO);
            }
        }
        return array;
    }

    private static byte complement(Bit bit) {
        return bit.value == ONE ? ZERO : ONE;
    }

    private static byte[] reverse(byte[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            byte temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    private static byte[] complementAndReverse(byte[] array) {
        return reverse(complement(array));
    }

    private static void applyFluctuation(Bit[] solution, QuantumFluctuation fluctuation) {
        for (int i = 0; i < solution.length; i++) {
            Bit bit = solution[i];
            if (bit != null && bit.needsFluctuation) {
                switch (fluctuation) {
                    case COMPLEMENTED:
                        solution[i] = new Bit(bit.position, complement(bit), bit.queryNumber);
                        break;
                    case REVERSED:
                        Bit temp = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = solution[i];
                        solution[i] = temp;
                        break;
                    case COMPLEMENTED_AND_REVERSED:
                        solution[i] = new Bit(bit.position, complement(bit), bit.queryNumber);
                        Bit reversedBit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = new Bit(reversedBit.position, complement(reversedBit), reversedBit.queryNumber);
                        Bit tempBit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = solution[i];
                        solution[i] = tempBit;
                        break;
                    case NOTHING:
                        solution[i].needsFluctuation = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static int findNextQueryPosition(Bit[] solution, boolean fromStart) {
        if (fromStart) {
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] == null || solution[i].value == NULL_BYTE) {
                    return i + 1;
                }
            }
        } else {
            for (int i = solution.length - 1; i >= 0; i--) {
                if (solution[i] == null || solution[i].value == NULL_BYTE) {
                    return i + 1;
                }
            }
        }
        return fromStart ? 1 : solution.length;
    }

    private static void markForFluctuation(Bit[] solution) {
        for (Bit bit : solution) {
            if (bit != null) {
                bit.needsFluctuation = true;
            }
        }
    }

    private static void testPrint(String str) {
        // Uncomment the next line to enable debug prints
        // System.err.println(str);
    }
}