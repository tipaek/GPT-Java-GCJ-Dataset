import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair [start=" + start + ", end=" + end + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            List<Pair> activities = new ArrayList<>();
            List<Pair> initialOrder = new ArrayList<>();
            List<Pair> cSchedule = new ArrayList<>();
            List<Pair> jSchedule = new ArrayList<>();
            List<Pair> temp = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Pair p = new Pair(start, end);
                activities.add(p);
                initialOrder.add(p);
            }

            activities.sort(Comparator.comparingInt((Pair p) -> p.end).thenComparingInt(p -> p.start));

            cSchedule.add(activities.get(0));
            int lastCIndex = 0;
            for (int i = 1; i < n; i++) {
                if (activities.get(i).start >= activities.get(lastCIndex).end) {
                    cSchedule.add(activities.get(i));
                    lastCIndex = i;
                } else {
                    temp.add(activities.get(i));
                }
            }

            if (!temp.isEmpty()) {
                jSchedule.add(temp.get(0));
                int lastJIndex = 0;
                for (int i = 1; i < temp.size(); i++) {
                    if (temp.get(i).start >= temp.get(lastJIndex).end) {
                        jSchedule.add(temp.get(i));
                        lastJIndex = i;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (cSchedule.size() + jSchedule.size() == initialOrder.size()) {
                for (Pair p : initialOrder) {
                    if (cSchedule.contains(p)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            bw.write("Case #" + (t + 1) + ": " + result.toString() + "\n");
        }

        bw.flush();
    }
}