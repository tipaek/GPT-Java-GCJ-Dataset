import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static final int INFINITY = 1_000_000;

    static class Edge {
        Node from;
        Node to;
        int weight = INFINITY;

        public Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int X;
        int realX;

        List<Edge> edges = new ArrayList<>();

        public Node(int index, int x) {
            this.index = index;
            X = x;
        }

        @Override
        public int compareTo(Node o) {
            return this.X - o.X;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Node other = (Node) o;
            return this.index == ((Node) o).index;
        }

        @Override
        public int hashCode() {
            return index;
        }

        @Override
        public String toString() {
            return index +" ";
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int C = scanner.nextInt();
            int D = scanner.nextInt();

            Node[] nodes = new Node[C];
            Edge[] edges = new Edge[D];

            nodes[0] = new Node(0, 0);
            for (int i = 1; i < C; i++) {
                nodes[i] = new Node(i, scanner.nextInt());
            }

            for (int i = 0; i < D; i++) {
                int Ui = scanner.nextInt() - 1;
                int Vi = scanner.nextInt() - 1;

                Edge edge = new Edge(nodes[Ui], nodes[Vi]);
                nodes[Ui].edges.add(edge);
                nodes[Vi].edges.add(edge);
                edges[i] = edge;
            }

            List<Node> order = getOrder(nodes);

            while (!order.isEmpty()) {
                Node u = order.remove(0);

                for (Edge edge: u.edges) {
                    Node neighbor = (edge.from.equals(u)) ? edge.to : edge.from;
                    if (!order.contains(neighbor) && neighbor.realX != u.realX) {
                        //do something
                        edge.weight = (neighbor.realX - u.realX) * -1;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + Arrays.stream(edges).map(edge -> String.valueOf(edge.weight)).collect(Collectors.joining(" ")));
        }
    }

    static List<Node> getOrder(Node[] nodes) {
        List<Node> result = new ArrayList<>();

        List<Node> positives = new ArrayList<>();
        List<Node> negatives = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].X >= 0) {
                positives.add(nodes[i]);
            } else {
                negatives.add(nodes[i]);
            }
        }


        Collections.sort(positives);
        negatives.sort(Comparator.reverseOrder());


        while (negatives.size() > 0) {
            while (negatives.get(0).X * - 1 > result.size()) {
                result.add(positives.remove(0));
            }
            Node newNode = negatives.remove(0);
            result.add(newNode);
        }

        result.addAll(positives);

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).X < 0) {
                result.get(i).realX = result.get((result.get(i).X * -1) - 1).realX + 1;
            } else {
                result.get(i).realX = result.get(i).X;
            }
        }


        return result;
    }
}
