
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Solution {

    static class P implements Comparable<P> {
        int start;
        int end;

        @Override
        public int compareTo(P o) {
            return this.start - o.start;
        }
    }

    static class T implements Comparable<T> {
        int start;
        int end;
        char who;

        public T(int start, int end, char who) {
            this.start = start;
            this.end = end;
            this.who = who;
        }

        @Override
        public int compareTo(T o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        in.nextLine();
        startCase: for (int caseNum = 1; caseNum <= t; ++caseNum) {
            Integer activities = in.nextInt();

            ArrayList<P> act = new ArrayList<>();

            for (int i = 0; i < activities; i++) {
                P p = new P();
                p.start = in.nextInt();
                p.end = in.nextInt();

                act.add(p);
            }
            StringBuilder output = new StringBuilder();

            Queue<T> queue = new PriorityQueue<>();
            boolean j = false;
            boolean c = false;

            Collections.sort(act);
            for (P p : act) {
                for (int ii = 0; ii < 2; ii++) {
                    T tt = queue.peek();
                    if (tt == null) {
                        break;
                    }
                    if (tt.end > p.start) {
                        break;
                    }
                    queue.poll();
                    if (tt.who == 'J') {
                        j = false;
                    }
                    if (tt.who == 'C') {
                        c = false;
                    }
                }
                if (!c) {
                    c = true;
                    queue.add(new T(p.start, p.end, 'C'));
                    output.append('C');
                    continue;
                }
                if (!j) {
                    j = true;
                    queue.add(new T(p.start, p.end, 'J'));
                    output.append('J');
                    continue;
                }
                out.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue startCase;
            }

            out.println("Case #" + caseNum + ": " + output.toString());
        }
    }
}