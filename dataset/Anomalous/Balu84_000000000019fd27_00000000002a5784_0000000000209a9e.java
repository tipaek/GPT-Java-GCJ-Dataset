import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int MAX_QUERIES = 150;
    private static final byte ONE = 1;
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

    private static final class TooManyQueriesException extends RuntimeException {
        //
    }

    private static final class MalformedQueryException extends RuntimeException {
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
            if (++queryCount > MAX_QUERIES) throw new TooManyQueriesException();
            System.out.println(position);
            String response = input.next().trim();
            if (ERROR.equals(response)) throw new MalformedQueryException();
            return new Bit(position, Byte.parseByte(response), queryCount);
        }

        public String getResponseForSolution(String solution) {
            return input.next().trim();
        }

        public int getQueryCount() {
            return queryCount;
        }
    }

    private static final class MockedDatabase extends Database {
        private final byte[] originalArray;
        private byte[] array;

        public MockedDatabase(int size, Scanner input) {
            super(size, input);
            this.originalArray = generateTestArray(size);
            this.array = Arrays.copyOf(originalArray, originalArray.length);
        }

        @Override
        public Bit query(int position) {
            if (++queryCount > MAX_QUERIES) throw new TooManyQueriesException();
            if (queryCount % QUANTUM_FLUCTUATION_PERIOD == 1) {
                array = quantumFluctuation(array);
            }
            if (position < 1 || position > size) throw new MalformedQueryException();
            return new Bit(position, array[position - 1], queryCount);
        }

        @Override
        public String getResponseForSolution(String solution) {
            StringBuilder sb = new StringBuilder();
            for (byte bit : array) sb.append(bit);
            return sb.toString().equals(solution) ? OK_SOLUTION : ERROR;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            Bit[] solution = new Bit[B];
            Bit[] previousSolution = null;
            Database db = new Database(B, input);
            int start = 1, end = B;
            int iterations = MAX_QUERIES / QUANTUM_FLUCTUATION_PERIOD;

            try {
                for (int tries = 0; tries <= iterations; tries++) {
                    for (int i = 0; i < QUANTUM_FLUCTUATION_PERIOD; i++) {
                        Bit currentBit;
                        try {
                            if (i % 2 == 0) {
                                currentBit = db.query(start++);
                                solution[start - 2] = currentBit;
                            } else {
                                currentBit = db.query(end--);
                                solution[end] = currentBit;
                            }
                        } catch (TooManyQueriesException e) {
                            String guess = makeGuess(solution);
                            System.out.println(guess);
                            if (OK_SOLUTION.equals(db.getResponseForSolution(guess))) return;
                        }

                        if (previousSolution != null) {
                            QuantumFluctuation fluctuation = guessFluctuation(solution, previousSolution);
                            if (fluctuation != QuantumFluctuation.UNKNOWN) {
                                previousSolution = null;
                                applyFluctuation(solution, fluctuation);
                                start = findStart(solution);
                                end = findEnd(solution);
                            }
                        }
                    }

                    String currentSolution = getSolution(solution);
                    if (!currentSolution.contains(NULL)) {
                        System.out.println(currentSolution);
                        if (OK_SOLUTION.equals(db.getResponseForSolution(currentSolution))) return;
                    } else {
                        markForFluctuation(solution);
                        previousSolution = Arrays.copyOf(solution, solution.length);
                        start = 1;
                        end = B;
                    }
                }
            } catch (MalformedQueryException e) {
                return;
            }
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
        byte[] prevBytes = toByteArray(prevSolution);

        List<QuantumFluctuation> guesses = new ArrayList<>();
        if (matches(currentSolution, getSolution(complement(Arrays.copyOf(prevBytes, prevBytes.length))))) {
            guesses.add(QuantumFluctuation.COMPLEMENTED);
        }
        if (matches(currentSolution, getSolution(reverse(Arrays.copyOf(prevBytes, prevBytes.length))))) {
            guesses.add(QuantumFluctuation.REVERSED);
        }
        if (matches(currentSolution, getSolution(complementAndReverse(Arrays.copyOf(prevBytes, prevBytes.length))))) {
            guesses.add(QuantumFluctuation.COMPLEMENTED_AND_REVERSED);
        }
        if (matches(currentSolution, prevSolution)) {
            guesses.add(QuantumFluctuation.NOTHING);
        }

        return guesses.size() == 1 ? guesses.get(0) : QuantumFluctuation.UNKNOWN;
    }

    private static boolean matches(String current, String previous) {
        for (int i = 0; i < current.length(); i++) {
            if (!NULL.equals(current.substring(i, i + 1)) && !current.substring(i, i + 1).equals(previous.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static byte[] toByteArray(String solution) {
        byte[] array = new byte[solution.length()];
        for (int i = 0; i < solution.length(); i++) {
            if (NULL.equals(solution.substring(i, i + 1))) {
                array[i] = NULL_BYTE;
            } else {
                array[i] = Byte.parseByte(solution.substring(i, i + 1));
            }
        }
        return array;
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
        long event = Math.round(Math.random() * 100);
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
            array[i] = array[i] == NULL_BYTE ? NULL_BYTE : (array[i] == ZERO ? ONE : ZERO);
        }
        return array;
    }

    private static byte complement(Bit bit) {
        return bit.value == NULL_BYTE ? NULL_BYTE : (bit.value == ONE ? ZERO : ONE);
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

    private static void applyFluctuation(Bit[] solution, QuantumFluctuation fluctuation) {
        for (int i = 0; i < solution.length; i++) {
            Bit bit = solution[i];
            if (bit != null && bit.needsFluctuation) {
                switch (fluctuation) {
                    case COMPLEMENTED:
                        solution[i] = new Bit(bit.position, complement(bit), bit.queryNumber);
                        break;
                    case REVERSED:
                        Bit reversedBit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = solution[i];
                        solution[i] = reversedBit;
                        break;
                    case COMPLEMENTED_AND_REVERSED:
                        solution[i] = new Bit(bit.position, complement(bit), bit.queryNumber);
                        bit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = new Bit(bit.position, complement(bit), bit.queryNumber);
                        reversedBit = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = solution[i];
                        solution[i] = reversedBit;
                        break;
                    case NOTHING:
                        bit.needsFluctuation = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static int findStart(Bit[] solution) {
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == null || solution[i].value == NULL_BYTE) {
                return i + 1;
            }
        }
        return 1;
    }

    private static int findEnd(Bit[] solution) {
        for (int i = solution.length - 1; i >= 0; i--) {
            if (solution[i] == null || solution[i].value == NULL_BYTE) {
                return i + 1;
            }
        }
        return solution.length;
    }

    private static void markForFluctuation(Bit[] solution) {
        for (Bit bit : solution) {
            if (bit != null) {
                bit.needsFluctuation = true;
            }
        }
    }

    private static String makeGuess(Bit[] solution) {
        StringBuilder guess = new StringBuilder(getSolution(solution));
        int unknownIndex = guess.indexOf(NULL);
        while (unknownIndex != -1) {
            guess.replace(unknownIndex, unknownIndex + 1, String.valueOf(Math.round(Math.random())));
            unknownIndex = guess.indexOf(NULL);
        }
        return guess.toString();
    }
}