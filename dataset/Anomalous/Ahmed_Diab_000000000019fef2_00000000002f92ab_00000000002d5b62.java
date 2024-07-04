import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            out.printf("Case #%d: ", i);
            int X = sc.nextInt(), Y = sc.nextInt();
            Set<Node> visited = new HashSet<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, 0, null, ""));
            StringBuilder result = new StringBuilder("IMPOSSIBLE");
            
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                if (current.level > 8) continue;
                
                int[] dx = {-1 << current.level, 1 << current.level, 0, 0};
                int[] dy = {0, 0, -1 << current.level, 1 << current.level};
                String[] directions = {"W", "E", "S", "N"};
                
                for (int j = 0; j < 4; j++) {
                    Node next = new Node(current.level + 1, current.x + dx[j], current.y + dy[j], current, directions[j]);
                    
                    if (next.x == X && next.y == Y) {
                        result = new StringBuilder();
                        while (next != null) {
                            result.append(next.direction);
                            next = next.parent;
                        }
                        result.reverse();
                        break;
                    }
                    
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            out.println(result);
        }
        out.flush();
        out.close();
    }

    static class Node {
        int level, x, y;
        String direction;
        Node parent;

        Node(int level, int x, int y, Node parent, String direction) {
            this.level = level;
            this.x = x;
            this.y = y;
            this.parent = parent;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return level == node.level && x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, x, y);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}