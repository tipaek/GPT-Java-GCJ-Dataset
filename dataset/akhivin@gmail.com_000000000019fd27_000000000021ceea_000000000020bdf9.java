
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Solution {

    static class P implements Comparable<P> {
        int index;
        int start;
        int end;
        char who = '?';

        @Override
        public int compareTo(P o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "P{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", who=" + who +
                    '}';
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

        @Override
        public String toString() {
            return "T{" +
                    "start=" + start +
                    ", end=" + end +
                    ", who=" + who +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        startCase: for (int caseNum = 1; caseNum <= t; ++caseNum) {
            Integer activities = in.nextInt();

            ArrayList<P> act = new ArrayList<>();

            for (int i = 0; i < activities; i++) {
                P p = new P();
                p.index=i;
                p.start = in.nextInt();
                p.end = in.nextInt();

                act.add(p);
            }

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
                    p.who = 'C';
                    continue;
                }
                if (!j) {
                    j = true;
                    queue.add(new T(p.start, p.end, 'J'));
                    p.who = 'J';
                    continue;
                }
                out.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue startCase;
            }

            Collections.sort(act, Comparator.comparingInt(x -> x.index));
            StringBuilder output = new StringBuilder();
            for (P p: act ) {
                output.append(p.who);
            }

            out.println("Case #" + caseNum + ": " + output.toString());
        }
    }
}