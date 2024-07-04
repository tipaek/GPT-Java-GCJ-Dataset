import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    private static final class Bit {
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
            return (queryNumber % QUANTUM_FLUCTUATION_PERIOD == 1);
        }

        @Override
        public String toString() {
            return "Bit{" + "value=" + value + ", queryNumber=" + queryNumber + ", position=" + position + '}';
        }
    }

    private enum QuantumFluctuation {
        COMPLEMENTED,
        REVERSED,
        COMPLEMENTED_AND_REVERSED,
        NOTHING,
        UNKNOWN
    }

    private static final class TooManyQueriesException extends RuntimeException {
        // Exception when too many queries are made
    }

    private static final class MalformedQueryException extends RuntimeException {
        // Exception for malformed queries
    }

    private static class Database {
        public final int bitSize;
        private int queryCount;
        private Scanner input;

        public Database(int bitSize, Scanner input) {
            this.bitSize = bitSize;
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

    private static final class MockedDatabase extends Database {
        private final byte[] originalArray;
        private byte[] array;

        public MockedDatabase(int bitSize, Scanner input) {
            super(bitSize, input);
            this.originalArray = generateTestArray(bitSize);
            this.array = Arrays.copyOf(originalArray, originalArray.length);
        }

        @Override
        public Bit query(int position) {
            incrementQueryCount();
            if (getQueryCount() > MAX_QUERIES) {
                throw new TooManyQueriesException();
            }
            if (getQueryCount() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                array = applyQuantumFluctuation(array);
            }
            if (position < 1 || position > bitSize) {
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
            return sb.toString().equals(solution) ? OK_SOLUTION : ERROR;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            try {
                solveTestCase(B, input);
            } catch (MalformedQueryException | TooManyQueriesException e) {
                // Handle exceptions gracefully
            }
        }
    }

    private static void solveTestCase(int B, Scanner input) {
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
                        resetPositions(solution, B);
                        break;
                    }
                }
            }

            String currentSolution = getSolution(solution);
            if (!currentSolution.contains(NULL)) {
                System.out.println(currentSolution);
                String response = db.getResponseForSolution(currentSolution);
                if (OK_SOLUTION.equals(response)) {
                    break;
                }
            } else {
                markFluctuation(solution);
                previousSolution = Arrays.copyOf(solution, solution.length);
                start = 1;
                end = B;
            }
        }
    }

    private static void applyFluctuation(Bit[] solution, QuantumFluctuation guess) {
        for (int i = 0; i < solution.length; i++) {
            Bit bit = solution[i];
            if (bit != null && bit.needsFluctuation) {
                switch (guess) {
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
                        Bit reverseBit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = new Bit(reverseBit.position, complement(reverseBit), reverseBit.queryNumber);
                        break;
                    case NOTHING:
                        break;
                }
            }
        }
    }

    private static void resetPositions(Bit[] solution, int B) {
        int start = 1;
        int end = B;
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == null || solution[i].value == NULL_BYTE) {
                start = i + 1;
                break;
            }
        }
        for (int i = solution.length - 1; i >= 0; i--) {
            if (solution[i] == null || solution[i].value == NULL_BYTE) {
                end = i + 1;
                break;
            }
        }
    }

    private static void markFluctuation(Bit[] solution) {
        for (Bit bit : solution) {
            if (bit != null) {
                bit.needsFluctuation = true;
            }
        }
    }

    private static QuantumFluctuation guessFluctuation(Bit[] solution, Bit[] previousSolution) {
        String currentSolution = getSolution(solution);
        String prevSolution = getSolution(previousSolution);
        byte[] prevBytes = convertToBytes(prevSolution);
        String complemented = getSolution(complement(Arrays.copyOf(prevBytes, prevBytes.length)));
        String reversed = getSolution(reverse(Arrays.copyOf(prevBytes, prevBytes.length)));
        String complementedAndReversed = getSolution(complementAndReverse(Arrays.copyOf(prevBytes, prevBytes.length)));

        List<QuantumFluctuation> guesses = new ArrayList<>();
        if (currentSolution.equals(complemented)) {
            guesses.add(QuantumFluctuation.COMPLEMENTED);
        }
        if (currentSolution.equals(reversed)) {
            guesses.add(QuantumFluctuation.REVERSED);
        }
        if (currentSolution.equals(complementedAndReversed)) {
            guesses.add(QuantumFluctuation.COMPLEMENTED_AND_REVERSED);
        }
        if (currentSolution.equals(prevSolution)) {
            guesses.add(QuantumFluctuation.NOTHING);
        }
        return guesses.size() == 1 ? guesses.get(0) : QuantumFluctuation.UNKNOWN;
    }

    private static byte[] convertToBytes(String solutionStr) {
        byte[] solution = new byte[solutionStr.length()];
        for (int i = 0; i < solutionStr.length(); i++) {
            char bit = solutionStr.charAt(i);
            if (bit == NULL.charAt(0)) {
                solution[i] = NULL_BYTE;
            } else if (bit == ONE_STR.charAt(0)) {
                solution[i] = ONE;
            } else {
                solution[i] = ZERO;
            }
        }
        return solution;
    }

    private static String getSolution(Bit[] solution) {
        StringBuilder sb = new StringBuilder();
        for (Bit bit : solution) {
            sb.append((bit == null || bit.value == NULL_BYTE) ? NULL : bit.value);
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

    private static byte[] applyQuantumFluctuation(byte[] array) {
        double event = Math.random() * 100;
        if (event < 25) {
            return complement(array);
        } else if (event < 50) {
            return reverse(array);
        } else if (event < 75) {
            return complementAndReverse(array);
        } else {
            return array;
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
                array[i] = (array[i] == ZERO) ? ONE : ZERO;
            }
        }
        return array;
    }

    private static byte complement(Bit bit) {
        return (bit.value == ONE) ? ZERO : ONE;
    }

    private static byte[] reverse(byte[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            byte temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    private static byte[] complementAndReverse(byte[] array) {
        return reverse(complement(array));
    }
}