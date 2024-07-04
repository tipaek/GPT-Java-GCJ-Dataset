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
        int order;
        List<Connection> connections = new ArrayList<>();

        Node(int num, int distance, int order) {
            this.num = num;
            this.distance = distance;
            this.order = order;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.distance, node2.distance);
        }
    }

    class OrderComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.order, node2.order);
        }
    }

    class ConnectionComparator implements Comparator<Connection> {
        @Override
        public int compare(Connection conn1, Connection conn2) {
            return Integer.compare(conn1.node.distance, conn2.node.distance);
        }
    }

    private void solve(Scanner scan) {
        int c = scan.nextInt();
        int d = scan.nextInt();

        List<Node> nodes = new ArrayList<>();
        List<Node> distanceNodes = new ArrayList<>();
        List<Node> orderNodes = new ArrayList<>();

        Node source = new Node(1, 0, 0);
        nodes.add(source);
        distanceNodes.add(source);
        for (int i = 2; i <= c; i++) {
            int val = scan.nextInt();
            if (val > 0) {
                Node n = new Node(i, val, -1);
                nodes.add(n);
                distanceNodes.add(n);
            } else {
                Node n = new Node(i, -1, -val);
                nodes.add(n);
                orderNodes.add(n);
            }
        }

        distanceNodes.sort(new NodeComparator());
        orderNodes.sort(new OrderComparator());

        for (Node n : orderNodes) {
            if (n.order >= distanceNodes.size()) {
                n.distance = distanceNodes.get(distanceNodes.size() - 1).distance + 100;
                distanceNodes.add(n);
            } else {
                Node distanceNode = distanceNodes.get(n.order);
                if (distanceNode.order == n.order) {
                    n.distance = distanceNodes.get(n.order).distance;
                } else {
                    n.distance = distanceNodes.get(n.order).distance - 1;
                }
                distanceNodes.add(n.order, n);
            }
        }

        List<Connection> connections1 = new ArrayList<>();
        List<Connection> connections2 = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;

            Connection connection1 = new Connection(i, nodes.get(y));
            Connection connection2 = new Connection(i, nodes.get(x));
            nodes.get(x).connections.add(connection1);
            nodes.get(y).connections.add(connection2);
            connections1.add(connection1);
            connections2.add(connection2);
        }

        Deque<Node> deque = new ArrayDeque<>(nodes);
        deque.removeFirst();

        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            Connection connection = node.connections.get(0);
            Node next = connection.node;
            int cost = node.distance - next.distance;
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
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count + 1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}