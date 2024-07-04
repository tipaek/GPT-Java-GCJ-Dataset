import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if (!wasPrevNextLine) scanner.nextLine();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            wasPrevNextLine = true;
            String result = solve(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solve(int x, int y) {
        final String IMPOSSIBLE = "IMPOSSIBLE";

        long sum = Math.abs(x) + Math.abs(y);
        if (sum % 2 == 0) return IMPOSSIBLE;

        StringBuilder result = new StringBuilder();
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1, ""));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.x == x && pos.y == y) return pos.path.toString();
            if (pos.jump > sum * 2) continue;

            long nextJump = (pos.jump == 1) ? 2 : pos.jump * 2;
            queue.offer(new Position(pos.x - pos.jump, pos.y, nextJump, pos.path + "W"));
            queue.offer(new Position(pos.x + pos.jump, pos.y, nextJump, pos.path + "E"));
            queue.offer(new Position(pos.x, pos.y + pos.jump, nextJump, pos.path + "N"));
            queue.offer(new Position(pos.x, pos.y - pos.jump, nextJump, pos.path + "S"));
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
}