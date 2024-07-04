import java.util.*;

public class Solution {

    public static void solve(int t, int N, int[][] schedule) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> next = new LinkedList<>();
        next.offer('C');
        next.offer('J');

        Map<Integer, Character> assignments = new HashMap<>();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < schedule.length; i++) {
            nodes.add(new Node(i, schedule[i][0], true));
            nodes.add(new Node(i, schedule[i][1], false));
        }

        nodes.sort((n1, n2) -> {
            if (n1.t != n2.t) return n1.t - n2.t;
            return (n1.starts ? 1 : 0) - (n2.starts ? 1 : 0);
        });

        for (Node node: nodes) {
            if (node.starts) {
                if (next.isEmpty()) {
                    printTestCase(t, "IMPOSSIBLE"); // all busy
                    return;
                }

                Character c = next.poll();
                assignments.put(node.id, c);
            } else {
                next.offer(assignments.get(node.id));
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(assignments.get(i));
        }
        printTestCase(t, sb.toString());
    }

    public static void printTestCase(int t, String solution) {
        System.out.println(String.format("Case #%d: %s", t + 1, solution));

    }

    public static class Node {
        int id;
        int t;
        boolean starts;

        public Node(int id, int t, boolean starts) {
            this.id = id;
            this.t = t;
            this.starts = starts;
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                int[][] schedule = new int[N][2];
                for (int i = 0; i < N; i++) {
                    schedule[i][0] = sc.nextInt();
                    schedule[i][1] = sc.nextInt();
                }
                solve(t, N, schedule);
            }
        }
    }
}
