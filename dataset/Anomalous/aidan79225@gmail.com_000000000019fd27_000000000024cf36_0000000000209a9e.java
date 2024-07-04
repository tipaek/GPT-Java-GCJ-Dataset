import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_TEMPLATE = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                new Solution().solveCase(caseNum, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int sameBit = -1;
    private int diffBit = -1;

    private void solveCase(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length / 2;

        while (curBit < target) {
            int remainingQueries = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;

            if (hasSameBit()) {
                shouldComplement = processSameBit(scanner, state);
                remainingQueries--;
            }

            if (hasDifferentBit()) {
                shouldReverse = processDifferentBit(scanner, state, shouldComplement);
                remainingQueries--;
            }

            if (shouldComplement) {
                complementArray(state);
            }

            if (shouldReverse) {
                reverseArray(state);
            }

            while (remainingQueries > 1 && curBit < target) {
                processBitPair(scanner, state, curBit, length);
                curBit++;
                remainingQueries -= 2;
            }

            if (remainingQueries > 0 && curBit < target) {
                System.out.println(length - curBit - 1);
                System.out.flush();
                scanner.nextInt();
            }
        }

        printResult(state);
    }

    private boolean processSameBit(Scanner scanner, boolean[] state) {
        System.out.println(sameBit);
        System.out.flush();
        int x = scanner.nextInt();
        return x > 0 != state[sameBit];
    }

    private boolean processDifferentBit(Scanner scanner, boolean[] state, boolean shouldComplement) {
        System.out.println(diffBit);
        System.out.flush();
        int x = scanner.nextInt();
        return shouldComplement ? x > 0 == state[diffBit] : x > 0 != state[diffBit];
    }

    private void complementArray(boolean[] state) {
        for (int i = 0; i < state.length; i++) {
            state[i] = !state[i];
        }
    }

    private void reverseArray(boolean[] state) {
        int mid = state.length / 2;
        for (int i = 0; i < mid; i++) {
            boolean temp = state[i];
            state[i] = state[state.length - i - 1];
            state[state.length - i - 1] = temp;
        }
    }

    private void processBitPair(Scanner scanner, boolean[] state, int curBit, int length) {
        System.out.println(curBit);
        System.out.flush();
        int x = scanner.nextInt();
        state[curBit] = x > 0;

        System.out.println(length - curBit - 1);
        System.out.flush();
        int y = scanner.nextInt();
        state[length - curBit - 1] = y > 0;

        if (!hasSameBit() && x == y) {
            sameBit = curBit;
        }

        if (!hasDifferentBit() && x != y) {
            diffBit = curBit;
        }
    }

    private void printResult(boolean[] state) {
        StringBuilder result = new StringBuilder();
        for (boolean bit : state) {
            result.append(bit ? '1' : '0');
        }
        System.out.println(result.toString());
        System.out.flush();
    }

    private boolean hasSameBit() {
        return sameBit > -1;
    }

    private boolean hasDifferentBit() {
        return diffBit > -1;
    }
}