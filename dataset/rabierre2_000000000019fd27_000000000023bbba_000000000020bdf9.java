import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        Solution solution = new Solution();
        for (int i = 1; i <= t; ++i) {
            int count = in.nextInt();
            int[][] schedule = new int[count][2];
            for (int j = 0; j < count; j++) {
                schedule[j][0] = in.nextInt();
                schedule[j][1] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solution.test(count, schedule));
        }
    }
    
    public String test(int C, int[][] schedule) {
        String result = "";

        List<Schedule> cameron = new LinkedList<>();
        List<Schedule> jamie = new LinkedList<>();

        cameron.add(new Schedule(schedule, 0));
        result += "C";

        for (int i = 1; i < C; i++) {
            Schedule next = new Schedule(schedule, i);
            if (!isOverlapped(cameron, next)) {
                cameron.add(next);
                result += "C";
                continue;
            } else if (!isOverlapped(jamie, next)) {
                jamie.add(next);
                result += "J";
                continue;
            }
            return "Impossible";
        }

        return result;
    }

    private boolean isOverlapped(List<Schedule> cameron, Schedule next) {
        for (Schedule pre : cameron) {
            if (pre.isOverlapped(next)) return true;
        }
        return false;
    }

    class Schedule {
        public int num;
        public int start;
        public int end;

        public Schedule(int[][] schedule, int index) {
            num = index;
            this.start = schedule[index][0];
            this.end = schedule[index][1];
        }

        public boolean isOverlapped(Schedule other) {
            return (start < other.end && other.start < end) || (other.start < end && start < other.end);
        }
    }
}
