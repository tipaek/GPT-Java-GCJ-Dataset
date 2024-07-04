import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private int sameBit = -1;
    private int diffBit = -1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().solveCase(caseNum, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solveCase(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length / 2;

        while (curBit < target) {
            int remainingQueries = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;

            if (hasSameBit()) {
                processBit(scanner, state, sameBit);
                shouldComplement = scanner.nextInt() > 0 != state[sameBit];
                remainingQueries--;
            }

            if (hasDifferentBit()) {
                processBit(scanner, state, diffBit);
                shouldReverse = scanner.nextInt() > 0 != state[diffBit];
                remainingQueries--;
            }

            if (shouldComplement) {
                complementState(state);
            }

            if (shouldReverse) {
                reverseState(state);
            }

            while (remainingQueries > 1) {
                processBit(scanner, state, curBit);
                processBit(scanner, state, length - curBit - 1);

                if (!hasSameBit() && state[curBit] == state[length - curBit - 1]) {
                    sameBit = curBit;
                }

                if (!hasDifferentBit() && state[curBit] != state[length - curBit - 1]) {
                    diffBit = curBit;
                }

                curBit++;
                remainingQueries -= 2;
            }

            if (remainingQueries > 0) {
                processBit(scanner, state, length - curBit - 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (boolean bit : state) {
            result.append(bit ? '1' : '0');
        }
        System.out.printf(OUTPUT_FORMAT, caseNum, result.toString());
        System.out.flush();
    }

    private void processBit(Scanner scanner, boolean[] state, int index) {
        System.out.println(index + 1);
        System.out.flush();
        state[index] = scanner.nextInt() > 0;
    }

    private void complementState(boolean[] state) {
        for (int i = 0; i < state.length; i++) {
            state[i] = !state[i];
        }
    }

    private void reverseState(boolean[] state) {
        int mid = state.length / 2;
        for (int i = 0; i < mid; i++) {
            boolean temp = state[i];
            state[i] = state[state.length - i - 1];
            state[state.length - i - 1] = temp;
        }
    }

    private boolean hasSameBit() {
        return sameBit > -1;
    }

    private boolean hasDifferentBit() {
        return diffBit > -1;
    }
}