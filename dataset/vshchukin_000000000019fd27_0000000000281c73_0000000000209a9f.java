import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String current = in.next().trim();
            List<NestingDepth.Level> list = new ArrayList<>();
            for (int i = 0; i < current.length(); i++) {
                char levelC = current.charAt(i);
                list.add(new NestingDepth.Level(levelC - '0', Character.toString(levelC)));
            }
            for (int level = 9; level > 0; level--) {
                List<NestingDepth.Level> buf = new ArrayList<>();
                List<NestingDepth.Level> newList = new ArrayList<>();
                for (NestingDepth.Level cur : list) {
                    if (cur.level == level) {
                        buf.add(cur);
                    } else if (!buf.isEmpty()) {
                        // combine
                        combine(level, newList, buf);
                        newList.add(cur);
                    } else {
                        newList.add(cur);
                    }
                }
                if (!buf.isEmpty()) {
                    combine(level, newList, buf);
                }

                list = newList;
            }
            StringBuilder sb = new StringBuilder();
            appendList(list, sb);
            out.printf("Case #%d: %s\n", testNumber, sb.toString());
        }

        private void combine(int level, List<NestingDepth.Level> newList, List<NestingDepth.Level> buf) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            appendList(buf, sb);
            sb.append(")");
            buf.clear();
            newList.add(new NestingDepth.Level(level - 1, sb.toString()));
        }

        private void appendList(List<NestingDepth.Level> buf, StringBuilder sb) {
            for (NestingDepth.Level lev : buf) {
                sb.append(lev.s);
            }
        }

        static class Level {
            int level;
            String s;

            public Level(int level, String s) {
                this.level = level;
                this.s = s;
            }

        }

    }
}

