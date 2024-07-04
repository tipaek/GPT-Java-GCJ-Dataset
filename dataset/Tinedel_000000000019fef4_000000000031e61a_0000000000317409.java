import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String p = in.next();
            System.out.println("Case #" + i + ": " + solve(x, y, p));
        }
    }

    static class State {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        int x;
        int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        State N(char nextStep) {
            switch (nextStep) {
                case 'N':
                    return this;
                case 'S':
                    return new State(x, y - 2);
                case 'W':
                    return new State(x - 1, y - 1);
                case 'E':
                    return new State(x + 1, y - 1);
            }
            throw new RuntimeException("Impossibru!");
        }

        State S(char nextStep) {
            switch (nextStep) {
                case 'S':
                    return this;
                case 'N':
                    return new State(x, y + 2);
                case 'W':
                    return new State(x - 1, y + 1);
                case 'E':
                    return new State(x + 1, y + 1);
            }
            throw new RuntimeException("Impossibru!");
        }

        State E(char nextStep) {
            switch (nextStep) {
                case 'N':
                    return new State(x - 1, y + 1);
                case 'S':
                    return new State(x - 1, y - 1);
                case 'W':
                    return new State(x - 2, y);
                case 'E':
                    return this;
            }
            throw new RuntimeException("Impossibru!");
        }

        State W(char nextStep) {
            switch (nextStep) {
                case 'N':
                    return new State(x + 1, y + 1);
                case 'S':
                    return new State(x + 1, y - 1);
                case 'E':
                    return new State(x + 2, y);
                case 'W':
                    return this;
            }
            throw new RuntimeException("Impossibru!");
        }

        State P(char nextStep) {
            switch (nextStep) {
                case 'N':
                    return new State(x, y + 1);
                case 'S':
                    return new State(x, y - 1);
                case 'W':
                    return new State(x - 1, y);
                case 'E':
                    return new State(x + 1, y);
            }
            throw new RuntimeException("Impossibru!");
        }

        boolean catchYou() {
            return x == 0 && y == 0;
        }

        int distance() {
            return Math.abs(x) + Math.abs(y);
        }

        boolean tooFarAway(int timeLeft) {
            return distance() > 2 * timeLeft;
        }

        Set<State> bringsNotFurther(char nextStep) {
            Set<State> res = new HashSet<>();
            res.add(E(nextStep));
            res.add(N(nextStep));
            res.add(S(nextStep));
            res.add(W(nextStep));
            res.add(P(nextStep));
            int dist = distance();

            return res.stream().filter(state -> state.distance() <= dist).collect(Collectors.toSet());
        }
    }

    private static String solve(int x, int y, String p) {
        Set<State> toCheck = new HashSet<>();
        int steps = 0;
        State st = new State(x, y);
        toCheck.add(st);
        int len = p.length();
        while (steps < len) {
            char nextStep = p.charAt(steps);
            Set<State> nextStates = new HashSet<>();
            for (State state : toCheck) {
                nextStates.addAll(state.bringsNotFurther(nextStep));
            }
            steps++;
            if (nextStates.stream().anyMatch(State::catchYou)) return String.valueOf(steps);
            int finalSteps = steps;
            toCheck = nextStates.stream().filter(state -> !state.tooFarAway(len - finalSteps + 1)).collect(Collectors.toSet());
        }

        return "IMPOSSIBLE";
    }
}