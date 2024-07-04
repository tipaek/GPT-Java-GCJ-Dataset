import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final int MAX_QUERIES = 150;
    private static final byte ONE = 1;
    private static final byte ZERO = 0;
    private static final String ERROR = "N";
    private static final String OK_SOLUTION = "Y";
    private static final String NULL = "?";
    private static final int QUANTUM_FLUCTUATION_PERIOD = 10;

    private static final class Bit {
        public final byte value;
        public final int queryNumber;
        public final int position;

        public Bit(int position, byte value, int queryNumber) {
            this.position = position;
            this.value = value;
            this.queryNumber = queryNumber;
        }

        public boolean wasFluctuated() {
            return (queryNumber % QUANTUM_FLUCTUATION_PERIOD == 1);
        }

        @Override
        public String toString() {
            return "Bit{" + "value=" + value + ", queryNumber=" + queryNumber + ", position=" + position + '}';
        }
    }

    private static final class TooManyQueriesException extends RuntimeException {
        // Empty exception class
    }

    private static final class MalformedQueryException extends RuntimeException {
        // Empty exception class
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
            byte value = (byte) Integer.parseInt(response);
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
        private byte[] currentArray;

        public MockedDatabase(int size, Scanner input) {
            super(size, input);
            originalArray = generateTestArray(size);
            currentArray = Arrays.copyOf(originalArray, originalArray.length);
            testPrint(Arrays.toString(currentArray) + " : original\n");
        }

        @Override
        public Bit query(int position) {
            incrementQueryCount();
            if (getQueryCount() > MAX_QUERIES) {
                throw new TooManyQueriesException();
            }
            testPrint("Query at position:" + position + ", query count: " + getQueryCount());
            if (getQueryCount() % QUANTUM_FLUCTUATION_PERIOD == 1) {
                currentArray = applyQuantumFluctuation(currentArray);
                testPrint("Fluctuated array: " + Arrays.toString(currentArray));
            }
            if (position < 1 || position > size) {
                throw new MalformedQueryException();
            }
            return new Bit(position, currentArray[position - 1], getQueryCount());
        }

        @Override
        public String getResponseForSolution(String solution) {
            String currentArrayStr = new String(currentArray);
            testPrint(solution + " : solution\n" + currentArrayStr + " : current array");
            return currentArrayStr.equals(solution) ? OK_SOLUTION : ERROR;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int bitArraySize = input.nextInt();

        try {
            for (int testCase = 1; testCase <= testCases; testCase++) {
                Bit[] solution = new Bit[bitArraySize];
                Database db = new Database(bitArraySize, input);
                int start = 1;
                int end = bitArraySize;
                int iterations = MAX_QUERIES / QUANTUM_FLUCTUATION_PERIOD;

                for (int tries = 0; tries < iterations; tries++) {
                    for (int i = 0; i < QUANTUM_FLUCTUATION_PERIOD; i++) {
                        if (i % 2 == 0) {
                            solution[start - 1] = db.query(start);
                            start++;
                        } else {
                            solution[end - 1] = db.query(end);
                            end--;
                        }
                    }
                    String currentSolution = buildSolutionString(solution);
                    testPrint(currentSolution);
                    if (!currentSolution.contains(NULL)) {
                        System.out.println(currentSolution);
                        String judgeResponse = db.getResponseForSolution(currentSolution);
                        if (ERROR.equals(judgeResponse)) {
                            throw new MalformedQueryException();
                        } else if (OK_SOLUTION.equals(judgeResponse)) {
                            break;
                        }
                    }
                }
            }
        } catch (MalformedQueryException e) {
            // Terminate to avoid timeout exception
        }
    }

    private static String buildSolutionString(Bit[] solution) {
        StringBuilder sb = new StringBuilder();
        for (Bit bit : solution) {
            sb.append((bit == null) ? NULL : bit.value);
        }
        return sb.toString();
    }

    private static byte[] applyQuantumFluctuation(byte[] array) {
        byte[] result = Arrays.copyOf(array, array.length);
        long event = Math.round(Math.random() * 100);
        if (event < 25) {
            testPrint("complement");
            return complement(result);
        } else if (event < 50) {
            testPrint("reverse");
            return reverse(result);
        } else if (event < 75) {
            testPrint("complementAndReverse");
            return complementAndReverse(result);
        } else {
            testPrint("doNothing");
            return result;
        }
    }

    private static byte[] generateTestArray(int size) {
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) Math.round(Math.random());
        }
        return new byte[]{0, 0, 0, 1, 1, 0, 1, 1, 1, 1}; // Example array
    }

    private static void testPrint(String str) {
        // System.err.println(str);
    }

    private static byte[] complement(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == ZERO) ? ONE : ZERO;
        }
        return array;
    }

    private static byte[] reverse(byte[] array) {
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
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