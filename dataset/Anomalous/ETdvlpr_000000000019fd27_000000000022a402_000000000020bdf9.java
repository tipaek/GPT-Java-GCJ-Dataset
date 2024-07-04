import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        List<String[]> schedules = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfTasks = Integer.parseInt(scanner.nextLine());
            String[] tasks = new String[numberOfTasks];
            for (int j = 0; j < numberOfTasks; j++) {
                tasks[j] = scanner.nextLine();
            }
            schedules.add(tasks);
        }

        Solution solution = new Solution();
        for (int i = 0; i < numberOfCases; i++) {
            System.out.println(solution.processSchedule(schedules.get(i), i + 1));
        }
    }

    public String processSchedule(String[] schedule, int caseNumber) {
        StringBuilder result = new StringBuilder();
        List<Point> cameronTasks = new ArrayList<>();
        List<Point> jamieTasks = new ArrayList<>();

        for (String task : schedule) {
            String[] times = task.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if (isTaskViable(start, end, jamieTasks)) {
                result.append("J");
                jamieTasks.add(new Point(start, end));
            } else if (isTaskViable(start, end, cameronTasks)) {
                result.append("C");
                cameronTasks.add(new Point(start, end));
            } else {
                return String.format("Case #%d: IMPOSSIBLE", caseNumber);
            }
        }
        return String.format("Case #%d: %s", caseNumber, result.toString());
    }

    private boolean isTaskViable(int start, int end, List<Point> tasks) {
        for (Point task : tasks) {
            if ((start >= task.x && start < task.y) || (end > task.x && end <= task.y)) {
                return false;
            }
        }
        return true;
    }
}