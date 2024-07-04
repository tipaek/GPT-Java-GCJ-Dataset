import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                List<int[]> schedulesList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    schedulesList.add(new int[] { start, end });
                }

                PersonSchedule cameron = new PersonSchedule();
                PersonSchedule jamie = new PersonSchedule();
                StringBuilder schedulePlan = new StringBuilder();

                for (int[] schedule : schedulesList) {
                    int start = schedule[0];
                    int end = schedule[1];

                    if (cameron.isFree(start, end)) {
                        schedulePlan.append("C");
                        cameron.addSchedule(start, end);
                    } else if (jamie.isFree(start, end)) {
                        schedulePlan.append("J");
                        jamie.addSchedule(start, end);
                    } else {
                        schedulePlan = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                System.out.println("Case #" + i + ": " + schedulePlan);
            }
        }
    }
}

class PersonSchedule {

    private final Map<Integer, Integer> scheduleMap = new HashMap<>();

    public void addSchedule(int startTime, int endTime) {
        scheduleMap.put(startTime, endTime);
    }

    public boolean isFree(int startTime, int endTime) {
        for (Entry<Integer, Integer> entry : scheduleMap.entrySet()) {
            if (!(endTime <= entry.getKey() || startTime >= entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}