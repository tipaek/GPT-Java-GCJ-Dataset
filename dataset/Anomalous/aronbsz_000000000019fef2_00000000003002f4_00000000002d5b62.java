import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();  // consume the remaining newline
        for (int i = 0; i < testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();  // consume the remaining newline
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    public static String findPath(int toX, int toY) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(new Node(0, 0, 1, ""));
        visited.add(new Node(0, 0, 0, ""));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == toX && current.y == toY) {
                return current.path;
            }

            int nextPower = current.power + 1;
            int step = (int) Math.pow(2, current.power - 1);

            Node[] nextNodes = {
                new Node(current.x + step, current.y, nextPower, current.path + "E"),
                new Node(current.x - step, current.y, nextPower, current.path + "W"),
                new Node(current.x, current.y + step, nextPower, current.path + "N"),
                new Node(current.x, current.y - step, nextPower, current.path + "S")
            };

            for (Node nextNode : nextNodes) {
                if (!visited.contains(nextNode)) {
                    queue.add(nextNode);
                    visited.add(nextNode);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static class Node {
        int x, y, power;
        String path;

        Node(int x, int y, int power, String path) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.path = path;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}