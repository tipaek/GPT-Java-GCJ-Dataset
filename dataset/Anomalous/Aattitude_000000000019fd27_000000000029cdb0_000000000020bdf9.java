import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            ArrayList<Pair> activities = new ArrayList<>();
            ArrayList<Pair> initialOrder = new ArrayList<>();
            ArrayList<Pair> cSchedule = new ArrayList<>();
            ArrayList<Pair> jSchedule = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Pair p = new Pair(start, end);
                activities.add(p);
                initialOrder.add(p);
            }

            activities.sort(Comparator.comparingInt((Pair p) -> p.start)
                    .thenComparingInt(p -> p.end));

            if (!activities.isEmpty()) {
                cSchedule.add(activities.get(0));
                if (n > 1) {
                    jSchedule.add(activities.get(1));
                }
            }

            int cIndex = 0;
            int jIndex = 0;
            for (int k = 2; k < n; k++) {
                Pair current = activities.get(k);
                if (current.start >= cSchedule.get(cIndex).end && current.start >= jSchedule.get(jIndex).end) {
                    if (cSchedule.get(cIndex).end > jSchedule.get(jIndex).end) {
                        cSchedule.add(current);
                        cIndex++;
                    } else {
                        jSchedule.add(current);
                        jIndex++;
                    }
                } else if (current.start >= cSchedule.get(cIndex).end) {
                    cSchedule.add(current);
                    cIndex++;
                } else if (current.start >= jSchedule.get(jIndex).end) {
                    jSchedule.add(current);
                    jIndex++;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (cSchedule.size() + jSchedule.size() == initialOrder.size()) {
                for (Pair p : initialOrder) {
                    if (cSchedule.contains(p)) {
                        sb.append("C");
                    } else {
                        sb.append("J");
                    }
                }
            } else {
                sb.append("IMPOSSIBLE");
            }

            bw.write("Case #" + (t + 1) + ": " + sb.toString() + "\n");
        }
        bw.flush();
    }
}