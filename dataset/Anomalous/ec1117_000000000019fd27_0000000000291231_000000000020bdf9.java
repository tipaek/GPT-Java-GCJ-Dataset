import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Pair> allJobs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                allJobs.add(new Pair(start, stop));
            }
            Collections.sort(allJobs);

            List<Integer> J = new ArrayList<>();
            List<Pair> jobs = new ArrayList<>();
            int stop = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int inStart = allJobs.get(j).start;
                int inStop = allJobs.get(j).stop;
                if (inStart >= stop) {
                    stop = inStop;
                } else {
                    J.add(j + 1);
                    jobs.add(new Pair(inStart, inStop));
                }
            }

            boolean works = true;
            for (int j = 1; j < J.size(); j++) {
                int nStart = jobs.get(j).start;
                int nStop = jobs.get(j - 1).stop;
                if (nStart < nStop) {
                    works = false;
                    break;
                }
            }

            if (works) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    if (J.contains(j)) {
                        sb.append("J");
                    } else {
                        sb.append("C");
                    }
                }
                System.out.println("Case #" + i + ": " + sb);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int stop;

        Pair(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Pair other) {
            return this.start - other.start;
        }
    }
}