import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Solution {

    private enum Dir {

        N, S, E, W;

    }

    private static class State {

        private List<Dir> path;
        private int x;
        private int y;
        private int length;

        public State(List<Dir> path, int x, int y, int length) {
            this.path = path;
            this.x = x;
            this.y = y;
            this.length = length;
        }

        public boolean isMatch(int targetX, int targetY) {
            return this.x == targetX && this.y == targetY;
        }

        public int getLength() {
            return length;
        }

        public List<Dir> getPath() {
            return path;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static class Task {

        private final int caseId;
        private final int x;
        private final int y;

        public Task(int caseId, int x, int y) {
            this.caseId = caseId;
            this.x = x;
            this.y = y;
        }

        public void process() {
//            if (!possible()) {
//                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseId));
//                return;
//            }
            Optional<State> solution = solve();
            if (solution.isPresent()) {
                System.out.println(String.format("Case #%d: %s", caseId,
                        solution.get().getPath().stream().map(Dir::toString).collect(joining(""))));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseId));
            }
        }

        private State newState(List<Dir> path, Dir dir, int x, int y, int length) {
            List<Dir> newPath = new ArrayList<>(path);
            newPath.add(dir);
            return new State(newPath, x, y, length);
        }

        private Optional<State> solve() {
            //System.err.println(String.format("=============== SOLVING caseId#%d, %d:%d", caseId, x, y));
            int pow = 0;
            State solution = null;

            LinkedList<State> states = new LinkedList<>();
            states.add(new State(Arrays.asList(), 0, 0, 0));
            while (!states.isEmpty()) {
               //System.err.println(printStates(states));
                State head = states.pop();
                if (head.isMatch(x, y)) {
                    if (solution == null || head.getLength() < solution.getLength()) {
                        solution = head;
                    }
                    continue;
                }

                int jump = (int) Math.pow(2.0, head.length);
                if (Math.abs(head.x) <= Math.abs(x) * Math.abs(x)) {
                    // E
                    states.add(newState(head.path, Dir.E, head.x + jump, head.y, head.length + 1));
                    // W
                    states.add(newState(head.path, Dir.W, head.x - jump, head.y, head.length + 1));
                }
                if (Math.abs(head.y) <= Math.abs(y) * Math.abs(y)) {
                    // N
                    states.add(newState(head.path, Dir.N, head.x, head.y + jump, head.length + 1));
                    // S
                    states.add(newState(head.path, Dir.S, head.x, head.y - jump, head.length + 1));
                }
            }
            return Optional.ofNullable(solution);
        }

        private String printStates(LinkedList<State> states) {
            return states.stream().map(s -> s.x + ":" + s.y).collect(Collectors.joining(", "));
        }

        private boolean possible() {
            int length = Math.abs(x) + Math.abs(y) - 1;
            int value = 0;
            double pow = 1;
            while (value < length) {
                value = (int) Math.pow(2.0, pow);
                pow++;
            }
            return value == length;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int caseId = 1; caseId <= testCount; caseId++) {
            int x = in.nextInt();
            int y = in.nextInt();
           // System.err.println(String.format("Case #%d: %d:%d", caseId, x, y));
            tasks.add(new Task(caseId, x, y));
        }
        tasks.forEach(Task::process);
    }



}
