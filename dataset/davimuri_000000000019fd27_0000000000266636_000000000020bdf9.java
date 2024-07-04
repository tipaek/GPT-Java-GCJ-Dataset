import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        Solution pp = new Solution();
        for (int i = 1; i <= testCases; i++) {
            int tasks = in.nextInt();
            DomesticTask[] domesticTasks = new DomesticTask[tasks];
            for (int t = 1; t <= tasks; t++) {
                int start = in.nextInt();
                int end = in.nextInt();
                domesticTasks[t-1] = DomesticTask.of(start, end);
            }
            String output = pp.schedule(domesticTasks);
            System.out.printf("Case #%d: %s%n", i, output);
        }
    }

    public String schedule(DomesticTask[] domesticTasks) {
        DomesticTask[] timeline = new DomesticTask[1441];
        for (DomesticTask t : domesticTasks) {
            timeline[t.start] = t;
        }
        DomesticTask jamie = null;
        DomesticTask cameron = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timeline.length; i++) {
            if (timeline[i] != null) {
                if (jamie == null || jamie.end <= i) {
                    jamie = timeline[i];
                    sb.append("J");
                } else if (cameron == null || cameron.end <= i) {
                    cameron = timeline[i];
                    sb.append("C");
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return sb.toString();
    }
    static class DomesticTask {
        int start; int end;
        DomesticTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        static DomesticTask of(int start, int end) {
            return new DomesticTask(start, end);
        }
    }

}
