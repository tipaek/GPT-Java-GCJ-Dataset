import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Duration {
        public int start;
        public int end;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        List<Duration> jamie = new LinkedList<>();
        List<Duration> cameron = new LinkedList<>();
        Duration duration;
        for (int i = 0; i < t; i++) {

            
            System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");

        }
    }

    private static boolean isFree(List<Duration> person, Duration newTask) {
        for (Duration task : person) {
            if ((newTask.start < task.start && newTask.end > task.start) ||
                    (newTask.start > task.start && newTask.end < task.end) ||
                    (newTask.start < task.end && newTask.end > task.end)) {
                return false;
            }
        }
        return true;
    }
}
