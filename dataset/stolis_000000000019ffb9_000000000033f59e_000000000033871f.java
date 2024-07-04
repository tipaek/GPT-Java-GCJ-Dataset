import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Solution {
    static NavigableSet<Node> timeSet;
    static NavigableSet<Node> beforeSet;
    static Node[] nodes;

    static void addNextNodes(Node source) {
        source.finished = true;
        for (Edge edge : source.next) {
            int next = (edge.from == source.id) ? edge.to : edge.from;
            Node node = nodes[next];
            if (!node.finished) {
                if (node.x < 0) {
                    beforeSet.add(node);
                } else {
                    timeSet.add(node);
                }
            }
        }
    }

    static void processNode(Node timeNode) {
        for (Edge edge : timeNode.next) {
            int next = (edge.from == timeNode.id) ? edge.to : edge.from;
            Node nextNode = nodes[next];
            if (nextNode.finished) {
                edge.cost = timeNode.x - nextNode.x;
                break;
            }
        }
        addNextNodes(timeNode);
    }

    static Node processNextTimeNode() {
        Node timeNode = timeSet.pollFirst();
        processNode(timeNode);
        return timeNode;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            int M = in.nextInt();
            nodes = new Node[N];
            Node source = new Node();
            source.id = 0;
            nodes[0] = source;
            for (int n=1; n<N; n++) {
                Node node = new Node();
                node.x = in.nextInt();
                node.id = n;
                nodes[n] = node;
            }
            Edge[] edges = new Edge[M];
            for (int m=0; m<M; m++) {
                int from = in.nextInt()-1;
                int to = in.nextInt()-1;
                Edge edge = new Edge();
                edge.from = from;
                edge.to = to;
                edges[m] = edge;
                nodes[from].next.add(edge);
                nodes[to].next.add(edge);
            }
            timeSet = new TreeSet<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int diff = o1.x - o2.x;
                    return (diff == 0) ? (o1.id - o2.id) : diff;
                }
            });
            beforeSet = new TreeSet<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    int diff = o2.x - o1.x;
                    return (diff == 0) ? (o1.id - o2.id) : diff;
                }
            });
            addNextNodes(source);
            int before = 1;
            int lastTime = 0;
            while (!timeSet.isEmpty() || !beforeSet.isEmpty()) {
                if (beforeSet.isEmpty()) {
                    Node timeNode = processNextTimeNode();
                    lastTime = timeNode.x;
                    before++;
                } else {
                    Node beforeNode = beforeSet.first();
                    while (before < -beforeNode.x) {
                        Node timeNode = processNextTimeNode();
                        lastTime = timeNode.x;
                        before++;                        
                    }
                    lastTime++;
                    int oldBefore = before;
                    while (!beforeSet.isEmpty() && beforeSet.first().x == -oldBefore) {
                        beforeNode = beforeSet.pollFirst();
                        beforeNode.x = lastTime;
                        processNode(beforeNode);
                        before++;
                    }
                }
            }
            StringJoiner sj = new StringJoiner(" ");
            for (Edge edge : edges) {
                sj.add(String.valueOf(edge.cost == 0 ? 1000000 : edge.cost));
            }
            System.out.printf("Case #%d: %s\n", t, sj.toString());
        }
    }

    static class Node {
        int id;
        List<Edge> next = new ArrayList<>();
        int x;
        boolean finished;
    }

    static class Edge {
        int from;
        int to;
        int cost;
    }

}
