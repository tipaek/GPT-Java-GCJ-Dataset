import java.io.*;
import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return start == pair.start && end == pair.end;
        }
    }

    static class Assign implements Comparable<Assign> {
        int index;
        char name;

        Assign(int index, char name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public int compareTo(Assign other) {
            return this.index - other.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals[i] = new Pair(start, end, i);
            }

            Arrays.sort(intervals);
            Assign[] assignments = new Assign[n];
            boolean isImpossible = false;
            int cMax = 0, jMax = 0;

            for (int i = 0; i < n; i++) {
                if (intervals[i].start >= cMax) {
                    assignments[i] = new Assign(intervals[i].index, 'C');
                    cMax = intervals[i].end;
                } else if (intervals[i].start >= jMax) {
                    assignments[i] = new Assign(intervals[i].index, 'J');
                    jMax = intervals[i].end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder("Case #").append(caseNum).append(": ");
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                Arrays.sort(assignments);
                for (Assign assign : assignments) {
                    result.append(assign.name);
                }
            }

            System.out.println(result);
        }
    }
}