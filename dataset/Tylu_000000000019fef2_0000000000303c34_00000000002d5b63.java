import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static int A;
    static int B;
    static int S = 1_000_000;
    static String HIT = "HIT";
    static String MISS = "MISS";
    static String CENTER = "CENTER";

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int numberOfCases = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        int R = A;

        for (int caze = 1; caze <= numberOfCases; caze++) {
            int initX, initY;
            if (!ask(out, sc, S / 2, -S / 2).equals(MISS)) {
                initX = S / 2;
                initY = -S / 2;
            } else if (!ask(out, sc, S / 2, S / 2).equals(MISS)) {
                initX = S / 2;
                initY = S / 2;
            } else if (!ask(out, sc, -S / 2, -S / 2).equals(MISS)) {
                initX = -S / 2;
                initY = -S / 2;
            } else if (!ask(out, sc, -S / 2, S / 2).equals(MISS)) {
                initX = -S / 2;
                initY = S / 2;
            } else {
                initX = 0;
                initY = 0;
            }

            int limitY = initY;
            int dicoSize = R;

            while (dicoSize != 1) {
                String ask = ask(out, sc, initX, limitY + dicoSize);
                if (ask.equals(MISS)) {
                } else {
                    limitY = limitY + dicoSize;
                }
                dicoSize = (int) Math.ceil((double) dicoSize / 2);
                ;
            }

            int limitY2 = initY;
            int dicoSize2 = R;

            while (dicoSize2 != 1) {
                String ask = ask(out, sc, initX, limitY2 - dicoSize2);
                if (ask.equals(MISS)) {
                } else {
                    limitY2 = limitY2 - dicoSize2;
                }
                dicoSize2 = (int) Math.ceil((double) dicoSize2 / 2);
            }

            int h = (limitY + limitY2) / 2;
            int l = (int) Math.round(Math.sqrt(R * R + h * h));

            int rep = rep(sc, out, initX, h, l);
            if (rep == 1) {
                throw new RuntimeException("WRONG");
            }

        }
    }

    private static int rep(MyScanner sc, PrintWriter out, int initX, int h, int l) {
        String ask = ask(out, sc, initX + l, h);
        if (ask.equals(CENTER)) {
            return 0;
        } else if (ask.equals(MISS)) {
            String ask2 = ask(out, sc, initX - l, h);
            if (ask2.equals(CENTER)) {
                return 0;
            }
        }
        return 1;
    }

    private static String ask(PrintWriter out, MyScanner sc, int x, int y) {
        out.println(x + " " + y);
        out.flush();

        String next = sc.next();
//        if (next.equals("WRONG")) throw new RuntimeException("WRONG");
        return next;
    }


    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
