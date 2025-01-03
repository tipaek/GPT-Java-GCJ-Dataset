import java.util.*;
import java.util.function.Consumer;

public class Solution {

    private final Scanner scan;
    private final int b;
    private final boolean[] array;

    public Solution(Scanner scan, int b) {
        this.scan = scan;
        this.b = b;
        this.array = new boolean[b];
    }

    private enum Operation {
        NOTHING(Operation::nothing),
        REVERSE(Operation::reverse),
        COMPLEMENT(Operation::complement),
        BOTH(Operation::both);

        private final Consumer<boolean[]> consumer;

        Operation(Consumer<boolean[]> consumer) {
            this.consumer = consumer;
        }

        private static void nothing(boolean[] array) {
            // No operation
        }

        private static void reverse(boolean[] array) {
            int n = array.length;
            for (int i = 0; i < n / 2; i++) {
                boolean temp = array[i];
                array[i] = array[n - 1 - i];
                array[n - 1 - i] = temp;
            }
        }

        private static void complement(boolean[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = !array[i];
            }
        }

        private static void both(boolean[] array) {
            reverse(array);
            complement(array);
        }

        void apply(boolean[] array) {
            consumer.accept(array);
        }
    }

    private void solve() {
        array[0] = query(0);
        array[b - 1] = query(b - 1);
        int a = (array[0] == array[b - 1]) ? findNotMatch() : findMatch();

        if (a == -1) {
            printOutput();
            return;
        }

        int rem = (10 - (x % 10)) % 10;
        int end = Math.min(b / 2, a + rem / 2 + 1);
        for (int i = a + 1; i < end; i++) {
            array[i] = query(i);
            array[b - 1 - i] = query(b - 1 - i);
        }

        int stop = b / 2;
        int i = end;
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

            Operation operation = findOperation(NorR, NorRC);
            operation.apply(array);

            int n = Math.min(i + 4, b / 2);
            for (int j = i; j < n; j++) {
                array[j] = query(j);
                array[b - 1 - j] = query(b - 1 - j);
            }
            i += 4;
        }

        printOutput();
    }

    private Operation findOperation(boolean NorR, boolean NorRC) {
        if (NorR && NorRC) {
            return Operation.NOTHING;
        } else if (NorR) {
            return Operation.REVERSE;
        } else if (NorRC) {
            return Operation.BOTH;
        } else {
            return Operation.COMPLEMENT;
        }
    }

    private void printOutput() {
        StringBuilder result = new StringBuilder();
        for (boolean b : array) {
            result.append(b ? 1 : 0);
        }
        System.out.println(result);
    }

    private int x = 0;

    private boolean query(int index) {
        if (x % 10 == 0) {
            // Perform some special operation
        }
        x++;
        System.out.println(index + 1);
        return scan.nextInt() == 1;
    }

    private int findMatch() {
        int i = 1;
        int x = 2;
        while (i < b / 2) {
            if (x % 10 == 0) {
                boolean before = array[0];
                boolean after = query(0);
                query(0);
                x += 2;
                if (before != after) {
                    Operation.COMPLEMENT.apply(array);
                }
            } else {
                array[i] = query(i);
                array[b - 1 - i] = query(b - 1 - i);
                if (array[i] == array[b - 1 - i]) {
                    return i;
                }
                i++;
                x += 2;
            }
        }
        return -1;
    }

    private int findNotMatch() {
        int i = 1;
        while (i < b / 2) {
            if (x % 10 == 0) {
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
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        int b = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            new Solution(scan, b).solve();
            if (!scan.next().equals("Y")) {
                return;
            }
        }
        scan.close();
    }
}