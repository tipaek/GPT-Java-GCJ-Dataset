import javax.sound.sampled.Line;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int tc = in.nextInt();
        for(int cc = 1;  cc <= tc; cc++) {

            String s = in.next();
            int n= s.length();

            int[] num = new int[n];

            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                num[i] = s.charAt(i)-'0';
                ArrayList<Integer> lis = map.getOrDefault(num[i],new ArrayList<>());
                lis.add(i);
                map.put(num[i],lis);
            }

            int[] freq = Arrays.copyOf(num,num.length);

            int[] before = new int[n];
            int[] after = new int[n];

            for(int i = 1; i <= 9; i++) {
                boolean[] vis = new boolean[n];
                for(int m : map.getOrDefault(i,new ArrayList<>())) {
                    if(vis[m])
                        continue;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(m);
                    int l = m;
                    int r = m;
                    ArrayList<Integer> pos = new ArrayList<>();
                    while(!q.isEmpty()) {
                        int at = q.poll();
                        if(vis[at] || at < 0 || at >= n)
                            continue;
                        vis[at] = true;
                        l = Math.min(l,at);
                        r = Math.max(r,at);
                        pos.add(at);
                        if(at+1<n && !vis[at+1] && num[at+1] >= i)
                            q.add(at+1);
                        if(at-1 >= 0 && !vis[at-1] && num[at-1] >= i)
                            q.add(at-1);
                    }
                    while(freq[m] != 0) {
                        for(int ind : pos) {
                            freq[ind]--;
                        }
                        before[l]++;
                        after[r]++;
                    }

                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < before[i]; j++) {
                    sb.append("(");
                }
                sb.append(num[i]);
                for(int j = 0; j < after[i]; j++)
                    sb.append(")");
            }

            System.out.printf("Case #%d: %s%n",cc,sb.toString());
        }

    }



    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars ;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }

}

