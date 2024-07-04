import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int activitiesCount = scanner.nextInt();
            List<Schedule> schedules = new ArrayList<>();
            
            for (int j = 0; j < activitiesCount; j++) {
                schedules.add(new Schedule(scanner.nextInt(), scanner.nextInt()));
            }
            
            System.out.println("Case #" + i + ": " + analyzeSchedules(schedules));
        }
    }

    private static String analyzeSchedules(List<Schedule> schedules) {
        Stack<String> results = new Stack<>();
        Stack<Schedule> cameronSchedules = new Stack<>();
        Stack<Schedule> jamieSchedules = new Stack<>();
        int cameronStreak = 0;
        int jamieStreak = 0;
        
        for (int i = 0; i < schedules.size(); i++) {
            Schedule current = schedules.get(i);
            
            if (canAddToSchedule(cameronSchedules, current)) {
                cameronSchedules.add(current);
                results.push("C");
                cameronStreak++;
                jamieStreak = 0;
            } else if (canAddToSchedule(jamieSchedules, current)) {
                jamieSchedules.add(current);
                results.push("J");
                jamieStreak++;
                cameronStreak = 0;
            } else {
                if (cameronStreak > 0) {
                    handleBacktrack(cameronStreak, jamieSchedules, cameronSchedules, results);
                    i--;
                    cameronStreak = 0;
                    jamieStreak = 0;
                    continue;
                } else if (jamieStreak > 0) {
                    handleBacktrack(jamieStreak, jamieSchedules, cameronSchedules, results);
                    i--;
                    cameronStreak = 0;
                    jamieStreak = 0;
                    continue;
                }
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder resultString = new StringBuilder();
        while (!results.isEmpty()) {
            resultString.append(results.pop());
        }
        return resultString.reverse().toString();
    }

    private static boolean canAddToSchedule(List<Schedule> scheduleList, Schedule schedule) {
        for (Schedule existingSchedule : scheduleList) {
            if ((schedule.start >= existingSchedule.start && schedule.start < existingSchedule.stop)
                || (schedule.start < existingSchedule.start && schedule.stop > existingSchedule.start)) {
                return false;
            }
        }
        return true;
    }

    private static void handleBacktrack(int streak, Stack<Schedule> jamieSchedules,
                                        Stack<Schedule> cameronSchedules, Stack<String> results) {
        Stack<Schedule> tempStack = new Stack<>();
        String lastAssigned = "";
        
        while (streak > 0) {
            if (results.peek().equals("C")) {
                tempStack.push(cameronSchedules.pop());
            } else {
                tempStack.push(jamieSchedules.pop());
            }
            lastAssigned = results.pop();
            streak--;
        }

        while (!tempStack.isEmpty()) {
            Schedule poppedSchedule = tempStack.pop();
            if (lastAssigned.equals("J")) {
                if (canAddToSchedule(cameronSchedules, poppedSchedule)) {
                    cameronSchedules.push(poppedSchedule);
                    results.push("C");
                    lastAssigned = "C";
                } else if (canAddToSchedule(jamieSchedules, poppedSchedule)) {
                    jamieSchedules.push(poppedSchedule);
                    results.push("J");
                    lastAssigned = "J";
                }
            } else {
                if (canAddToSchedule(jamieSchedules, poppedSchedule)) {
                    jamieSchedules.push(poppedSchedule);
                    results.push("J");
                    lastAssigned = "J";
                } else if (canAddToSchedule(cameronSchedules, poppedSchedule)) {
                    cameronSchedules.push(poppedSchedule);
                    results.push("C");
                    lastAssigned = "C";
                }
            }
        }
    }

    private static class Schedule {
        private final int start;
        private final int stop;

        Schedule(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }
}