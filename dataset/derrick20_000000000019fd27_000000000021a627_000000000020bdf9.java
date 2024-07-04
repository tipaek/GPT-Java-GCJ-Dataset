/**
 * @author derrick20
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

// REPLACE NAME WITH "Solution"
public class Solution {
    public static void main(String args[]) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = sc.nextInt();
        int testCase = 1;
        while (T-->0) {
            int N = sc.nextInt();
            Interval[] ranges = new Interval[N];
            for (int i = 0; i < N; i++) {
                ranges[i] = new Interval(i, sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(ranges);

            ArrayDeque<Interval> C = new ArrayDeque<>();
            C.add(new Interval(-1, 0, 0));
            ArrayDeque<Interval> J = new ArrayDeque<>();
            J.add(new Interval(-1, 0, 0));

            boolean poss = true;
            for (int i = 0; i < N; i++) {
                if (ranges[i].l >= C.getLast().r) {
                    C.addLast(ranges[i]);
                }
                else if (ranges[i].l >= J.getLast().r) {
                    J.addLast(ranges[i]);
                }
                else {
                    poss = false;
                }
            }
            if (poss) {
                char[] ans = new char[N];
                C.removeFirst();
                J.removeFirst();
                for (Interval range : C) {
                    ans[range.i] = 'C';
                }
                for (Interval range : J) {
                    ans[range.i] = 'J';
                }
                StringBuilder sb = new StringBuilder();
                for (char c : ans) {
                    sb.append(c);
                }
                out.printf("Case #%d: %s\n", testCase++, sb.toString());
            }
            else {
                out.printf("Case #%d: IMPOSSIBLE\n", testCase++);
            }
        }
        out.close();
    }

    static class Interval implements Comparable<Interval> {
        int i, l, r;
        public Interval(int idx, int left, int right) {
            i = idx; l = left; r = right;
        }
        public int compareTo(Interval i2) {
            return l - i2.l != 0 ? l - i2.l : i2.r - r; // earliest start, then by length
        }
    }


    static class FastScanner {
        public int BS = 1<<16;
        public char NC = (char)0;
        byte[] buf = new byte[BS];
        int bId = 0, size = 0;
        char c = NC;
        double cnt = 1;
        BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            }
            catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar(){
            while(bId==size) {
                try {
                    size = in.read(buf);
                }catch(Exception e) {
                    return NC;
                }
                if(size==-1)return NC;
                bId=0;
            }
            return (char)buf[bId++];
        }

        public int nextInt() {
            return (int)nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt=1;
            boolean neg = false;
            if(c==NC)c=getChar();
            for(;(c<'0' || c>'9'); c = getChar()) {
                if(c=='-')neg=true;
            }
            long res = 0;
            for(; c>='0' && c <='9'; c=getChar()) {
                res = (res<<3)+(res<<1)+c-'0';
                cnt*=10;
            }
            return neg?-res:res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c!='.' ? cur:cur+nextLong()/cnt;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c>32) {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c!='\n') {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if(c>32)return true;
            while(true) {
                c=getChar();
                if(c==NC)return false;
                else if(c>32)return true;
            }
        }
    }
}