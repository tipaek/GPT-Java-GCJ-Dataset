import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine().trim());
        
        for (int i = 0; i < testCases; i++) {
            String[] line = sc.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static String findPath(int toX, int toY) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1, ""));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.x == toX && current.y == toY) {
                return current.path;
            }
            if (current.moves > 20) { // Limit the depth to prevent infinite loops
                continue;
            }
            int power = (int) Math.pow(2, current.moves - 1);
            queue.add(new State(current.x + power, current.y, current.moves + 1, current.path + "E"));
            queue.add(new State(current.x - power, current.y, current.moves + 1, current.path + "W"));
            queue.add(new State(current.x, current.y + power, current.moves + 1, current.path + "N"));
            queue.add(new State(current.x, current.y - power, current.moves + 1, current.path + "S"));
        }

        return "IMPOSSIBLE";
    }

    static class State {
        int x, y, moves;
        String path;

        State(int x, int y, int moves, String path) {
            this.x = x;
            this.y = y;
            this.moves = moves;
            this.path = path;
        }
    }
}