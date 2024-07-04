package com.janosgyerik.codejam.codejam2020.round1b.p3_JoinRanks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner = example();
        // scanner = bigTest();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            Input input = Input.fromScanner(scanner);
            printCase(t, solve(input));
        }
    }

    private static Scanner example() {
        return new Scanner("3\n2 2\n3 2\n2 3");
    }

    private static Scanner bigTest() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int T = 100;
        int A = 255;
        int maxLength = 500;
        sb.append(T).append('\n');
        for (int t = 0; t < T; t++) {
            sb.append(A).append('\n');
            for (int i = 0; i < A; i++) {
                int length = 1 + random.nextInt(maxLength);
                // TODO
            }
        }
        return new Scanner(sb.toString());
    }

    private static class Input {
        private final int R;
        private final int S;

        public Input(int R, int S) {
            this.R = R;
            this.S = S;
        }

        public static Input fromScanner(Scanner scanner) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            return new Input(R, S);
        }
    }

    private static void printCase(int t, List<String> lines) {
        System.out.printf("Case #%d:%n", t + 1);
        lines.forEach(System.out::println);
    }

    private static List<String> solve(Input input) {
        int[] ranks = new int[input.R * input.S];
        for (int s = 0, i = 0; s < input.S; s++) {
            for (int r = 0; r < input.R; r++, i++) {
                ranks[i] = r;
            }
        }

        List<String> steps = new ArrayList<>();
        while (!isSorted(ranks)) {
            int start = firstIncorrect(ranks);
            int end = lastIncorrect(ranks, start - 1);
            int[] work = ranks.clone();
            System.arraycopy(work, start, ranks, 0, end - start + 1);
            System.arraycopy(work, 0, ranks, end - start + 1, start);
            steps.add(String.format("%d %d", start, end - start + 1));
        }
        return steps;
    }

    private static int firstIncorrect(int[] ranks) {
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] < ranks[i - 1]) {
                return i;
            }
        }
        return ranks.length - 1;
    }

    private static int lastIncorrect(int[] ranks, int start) {
        for (int i = ranks.length - 1; i > start; i--) {
            if (ranks[i] < ranks[start]) {
                return i;
            }
        }
        return ranks.length - 1;
    }

    private static boolean isSorted(int[] ranks) {
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i - 1] > ranks[i]) {
                return false;
            }
        }
        return true;
    }
}