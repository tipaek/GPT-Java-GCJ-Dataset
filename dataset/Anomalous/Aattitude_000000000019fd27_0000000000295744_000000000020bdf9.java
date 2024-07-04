import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> activities = new ArrayList<>();
            ArrayList<Pair> initialOrder = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                Pair p = new Pair(start, end);
                activities.add(p);
                initialOrder.add(p);
            }

            activities.sort(Comparator.comparingInt((Pair p) -> p.end).thenComparingInt(p -> p.start));

            ArrayList<Pair> cSchedule = new ArrayList<>();
            ArrayList<Pair> jSchedule = new ArrayList<>();
            ArrayList<Pair> temp = new ArrayList<>();

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