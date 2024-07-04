import java.io.PrintStream;
import java.util.*;

public class Solution {



        public static void main(String[] args) throws Exception {
            String fileName = "read_e.txt";
            Scanner in = new Scanner(System.in );
//        PrintStream o = new PrintStream(new FileOutputStream(fileName + ".out"));
            PrintStream o = new PrintStream(System.out);
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream("resource/gcj2020/b1/read_e.txt"));
            int cases = in.nextInt();
            for (int i = 0; i<cases; i++ ) {
                o.println(solve(in, i+1));
            }
            in.close();
            o.close();
        }

        private static String solve(Scanner in, int cc) {
            int x = in.nextInt();
            int y = in.nextInt();
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(0,0, null, null, 1));
            Set<Node> visited = new HashSet<>();
            Node found = null;
            while (!q.isEmpty() && found == null) {
                Node node = q.poll();
                Node newNode = createNode (node, 0, 1,"N");
                found = handleNode (newNode, x, y, q, visited);
                if (found == null) {
                    newNode = createNode (node, -1, 0,  "W");
                    found = handleNode (newNode, x, y, q, visited);
                }
                if (found == null) {
                    newNode = createNode (node, 0, -1,"S");
                    found = handleNode (newNode, x, y, q, visited);
                }
                if (found == null) {
                    newNode =createNode (node, 1, 0, "E");
                    found = handleNode (newNode, x, y, q, visited);
                }
            }
            if (found == null) {
                return "Case #" + cc + ": IMPOSSIBLE";
            }
            StringBuffer b = new StringBuffer();
            while (found != null && found.from!=null) {
                b.append(found.direction);
                found = found.from;
            }
            return "Case #" + cc + ": " + b.reverse().toString();
        }

    private static Node handleNode(Node node, int x, int y, Queue<Node> q, Set<Node> visited) {
        if ((x == node.x )&& (y == node.y)) {
            return node;
        }
//        if (visited.contains(node)) {
//            return null;
//        }
        if ((Math.abs(x) +Math.abs(y)) < Math.abs(node.x) + Math.abs(node.y)  ) {
            return null;
        }
        visited.add(node);
        q.offer(node);
        return null;
    }

    private static Node createNode(Node node, int x, int y, String e) {
        return  new Node (node.x + x*node.l , node.y + y*node.l, node, e, node.l*2);
    }

    static class Node{
        final int x;
        final int y;
        final Node from;
        final String direction;
        final int l;


        Node(int x, int y, Node from, String direction, int l) {
            this.x = x;
            this.y = y;
            this.from = from;
            this.direction = direction;
            this.l = l;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }


}
