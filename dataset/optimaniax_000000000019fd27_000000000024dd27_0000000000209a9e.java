//package CodeJam.Qualification2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {

    static int getibit(int i) {
        out.println(i); out.flush();
        return in.NI();
    }

    static class pair {
        int first; int second;;

        private pair(int first, int second) {
            this.first = first; this.second = second;
        }

        static pair of(int first, int second) {
            return new pair(first, second);
        }
    }
    static List<Integer> present = new ArrayList<>();

    static void reverse() {
        for (int i=1,j=present.size()-1; i<j;i++,j--) {
            int v1 = present.get(i);
            int v2 = present.get(j);
            present.set(j, v1); present.set(i, v2);
        }
    }

    static void flip () {
        for (int i=1;i<present.size();i++) {
            int nv = 1-present.get(i);
            present.set(i, nv);
        }
    }

    static void flipreverse() {
        flip(); reverse();
    }

    public static void main(String[] args) {

        int t = in.NI(); int b = in.NI();
        for (int z=1;z<=t;z++) {

            List<pair> diferent = new ArrayList<>();
            List<pair> same = new ArrayList<>();
            present.clear();

            for (int i=0;i<b+1;i++) present.add(-1);

            for (int i=1,j=b;i<=5;i++,j--) {
                present.set(i, getibit(i)); present.set(j, getibit(j));
                if (!present.get(i).equals(present.get(j))) {
                    diferent.add(pair.of(i,j));
                } else {
                    same.add(pair.of(i,j));
                }
                //out.println(present.subList(1, b+1)); out.flush();
            }

            int qcoun = 11;


            for (int i=6;i<b-4;i++) {

                if (qcoun%10==1) {
                    if (diferent.size()==0) {
                        int bitval = getibit(1); qcoun++;
                        same.forEach(p -> {
                            present.set(p.first, bitval);
                            present.set(p.second, bitval);
                        });
                    } else if (same.size()==0) {
                        int pbit = present.get(1);
                        int nbit = getibit(1); qcoun++;
                        if (pbit == nbit) continue;
                        else flip();
                    } else {
                        int diffindex = diferent.get(0).first;
                        int sameindex = same.get(0).first;

                        int diffpval = present.get(diffindex);
                        int diffnewval = getibit(diffindex);

                        int samepval = present.get(sameindex);
                        int samenewval = getibit(sameindex);

                        boolean diffflip = diffpval != diffnewval;
                        boolean sameflip = samepval != samenewval;

                        qcoun+=2;

                        /*out.println(diffpval + " " + diffnewval);
                        out.println(samepval + " " + samenewval);
                        out.println(diffflip); out.println(sameflip); out.flush();*/

                        if (diffflip && sameflip) {
                            flip();
                        //    out.println("flip"); out.flush();
                        } else if (diffflip && !sameflip) {
                            reverse();
                        //   out.println("rev"); out.flush();
                        } else if (!diffflip && sameflip) {
                            flipreverse();
                        //    out.println("both"); out.flush();
                        } else {
                        //    out.println("nothing"); out.flush();
                        }

                        //out.println(present.subList(1, b+1)); out.flush();
                    }
                }

                present.set(i, getibit(i)); qcoun++;
                //out.println(present.subList(1, b+1)); out.flush();
            }

            for (int i=1;i<=b;i++) out.printf("%d", present.get(i)); out.println(); out.flush();
            String response = in.next();
            if (response.charAt(0) == 'N') {
                break;
            }
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
