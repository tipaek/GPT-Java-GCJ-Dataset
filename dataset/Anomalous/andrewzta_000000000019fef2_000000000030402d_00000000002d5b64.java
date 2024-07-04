import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        JoinTheRanks solver = new JoinTheRanks();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class JoinTheRanks {
        private PrintWriter out;

        private int solvePuzzle(int r, int s) {
            Map<State, Integer> stateMap = new HashMap<>();
            Deque<State> queue = new ArrayDeque<>();
            State initialState = new State(r * s);
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < r; j++) {
                    initialState.values[i * r + j] = j;
                }
            }
            queue.add(initialState);
            stateMap.put(initialState, 0);

            while (!queue.isEmpty()) {
                State currentState = queue.pollFirst();
                int currentBadness = currentState.calculateBadness();
                for (int a = 0; a < currentState.values.length - 1; a++) {
                    for (int b = 1; a + b <= currentState.values.length; b++) {
                        State nextState = currentState.move(a, b);
                        if (stateMap.containsKey(nextState)) {
                            continue;
                        }
                        if (nextState.isSorted()) {
                            out.println(stateMap.get(currentState) + 1);
                            nextState.printPath();
                            return stateMap.get(currentState) + 1;
                        }
                        if (nextState.calculateBadness() > currentBadness - 2) {
                            continue;
                        }
                        stateMap.put(nextState, stateMap.get(currentState) + 1);
                        queue.add(nextState);
                        break;
                    }
                }
            }
            return -1;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            this.out = out;
            int r = in.nextInt();
            int s = in.nextInt();
            out.print("Case #" + testNumber + ": ");
            solvePuzzle(r, s);
        }

        class State {
            int[] values;
            State previousState;
            int fromIndex;
            int length;

            public State(State state) {
                this.values = state.values.clone();
            }

            public State(int size) {
                this.values = new int[size];
            }

            State move(int start, int length) {
                State newState = new State(values.length);
                System.arraycopy(values, start, newState.values, 0, length);
                System.arraycopy(values, 0, newState.values, length, start);
                System.arraycopy(values, start + length, newState.values, start + length, values.length - start - length);
                newState.previousState = this;
                newState.fromIndex = start;
                newState.length = length;
                return newState;
            }

            public boolean isSorted() {
                for (int i = 0; i < values.length - 1; i++) {
                    if (values[i] > values[i + 1]) {
                        return false;
                    }
                }
                return true;
            }

            int calculateBadness() {
                int badness = 0;
                boolean[] seen = new boolean[values.length];
                for (int i = 0; i < values.length - 1; i++) {
                    if (values[i] > values[i + 1]) {
                        badness++;
                    } else if (values[i] < values[i + 1] - 1) {
                        badness++;
                    } else if (values[i] == values[i + 1] - 1 && seen[values[i]]) {
                        badness++;
                    } else if (values[i] == values[i + 1] - 1) {
                        seen[values[i]] = true;
                    }
                }
                return badness;
            }

            void printPath() {
                if (previousState != null) {
                    previousState.printPath();
                    out.println(fromIndex + " " + length);
                }
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                State state = (State) obj;
                return Arrays.equals(values, state.values);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(values);
            }
        }
    }
}