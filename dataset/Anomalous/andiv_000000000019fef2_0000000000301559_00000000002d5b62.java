import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        scanner.nextLine(); // consume the newline after the integer input

        for (int i = 1; i <= totalTests; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // consume the newline after the integer inputs
            String result = solve(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solve(int x, int y) {
        final String IMPOSSIBLE = "IMPOSSIBLE";
        long sum = Math.abs(x) + Math.abs(y);

        // If the sum of x and y is even, it's impossible to reach the target
        if (sum % 2 == 0) return IMPOSSIBLE;

        Queue<Position> queue = new LinkedList<>();
        Set<Position> visited = new HashSet<>();

        Position start = new Position(0, 0, 1, "");
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.x == x && pos.y == y) return pos.path.toString();
            if (pos.jump > sum * 2) continue;

            long nextJump = (pos.jump == 1) ? 2 : pos.jump * 2;
            List<Position> nextPositions = Arrays.asList(
                new Position(pos.x - pos.jump, pos.y, nextJump, pos.path + "W"),
                new Position(pos.x + pos.jump, pos.y, nextJump, pos.path + "E"),
                new Position(pos.x, pos.y + pos.jump, nextJump, pos.path + "N"),
                new Position(pos.x, pos.y - pos.jump, nextJump, pos.path + "S")
            );

            for (Position nextPos : nextPositions) {
                if (!visited.contains(nextPos)) {
                    queue.offer(nextPos);
                    visited.add(nextPos);
                }
            }
        }

        return IMPOSSIBLE;
    }
}

class Position {
    long x, y, jump;
    String path;

    Position(long x, long y, long jump, String path) {
        this.x = x;
        this.y = y;
        this.jump = jump;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}