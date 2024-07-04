import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Node {
        int v;
        Node n, s, e, w;
        int elim = -1;

        double avg() {
            double sum = 0;
            double count = 0;
            if (n != null) {
                sum += n.v;
                count++;
            }
            if (s != null) {
                sum += s.v;
                count++;
            }
            if (e != null) {
                sum += e.v;
                count++;
            }
            if (w != null) {
                sum += w.v;
                count++;
            }
            return sum / count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            String[] line = sc.nextLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            List<Node> allNode = new ArrayList<>(r * c);
            for (int i = 0; i < r; i++) {
                line = sc.nextLine().split(" ");
                for (int j = 0; j < c; j++) {
                    Node node = new Node();
                    node.v = Integer.parseInt(line[j]);
                    allNode.add(node);
                }
            }
            for (int i = 0; i < r * c; i++) {
                if (i % c != 0) {
                    link(getNode(allNode, i), getNode(allNode, i - 1), c, 'w');
                }
                if (i % c != c - 1) {
                    link(getNode(allNode, i), getNode(allNode, i + 1), c, 'e');
                }
                link(getNode(allNode, i), getNode(allNode, i + c), c, 's');
                link(getNode(allNode, i), getNode(allNode, i - c), c, 'n');
            }


            boolean stop = false;
            long sum = 0;
            int roundNr = 1;
            while (!stop) {
                stop = true;
                for (Node node : allNode) {
                    if (node.elim != -1) {
                        continue;
                    }
                    sum += node.v;
                    double avg = node.avg();
                    if (avg > node.v) {
                        node.elim = roundNr;
                        stop = false;
                    }
                }
                for (Node node : allNode) {
                    if (node.elim == roundNr) {
                        rm(node);
                    }
                }
                roundNr++;
            }


            System.out.println("Case #" + tt + ": " + sum);
        }
    }

    private static void rm(Node node) {
        if (node.s != null) {
            node.s.n = node.n;
        }
        if (node.n != null) {
            node.n.s = node.s;
        }
        if (node.e != null) {
            node.e.w = node.w;
        }
        if (node.w != null) {
            node.w.e = node.e;
        }
    }

    private static void link(Node node, Node second, int c, char type) {
        if (second == null) return;
        switch (type) {
            case 'w':
                node.w = second;
                second.e = node;
                break;
            case 'e':
                node.e = second;
                second.w = node;
                break;
            case 'n':
                node.n = second;
                second.s = node;
                break;
            case 's':
                node.s = second;
                second.n = node;
                break;
        }
    }

    private static Node getNode(List<Node> allNode, int i) {
        if (i >= 0 && i < allNode.size()) {
            return allNode.get(i);
        }
        return null;
    }
}
