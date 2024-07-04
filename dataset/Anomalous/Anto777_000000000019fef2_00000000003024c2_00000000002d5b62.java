import java.io.*;
import java.util.*;
import java.math.BigInteger;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private HashMap<Pair, Pair> pars;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch(Exception | Error ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws Exception {
        int t = ni();
        HashMap<Pair, Node> map = formGraph();
        for(int I = 1; I <= t; I++) {
            long x = nl(), y = nl();
            if(map.containsKey(new Pair(x, y, 0))) {
                pl("Case #" + I + ": " + getDirections(getPath(x, y)));
            } else {
                pl("Case #" + I + ": IMPOSSIBLE");
            }
        }
    }

    private String getDirections(List<Pair> path) {
        StringBuilder res = new StringBuilder(path.size());
        for(int i = 1; i < path.size(); i++) {
            Pair back = path.get(i - 1);
            Pair front = path.get(i);
            if(back.x < front.x) {
                res.append("W");
            } else if(back.x > front.x) {
                res.append("E");
            } else if(back.y < front.y) {
                res.append("N");
            } else {
                res.append("S");
            }
        }
        return res.toString();
    }

    private List<Pair> getPath(long x, long y) {
        List<Pair> ret = new ArrayList<>();
        Pair pair = new Pair(x, y, 0);
        while(true) {
            ret.add(pair);
            if(pair.x == 0 && pair.y == 0) break;
            pair = pars.get(pair);
        }
        return ret;
    }

    private HashMap<Pair, Node> formGraph() {
        int limit = 260;
        pars = new HashMap<>();
        HashMap<Pair, Node> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();
        queue.add(new Pair(0, 0, 1));
        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            if(visited.contains(cur) || Math.abs(cur.x) > limit || Math.abs(cur.y) > limit) continue;
            visited.add(cur);
            map.put(cur, new Node());

            addNeighbor(queue, cur, cur.x + cur.level, cur.y);
            addNeighbor(queue, cur, cur.x - cur.level, cur.y);
            addNeighbor(queue, cur, cur.x, cur.y + cur.level);
            addNeighbor(queue, cur, cur.x, cur.y - cur.level);
        }
        return map;
    }

    private void addNeighbor(Queue<Pair> queue, Pair cur, long x, long y) {
        Pair neighbor = new Pair(x, y, cur.level << 1);
        queue.add(neighbor);
        pars.putIfAbsent(neighbor, cur);
    }

    private class Node {
        private HashSet<Pair> adj;

        public Node() {
            adj = new HashSet<>();
        }
    }

    private class Pair {
        long x, y, hcode, level;

        public Pair(long x, long y, long level) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.hcode = Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return (int) hcode;
        }

        @Override
        public String toString() {
            return "[" + x + " " + y + "]";
        }
    }

    private String nextToken() throws Exception {
        while (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private String nt() throws Exception {
        return nextToken();
    }

    private String ns() throws Exception {
        return br.readLine();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    private double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    private void p(Object o) {
        System.out.print(o);
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}