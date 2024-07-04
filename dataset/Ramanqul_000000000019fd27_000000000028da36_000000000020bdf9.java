import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    private static boolean intersects(Node o1, Node o2) {
        return !(o1.end <= o2.start || o2.end <= o1.start);
    }

    private static class Node {
        public final int start;
        public final int end;
        public final int index;
        public String owner;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node(" + start + ", " + end + ")";
        }

    }
    private static String toString(List<Node> steps) {
        if (steps == null) {
            return "IMPOSSIBLE";
        }

        return steps.stream().sorted((o1, o2) -> o1.index - o2.index).map(n -> n.owner).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();


        for (int i = 1; i <= t; ++i) {
            int m = in.nextInt();
            in.nextLine();

            List<Node> nodes = new ArrayList<>();

            for (int j=0;j<m;j++) {
                int s = in.nextInt();
                int e = in.nextInt();

                nodes.add(new Node(s, e, j));
            }

            Collections.sort(nodes, (o1, o2) -> {
                if (o1 == null) {
                    return -1;
                } else if (o2 == null) {
                    return 1;
                }

                int c1 = o1.start-o2.start;
                int c2 = o2.end - o1.end;

                if (c1 == 0) {
                    return c2;
                }

                return c1;
            });

            List<Node> steps = new ArrayList<>();
            Node prevC = null, prevJ = null;

            for (Node n: nodes) {
                if (prevC == null || !intersects(prevC, n)) {
                    n.owner = "C";
                    steps.add(n);
                    prevC = n;
                } else if (prevJ == null || !intersects(prevJ, n)) {
                    n.owner = "J";
                    steps.add(n);
                    prevJ = n;
                } else {
                    steps = null;
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", i, toString(steps));
        }
    }
}