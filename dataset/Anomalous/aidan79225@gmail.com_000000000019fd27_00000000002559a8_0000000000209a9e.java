package com.crazystudio.qualification.esab;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                solution.processCase(caseNum, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int sameBit = -1;
    private int diffBit = -1;

    private void processCase(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length / 2;

        while (curBit < target) {
            int remainingQueries = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;

            if (hasSameBit()) {
                shouldComplement = queryAndCheckComplement(scanner, state, sameBit);
                remainingQueries--;
            }

            if (hasDifferentBit()) {
                shouldReverse = queryAndCheckReverse(scanner, state, diffBit, shouldComplement);
                remainingQueries--;
            }

            if (shouldComplement) {
                complementState(state);
            }

            if (shouldReverse) {
                reverseState(state);
            }

            while (remainingQueries > 1 && curBit < target) {
                queryAndSetState(scanner, state, curBit, length);
                if (!hasSameBit() && state[curBit] == state[length - curBit - 1]) {
                    sameBit = curBit;
                }
                if (!hasDifferentBit() && state[curBit] != state[length - curBit - 1]) {
                    diffBit = curBit;
                }
                curBit++;
                remainingQueries -= 2;
            }

            if (remainingQueries > 0 && curBit < target) {
                scanner.nextInt(); // Consume an extra query if needed
            }
        }

        StringBuilder result = new StringBuilder();
        for (boolean bit : state) {
            result.append(bit ? '1' : '0');
        }
        System.out.println(result.toString());
        System.out.flush();

        if (!scanner.next().equals("Y")) {
            System.exit(1);
        }
    }

    private boolean queryAndCheckComplement(Scanner scanner, boolean[] state, int bitPos) {
        System.out.println(bitPos + 1);
        System.out.flush();
        int response = scanner.nextInt();
        return response > 0 != state[bitPos];
    }

    private boolean queryAndCheckReverse(Scanner scanner, boolean[] state, int bitPos, boolean shouldComplement) {
        System.out.println(bitPos + 1);
        System.out.flush();
        int response = scanner.nextInt();
        return shouldComplement ? response > 0 == state[bitPos] : response > 0 != state[bitPos];
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

    private void queryAndSetState(Scanner scanner, boolean[] state, int curBit, int length) {
        System.out.println(curBit + 1);
        System.out.flush();
        state[curBit] = scanner.nextInt() > 0;

        System.out.println(length - curBit);
        System.out.flush();
        state[length - curBit - 1] = scanner.nextInt() > 0;
    }

    private boolean hasSameBit() {
        return sameBit > -1;
    }

    private boolean hasDifferentBit() {
        return diffBit > -1;
    }
}