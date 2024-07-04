import java.util.*;
import java.util.function.Consumer;

public class Solution {

    private final Scanner scanner;
    private final int length;
    private final boolean[] bitArray;

    Solution(Scanner scanner, int length) {
        this.scanner = scanner;
        this.length = length;
        this.bitArray = new boolean[length];
    }

    enum Operation {
        NOTHING(Operation::doNothing),
        REVERSE(Operation::reverseArray),
        COMPLEMENT(Operation::complementArray),
        BOTH(Operation::reverseAndComplementArray);

        private final Consumer<boolean[]> operation;

        Operation(Consumer<boolean[]> operation) {
            this.operation = operation;
        }

        void apply(boolean[] array) {
            operation.accept(array);
        }

        static void doNothing(boolean[] array) {}

        static void reverseArray(boolean[] array) {
            int n = array.length;
            for (int i = 0; i < n / 2; i++) {
                boolean temp = array[i];
                array[i] = array[n - 1 - i];
                array[n - 1 - i] = temp;
            }
        }

        static void complementArray(boolean[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = !array[i];
            }
        }

        static void reverseAndComplementArray(boolean[] array) {
            reverseArray(array);
            complementArray(array);
        }
    }

    private void solve() {
        bitArray[0] = query(0);
        bitArray[length - 1] = query(length - 1);
        int matchIndex = bitArray[0] == bitArray[length - 1] ? findMismatch() : findMatch();

        if (matchIndex == -1) {
            printResult();
            return;
        }

        int remaining = (10 - (queryCount % 10)) % 10;
        int end = Math.min(length / 2, matchIndex + remaining / 2 + 1);
        for (int i = matchIndex + 1; i < end; i++) {
            bitArray[matchIndex + i] = query(matchIndex + i);
            bitArray[length - 1 - matchIndex - i] = query(length - 1 - matchIndex - i);
        }

        int stop = length / 2;
        int i = matchIndex + remaining + 1;
        while (i < stop) {
            boolean normalOrReversed;
            boolean normalOrReversedComplemented;
            if (bitArray[0] == bitArray[length - 1]) {
                normalOrReversed = query(0) == bitArray[0];
                normalOrReversedComplemented = query(matchIndex) == bitArray[matchIndex];
            } else {
                normalOrReversedComplemented = query(0) == bitArray[0];
                normalOrReversed = query(matchIndex) == bitArray[matchIndex];
            }

            Operation operation = determineOperation(normalOrReversed, normalOrReversedComplemented);
            operation.apply(bitArray);

            int n = Math.min(i + 8, length / 2);
            for (int j = i; j < n; j += 2) {
                bitArray[j] = query(j);
                bitArray[length - 1 - j] = query(length - 1 - j);
            }

            i += 10;
        }

        printResult();
    }

    private Operation determineOperation(boolean normalOrReversed, boolean normalOrReversedComplemented) {
        if (normalOrReversed && normalOrReversedComplemented) {
            return Operation.NOTHING;
        } else if (normalOrReversed && !normalOrReversedComplemented) {
            return Operation.REVERSE;
        } else if (!normalOrReversed && normalOrReversedComplemented) {
            return Operation.BOTH;
        } else {
            return Operation.COMPLEMENT;
        }
    }

    private void printResult() {
        StringBuilder result = new StringBuilder();
        for (boolean bit : bitArray) {
            result.append(bit ? 1 : 0);
        }
        System.out.println(result);
    }

    private int queryCount = 0;

    private boolean query(int index) {
        if (queryCount % 10 == 0) {
            // Perform some operation if needed
        }
        queryCount++;
        System.out.println(index);
        return scanner.nextInt() == 1;
    }

    private int findMatch() {
        int i = 1;
        int queryCounter = 2;
        while (i < length / 2) {
            if (queryCounter % 10 == 0) {
                boolean before = bitArray[0];
                boolean after = query(0);
                query(0);
                queryCounter += 2;
                if (before != after) {
                    Operation.COMPLEMENT.apply(bitArray);
                }
            } else {
                bitArray[i] = query(i);
                bitArray[length - 1 - i] = query(length - 1 - i);
                if (bitArray[i] == bitArray[length - 1 - i]) {
                    return i;
                }
                i++;
                queryCounter += 2;
            }
        }
        return -1;
    }

    private int findMismatch() {
        int i = 1;
        int queryCounter = 2;
        while (i < length / 2) {
            if (queryCounter % 10 == 0) {
                boolean before = bitArray[0];
                boolean after = query(0);
                query(0);
                queryCounter += 2;
                if (before != after) {
                    Operation.COMPLEMENT.apply(bitArray);
                }
            } else {
                bitArray[i] = query(i);
                bitArray[length - 1 - i] = query(length - 1 - i);
                if (bitArray[i] != bitArray[length - 1 - i]) {
                    return i;
                }
                i++;
                queryCounter += 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemCount = scanner.nextInt();
        int length = scanner.nextInt();
        for (int i = 0; i < problemCount; i++) {
            new Solution(scanner, length).solve();
            if (!scanner.next().equals("Y")) {
                return;
            }
        }
        scanner.close();
    }
}