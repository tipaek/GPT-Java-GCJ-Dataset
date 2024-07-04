import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static int A;
    static int B;
    static int S = 1_000_000_000;
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
            if (ask(out, sc, S / 2, -S / 2).equals(HIT)) {
                initX = S / 2;
                initY = -S / 2;
            } else if (ask(out, sc, S / 2, S / 2).equals(HIT)) {
                initX = S / 2;
                initY = S / 2;
            } else if (ask(out, sc, -S / 2, -S / 2).equals(HIT)) {
                initX = -S / 2;
                initY = -S / 2;
            } else if (ask(out, sc, -S / 2, S / 2).equals(HIT)) {
                initX = -S / 2;
                initY = S / 2;
            } else {
                initX = 0;
                initY = 0;
            }

            int limitY = initY + R;
            boolean search = true;
            int dicoSize = R;

            while (search) {
                if (dicoSize == 1) {
                    search = false;
                }
                String ask = ask(out, sc, initX, limitY);
                if (ask.equals(MISS)) {
                    dicoSize = dicoSize / 2;
                } else if (ask.equals(HIT)) {
                    limitY = limitY + dicoSize;
                    dicoSize = dicoSize / 2;
                }

            }

            int limitY2 = initY - R;
            boolean search2 = true;
            int dicoSize2 = R;

            while (search2) {
                if (dicoSize2 == 1) {
                    search2 = false;
                }

                String ask = ask(out, sc, initX, limitY2);
                if (ask.equals(MISS)) {
                    dicoSize2 = dicoSize2 / 2;
                } else if (ask.equals(HIT)) {
                    limitY2 = limitY2 + dicoSize2;
                    dicoSize2 = dicoSize2 / 2;
                }

            }

            int h = (limitY + limitY2) / 2;
            int l = (int) Math.round(Math.sqrt(R * R + h * h));

            String ask = ask(out, sc, h, l + initX);
            if (ask.equals(CENTER)) {

            } else if (ask.equals(MISS)) {
                String ask2 = ask(out, sc, h, initX - l);
//                if (ask2.equals(CENTER)) {
//
//                }
            }
        }
    }

    private static String ask(PrintWriter out, MyScanner sc, int x, int y) {
        out.println(x + " " + y);
        out.flush();
        return sc.next();
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
