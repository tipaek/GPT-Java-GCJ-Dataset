import java.util.*;

public class Solution {

    private static final int MAX_QUERIES = 150;
    private static final byte ONE = 1;
    private static final byte ZERO = 0;
    private static final byte NULL_BYTE = -1;
    private static final String ONE_STR = "1";
    private static final String ERROR = "N";
    private static final String OK_SOLUTION = "Y";
    private static final String NULL = "?";
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
    }

    private static final class MalformedQueryException extends RuntimeException {
    }

    private static class Database {
        public final int B;
        private int queryCount;
        private Scanner input;

        public Database(int B, Scanner input) {
            this.B = B;
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
            return new Bit(position, Byte.parseByte(response), queryCount);
        }

        public String getSolutionResponse(String solution) {
            return input.next().trim();
        }

        private void incrementQueryCount() {
            queryCount++;
        }

        public int getQueryCount() {
            return queryCount;
        }
    }

    private static final class MockDatabase extends Database {
        private final byte[] originalArray;
        private byte[] array;

        public MockDatabase(int B, Scanner input) {
            super(B, input);
            this.originalArray = generateTestArray(B);
            this.array = Arrays.copyOf(originalArray, originalArray.length);
        }

        @Override
        public Bit query(int position) {
            incrementQueryCount();
            if (getQueryCount() > MAX_QUERIES) {
                throw new TooManyQueriesException();
            }
            byte[] newArray = array;
            if (getQueryCount() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                newArray = quantumFluctuation(array);
            }
            array = newArray;
            if (position < 1 || position > B) {
                throw new MalformedQueryException();
            }
            return new Bit(position, newArray[position - 1], getQueryCount());
        }

        @Override
        public String getSolutionResponse(String solution) {
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
                        QuantumFluctuation fluctuation = guessFluctuation(solution, previousSolution);
                        if (fluctuation != QuantumFluctuation.UNKNOWN) {
                            previousSolution = null;
                            applyFluctuation(solution, fluctuation);
                            start = findNextPosition(solution, true);
                            end = findNextPosition(solution, false);
                        }
                    }
                }

                String currentSolution = getSolutionString(solution);
                if (!currentSolution.contains(NULL)) {
                    System.out.println(currentSolution);
                    String judgeResponse = db.getSolutionResponse(currentSolution);
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
    }

    private static QuantumFluctuation guessFluctuation(Bit[] solution, Bit[] previousSolution) {
        String currentSolution = getSolutionString(solution);
        String prevSolution = getSolutionString(previousSolution);
        byte[] prevSolutionBytes = convertToByteArray(prevSolution);

        if (currentSolution.equals(getSolutionString(complement(Arrays.copyOf(prevSolutionBytes, prevSolutionBytes.length))))) {
            return QuantumFluctuation.COMPLEMENTED;
        }
        if (currentSolution.equals(getSolutionString(reverse(Arrays.copyOf(prevSolutionBytes, prevSolutionBytes.length))))) {
            return QuantumFluctuation.REVERSED;
        }
        if (currentSolution.equals(getSolutionString(complementAndReverse(Arrays.copyOf(prevSolutionBytes, prevSolutionBytes.length))))) {
            return QuantumFluctuation.COMPLEMENTED_AND_REVERSED;
        }
        if (currentSolution.equals(prevSolution)) {
            return QuantumFluctuation.NOTHING;
        }
        return QuantumFluctuation.UNKNOWN;
    }

    private static byte[] convertToByteArray(String solutionStr) {
        byte[] solution = new byte[solutionStr.length()];
        for (int i = 0; i < solutionStr.length(); i++) {
            char bit = solutionStr.charAt(i);
            solution[i] = bit == '?' ? NULL_BYTE : (byte) (bit - '0');
        }
        return solution;
    }

    private static String getSolutionString(Bit[] solution) {
        StringBuilder sb = new StringBuilder();
        for (Bit bit : solution) {
            sb.append(bit == null || bit.value == NULL_BYTE ? NULL : bit.value);
        }
        return sb.toString();
    }

    private static String getSolutionString(byte[] solution) {
        StringBuilder sb = new StringBuilder();
        for (byte bit : solution) {
            sb.append(bit == NULL_BYTE ? NULL : bit);
        }
        return sb.toString();
    }

    private static byte[] quantumFluctuation(byte[] array) {
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
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = (byte) rand.nextInt(2);
        }
        return array;
    }

    private static byte[] complement(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == NULL_BYTE ? NULL_BYTE : (byte) (1 - array[i]);
        }
        return array;
    }

    private static byte complement(Bit bit) {
        return bit.value == NULL_BYTE ? NULL_BYTE : (byte) (1 - bit.value);
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
                        solution[solution.length - 1 - i] = new Bit(bit.position, complement(solution[solution.length - 1 - i]), bit.queryNumber);
                        Bit temp2 = solution[solution.length - 1 - i];
                        solution[solution.length - 1 - i] = solution[i];
                        solution[i] = temp2;
                        break;
                    case NOTHING:
                        break;
                }
                solution[i].needsFluctuation = false;
            }
        }
    }

    private static int findNextPosition(Bit[] solution, boolean fromStart) {
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
}