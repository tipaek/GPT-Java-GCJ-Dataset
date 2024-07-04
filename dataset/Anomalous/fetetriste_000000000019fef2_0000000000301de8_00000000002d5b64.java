import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        JoinTheRanks solver = new JoinTheRanks();
        solver.solve(1, in, out);
        out.close();
    }

    static class JoinTheRanks {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int r = in.nextInt();
                int s = in.nextInt();
                out.printf("Case #%d: ", test);
                solve(out, r, s);
            }
        }

        private void solve(PrintWriter out, int r, int s) {
            int[] initial = new int[r * s];
            int[] target = new int[r * s];
            for (int i = 0; i < initial.length; i++) {
                initial[i] = i % r;
                target[i] = i / s;
            }
            State startState = new State(initial);
            State targetState = new State(target);
            Map<State, Integer> distanceMap = new HashMap<>();
            Map<State, int[]> moveMap = new HashMap<>();
            List<State> queue = new ArrayList<>();
            queue.add(startState);
            distanceMap.put(startState, 0);

            for (int i = 0; i < queue.size(); i++) {
                State currentState = queue.get(i);
                if (currentState.equals(targetState)) break;
                int currentDistance = distanceMap.get(currentState);

                for (int x = 1; x < r * s; x++) {
                    for (int y = 1; x + y <= r * s; y++) {
                        State nextState = currentState.move(x, y);
                        if (!distanceMap.containsKey(nextState)) {
                            queue.add(nextState);
                            distanceMap.put(nextState, currentDistance + 1);
                            moveMap.put(nextState, new int[]{x, y});
                        }
                    }
                }
            }

            State currentState = targetState;
            List<String> moves = new ArrayList<>();
            while (!currentState.equals(startState)) {
                int[] move = moveMap.get(currentState);
                moves.add(move[0] + " " + move[1]);
                currentState = currentState.move(move[1], move[0]);
            }

            Collections.reverse(moves);
            out.println(moves.size());
            for (String move : moves) {
                out.println(move);
            }
        }

        class State {
            int[] array;

            State(int[] array) {
                this.array = array;
            }

            State move(int x, int y) {
                int[] newArray = array.clone();
                System.arraycopy(array, x, newArray, 0, y);
                System.arraycopy(array, 0, newArray, y, x);
                return new State(newArray);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(array);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                State state = (State) obj;
                return Arrays.equals(array, state.array);
            }
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}