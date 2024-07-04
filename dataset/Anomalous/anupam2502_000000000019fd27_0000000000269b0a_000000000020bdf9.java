import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ScheduleTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCaseCount = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            int scheduleCount = scanner.nextInt();

            Map<Integer, Integer> taskMap = new HashMap<>();
            List<Integer> startTimes = new ArrayList<>();

            for (int i = 0; i < scheduleCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                taskMap.put(startTime, endTime);
                startTimes.add(startTime);
            }

            Collections.sort(startTimes);

            int cEndTime = -1;
            int jEndTime = -1;

            Map<Integer, String> taskAssignments = new HashMap<>();
            boolean isImpossible = false;

            for (int startTime : startTimes) {
                if (startTime >= cEndTime) {
                    taskAssignments.put(startTime, "C");
                    cEndTime = taskMap.get(startTime);
                } else if (startTime >= jEndTime) {
                    taskAssignments.put(startTime, "J");
                    jEndTime = taskMap.get(startTime);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder taskSequence = new StringBuilder();
            if (isImpossible) {
                taskSequence.append("IMPOSSIBLE");
            } else {
                for (int startTime : startTimes) {
                    taskSequence.append(taskAssignments.get(startTime));
                }
            }

            System.out.println("Case #" + caseNumber + ": " + taskSequence.toString());
        }

        scanner.close();
    }
}