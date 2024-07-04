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
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> activities = new ArrayList<>();
            ArrayList<Pair> initialOrder = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Pair p = new Pair(start, end);
                activities.add(p);
                initialOrder.add(p);
            }

            activities.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.end != o2.end) {
                        return Integer.compare(o1.end, o2.end);
                    }
                    return Integer.compare(o1.start, o2.start);
                }
            });

            ArrayList<Pair> cActivities = new ArrayList<>();
            ArrayList<Pair> jActivities = new ArrayList<>();
            ArrayList<Pair> temp = new ArrayList<>();

            cActivities.add(activities.get(0));
            int lastCActivityEnd = activities.get(0).end;

            for (int i = 1; i < n; i++) {
                Pair current = activities.get(i);
                if (current.start >= lastCActivityEnd) {
                    cActivities.add(current);
                    lastCActivityEnd = current.end;
                } else {
                    temp.add(current);
                }
            }

            if (!temp.isEmpty()) {
                jActivities.add(temp.get(0));
                int lastJActivityEnd = temp.get(0).end;

                for (int i = 1; i < temp.size(); i++) {
                    Pair current = temp.get(i);
                    if (current.start >= lastJActivityEnd) {
                        jActivities.add(current);
                        lastJActivityEnd = current.end;
                    }
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