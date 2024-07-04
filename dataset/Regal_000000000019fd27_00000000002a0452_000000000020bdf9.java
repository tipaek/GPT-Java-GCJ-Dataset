
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

            int[] time = new int[24*60 + 1];


            for (int j = 0; j < n; j++) {
                Pair pair = new Pair(in.nextInt(), in.nextInt());
                pairList.add(pair);

            }

            for (Pair pair : pairList) {
                for (int j = pair.s; j < pair.e; j++) {
                    time[j]++;

                }
            }

            boolean breakFlag = false;
            for (int i1 : time) {
                if (i1 > 2){
                    System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag){
                continue;
            }

            int idx = 0;
            for (Pair pair : pairList) {

                for (int x = 0; x < idx; x++) {
                    Pair pair1 = pairList.get(x);
                    if (pair1.intersect(pair)){
                        if (pair1.assignedParent == 1){
                            pair.assignedParent = 2;
                        }else {
                            pair.assignedParent = 1;
                        }

                    }

                }
                idx++;
            }

            StringBuilder resultSB = new StringBuilder();

            for (Pair pair : pairList) {
                if (pair.assignedParent == 1) {
                    resultSB.append("C");
                } else {
                    resultSB.append("J");
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
            if ((e <= o.s) || (o.e <= s)) {
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
