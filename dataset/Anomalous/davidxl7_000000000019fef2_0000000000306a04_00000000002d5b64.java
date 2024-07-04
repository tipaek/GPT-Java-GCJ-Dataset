import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= testCases; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int R = Integer.parseInt(tokenizer.nextToken());
            int S = Integer.parseInt(tokenizer.nextToken());
            System.out.print("Case #" + i + ": ");
            solve(R, S);
        }
    }

    public static void solve(int R, int S) {
        Pair[] initialState = new Pair[R * S];
        int index = 0;

        for (int i = 0; i < S; i++) {
            for (int j = 0; j < R; j++) {
                initialState[index++] = new Pair(j, i);
            }
        }

        int size = R * S;
        LinkedList<State> queue = new LinkedList<>();
        queue.add(new State(R, S, new ArrayList<>(), initialState));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (isSorted(R, S, currentState.situation)) {
                System.out.println(currentState.path.size());
                for (Pair move : currentState.path) {
                    System.out.println(move.a + " " + move.b);
                }
                return;
            }

            for (int a = 1; a < size; a++) {
                for (int b = 1; a + b < size; b++) {
                    ArrayList<Pair> newPath = new ArrayList<>(currentState.path);
                    newPath.add(new Pair(a, b));
                    queue.add(new State(R, S, newPath, swap(a, b, currentState.situation)));
                }
            }
        }
    }

    public static Pair[] swap(int a, int b, Pair[] situation) {
        Pair[] newSituation = new Pair[situation.length];
        int index = 0;

        for (int i = 0; i < b; i++) {
            newSituation[index++] = situation[a + i];
        }
        for (int i = 0; i < a; i++) {
            newSituation[index++] = situation[i];
        }
        for (int i = a + b; i < situation.length; i++) {
            newSituation[index++] = situation[i];
        }

        return newSituation;
    }

    public static boolean isSorted(int R, int S, Pair[] situation) {
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (situation[index].a != i) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }

    static class State {
        int r, s;
        ArrayList<Pair> path;
        Pair[] situation;

        public State(int r, int s, ArrayList<Pair> path, Pair[] situation) {
            this.r = r;
            this.s = s;
            this.path = path;
            this.situation = situation;
        }
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}