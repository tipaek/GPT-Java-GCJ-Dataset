import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Schedule {
        int no;
        int startTime;
        int endTime;
        String workerName = "";

        public Schedule(int no, int startTime, int endTime) {
            this.no = no;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int N;
    private static int enableSchedulesCount;
    private static int lastTime;
    private static List<Schedule> schedules = new ArrayList<>();
    private static StringBuilder out = new StringBuilder();

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            init();
            sortSchedulesIntoStartTimeOrder();
            allocateSchedule("C");
            allocateSchedule("J");
            sortSchedulesIntoNoOrder();
            printAnswer(caseNum);
        }
    }

    private static void init() {
        schedules.clear();
        enableSchedulesCount = 0;
        out.setLength(0);

        N = sc.nextInt();
        for (int no = 0; no < N; no++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            schedules.add(new Schedule(no, startTime, endTime));
        }
    }

    private static void sortSchedulesIntoStartTimeOrder() {
        schedules.sort(Comparator.comparingInt((Schedule s) -> s.startTime));
    }

    private static void allocateSchedule(String workerName) {
        lastTime = 0;
        schedules.stream()
                 .filter(schedule -> schedule.workerName.isEmpty())
                 .forEach(schedule -> {
                     if (lastTime <= schedule.startTime) {
                         lastTime = schedule.endTime;
                         schedule.workerName = workerName;
                         enableSchedulesCount++;
                     }
                 });
    }

    private static void sortSchedulesIntoNoOrder() {
        schedules.sort(Comparator.comparingInt((Schedule s) -> s.no));
    }

    private static void printAnswer(int caseNum) {
        if (enableSchedulesCount == N) {
            schedules.forEach(schedule -> out.append(schedule.workerName));
            System.out.printf("Case #%d: %s\n", caseNum, out);
        } else if (enableSchedulesCount < N) {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
        }
    }
}
