import java.util.*;

public class B {
    static class EdgeList extends ArrayList<Edge> {}

    static class Edge {
        int u, v, cost;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.cost = -100;
        }

        int other(int x) {
            return x == u ? v : u;
        }
    }

    static class Pair implements Comparable<Pair> {
        int prev;
        Edge e;
        int cost;

        Pair(int prev, Edge e, int cost) {
            this.prev = prev;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class Graph {
        EdgeList[] edgeLists;
        int[] nums;
        int n;

        Graph(int n) {
            this.n = n;
            edgeLists = new EdgeList[n];
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                edgeLists[i] = new EdgeList();
            }
        }

        void setNum(int i, int num) {
            nums[i] = num;
        }

        void addEdge(Edge e) {
            edgeLists[e.u].add(e);
            edgeLists[e.v].add(e);
        }

        void solve() {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;

            for (Edge e : edgeLists[0]) {
                pq.add(new Pair(0, e, nums[e.other(0)]));
            }

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int v = p.e.other(p.prev);

                if (visited[v]) {
                    p.e.cost = 1000000;
                    continue;
                }

                visited[v] = true;
                p.e.cost = nums[v] - nums[p.prev];

                for (Edge e : edgeLists[v]) {
                    int other = e.other(v);
                    if (!visited[other]) {
                        pq.add(new Pair(v, e, nums[other]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int kei = 1; kei <= t; kei++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            Edge[] edges = new Edge[d];
            Graph graph = new Graph(c);

            for (int i = 1; i < c; i++) {
                graph.setNum(i, -sc.nextInt());
            }

            for (int i = 0; i < d; i++) {
                edges[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1);
                graph.addEdge(edges[i]);
            }

            graph.solve();

            System.out.printf("Case #%d: %d", kei, edges[0].cost);
            for (int i = 1; i < d; i++) {
                System.out.print(" " + edges[i].cost);
            }
            System.out.println();
        }
    }
}