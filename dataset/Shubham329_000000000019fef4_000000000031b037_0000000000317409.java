import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            sb.append("Case #").append(t + 1).append(": ");

            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.next();

            int x = 0;
            int y = 0;
            Queue<Node> store = new LinkedList<>();
            store.add(new Node(x, y, 0));
            boolean flag = false;
            Node n;
            int time = 0;

            for (; time < path.length() && !flag; time++) {
                Queue<Node> tmp = new LinkedList<>();

                int[] moved = move(path.charAt(time), X, Y);
                X = moved[0];
                Y = moved[1];

                while (!store.isEmpty()) {
                    n = store.poll();
                    Node[] nodes = new Node[5];

                    nodes[0] = new Node(n.x, n.y, n.time + 1);
                    nodes[1] = new Node(n.x + 1, n.y, n.time + 1);
                    nodes[2] = new Node(n.x, n.y + 1, n.time + 1);
                    nodes[3] = new Node(n.x - 1, n.y, n.time + 1);
                    nodes[4] = new Node(n.x, n.y - 1, n.time + 1);

                    for (int j = 0; j < 5; j++) {
                        if (!reached(nodes[j], X, Y))
                            tmp.add(nodes[j]);
                        else {
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

    private static int[] move(char direction, int x, int y) {
        if (direction == 'N')
            return new int[]{x, y + 1};
        else if (direction == 'S')
            return new int[]{x, y - 1};
        else if (direction == 'E')
            return new int[]{x + 1, y};
        else
            return new int[]{x - 1, y};
    }

    private static boolean reached(Node n, int x2, int y2) {
        return n.x == x2 && n.y == y2;
    }
}
