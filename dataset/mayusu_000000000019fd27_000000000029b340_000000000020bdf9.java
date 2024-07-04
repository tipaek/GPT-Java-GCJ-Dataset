import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Map.Entry<Integer, Integer>> jamieSchedule = new ArrayList<>();
            List<Map.Entry<Integer, Integer>> cameronSchedule = new ArrayList<>();
            StringBuilder solutionBuilder = new StringBuilder();
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            jamieSchedule.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
            solutionBuilder.append("J");
            for (int j = 2; j <= n; j++) {
                startTime = in.nextInt();
                endTime = in.nextInt();
                boolean taskAssigned = true;
                for (Map.Entry<Integer, Integer> jamie : jamieSchedule) {
                    if (!(startTime >= jamie.getValue() || endTime <= jamie.getKey())) {
                        taskAssigned = false;
                        break;
                    }
                }
                if (taskAssigned) {
                    jamieSchedule.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
                    solutionBuilder.append("J");
                } else {
                    taskAssigned = true;
                    for (Map.Entry<Integer, Integer> cameron : cameronSchedule) {
                        if (!(startTime >= cameron.getValue() || endTime <= cameron.getKey())) {
                            taskAssigned = false;
                            break;
                        }
                    }
                    if (taskAssigned) {
                        cameronSchedule.add(new AbstractMap.SimpleEntry<>(startTime, endTime));
                        solutionBuilder.append("C");
                    } else {
                        solutionBuilder = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + solutionBuilder.toString());
        }
    }
}