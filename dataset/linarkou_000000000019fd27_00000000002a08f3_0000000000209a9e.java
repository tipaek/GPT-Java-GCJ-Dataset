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
            boolean res[][] = new boolean[15][b];
            int counter = 0;
            for (int i = 0; i < 15; ++i) {
                for (int j = 0; j < b; ++j) {
                    if (counter == 150) {
                        break;
                    }
                    System.out.print(j + 1);
                    res[i][j] = in.nextInt() == 1;
                    counter++;
                }
                if (counter == 150) {
                    break;
                }
            }
            int[] cntActions = new int[4];
            for (int i = 1; i < 15; ++i) {
                boolean isBitflip = true;
                boolean isReverse = true;
                boolean isBitFlipAndReverse = true;
                for (int j = 0; j < b; ++j) {
                    if (res[i-1][j] == res[i][j]) {
                        isBitflip = false;
                        break;
                    }
                }
                for (int j = 0; j < b; ++j) {
                    if (!(res[i-1][j] == res[i][b-j-1] && res[i-1][b-j-1] == res[i][j])) {
                        isReverse = false;
                        break;
                    }
                }
                for (int j = 0; j < b; ++j) {
                    if (!(res[i-1][j] == !res[i][b-j-1] && res[i-1][b-j-1] == !res[i][j])) {
                        isBitFlipAndReverse = false;
                        break;
                    }
                }
                if (isBitflip) {
                    cntActions[1]++;
                } else if (isReverse) {
                    cntActions[2]++;
                } else if (isBitFlipAndReverse) {
                    cntActions[3]++;
                } else {
                    cntActions[0]++;
                }
            }
            int min = 1000;
            int minIndex = -1;
            for (int i = 0; i < 4; ++i) {
                if (cntActions[i] < min) {
                    min = cntActions[i];
                    minIndex = i;
                }
            }
            StringBuilder sb = new StringBuilder(b);
            for (int i = 0; i < b; ++i) {
                switch (minIndex) {
                    case 0:
                        sb.append(res[0][i] ? 1 : 0);
                        break;
                    case 1:
                        sb.append(!res[0][i] ? 1 : 0);
                        break;
                    case 2:
                        sb.append(res[0][b - i - 1] ? 1 : 0);
                        break;
                    case 3:
                        sb.append(!res[0][b - i - 1] ? 1 : 0);
                        break;
                }
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
        if (b <= 20) {
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