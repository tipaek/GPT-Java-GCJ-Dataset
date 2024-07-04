//package CodeJam.Qualification2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static class pair {
        int first; int second; int index;

        private pair(int first, int second, int index) {
            this.first = first; this.second = second; this.index = index;
        }

        static pair of(int first, int second, int index) {
            return new pair(first, second, index);
        }
    }

    public static void main(String[] args) {
        int t = in.NI();
        for (int z=1;z<=t;z++) {
            int[] psum = new int[25*60];
            Arrays.fill(psum, 0);

            int coun = in.NI();
            List<pair> pairs = new ArrayList<>();
            for (int i=0;i<coun;i++) pairs.add(pair.of(in.NI(), in.NI()-1, i));

            for (int i=0;i<coun;i++) {
                psum[pairs.get(i).first]++;
                psum[pairs.get(i).second+1]--;
            }

            int maxval = 0;
            for (int i=1;i<psum.length;i++) {
                psum[i]+=psum[i-1];
                maxval = Integer.max(maxval, psum[i]);
            }

            if (maxval>2) {
                out.println("Case #" + z + ": " + "IMPOSSIBLE"); continue;
            }

            Collections.sort(pairs, (o1, o2) -> {
                if (o1.first==o2.first) return Integer.compare(o1.second, o2.second);
                else return Integer.compare(o1.first, o2.first);
            });


            StringBuilder ans = new StringBuilder();
            for (int i=0;i<coun;i++) ans.append('C');
            int maxtime = pairs.get(0).second;
            char lastendchar = 'C';
            for (int i=1;i<coun;i++) {
                int pind = pairs.get(i).index;
                if (pairs.get(i).first <= maxtime) {
                    ans.setCharAt(pind, lastendchar=='C' ? 'J':'C');
                } else {
                    ans.setCharAt(pind, lastendchar);
                }
                if (pairs.get(i).second > maxtime) {
                    maxtime = pairs.get(i).second;
                    lastendchar = ans.charAt(pairs.get(i).index);
                }
                maxtime = Integer.max(maxtime, pairs.get(i).second);
            }
            out.println("Case #" + z + ": " + ans.toString());

        }
        out.close();
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NI() {
            return Integer.parseInt(next());
        }

        public long NL() {
            return Long.parseLong(next());
        }

    }
}
