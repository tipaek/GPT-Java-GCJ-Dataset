//package solution;

import java.io.*;
import java.util.*;
import java.awt.Point;
import java.math.BigInteger;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception | Error ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    void run() throws Exception {
        int t = ni();
        HashMap<Pair, Node> map = formGraph();
        for(int I=1; I<=t; I++) {
            long x = nl(), y = nl();
            if(map.containsKey(new Pair(x, y, 0))) {
                pl("Case #" + I + ": " + getDIR(getPath(x, y)));
            } else {
                pl("Case #" + I + ": IMPOSSIBLE");
            }
        }
    }
    
    String getDIR(List<Pair> path) {
        StringBuilder res = new StringBuilder(path.size());
        for(int i=1; i<path.size(); i++) {
            Pair back = path.get(i-1);
            Pair front = path.get(i);
            if(back.x < front.x) {
                res.append("W");
            } else if(back.x > front.x) {
                res.append("E");
            } else if(back.y < front.y) {
                res.append("S");
            } else {
                res.append("N");
            }
        }
        return res.reverse().toString();
    }
    
    List<Pair> getPath(long x, long y) {
        List<Pair> ret = new ArrayList<>();
        Pair pair = new Pair(x, y, 0);
        while(true) {
            ret.add(pair);
            if(pair.x == 0 && pair.y == 0) break;
            pair = pars.get(pair);
        }
        //pl(ret);
        return ret;
    }
    
    HashMap<Pair, Pair> pars;
    HashMap<Pair, Node> formGraph() {
        int limit = 300;
        pars = new HashMap<>();
        HashMap<Pair, Node> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();
        queue.add(new Pair(0, 0, 1));
        while(!queue.isEmpty()) {
            Pair cur = queue.remove();
            if(visited.contains(cur)) continue;
            if(cur.x > limit || cur.y > limit) continue;
            if(cur.x < -limit || cur.y < -limit) continue;
            visited.add(cur);
            map.put(cur, new Node());
            
            queue.add(new Pair(cur.x + cur.level, cur.y, cur.level << 1));
            queue.add(new Pair(cur.x - cur.level, cur.y, cur.level << 1));
            queue.add(new Pair(cur.x, cur.y + cur.level, cur.level << 1));
            queue.add(new Pair(cur.x, cur.y - cur.level, cur.level << 1));
            
            map.get(cur).adj.add(new Pair(cur.x + cur.level, cur.y, cur.level << 1));
            map.get(cur).adj.add(new Pair(cur.x - cur.level, cur.y, cur.level << 1));
            map.get(cur).adj.add(new Pair(cur.x, cur.y + cur.level, cur.level << 1));
            map.get(cur).adj.add(new Pair(cur.x, cur.y - cur.level, cur.level << 1));
            
            for(Pair adj : map.get(cur).adj) {
                if(!pars.containsKey(adj)) pars.put(adj, cur);
            }
        }
        
        return map;
    }
    
    class Node {
        HashSet<Pair> adj;
        public Node() {
            adj = new HashSet<>();
        }
    }
    
    class Pair {
        long x, y, hcode, level;
        public Pair (long x, long y, long level) {
            this.x = x;
            this.y = y;
            this.level = level;
            hcode = (x + ", " + y).hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            Pair obj = (Pair) o;
            if(this == obj) return true;
            if(this.x == obj.x && this.y == obj.y) return true;
            return false;
        }
        
        @Override
        public int hashCode() {
            return (int)hcode;
        }
        
        @Override
        public String toString() {
            return "[" + x + " " + y + "]";
        }
    }
    
    //Reader & Writer
    String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    String nt() throws Exception {
        return nextToken();
    }

    String ns() throws Exception {
        return br.readLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    void p(Object o) {
        System.out.print(o);
    }

    void pl(Object o) {
        System.out.println(o);
    }
}