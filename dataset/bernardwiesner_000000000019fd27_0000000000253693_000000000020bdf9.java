import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        boolean imp =false;
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            int n = in.nextInt(); //activities
            Parent ja = new Parent();
            Parent ca = new Parent();
            imp = false;
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (imp) continue;
                if ((s < ja.start || s >= ja.end) && (e <= ja.start || e > ja.end)) {
                    ja.setStart(s);
                    ja.setEnd(e);
                    sb.append("J");
                } else if ((s < ca.start || s >= ca.end) && (e <= ca.start || e > ca.end)) {
                    ca.setStart(s);
                    ca.setEnd(e);
                    sb.append("C");
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    imp = true;
//                    break;
                }
            }

                System.out.println("Case #" + i + ": " + sb);

        }
    }

    static class Parent {
        int start = 0;
        int end = 0;
        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}