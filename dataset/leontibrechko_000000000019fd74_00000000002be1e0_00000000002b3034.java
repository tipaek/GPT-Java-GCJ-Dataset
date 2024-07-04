import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.in = in;

            int n = ni();
            String[] p = new String[n];
            for (int i = 0; i < n; i++) {
                p[i] = next();
            }

            boolean isOk = true;
            StringBuilder res = new StringBuilder();
            int[] pPointer = new int[n];
            int[] lastInRes = new int[n];
            Arrays.fill(pPointer, -1);
            int previousResLenght = res.length();

            ArrayDeque<String>[] subStrings = new ArrayDeque[n];
            for (int i = 0; i < n; i++) {
                subStrings[i] = new ArrayDeque<>();

                for (String sub : p[i].split("\\*")) {
                    subStrings[i].offer(sub);
                }
            }

            out:
            while (true) {
                List<String> subs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (subStrings[i].size() != 0) subs.add(subStrings[i].poll());
                }

                if (subs.size() == 0) break;
                subs.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));

                for (int i = 0; i < subs.size(); i++) {
                    if (i == 0) res.append(subs.get(i));
                    else if (subs.get(i).length() > 0 && res.indexOf(subs.get(i)) < 0) {
                        isOk = false;
                        break out;
                    }
                }
            }

//        out: while (needToContinue) {
//            needToContinue = false;
//
//            for (int i = 0; i < n; i++) {
//                Pair subIndices = getNextSubIndices(p[i], pPointer[i]);
//                if (subIndices.r - subIndices.l == 0) {
//                    pPointer[i] = subIndices.r;
//                    needToContinue = true;
//                    continue;
//                } else if (subIndices.r - subIndices.l < 0) {
//                    continue;
//                }
//                pPointer[i] = subIndices.r;
//
//                int indexToStart = getNextIndexToStart(p[i], lastInRes[i], res, subIndices, previousResLenght);
//                if (indexToStart < 0) {
//                    isOk = false;
//                    break out;
//                }
//
//                lastInRes[i] = addNext(p[i], indexToStart, res, subIndices);
//
//                needToContinue = true;
//            }
//
//            previousResLenght = res.length();
//        }

            if (!isOk) {
                out.printf("Case #%d: *\n", testNumber);
            } else {
                out.printf("Case #%d: %s\n", testNumber, res.toString());
            }
        }

        private int ni() {
            return in.nextInt();
        }

        private String next() {
            return in.next();
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

