import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            ArrayList<Schedule> schedules = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedules.add(new Schedule(j, start, end));
            }

            Collections.sort(schedules, new SortByStart());

            int C = 0, J = 0;
            boolean isPossible = true;
            for (Schedule schedule : schedules) {
                if (C <= schedule.start) {
                    schedule.assignedTo = "C";
                    C = schedule.end;
                } else if (J <= schedule.start) {
                    schedule.assignedTo = "J";
                    J = schedule.end;
                } else {
                    ans.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Collections.sort(schedules, new SortByNumber());
                ans.append("Case #").append(i + 1).append(": ");
                for (Schedule schedule : schedules) {
                    ans.append(schedule.assignedTo);
                }
                ans.append("\n");
            }
        }

        System.out.print(ans.toString());
        sc.close();
    }
}

class Schedule {
    int number;
    int start;
    int end;
    String assignedTo;

    public Schedule(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }
}

class SortByStart implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
        return Integer.compare(a.start, b.start);
    }
}

class SortByNumber implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
        return Integer.compare(a.number, b.number);
    }
}