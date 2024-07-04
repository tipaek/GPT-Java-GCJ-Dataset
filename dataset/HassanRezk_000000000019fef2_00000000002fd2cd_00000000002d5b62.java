import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    static long MX = 2000000005L;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        String line;
        String[] sp;
        for(int caseI = 1; caseI <= cases; ++caseI) {
            line = in.readLine();
            sp = line.split(" ");
            int x = Integer.parseInt(sp[0]);
            int y = Integer.parseInt(sp[1]);
            Point t = new Point(x, y);
            Point s = new Point(0L, 0L);
            long[] dx = {0L, 0L, 1L, -1L};
            long[] dy = {1L, -1L, 0L, 0L};
            PriorityQueue<PriorityQueueNode> pq = new PriorityQueue<>((n1, n2) -> {
                Point p1 = n1.p;
                Point p2 = n2.p;

                long d1 = t.getSquaeDistance(p1);
                long d2 = t.getSquaeDistance(p2);
                if(d1 < d2) return -1;
                if(d1 > d2) return 1;
                return 0;
            });
            Map<Point, Point> parent = new HashMap<>();
            parent.put(new Point(s), new Point(s));
            pq.add(new PriorityQueueNode(new Point(s), 1L));
            for(int it = 0; it < 20000 && !pq.isEmpty(); ++it) {
                PriorityQueueNode n = pq.poll();
                Point curr = n.p;
                Long cW = n.w;
                if(cW > MX) continue;
                if(curr.equals(t)) {
                    s = t;
                    break;
                }
//                System.out.println(curr);
                for(int k = 0; k < 4; ++k) {
                    Point p = new Point(curr.x + cW * dx[k], curr.y + cW * dy[k]);
                    if(!parent.containsKey(p)) {
                        pq.add(new PriorityQueueNode(p, cW * 2L));
                        parent.put(p, curr);
                    }
                }
            }
//            System.out.println()
            System.out.printf("Case #%d: ", caseI);
            if(s.equals(t)) {
                StringBuilder sb = new StringBuilder();
                final Point o = new Point(0, 0);
                while(!s.equals(o)) {
                    Point p = parent.get(s);
                    if(p.x == s.x) {
                        if(p.y < s.y) sb.append("N");
                        else sb.append("S");
                    } else if(p.y == s.y) {
                        if(p.x < s.x) sb.append("E");
                        else sb.append("W");
                    } else throw new RuntimeException("Not Poossible");
                    s = p;
                }
                System.out.println(sb.reverse().toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class PriorityQueueNode {
        Point p;
        Long w;

        PriorityQueueNode(Point p, Long w) {
            this.p = p;
            this.w = w;
        }
    }

    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

        private long getSquaeDistance(Point p) {
            long diffX = x - p.x;
            long diffY = y - p.y;
            return diffX * diffX + diffY * diffY;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Point)) return false;
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
