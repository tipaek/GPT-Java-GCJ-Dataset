import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] line = sc.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    public static String findPath(int toX, int toY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, ""));
        int maxSteps = 100000;

        while (!queue.isEmpty() && maxSteps-- > 0) {
            Node current = queue.poll();

            if (current.x == toX && current.y == toY) {
                return current.path;
            }

            int nextPower = current.power + 1;
            queue.add(new Node(current.x + (1 << (current.power - 1)), current.y, nextPower, current.path + "E"));
            queue.add(new Node(current.x - (1 << (current.power - 1)), current.y, nextPower, current.path + "W"));
            queue.add(new Node(current.x, current.y + (1 << (current.power - 1)), nextPower, current.path + "N"));
            queue.add(new Node(current.x, current.y - (1 << (current.power - 1)), nextPower, current.path + "S"));
        }

        return "IMPOSSIBLE";
    }

    public static class Node {
        int x, y, power;
        String path;

        public Node(int x, int y, int power, String path) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.path = path;
        }
    }
}