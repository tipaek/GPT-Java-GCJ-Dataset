import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Duration {
        public long start;
        public long end;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        List<Duration> jamie = new LinkedList<>();
        List<Duration> cameron = new LinkedList<>();
        Duration duration;
        for (int i = 0; i < t; i++) {
            jamie.clear();
            cameron.clear();
            boolean possible = true;
            int act = in.nextInt();
            int j = 0;
            StringBuffer output = new StringBuffer();
            while (possible && j < act) {
                long start = in.nextLong();
                long end = in.nextLong();
                duration = new Duration();
                duration.start = start;
                duration.end = end;
                if (isFree(jamie, duration)) {
                    jamie.add(duration);
                    output.append("J");
                } else if (isFree(cameron, duration)) {
                    cameron.add(duration);
                    output.append("C");
                } else {
                    possible = false;
                }
                j++;
            }
            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + output.toString());
            }
        }
    }

    private static boolean isFree(List<Duration> person, Duration newTask) {
        for (Duration task : person) {
            if (newTask.start < task.start && newTask.end > task.start) {
                return false;
            }
            if (newTask.start > task.start && newTask.end < task.end) {
                return false;
            }
            if (newTask.start < task.end && newTask.end > task.end) {
                return false;
            }
        }
        return true;
    }
}
