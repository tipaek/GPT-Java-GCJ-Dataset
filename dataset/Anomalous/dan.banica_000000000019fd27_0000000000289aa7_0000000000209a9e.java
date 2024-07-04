import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter printWriter = new PrintWriter(System.out);

    private int query(int position) {
        printWriter.println(position);
        printWriter.flush();
        return scanner.nextInt();
    }

    private int[] solve(int b) {
        int[] values = new int[b + 1];
        boolean[] same = new boolean[b + 1];

        int firstSame = -1;
        int firstComplement = -1;
        for (int i = 1; i <= b / 2; i++) {
            values[i] = query(i);
            values[b + 1 - i] = query(b + 1 - i);

            same[i] = (values[b + 1 - i] == values[i]);
            if (same[i] && firstSame == -1) {
                firstSame = i;
            } else if (!same[i] && firstComplement == -1) {
                firstComplement = i;
            }
        }

        int[] valuesSame = new int[b + 1];
        Arrays.fill(valuesSame, 2);
        if (firstSame > 0) {
            int queries = 0;
            for (int i = 1; i <= b / 2; i++) {
                if (same[i]) {
                    valuesSame[i] = query(i);
                    queries++;
                    i = 5 * ((i - 1) / 5) + 5;
                }
            }

            for (int i = 0; i < 10 - queries; i++) {
                query(firstSame);
            }
        }

        int[] valuesComplement = new int[b + 1];
        Arrays.fill(valuesComplement, 2);
        if (firstComplement > 0) {
            int queries = 0;
            for (int i = 1; i <= b / 2; i++) {
                if (!same[i]) {
                    valuesComplement[i] = query(i);
                    queries++;
                    i = 5 * ((i - 1) / 5) + 5;
                }
            }

            for (int i = 0; i < 10 - queries; i++) {
                query(firstComplement);
            }
        }

        int[] currentValues = new int[b + 1];
        if (firstSame > 0) {
            currentValues[firstSame] = query(firstSame);
        }
        if (firstComplement > 0) {
            currentValues[firstComplement] = query(firstComplement);
        }

        for (int i = 1; i <= b / 2; i++) {
            if (same[i]) {
                boolean equalsFirst;
                if (valuesSame[i] != 2) {
                    equalsFirst = valuesSame[i] == valuesSame[firstSame];
                } else {
                    int j = i;
                    while (true) {
                        j--;
                        if (valuesSame[j] != 2) {
                            equalsFirst = (valuesSame[j] == valuesSame[firstSame]) == (values[j] == values[i]);
                            break;
                        }
                    }
                }

                currentValues[i] = equalsFirst ? currentValues[firstSame] : 1 - currentValues[firstSame];
                currentValues[b + 1 - i] = currentValues[i];
            } else {
                boolean equalsFirst;
                if (valuesComplement[i] != 2) {
                    equalsFirst = valuesComplement[i] == valuesComplement[firstComplement];
                } else {
                    int j = i;
                    while (true) {
                        j--;
                        if (valuesComplement[j] != 2) {
                            equalsFirst = (valuesComplement[j] == valuesComplement[firstComplement]) == (values[j] == values[i]);
                            break;
                        }
                    }
                }

                currentValues[i] = equalsFirst ? currentValues[firstComplement] : 1 - currentValues[firstComplement];
                currentValues[b + 1 - i] = 1 - currentValues[i];
            }
        }

        return currentValues;
    }

    private void solveTestCase(int b) {
        int[] values = solve(b);

        for (int i = 1; i <= b; i++) {
            printWriter.print(values[i]);
        }
        printWriter.println();
        printWriter.flush();

        char response = scanner.next().charAt(0);
        if (response != 'Y' && response != 'y') {
            System.exit(0);
        }
    }

    private void run() {
        int numberOfTests = scanner.nextInt();
        int b = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            solveTestCase(b);
        }

        printWriter.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}