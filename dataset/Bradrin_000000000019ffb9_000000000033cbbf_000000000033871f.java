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
        public int compare(Node node, Node t1) {
            return Integer.compare(node.distance, t1.distance);
        }
    }

    class ConnectionComparator implements Comparator<Connection> {
        @Override
        public int compare(Connection connection, Connection t1) {
            return Integer.compare(connection.node.distance, t1.node.distance);
        }
    }

    private void solve(Scanner scan) {
        int c = scan.nextInt();
        int d = scan.nextInt();

        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(1, 0));
        for (int i = 2; i <= c; i++) {
            nodes.add(new Node(i, scan.nextInt() * -100));
        }

        List<Connection> connections1 = new ArrayList<>();
        List<Connection> connections2 = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            int x = scan.nextInt()-1;
            int y = scan.nextInt()-1;

            Connection connection = new Connection(i, nodes.get(y));
            Connection connection2 = new Connection(i, nodes.get(x));
            nodes.get(x).connections.add(connection);
            nodes.get(y).connections.add(connection2);
            connections1.add(connection);
            connections2.add(connection2);
        }

        nodes.sort(new NodeComparator());
        Deque<Node> deque = new ArrayDeque<>();

        for (Node n : nodes) {
            n.connections.sort(new ConnectionComparator());
            deque.addLast(n);
        }

        deque.removeFirst();

        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
//            System.out.println("Processing node " + node.num);
            Connection connection = node.connections.get(0);
            Node next = connection.node;
            int cost = node.distance - next.distance;
//            System.out.println("Setting connection id " + connection.id + " (" +  connections2.get(connection.id).node.num +","+connections1.get(connection.id).node.num+") to " + cost);
            connections1.get(connection.id).cost = cost;
            connections2.get(connection.id).cost = cost;
        }

        List<String> results = new ArrayList<>();
        for (Connection connection : connections1) {
            if (connection.cost == 0) {
                connection.cost = 1000000;
            }
            results.add(connection.cost + "");
        }
        System.out.println(String.join(" ", results));
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
