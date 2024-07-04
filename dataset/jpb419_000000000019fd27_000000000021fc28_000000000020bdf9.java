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
        outer:
        for (int casenum = 1; casenum <= T; casenum++) {
            int N = in.nextInt();
            PriorityQueue<Pair> tasks = new PriorityQueue(N);
            List<Pair> originalOrder = new ArrayList<>();
            while (N --> 0) {
                Pair p = new Pair(in.nextInt(), in.nextInt());
                tasks.add(p);
                originalOrder.add(p);
            }
            int a = -1, b = -1;
            HashMap<Pair, Character> map = new HashMap<>();
            while (!tasks.isEmpty()) {
                Pair curr = tasks.poll();
                if (a <= curr.x) {
                    a = curr.y;
                    map.put(curr, 'C');
                } else if (b <= curr.x) {
                    b = curr.y;
                    map.put(curr, 'J');
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", casenum);
                    continue outer;
                }
            }
            System.out.printf("Case #%d: ", casenum);
            for (Pair p : originalOrder) {
                System.out.print(map.get(p));
            }
            System.out.println();
        }
    }
}
