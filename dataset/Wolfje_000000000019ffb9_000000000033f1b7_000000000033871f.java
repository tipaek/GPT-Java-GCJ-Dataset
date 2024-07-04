import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        for ( int t = 1; t <= tests; t++) {
            solve(in, t);
//            System.out.printf("Case #%d: %d\n", t, result);
        }
    }

    private void solve(Scanner in, int testcase) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] latency = new int[n];
        Arrays.fill(latency, 1000000000);
        PriorityQueue<Pair> fixed = new PriorityQueue<>();
        PriorityQueue<Pair> order = new PriorityQueue<>();
        latency[0] = 0;
        for ( int i = 0; i < n-1; i++) {
            int x = in.nextInt();
            if ( x > 0 ) {
                latency[i+1] = x;
                fixed.add(new Pair(i+1, x));
            } else {
                order.add(new Pair(i+1, -x));
            }
        }
        Edge[] edges = new Edge[k];
        for ( int i = 0; i < k; i++) {
            edges[i] = new Edge(in.nextInt()-1, in.nextInt()-1);

        }
        int placed = 1;
        boolean[] done = new boolean[n];
        boolean[] check = new boolean[n];
        done[0] = true;
        Vector<Integer> todo = new Vector<>();
        int prevTarget = 0;
        while ( placed < n ) {
            todo.clear();
            // pick all placed == o.value
            while ( !order.isEmpty() && order.peek().value == placed ) {
                Pair o = order.poll();
                todo.add(o.index);
//                System.out.println("pick vertex " + o.index);
            }
            int target = 0;
            if ( !fixed.isEmpty() && (order.isEmpty() || placed + todo.size() < order.peek().value )) {
                // add all fixed latency
                target = fixed.peek().value;
                while ( !fixed.isEmpty() && fixed.peek().value == target ) {
                    Pair o = fixed.poll();
                    todo.add(o.index);
//                    System.out.println("pick lat vertex " + o.index);
                }
            }
            Arrays.fill(check, false);
            for ( Integer a: todo ) check[a] = true;
            Vector<Edge> tmp = new Vector<>();
            for (Edge e: edges) {
                if ( done[e.u] && check[e.v] ) {
                    if ( latency[e.u] + 1 > target) target = latency[e.u] + 1;
                } else if ( done[e.v] && check[e.u] ) {
                    if ( latency[e.v] + 1 > target) target = latency[e.v] + 1;
                }
            }
            if ( target == prevTarget ) target++;
//            System.out.println("target lat = " + target);
            for (Edge e: edges) {
                if ( done[e.u] && check[e.v] ) {
                    e.cost = target - latency[e.u];
                } else if ( done[e.v] && check[e.u] ) {
                    e.cost = target - latency[e.v];
                }
            }
            for ( Integer a: todo ) {
                latency[a] = target;
                done[a] = true;
            }
            placed += todo.size();
            prevTarget = target;
        }
        System.out.printf("Case #%d:", testcase);
        for ( Edge e: edges ) System.out.printf(" %d", e.cost);
        System.out.println();
    }

    class Pair implements Comparable<Pair> {
        int index, value;
        public Pair(int i, int v) {
            index = i;
            value = v;
        }

        @Override
        public int compareTo(Pair o) {
            return value - o.value;
        }
    }
    class Edge {
        int u, v;
        int cost = 1000000;
        public Edge(int a, int b) {
            u = a;
            v = b;
        }
    }

}
