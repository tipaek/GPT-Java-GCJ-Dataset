import java.util.*;
import java.io.*;

public class Solution {
    static class EdgeList extends ArrayList<Edge>{}
    static class Edge {
        int u, v, cost;
        Edge(int _u, int _v) {
            u = _u;
            v = _v;
            cost = 1000000;
        }
        int other(int x) {
            if (x == u) return v;
            return u;
        }
    }
    static class Pair implements Comparable<Pair> {
        int prev;
        Edge e;
        int cost;
        Pair(int _prev, Edge _e, int _cost) {
            prev = _prev;
            e = _e;
            cost = _cost;
        }
        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }
    static class Graph {
        EdgeList[] el;
        int[] nums;
        int n;
        Graph(int n) {
            this.n = n;
            el = new EdgeList[n];
            nums = new int[n];
            for (int i = 0; i < n; i++) el[i] = new EdgeList();
        }
        void setnum(int i, int num) {
            nums[i] = num;
        }
        void edge(Edge e) {
            el[e.u].add(e);
            el[e.v].add(e);
        }
        void sol() {
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            for (Edge e : el[0]) {
                pq.add(new Pair(0, e, nums[e.other(0)]));
            }
            while (pq.size() != 0) {
                Pair p = pq.poll();
                int v = p.e.other(p.prev);
                if (visited[v]) {
                    p.e.cost = 1000000;
                    continue;
                }
                int cost = nums[v] - nums[p.prev];
                if (cost == 0) continue;
                visited[v] = true;
                p.e.cost = cost;
                for (Edge e : el[v]) {
                    int other = e.other(v);
                    if (!visited[other]) {
                        pq.add(new Pair(v, e, nums[other]));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int kei = 1; kei <= t; kei++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            Edge[] earr = new Edge[d];
            Graph g = new Graph(c);
            for (int i = 1; i < c; i++) {
                g.setnum(i, -sc.nextInt());
            }
            for (int i = 0; i < d; i++) {
                earr[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1);
                g.edge(earr[i]);
            }
            g.sol();
            System.out.printf("Case #%d: %d", kei, earr[0].cost);
            for (int i = 1; i < d; i++) System.out.print(" " + earr[i].cost);
            System.out.println();
        }
    }
}