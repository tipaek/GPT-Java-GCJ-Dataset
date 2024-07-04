import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.comparingInt;

public class Solution {

    static public class Act {

        int start;
        int end;

        public Act(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Act act = (Act) o;
            return start == act.start &&
                    end == act.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = in.nextInt();

            List<Act> acts = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                acts.add(new Act(in.nextInt(), in.nextInt()));
            }

            acts.sort(comparingInt(Act::getStart).thenComparing(Act::getEnd));

            StringBuilder resB = new StringBuilder("");

            int Cam = -1;
            int Jam = -1;
            for (int i = 0; i < n; i++) {
                Act a = acts.get(i);
                if (Cam <= a.start ) {
                    resB.append("C");
                    Cam = a.end;
                } else {
                    if (Jam <= a.start) {
                        resB.append("J");
                        Jam = a.end;
                    }
                    else {
                        resB = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + (tt + 1) + ": " + resB);
        }
    }
}
