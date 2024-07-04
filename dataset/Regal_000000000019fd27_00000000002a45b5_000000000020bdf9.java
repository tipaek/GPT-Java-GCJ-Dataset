
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<Pair> pairList;
        for (int i = 1; i <= t; ++i) {
            pairList = new LinkedList<>();
            int n = in.nextInt();
            boolean breakFlag = false;
            Integer min = null;
            int max = 0;
            Stack<String> parents = new Stack<>();
            parents.push("J");
            parents.push("C");
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if (min == null || min > s) {
                    min = s;
                }
                if (max < e) {
                    max = e;
                }

                Pair pair = new Pair(s, e);
                pairList.add(pair);
            }

            Map<Integer, String> occupiedMap = new HashMap<>();
            for (int q = min; q <= max; q++) {
                if (occupiedMap.containsKey(q)) {
                    String remove = occupiedMap.remove(q);
                    parents.add(remove);
                }
                Pair pair = new Pair(q, q);
                for (Pair pair1 : pairList) {
                    if (pair1.parent != null){
                        continue;
                    }
                    if (pair.intersect(pair1)) {
                        if (parents.isEmpty()) {
                            breakFlag = true;
                            break;
                        }

                        String parent = parents.pop();
                        pair1.parent = parent;
                        occupiedMap.put(pair1.e, parent);

                    }
                }
                if (breakFlag) {
                    break;
                }

            }

            if (breakFlag) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                continue;
            }
            System.out.println(String.format("Case #%d: %s", i, pairList.stream().map(e -> e.parent).collect(Collectors.joining())));
        }
    }


    static class Pair {
        int s;
        int e;

        int assignedParent = 0;
        String parent = null;

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