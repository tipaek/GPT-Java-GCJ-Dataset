import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();  // Consume the newline character
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    public static String findPath(int toX, int toY) {
        Set<Node> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1, ""));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int currX = current.x;
            int currY = current.y;
            int power = current.power;
            String path = current.path;

            if (currX == toX && currY == toY) {
                return path;
            }

            if (!visited.add(new Node(currX, currY))) {
                continue;
            }

            int step = (int) Math.pow(2, power - 1);
            queue.add(new State(currX + step, currY, power + 1, path + "E"));
            queue.add(new State(currX - step, currY, power + 1, path + "W"));
            queue.add(new State(currX, currY + step, power + 1, path + "N"));
            queue.add(new State(currX, currY - step, power + 1, path + "S"));
        }

        return "IMPOSSIBLE";
    }

    static class State {
        int x, y, power;
        String path;

        State(int x, int y, int power, String path) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.path = path;
        }
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node other = (Node) obj;
            return x == other.x && y == other.y;
        }
    }
}