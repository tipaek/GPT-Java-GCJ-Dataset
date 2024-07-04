import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                scanner.nextLine();
                
                List<int[]> schedulesList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    String[] input = scanner.nextLine().split(" ");
                    int[] schedules = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
                    schedulesList.add(schedules);
                }

                PersonSchedule cameron = new PersonSchedule();
                PersonSchedule jamie = new PersonSchedule();

                StringBuilder schedulePlan = new StringBuilder();
                boolean possible = true;

                for (int[] schedule : schedulesList) {
                    if (cameron.isFree(schedule[0], schedule[1])) {
                        schedulePlan.append("C");
                        cameron.addSchedule(schedule[0], schedule[1]);
                    } else if (jamie.isFree(schedule[0], schedule[1])) {
                        schedulePlan.append("J");
                        jamie.addSchedule(schedule[0], schedule[1]);
                    } else {
                        schedulePlan = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }

                System.out.println("Case #" + i + ": " + schedulePlan.toString());
            }
        }
    }
}

class PersonSchedule {

    private List<int[]> schedules = new ArrayList<>();

    public void addSchedule(int startTime, int endTime) {
        schedules.add(new int[]{startTime, endTime});
    }

    public boolean isFree(int startTime, int endTime) {
        for (int[] schedule : schedules) {
            if (!(endTime <= schedule[0] || startTime >= schedule[1])) {
                return false;
            }
        }
        return true;
    }
}