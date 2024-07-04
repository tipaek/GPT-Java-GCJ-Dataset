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
            char[] s = sc.next().toCharArray();
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Character.getNumericValue(s[i]);
            }
            // ab
            // a > b -> (((a))b
            // a <- b -> (((a((b...
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr[0]; i++) {
                sb.append('(');
            }
            sb.append(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    for (int j = 0; j < arr[i] - arr[i - 1]; j++) {
                        sb.append('(');
                    }
                }
                else {
                    for (int j = 0; j < arr[i - 1] - arr[i]; j++) {
                        sb.append(')');
                    }
                }
                sb.append(arr[i]);
            }
            for (int i = 0; i < arr[arr.length - 1]; i++) {
                sb.append(')');
            }

            out.printf("Case #%d: %s\n", testCase++, sb.toString());
        }
        out.close();
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