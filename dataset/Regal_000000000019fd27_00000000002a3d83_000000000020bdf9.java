
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<Pair> pairList;
        for (int i = 1; i <= t; ++i) {
            pairList = new LinkedList<>();
            int n = in.nextInt();
            boolean breakFlag = false;
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();

                Pair pair = new Pair(s, e);
                int count = 0;
                for (Pair pair1 : pairList) {
                    if (pair1.intersect(pair)) {
                        count++;
                    }
                }
                pairList.add(pair);

                if (count > 1) {
                    System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag){
                continue;
            }
            StringBuilder resultSB = new StringBuilder();

            for (Pair pair : pairList) {
                for (Pair pair1 : pairList) {
                    if (pair.assignedParent != 0){
                        break;
                    }
                    if (pair.equals(pair1)) {
                        continue;
                    }

                    if (pair.intersect(pair1) && pair1.assignedParent == 1 ) {
                        pair.assignedParent = 2;

                    }
                }
                if (pair.assignedParent == 0){
                    pair.assignedParent = 1;
                }
            }

            for (Pair pair : pairList) {
                if (pair.assignedParent == 1) {
                    resultSB.append("J");
                } else {
                    resultSB.append("C");
                }
            }


            System.out.println(String.format("Case #%d: %s", i, resultSB.toString()));
        }


    }

    static class Pair {
        int s;
        int e;

        int assignedParent = 0;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        boolean intersect(Pair o) {
            if ((e < o.s) || (o.e <= s)) {
                return false;
            }

            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return s == pair.s &&
                    e == pair.e &&
                    assignedParent == pair.assignedParent;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e, assignedParent);
        }
    }
}
