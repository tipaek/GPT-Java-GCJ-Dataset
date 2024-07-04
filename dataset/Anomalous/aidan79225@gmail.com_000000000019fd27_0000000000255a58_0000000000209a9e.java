import java.util.Scanner;

public class Solution {
    private int sameBit = -1;
    private int diffBit = -1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                solution.getAnswer(caseNum, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAnswer(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length / 2;

        while (curBit < target) {
            int count = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;

            if (hasSameBit()) {
                shouldComplement = handleSameBit(scanner, state);
                --count;
            }

            if (hasDifferentBit()) {
                shouldReverse = handleDifferentBit(scanner, state, shouldComplement);
                --count;
            }

            if (shouldComplement) {
                complementState(state);
            }

            if (shouldReverse) {
                reverseState(state);
            }

            while (count > 1 && curBit < target) {
                processBits(scanner, state, length, curBit);
                ++curBit;
                count -= 2;
            }

            if (count > 0 && curBit < target) {
                System.out.println(length - curBit);
                System.out.flush();
                scanner.nextInt(); // Read and discard input
            }
        }

        printResult(state, scanner);
    }

    private boolean handleSameBit(Scanner scanner, boolean[] state) {
        System.out.println(sameBit + 1);
        System.out.flush();
        int x = scanner.nextInt();
        return x > 0 != state[sameBit];
    }

    private boolean handleDifferentBit(Scanner scanner, boolean[] state, boolean shouldComplement) {
        System.out.println(diffBit + 1);
        System.out.flush();
        int x = scanner.nextInt();
        return shouldComplement ? x > 0 == state[diffBit] : x > 0 != state[diffBit];
    }

    private void complementState(boolean[] state) {
        for (int i = 0; i < state.length; ++i) {
            state[i] = !state[i];
        }
    }

    private void reverseState(boolean[] state) {
        int mid = state.length / 2;
        for (int i = 0; i < mid; ++i) {
            boolean temp = state[i];
            state[i] = state[state.length - i - 1];
            state[state.length - i - 1] = temp;
        }
    }

    private void processBits(Scanner scanner, boolean[] state, int length, int curBit) {
        System.out.println(curBit + 1);
        System.out.flush();
        int x = scanner.nextInt();
        state[curBit] = x > 0;

        System.out.println(length - curBit);
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

    private void printResult(boolean[] state, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        for (boolean bit : state) {
            sb.append(bit ? '1' : '0');
        }
        System.out.println(sb.toString());
        System.out.flush();
        String result = scanner.next();
        if (!result.equals("Y")) {
            System.exit(1);
        }
    }

    private boolean hasSameBit() {
        return sameBit > -1;
    }

    private boolean hasDifferentBit() {
        return diffBit > -1;
    }
}