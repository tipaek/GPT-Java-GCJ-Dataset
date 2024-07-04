import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;
    String path;

    public Pair(int x, int y) {
        this(x, y, "");
    }

    public Pair(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }

    ArrayList<Pair> getChildren() {
        int stepSize = (int) Math.pow(2, path.length());
        ArrayList<Pair> children = new ArrayList<>();

        children.add(new Pair(x + stepSize, y, path + "E"));
        children.add(new Pair(x - stepSize, y, path + "W"));
        children.add(new Pair(x, y + stepSize, path + "N"));
        children.add(new Pair(x, y - stepSize, path + "S"));

        return children;
    }
}

public class Solution {

    static boolean contains(ArrayList<Pair> list, Pair pair) {
        for (Pair p : list) {
            if ((p.x == pair.x && p.y == pair.y) || (p.x == -pair.x && p.y == -pair.y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            String result = "IMPOSSIBLE";
            ArrayList<Pair> visited = new ArrayList<>();
            Queue<Pair> queue = new LinkedList<>();

            queue.add(new Pair(0, 0));
            boolean goalReached = false;

            while (!queue.isEmpty() && !goalReached) {
                Pair current = queue.poll();
                ArrayList<Pair> children = current.getChildren();

                for (Pair child : children) {
                    if (!contains(visited, child) && (Math.abs(child.x) <= Math.abs(targetX) && Math.abs(child.y) <= Math.abs(targetY))) {
                        if (child.x == targetX && child.y == targetY) {
                            result = child.path;
                            goalReached = true;
                            break;
                        } else if (child.x == -targetX && child.y == -targetY) {
                            StringBuilder reversePath = new StringBuilder();
                            for (char direction : child.path.toCharArray()) {
                                switch (direction) {
                                    case 'N':
                                        reversePath.append('S');
                                        break;
                                    case 'E':
                                        reversePath.append('W');
                                        break;
                                    case 'W':
                                        reversePath.append('E');
                                        break;
                                    case 'S':
                                        reversePath.append('N');
                                        break;
                                }
                            }
                            result = reversePath.toString();
                            goalReached = true;
                            break;
                        } else {
                            queue.add(child);
                            visited.add(child);
                        }
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}