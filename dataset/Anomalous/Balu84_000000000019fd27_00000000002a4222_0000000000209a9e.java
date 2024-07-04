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
        public final byte BIT_VALUE;
        public final int NUMBER_OF_THIS_QUERY;
        public final int POSITION;
        public boolean doesNeedToFluctuate;

        public Bit(int position, byte value, int numberOfQuery) {
            POSITION = position;
            BIT_VALUE = value;
            NUMBER_OF_THIS_QUERY = numberOfQuery;
            doesNeedToFluctuate = false;
        }

        public boolean wasThisQueryFluctuated() {
            return (NUMBER_OF_THIS_QUERY % QUANTUM_FLUCTUATION_PERIOD == 1);
        }

        @Override
        public String toString() {
            return "Bit{" + "BIT_VALUE=" + BIT_VALUE + ", NUMBER_OF_THIS_QUERY=" + NUMBER_OF_THIS_QUERY + ", POSITION=" + POSITION + '}';
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
        // Custom exception for too many queries
    }

    private static final class MalformedQueryException extends RuntimeException {
        // Custom exception for malformed query
    }

    private static class Database {
        public final int B; // size of the bit array for every test case
        private int numberOfQueries;
        private final Scanner input;

        public Database(int bitSizeOfArrays, Scanner input) {
            numberOfQueries = 0;
            B = bitSizeOfArrays;
            this.input = input;
        }

        public Bit query(int position) {
            increaseNumberOfQueries();
            if (MAX_QUERIES < getNumberOfQueries()) {
                throw new TooManyQueriesException();
            }
            System.out.println(position); // flush is called automatically
            String judgeResponse = input.next().trim();
            if (ERROR.equals(judgeResponse)) {
                throw new MalformedQueryException();
            }
            byte answer = (byte) Integer.parseInt(judgeResponse);
            return new Bit(position, answer, getNumberOfQueries());
        }

        public String getResponseForSolution(String solution) {
            return input.next().trim();
        }

        public void increaseNumberOfQueries() {
            numberOfQueries += 1;
        }

        public int getNumberOfQueries() {
            return numberOfQueries;
        }
    }

    private static final class MockedDatabase extends Database {
        private final byte[] ORIGINAL_ARRAY;
        private byte[] array;

        public MockedDatabase(int bitSizeOfArrays, Scanner input) {
            super(bitSizeOfArrays, input);
            ORIGINAL_ARRAY = generateTestArray(super.B);
            array = Arrays.copyOf(ORIGINAL_ARRAY, ORIGINAL_ARRAY.length);
        }

        @Override
        public Bit query(int position) {
            increaseNumberOfQueries();
            if (MAX_QUERIES < getNumberOfQueries()) {
                throw new TooManyQueriesException();
            }
            byte[] newArray = array;
            if (getNumberOfQueries() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                newArray = quantumFluctuation(array);
            }
            array = newArray;
            if (position < 1 || B < position) {
                throw new MalformedQueryException();
            }
            return new Bit(position, newArray[position - 1], getNumberOfQueries());
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
        int T = input.nextInt(); // number of test cases
        int B = input.nextInt(); // size of the bit array for every test case
        try {
            for (int testCase = 1; testCase <= T; testCase++) {
                Bit[] solution = new Bit[B];
                Bit[] previousSolution = null;
                Database db = new Database(B, input);
                int positionAtStart = 1;
                int positionAtEnd = B;
                int iterations = MAX_QUERIES / QUANTUM_FLUCTUATION_PERIOD;
                for (int tries = 0; tries < iterations + 1; tries++) {
                    for (int i = 0; i < QUANTUM_FLUCTUATION_PERIOD; i++) {
                        Bit currentBit;
                        if (i % 2 == 0) {
                            currentBit = db.query(positionAtStart);
                            solution[positionAtStart - 1] = currentBit;
                            positionAtStart++;
                        } else {
                            currentBit = db.query(positionAtEnd);
                            solution[positionAtEnd - 1] = currentBit;
                            positionAtEnd--;
                        }
                        if (previousSolution != null) {
                            QuantumFluctuation guess = guessFluctuation(solution, previousSolution);
                            if (guess != null && guess != QuantumFluctuation.UNKNOWN) {
                                previousSolution = null;
                                for (int b = 0; b < solution.length; b++) {
                                    Bit bit = solution[b];
                                    if (bit != null && bit.doesNeedToFluctuate) {
                                        switch (guess) {
                                            case COMPLEMENTED:
                                                solution[b] = new Bit(bit.POSITION, complement(bit), bit.NUMBER_OF_THIS_QUERY);
                                                break;
                                            case REVERSED:
                                                Bit bitToUse = solution[solution.length - 1 - b];
                                                solution[solution.length - 1 - b] = solution[b];
                                                solution[solution.length - 1 - b].doesNeedToFluctuate = false;
                                                solution[b] = bitToUse;
                                                if (solution[b] != null) {
                                                    solution[b].doesNeedToFluctuate = false;
                                                }
                                                break;
                                            case COMPLEMENTED_AND_REVERSED:
                                                byte newBitValue = complement(bit);
                                                solution[b] = new Bit(bit.POSITION, newBitValue, bit.NUMBER_OF_THIS_QUERY);
                                                bit = solution[solution.length - 1 - b];
                                                newBitValue = complement(bit);
                                                solution[solution.length - 1 - b] = new Bit(bit.POSITION, newBitValue, bit.NUMBER_OF_THIS_QUERY);
                                                Bit tempBit = solution[solution.length - 1 - b];
                                                solution[solution.length - 1 - b] = solution[b];
                                                solution[b] = tempBit;
                                                break;
                                            case NOTHING:
                                                solution[b].doesNeedToFluctuate = false;
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                for (int b = 0; b < solution.length; b++) {
                                    Bit bit = solution[b];
                                    if (bit == null || bit.BIT_VALUE == NULL_BYTE) {
                                        positionAtStart = b + 1;
                                        break;
                                    }
                                }
                                for (int b = solution.length - 1; b >= 0; b--) {
                                    Bit bit = solution[b];
                                    if (bit == null || bit.BIT_VALUE == NULL_BYTE) {
                                        positionAtEnd = b + 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    String currentSolution = getSolution(solution);
                    if (!currentSolution.contains(NULL)) {
                        System.out.println(currentSolution);
                        String judgeResponse = db.getResponseForSolution(currentSolution);
                        if (ERROR.equals(judgeResponse)) {
                            throw new MalformedQueryException();
                        } else if (OK_SOLUTION.equals(judgeResponse)) {
                            break;
                        }
                    } else {
                        for (Bit bit : solution) {
                            if (bit != null) {
                                bit.doesNeedToFluctuate = true;
                            }
                        }
                        previousSolution = Arrays.copyOf(solution, solution.length);
                        positionAtStart = 1;
                        positionAtEnd = B;
                    }
                }
            }
        } catch (MalformedQueryException | TooManyQueriesException e) {
            // Handle exceptions
        }
    }

    private static QuantumFluctuation guessFluctuation(Bit[] solution, Bit[] previousSolution) {
        Bit[] fixedSolution = Arrays.copyOf(solution, solution.length);
        for (int i = 0; i < fixedSolution.length; i++) {
            if (fixedSolution[i] != null && fixedSolution[i].doesNeedToFluctuate) {
                fixedSolution[i] = null;
            }
        }
        String currentSolution = getSolution(fixedSolution);
        String prevSolution = getSolution(previousSolution);
        byte[] previousSolutionBytes = convertStringSolution(prevSolution);
        String prevSolComplemented = getSolution(complement(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        String prevSolReversed = getSolution(reverse(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        String prevSolComplementedAndReversed = getSolution(complementAndReverse(Arrays.copyOf(previousSolutionBytes, previousSolutionBytes.length)));
        List<QuantumFluctuation> guesses = new ArrayList<>();
        if (mightMatchSolutions(currentSolution, prevSolComplemented)) {
            guesses.add(QuantumFluctuation.COMPLEMENTED);
        }
        if (mightMatchSolutions(currentSolution, prevSolReversed)) {
            guesses.add(QuantumFluctuation.REVERSED);
        }
        if (mightMatchSolutions(currentSolution, prevSolComplementedAndReversed)) {
            guesses.add(QuantumFluctuation.COMPLEMENTED_AND_REVERSED);
        }
        if (mightMatchSolutions(currentSolution, prevSolution)) {
            guesses.add(QuantumFluctuation.NOTHING);
        }
        return (guesses.size() == 1) ? guesses.get(0) : QuantumFluctuation.UNKNOWN;
    }

    private static boolean mightMatchSolutions(String currentSolution, String previousFluctuatedSolution) {
        for (int i = 0; i < currentSolution.length(); i++) {
            String bit = currentSolution.substring(i, i + 1);
            if (!NULL.equals(bit)) {
                if (!bit.equals(previousFluctuatedSolution.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static byte[] convertStringSolution(String solutionStr) {
        byte[] solution = new byte[solutionStr.length()];
        for (int i = 0; i < solutionStr.length(); i++) {
            String bit = solutionStr.substring(i, i + 1);
            if (NULL.equals(bit)) {
                solution[i] = NULL_BYTE;
            } else if (ONE_STR.equals(bit)) {
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
            sb.append((bit == null || bit.BIT_VALUE == NULL_BYTE) ? NULL : bit.BIT_VALUE);
        }
        return sb.toString();
    }

    private static String getSolution(byte[] solution) {
        StringBuilder sb = new StringBuilder();
        for (byte bit : solution) {
            sb.append((bit == NULL_BYTE) ? NULL : bit);
        }
        return sb.toString();
    }

    private static byte[] quantumFluctuation(byte[] originalArray) {
        byte[] array = Arrays.copyOf(originalArray, originalArray.length);
        long event = Math.round(Math.random() * 100);
        if (event < 25) {
            return complement(array);
        } else if (event < 50) {
            return reverse(array);
        } else if (event < 75) {
            return complementAndReverse(array);
        } else {
            return doNothing(array);
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
            if (array[i] == NULL_BYTE) {
                continue;
            }
            array[i] = (array[i] == ZERO) ? ONE : ZERO;
        }
        return array;
    }

    private static byte complement(Bit bit) {
        if (bit.BIT_VALUE == NULL_BYTE) {
            return NULL_BYTE;
        } else if (bit.BIT_VALUE == ONE) {
            return ZERO;
        }
        return ONE;
    }

    private static byte[] reverse(byte[] array) {
        final int HALF_OF_ARRAY = array.length / 2;
        for (int i = 0; i < HALF_OF_ARRAY; i++) {
            byte temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    private static byte[] complementAndReverse(byte[] array) {
        byte[] temp = complement(array);
        return reverse(temp);
    }

    private static byte[] doNothing(byte[] array) {
        return array;
    }
}