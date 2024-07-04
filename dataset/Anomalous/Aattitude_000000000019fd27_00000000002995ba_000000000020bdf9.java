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
            ArrayList<Pair> cActivities = new ArrayList<>();
            ArrayList<Pair> jActivities = new ArrayList<>();

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

            cActivities.add(activities.get(0));
            if (n > 1) {
                jActivities.add(activities.get(1));
            }

            int cIndex = 0;
            int jIndex = 0;
            for (int k = 2; k < n; k++) {
                Pair current = activities.get(k);
                if (current.start >= cActivities.get(cIndex).end && current.start >= jActivities.get(jIndex).end) {
                    if (cActivities.get(cIndex).end > jActivities.get(jIndex).end) {
                        cActivities.add(current);
                        cIndex++;
                    } else {
                        jActivities.add(current);
                        jIndex++;
                    }
                } else if (current.start >= cActivities.get(cIndex).end) {
                    cActivities.add(current);
                    cIndex++;
                } else if (current.start >= jActivities.get(jIndex).end) {
                    jActivities.add(current);
                    jIndex++;
                }
            }

            StringBuilder result = new StringBuilder();
            if (cActivities.size() + jActivities.size() == initialOrder.size()) {
                for (Pair p : initialOrder) {
                    if (cActivities.contains(p)) {
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