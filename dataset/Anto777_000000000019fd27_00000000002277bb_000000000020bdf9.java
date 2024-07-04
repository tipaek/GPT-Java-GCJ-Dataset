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
            int[] intervals = new int[1500];
            int n = ni();
            List<Pair> timeSlots = new ArrayList<>(n);
            for(int i=0; i<n; i++) {
                int from = ni(), to = ni()-1;
                timeSlots.add(new Pair(from, to, i));
                intervals[from]++;
                intervals[to + 1]--;
            }
            for(int i=1; i<intervals.length; i++)
                intervals[i] += intervals[i-1];
            
            boolean impossible = false;
            for(int i=0; i<intervals.length; i++) {
                if(intervals[i] > 2) {
                    impossible = true;
                    break;
                }
            }
            
            if(impossible) {
                pl("Case #" + I + ": IMPOSSIBLE");
            } else {
                Collections.sort(timeSlots);
                
                Stack<Pair> stack = new Stack<>();
                stack.push(timeSlots.get(0));
                for(int i=1; i<n; i++) {
                    Pair cur = timeSlots.get(i);
                    if(overlaps(cur, stack.peek())) {
                        if(cur.to < stack.peek().to) {
                            stack.pop();
                            stack.push(cur);
                        }
                    } else {
                        stack.push(cur);
                    }
                }
                
                HashSet<Integer> cameron = new HashSet<>();
                while(!stack.isEmpty()) {
                    cameron.add(stack.pop().index);
                }
                
                StringBuilder res = new StringBuilder(n + 100);
                for(int i=0; i<n; i++) {
                    if(cameron.contains(i)) {
                        res.append("C");
                    } else {
                        res.append("J");
                    }
                }
                
                pl("Case #" + I + ": " + res.toString());
            }
        }
    }
    
    boolean overlaps(Pair p, Pair q) {
        if(q.from >= p.from && q.from <= p.to) return true;
        if(p.from >= q.from && p.from <= q.to) return true;
        return false;
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