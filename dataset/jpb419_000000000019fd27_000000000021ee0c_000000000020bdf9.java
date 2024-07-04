import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Pair other) {
        return this.x - other.x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int casenum = 1; casenum <= T; casenum++) {
            int N = in.nextInt();
            PriorityQueue<Pair> tasks = new PriorityQueue(N);
            while (N --> 0) {
                tasks.add(new Pair(in.nextInt(), in.nextInt()));
            }
            int a = -1, b = -1;
            StringBuilder sb = new StringBuilder();
            while (!tasks.isEmpty()) {
                Pair curr = tasks.poll();
                if (a <= curr.x) {
                    a = curr.y;
                    sb.append('C');
                } else if (b <= curr.x) {
                    b = curr.y;
                    sb.append('J');
                } else {
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", casenum, sb);
        }
    }
}
