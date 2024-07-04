import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the following line to run the test method
        // test();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(Integer.parseInt(scanner.nextLine())));
            }
        }
    }

    private static class Location {
        final int r, k;

        private Location(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Location location = (Location) obj;
            return r == location.r && k == location.k;
        }
    }

    private static int[][] generatePascalTriangle(int depth) {
        int[][] pascal = new int[depth][depth];
        for (int i = 0; i < depth; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }
        for (int r = 2; r < depth; r++) {
            for (int k = 1; k < r; k++) {
                pascal[r][k] = pascal[r - 1][k - 1] + pascal[r - 1][k];
            }
        }
        return pascal;
    }

    private static String listToString(List<Location> locations) {
        if (locations == null) return "ERROR";
        StringBuilder sb = new StringBuilder();
        for (Location location : locations) {
            sb.append("\n").append(location.r + 1).append(" ").append(location.k + 1);
        }
        return sb.toString();
    }

    private static class State {
        int total;
        int currR, currK;
        List<Location> steps;

        public State(int total, int currR, int currK, List<Location> steps) {
            this.total = total;
            this.currR = currR;
            this.currK = currK;
            this.steps = steps;
        }
    }

    private static State tryAddState(int r, int k, List<Location> prevSteps, int prevTotal, int[][] pascal, Queue<State> queue, final int target) {
        Location newLocation = new Location(r, k);
        if (r < 0 || k < 0 || k > r || prevSteps.contains(newLocation)) return null;

        int newTotal = prevTotal + pascal[r][k];
        if (newTotal > target) return null;

        List<Location> newSteps = new ArrayList<>(prevSteps);
        newSteps.add(newLocation);

        State newState = new State(newTotal, r, k, newSteps);
        if (newTotal == target) return newState;

        queue.add(newState);
        return null;
    }

    private static String getResult(final int target) {
        int[][] pascal = generatePascalTriangle(Math.min(500, target));
        Queue<State> queue = new ArrayDeque<>();

        List<Location> startSteps = new ArrayList<>();
        startSteps.add(new Location(0, 0));

        if (target == 1) return listToString(startSteps);

        queue.add(new State(1, 0, 0, startSteps));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int r = state.currR;
            int k = state.currK;

            State resultState;
            resultState = tryAddState(r - 1, k - 1, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);

            resultState = tryAddState(r - 1, k, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);

            resultState = tryAddState(r, k - 1, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);

            resultState = tryAddState(r, k + 1, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);

            resultState = tryAddState(r + 1, k, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);

            resultState = tryAddState(r + 1, k + 1, state.steps, state.total, pascal, queue, target);
            if (resultState != null) return listToString(resultState.steps);
        }

        return "ERROR";
    }
}