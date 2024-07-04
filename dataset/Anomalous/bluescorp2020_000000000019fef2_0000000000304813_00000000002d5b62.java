import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static void solve(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        Position start = new Position(0, 0, 1, "");
        Position end = new Position(y, x, 0, "");

        queue.add(start);
        int jump = 1;
        while (true) {
            Position current = queue.remove();
            jump = current.jump;
            if (jump > 256) {
                break;
            }
            if (current.x == end.x && current.y == end.y) {
                end.path = current.path;
                end.jump = jump;
                break;
            }
            queue.add(new Position(current.x + jump, current.y, jump << 1, current.path + "N"));
            queue.add(new Position(current.x - jump, current.y, jump << 1, current.path + "S"));
            queue.add(new Position(current.x, current.y + jump, jump << 1, current.path + "E"));
            queue.add(new Position(current.x, current.y - jump, jump << 1, current.path + "W"));
        }
        if (end.jump == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(end.path);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.print("Case #" + t + ": ");
            solve(x, y);
        }
        scanner.close();
    }
}

class Position {
    int x;
    int y;
    int jump;
    String path;

    public Position(int x, int y, int jump, String path) {
        this.x = x;
        this.y = y;
        this.jump = jump;
        this.path = path;
    }

    public Position(int x, int y, int jump) {
        this(x, y, jump, "");
    }

    public Position(Position p) {
        this(p.x, p.y, p.jump, p.path);
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + ", jump=" + jump + ", path=" + path + "]";
    }
}