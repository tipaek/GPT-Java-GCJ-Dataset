import java.util.*;
import java.util.function.Consumer;

public class Solution {

    private final Scanner scanner;
    private final int b;
    private final boolean[] array;
    private int queryCount = 0;

    public Solution(Scanner scanner, int b) {
        this.scanner = scanner;
        this.b = b;
        this.array = new boolean[b];
    }

    private enum Operation {
        NOTHING(Operation::nothing),
        REVERSE(Operation::reverse),
        COMPLEMENT(Operation::complement),
        BOTH(Operation::both);

        private final Consumer<boolean[]> action;

        Operation(Consumer<boolean[]> action) {
            this.action = action;
        }

        static void nothing(boolean[] array) {
            // No operation
        }

        static void reverse(boolean[] array) {
            int n = array.length;
            for (int i = 0; i < n / 2; i++) {
                boolean temp = array[i];
                array[i] = array[n - 1 - i];
                array[n - 1 - i] = temp;
            }
        }

        static void complement(boolean[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = !array[i];
            }
        }

        static void both(boolean[] array) {
            reverse(array);
            complement(array);
        }

        void apply(boolean[] array) {
            action.accept(array);
        }
    }

    private void solve() {
        array[0] = query(0);
        array[b - 1] = query(b - 1);
        int a = array[0] == array[b - 1] ? findNotMatch() : findMatch();

        if (a == -1) {
            printOutput();
            return;
        }

        int remainingQueries = (10 - (queryCount % 10)) % 10;
        int end = Math.min(b / 2, a + remainingQueries / 2 + 1);
        for (int i = a + 1; i < end; i++) {
            array[i] = query(i);
            array[b - 1 - i] = query(b - 1 - i);
        }

        int stop = b / 2;
        int i = a + remainingQueries + 1;
        while (i < stop) {
            boolean NorR;
            boolean NorRC;
            if (array[0] == array[b - 1]) {
                NorR = query(0) == array[0];
                NorRC = query(a) == array[a];
            } else {
                NorRC = query(0) == array[0];
                NorR = query(a) == array[a];
            }

            Operation operation = determineOperation(NorR, NorRC);
            operation.apply(array);

            int limit = Math.min(i + 8, b / 2);
            for (int j = i; j < limit; j += 2) {
                array[j] = query(j);
                array[b - 1 - j] = query(b - 1 - j);
            }

            i += 10;
        }

        printOutput();
    }

    private Operation determineOperation(boolean NorR, boolean NorRC) {
        if (NorR && NorRC) {
            return Operation.NOTHING;
        } else if (NorR && !NorRC) {
            return Operation.REVERSE;
        } else if (!NorR && NorRC) {
            return Operation.BOTH;
        } else {
            return Operation.COMPLEMENT;
        }
    }

    private void printOutput() {
        StringBuilder result = new StringBuilder();
        for (boolean bit : array) {
            result.append(bit ? 1 : 0);
        }
        System.out.println(result);
    }

    private boolean query(int index) {
        if (queryCount % 10 == 0) {
            // Simulate some special operation every 10 queries
        }
        queryCount++;
        System.out.println(index + 1);
        return scanner.nextInt() == 1;
    }

    private int findMatch() {
        for (int i = 1; i < b / 2; i++) {
            if (queryCount % 10 == 0) {
                boolean before = array[0];
                boolean after = query(0);
                query(0);
                if (before != after) {
                    Operation.COMPLEMENT.apply(array);
                }
            } else {
                array[i] = query(i);
                array[b - 1 - i] = query(b - 1 - i);
                if (array[i] == array[b - 1 - i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findNotMatch() {
        for (int i = 1; i < b / 2; i++) {
            if (queryCount % 10 == 0) {
                boolean before = array[0];
                boolean after = query(0);
                query(0);
                if (before != after) {
                    Operation.COMPLEMENT.apply(array);
                }
            } else {
                array[i] = query(i);
                array[b - 1 - i] = query(b - 1 - i);
                if (array[i] != array[b - 1 - i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problems = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < problems; i++) {
            new Solution(scanner, b).solve();
            if (!scanner.next().equals("Y")) {
                break;
            }
        }
        scanner.close();
    }
}