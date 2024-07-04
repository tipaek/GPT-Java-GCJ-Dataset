import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solveEasy(InputReader in, int t, int b) {
        for (int index = 1; index <= t; ++index) {
            boolean res[] = new boolean[b];
            int i = 0;
            while (i < b) {
                int counter = 0;
                while (counter < 30) {
                    System.out.print(1);
                    in.nextInt();
                    counter++;
                }
                for (; i < b && counter < 40; ++i, counter++) {
                    System.out.print(i+1);
                    res[i] = in.nextInt() == 1;
                }
            }
            StringBuilder sb = new StringBuilder(b);
            for (i = 0; i < b; ++i) {
                sb.append(res[i] ? 1 : 0);
            }
            System.out.println(sb.toString());
            String nextToken = in.next();
            if (nextToken.equals("N")) {
                return;
            }
        }
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int b = in.nextInt();
        if (b <= 30) {
            solveEasy(in, t, b);
            return;
        }
        return;
//        for (int index = 1; index <= t; ++index) {
//            boolean[] res = new boolean[b+1];
//            boolean flip = false;
//            boolean reverse = false;
//            int counter = 0;
//            int indexOfEqual = -1;
//            int indexOfDiff = -1;
//            int i = 1;
//            List<Action> actions = new ArrayList<>();
//            while(true) {
//                if (i% 10 == 1) {
//                    boolean resultEqual = false;
//                    boolean resultDiff = false;
//                    if (indexOfEqual != -1) {
//                        System.out.print(indexOfEqual);
//                        boolean result = in.nextInt() == 1;
//                        resultEqual = result != res[indexOfEqual];
//                        counter++;
//                    }
//                    if (indexOfDiff != -1) {
//                        System.out.print(indexOfDiff);
//                        boolean result = in.nextInt() == 1;
//                        resultDiff = result == res[b-indexOfDiff];
//                        counter++;
//                    }
//                    actions.add(new Action(resultEqual, resultDiff));
//                }
//                System.out.print(i);
//                res[i] = in.nextInt() == 1;
//                counter++;
//                System.out.print(b-i);
//                res[b-i] = in.nextInt() == 1;
//                counter++;
//                if (indexOfEqual == -1 && res[i] == res[b-i]) {
//                    indexOfEqual = i;
//                }
//                if (indexOfDiff == -1 && res[i] != res[b-i]) {
//                    indexOfDiff = i;
//                }
//                i++;
//            }
//        }
    }

    static class Action {
        boolean flip;
        boolean reverse;

        public Action(boolean flip, boolean reverse) {
            this.flip = flip;
            this.reverse = reverse;
        }

        public int getIndex() {
            if (flip) {
                if (!reverse) {
                    return 1;
                } else {
                    return 3;
                }
            } else {
                if (reverse) {
                    return 2;
                } else {
                    return 4;
                }
            }
        }
    }

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}