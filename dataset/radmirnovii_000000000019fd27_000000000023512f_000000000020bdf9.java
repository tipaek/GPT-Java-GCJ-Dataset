import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.comparingInt;

public class Solution {

    static public class Act {

        int start;
        int end;
        int num;
        int assigned;

        public Act(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public int getAssigned() {
            return assigned;
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
                acts.add(new Act(in.nextInt(), in.nextInt(), i));
            }

            acts.sort(comparingInt(Act::getStart).thenComparing(Act::getEnd));

            StringBuilder resB = new StringBuilder("");

            int Cam = -1;
            int Jam = -1;
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                Act a = acts.get(i);
                if (Cam <= a.start ) {
                    a.assigned = 1;
                    Cam = a.end;
                } else {
                    if (Jam <= a.start) {
                        a.assigned = 0;
                        Jam = a.end;
                    }
                    else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                resB  = new StringBuilder("IMPOSSIBLE");
            } else {
                acts.sort(comparingInt(Act::getNum));
                for (int i = 0; i < n; i++) {
                    resB.append(acts.get(i).assigned == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + (tt + 1) + ": " + resB);
        }
    }
}
