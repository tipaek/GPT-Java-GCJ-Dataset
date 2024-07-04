import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private final static StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        Map<Integer, List<List<Integer>>> testCaseActivitiesMap = new HashMap<>();
        Map<Integer, StringBuilder> responseMap = new HashMap<>();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = Integer.parseInt(reader.readLine());
            List<List<Integer>> activities = new ArrayList<>();
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                String entry = reader.readLine();
                String[] entrySet = entry.split(" ");
                Integer startTime = Integer.parseInt(entrySet[0]);
                Integer endTime = Integer.parseInt(entrySet[1]);
                if (endTime < startTime) {
                    responseMap.put(caseNumber, IMPOSSIBLE);
                    return;
                }
                List<Integer> activity = new ArrayList<>(Arrays.asList(startTime, endTime));
                activities.add(activity);
            }
            testCaseActivitiesMap.put(caseNumber, activities);
        }
        testCaseActivitiesMap.keySet().forEach(testCase -> {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    StringBuilder result = compute(testCaseActivitiesMap.get(testCase));
                    responseMap.put(testCase, result);
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        responseMap.keySet().forEach(testCase -> {
            System.out.println("Case #" + testCase + ": " + responseMap.get(testCase));
        });
    }

    private static StringBuilder compute(List<List<Integer>> activities) {
        StringBuilder response = recursiveSolution(0, activities, new ArrayList<>(), new ArrayList<>());
        return response == IMPOSSIBLE ? IMPOSSIBLE : response.reverse();
    }

    private static StringBuilder recursiveSolution(Integer index, List<List<Integer>> activities, List<List<Integer>> jobCEntries, List<List<Integer>> jobJEntries) {
        if (index >= activities.size()) return new StringBuilder("");
        List<Integer> activity = activities.get(index);
        Boolean isCFree = isFree(activity, jobCEntries);
        if (isCFree) {
            List<List<Integer>> cloneJobC = new ArrayList<>(jobCEntries);
            cloneJobC.add(activity);
            StringBuilder jobCStatus = recursiveSolution(index + 1, activities, cloneJobC, jobJEntries);
            if (jobCStatus != IMPOSSIBLE) {
                return jobCStatus.append("C");
            }
        }
        Boolean isJFree = isFree(activity, jobJEntries);
        if (isJFree) {
            List<List<Integer>> cloneJobJ = new ArrayList<>(jobJEntries);
            cloneJobJ.add(activity);
            StringBuilder jobJStatus = recursiveSolution(index + 1, activities, jobCEntries, cloneJobJ);
            if (jobJStatus != IMPOSSIBLE) {
                return jobJStatus.append("J");
            }
        }
        return IMPOSSIBLE;
    }

    private static Boolean isFree(List<Integer> currentEntry, List<List<Integer>> assignedEntries) {
        if (assignedEntries.isEmpty()) return true;
        Integer currentStartTime = currentEntry.get(0);
        Integer currentEndTime = currentEntry.get(1);
        return assignedEntries.stream().allMatch(entry -> {
            Integer startTime = entry.get(0);
            Integer endTime = entry.get(1);
            return currentStartTime >= endTime || currentEndTime <= startTime;
        });
    }
}
