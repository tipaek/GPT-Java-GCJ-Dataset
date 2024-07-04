import java.util.*;

public class Solution {
    class Node {
        Position p;
        Node prev;
        char lastDir;

        public Node(Position p, Node prev, char lastDir) {
            this.p = p;
            this.prev = prev;
            this.lastDir = lastDir;
        }
    }
    class Position {
        int x;
        int y;
        int jumpSize;

        public Position(int x, int y, int jumpSize) {
            this.x = x;
            this.y = y;
            this.jumpSize = jumpSize;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position node = (Position) o;
            return x == node.x &&
                    y == node.y &&
                    jumpSize == node.jumpSize;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, jumpSize);
        }
    }

    public String jump(int goalX, int goalY) {
        Set<Position> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(new Position(0, 0, 1), null, 'X'));
        visited.add(new Position(0,0, 1));

        while (!queue.isEmpty()) {
            Node curr = queue.pop();

            if (curr.p.x == goalX && curr.p.y == goalY) {
                return getPath(curr);
            }

            List<Node> children = getChildren(curr);
            for (Node child : children) {
                if (!visited.contains(child.p) && viable(child, goalX, goalY)) {
                    queue.add(child);
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private boolean viable(Node curr, int goalX, int goalY) {
        return (curr.p.x - goalX) % curr.p.jumpSize == 0
                && (curr.p.y - goalY) % curr.p.jumpSize == 0;
    }

    private String getPath(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node.prev != null) {
            sb.append(node.lastDir);
            node = node.prev;
        }
        return sb.reverse().toString();
    }

    private List<Node> getChildren(Node curr) {
        List<Node> children = new ArrayList<>();
        children.add(new Node(new Position(curr.p.x + curr.p.jumpSize, curr.p.y, curr.p.jumpSize * 2), curr, 'E'));
        children.add(new Node(new Position(curr.p.x - curr.p.jumpSize, curr.p.y, curr.p.jumpSize * 2), curr, 'W'));
        children.add(new Node(new Position(curr.p.x, curr.p.y + curr.p.jumpSize, curr.p.jumpSize * 2), curr, 'N'));
        children.add(new Node(new Position(curr.p.x, curr.p.y - curr.p.jumpSize, curr.p.jumpSize * 2), curr, 'S'));
        return children;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();

        int tests = sc.nextInt();
        for (int test = 1; test <= tests; test++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(String.format("Case #%s: %s", test, s.jump(x, y)));
        }
    }
}
