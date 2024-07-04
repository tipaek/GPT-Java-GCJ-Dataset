import java.util.*;

public class Solution {

    class Connection {
        int id;
        Node node;
        int cost;

        Connection(int id, Node node) {
            this.id = id;
            this.node = node;
        }
    }

    class Node {
        int num;
        int distance;
        List<Connection> connections = new ArrayList<>();

        Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return Integer.compare(n1.distance, n2.distance);
        }
    }

    class ConnectionComparator implements Comparator<Connection> {
        @Override
        public int compare(Connection c1, Connection c2) {
            return Integer.compare(c1.node.distance, c2.node.distance);
        }
    }

    private void solve(Scanner scanner) {
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1, 0));
        for (int i = 2; i <= c; i++) {
            nodes.add(new Node(i, scanner.nextInt() * -100));
        }

        List<Connection> connections1 = new ArrayList<>();
        List<Connection> connections2 = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            Connection conn1 = new Connection(i, nodes.get(y));
            Connection conn2 = new Connection(i, nodes.get(x));
            nodes.get(x).connections.add(conn1);
            nodes.get(y).connections.add(conn2);
            connections1.add(conn1);
            connections2.add(conn2);
        }

        nodes.sort(new NodeComparator());
        Deque<Node> deque = new ArrayDeque<>(nodes);
        deque.removeFirst();

        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            Connection connection = node.connections.get(0);
            Node nextNode = connection.node;
            int cost = node.distance - nextNode.distance;
            connections1.get(connection.id).cost = cost;
            connections2.get(connection.id).cost = cost;
        }

        List<String> results = new ArrayList<>();
        for (Connection connection : connections1) {
            if (connection.cost == 0) {
                connection.cost = 1000000;
            }
            results.add(String.valueOf(connection.cost));
        }
        System.out.println(String.join(" ", results));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problems = scanner.nextInt();
        for (int i = 0; i < problems; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}