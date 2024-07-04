import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        Map<Integer, List<int[]>> testCaseActivitiesMap = new HashMap<>();
        Map<Integer, StringBuilder> responseMap = new HashMap<>();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = Integer.parseInt(reader.readLine());
            List<int[]> activities = new ArrayList<>();

            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                String[] entrySet = reader.readLine().split(" ");
                int startTime = Integer.parseInt(entrySet[0]);
                int endTime = Integer.parseInt(entrySet[1]);

                if (endTime < startTime) {
                    responseMap.put(caseNumber, IMPOSSIBLE);
                    return;
                }

                activities.add(new int[]{startTime, endTime});
            }

            testCaseActivitiesMap.put(caseNumber, activities);
        }

        testCaseActivitiesMap.forEach((testCase, activities) -> {
            Thread thread = new Thread(() -> {
                StringBuilder result = compute(activities);
                responseMap.put(testCase, result);
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        responseMap.forEach((testCase, response) -> {
            System.out.println("Case #" + testCase + ": " + response);
        });
    }

    private static StringBuilder compute(List<int[]> activities) {
        StringBuilder response = recursiveSolution(0, activities, new ArrayList<>(), new ArrayList<>());
        return response == IMPOSSIBLE ? IMPOSSIBLE : response.reverse();
    }

    private static StringBuilder recursiveSolution(int index, List<int[]> activities, List<int[]> jobCEntries, List<int[]> jobJEntries) {
        if (index >= activities.size()) return new StringBuilder("");

        int[] activity = activities.get(index);

        if (isFree(activity, jobCEntries)) {
            List<int[]> cloneJobC = new ArrayList<>(jobCEntries);
            cloneJobC.add(activity);
            StringBuilder jobCStatus = recursiveSolution(index + 1, activities, cloneJobC, jobJEntries);
            if (jobCStatus != IMPOSSIBLE) {
                return jobCStatus.append("C");
            }
        }

        if (isFree(activity, jobJEntries)) {
            List<int[]> cloneJobJ = new ArrayList<>(jobJEntries);
            cloneJobJ.add(activity);
            StringBuilder jobJStatus = recursiveSolution(index + 1, activities, jobCEntries, cloneJobJ);
            if (jobJStatus != IMPOSSIBLE) {
                return jobJStatus.append("J");
            }
        }

        return IMPOSSIBLE;
    }

    private static boolean isFree(int[] currentEntry, List<int[]> assignedEntries) {
        if (assignedEntries.isEmpty()) return true;

        int currentStartTime = currentEntry[0];
        int currentEndTime = currentEntry[1];

        return assignedEntries.stream().allMatch(entry -> {
            int startTime = entry[0];
            int endTime = entry[1];
            return currentStartTime >= endTime || currentEndTime <= startTime;
        });
    }
}