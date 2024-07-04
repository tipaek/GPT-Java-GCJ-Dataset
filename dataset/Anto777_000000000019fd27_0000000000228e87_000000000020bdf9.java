//package solution;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.awt.Point;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    long mod = 1000000007L;
    void run() throws Exception {
        int t = ni();
        for(int I=1; I<=t; I++) {
            int n = ni();
            Pair[] pairs = new Pair[n];
            for(int i=0; i<n; i++) {
                pairs[i] = new Pair(ni(), ni(), i);
            }
            Arrays.sort(pairs);
            
            Stack<Pair> cStack = new Stack<>();
            Stack<Pair> jStack = new Stack<>();
            
            cStack.push(pairs[0]);
            boolean impossible = false;
            for(int i=1; i<n; i++) {
                if(overlaps(cStack.peek(), pairs[i]) || overlaps(pairs[i], cStack.peek())) {
                    if(jStack.isEmpty()) {
                        jStack.push(pairs[i]);
                    } else {
                        if(overlaps(jStack.peek(), pairs[i]) || overlaps(pairs[i], jStack.peek())) {
                            impossible = true;
                            break;
                        } else {
                            jStack.push(pairs[i]);
                        }
                    }
                } else {
                    cStack.push(pairs[i]);
                }
            }
            
            if(impossible) {
                pl("Case #" + I + ": IMPOSSIBLE");
            } else {
                //pl(cStack);
                //pl(jStack);
                char[] c = new char[n];
                while(!cStack.isEmpty()) {
                    c[cStack.pop().index] = 'C';
                }
                while(!jStack.isEmpty()) {
                    c[jStack.pop().index] = 'J';
                }
                
                pl("Case #" + I + ": " + new String(c));
            }
        }
    }
    
    boolean overlaps(Pair p, Pair q) {
        if(q.from == p.to) return false;
        return q.from >= p.from && q.from <= p.to;
    }
    
    class Pair implements Comparable<Pair> {
        int from, to, index;
        public Pair(int from, int to, int index) {
            this.from  = from;
            this.to    = to;
            this.index = index;
        }
        @Override
        public int compareTo(Pair pair) {
            if(this.from == pair.from) {
                return this.to - pair.to;
            }
            return this.from - pair.from;
        }
        @Override
        public String toString() {
            return "[" + from + ", " + to + "]";
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