import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Map<Character, Integer[]> direction = new HashMap<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        direction.put('N', new Integer[]{0, 1});
        direction.put('S', new Integer[]{0, -1});
        direction.put('E', new Integer[]{1, 0});
        direction.put('W', new Integer[]{-1, 0});

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            sb.append("Case #").append(t + 1).append(": ");

            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.next();

            int x = 0;
            int y = 0;
            Queue<Node> store = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            store.add(new Node(x, y));
            boolean flag = false;
            Node n;
            int time = 0;
            double min;

            for (; time < path.length() && !flag; time++) {
                Queue<Node> tmp = new LinkedList<>();

                X = X + direction.get(path.charAt(time))[0];
                Y = Y + direction.get(path.charAt(time))[1];

                while (!store.isEmpty()) {
                    n = store.poll();
                    Node[] nodes = new Node[5];
                    min = getDistance(new Node(0, 0), X, Y);

                    nodes[0] = new Node(n.x, n.y);
                    nodes[1] = new Node(n.x + 1, n.y);
                    nodes[2] = new Node(n.x, n.y + 1);
                    nodes[3] = new Node(n.x - 1, n.y);
                    nodes[4] = new Node(n.x, n.y - 1);

                    for (int j = 0 ; j < 5 ; j++) {
                        min = Math.min(min, getDistance(nodes[j], X, Y));
                    }

                    for (int j = 0; j < 5; j++) {
                        if (!(nodes[j].x == X && nodes[j].y == Y)) {
                            double distance = getDistance(nodes[j], X, Y);
                            if (!visited.contains(nodes[j].x + " " + nodes[j].y) && distance == min) {
                                tmp.add(nodes[j]);
                                visited.add(nodes[j].x + " " + nodes[j].y);
                            }
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }

                store = tmp;
            }

            if (flag)
                sb.append(time);
            else
                sb.append("IMPOSSIBLE");

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static double getDistance(Node n, int x, int y) {
        return Math.abs(n.y - y) + Math.abs(n.x - x);
    }
}
