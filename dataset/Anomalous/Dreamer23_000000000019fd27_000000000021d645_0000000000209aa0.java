import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(in.nextLine().split(" ")));
            }
        }
    }

    static int expectedTrace = 0;

    private static String getResult(String[] input) {
        int N = Integer.parseInt(input[0]);
        expectedTrace = Integer.parseInt(input[1]);
        if (expectedTrace < N || expectedTrace > N * N) return "IMPOSSIBLE";

        final int maxAttempts = 10000;
        final int maxSize = 500;
        final int eachActionNum = 5;
        final int base = expectedTrace / N - 1;

        int[][] initialState = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = ((j + base - i) % N) + 1;
                if (x < 1) x = N + x;
                initialState[i][j] = x;
            }
        }

        TreeSet<State> states = new TreeSet<>();
        states.add(new State(initialState));

        for (int i = 0; i < maxAttempts; i++) {
            State state = states.pollFirst();
            if (state.diff == 0) return stateToString(state.square, N);

            for (int x = 0; x < eachActionNum; x++) {
                states.add(new State(shuffleRandomColumn(state.square, N)));
                states.add(new State(shuffleRandomRow(state.square, N)));
                states.add(new State(shuffleRandomNumbers(state.square, N)));
            }
            while (states.size() > maxSize) {
                states.pollLast();
            }
        }

        return "IMPOSSIBLE";
    }

    private static String stateToString(int[][] square, int N) {
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) sb.append(" ");
                sb.append(square[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private static class State implements Comparable<State> {
        final int[][] square;
        final int diff;

        public State(int[][] square) {
            this.square = square;
            this.diff = Math.abs(calcDiagonal(square.length, square) - expectedTrace);
        }

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.diff, other.diff);
        }
    }

    private static int[][] clone(int[][] square, int N) {
        int[][] cloned = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(square[i], 0, cloned[i], 0, N);
        }
        return cloned;
    }

    private static int[][] shuffleRandomColumn(int[][] squareOrig, int N) {
        int[][] square = clone(squareOrig, N);
        int col1 = (int) (Math.random() * N);
        int col2 = (int) (Math.random() * N);
        for (int i = 0; i < N; i++) {
            int tmp = square[i][col1];
            square[i][col1] = square[i][col2];
            square[i][col2] = tmp;
        }
        return square;
    }

    private static int[][] shuffleRandomRow(int[][] squareOrig, int N) {
        int[][] square = clone(squareOrig, N);
        int row1 = (int) (Math.random() * N);
        int row2 = (int) (Math.random() * N);
        for (int i = 0; i < N; i++) {
            int tmp = square[row1][i];
            square[row1][i] = square[row2][i];
            square[row2][i] = tmp;
        }
        return square;
    }

    private static int[][] shuffleRandomNumbers(int[][] squareOrig, int N) {
        int[][] square = clone(squareOrig, N);
        int num1 = 1 + (int) (Math.random() * N);
        int num2 = 1 + (int) (Math.random() * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == num1) {
                    square[i][j] = num2;
                } else if (square[i][j] == num2) {
                    square[i][j] = num1;
                }
            }
        }
        return square;
    }

    private static int calcDiagonal(int N, int[][] square) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += square[i][i];
        }
        return sum;
    }
}