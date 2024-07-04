import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Solution {
    private final static StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        Map<Integer, List<List<Integer>>> testCaseActivitiesMap = new HashMap<>();
        Map<Integer, StringBuilder> responseMap = new HashMap<>();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = in.nextInt();
            List<List<Integer>> activities = new ArrayList<>();
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
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
        List<StringBuilder> response = recursiveSolution(0, activities, new ArrayList<>(), new ArrayList<>());
        StringBuilder answer = response.stream().filter(stringBuilder -> stringBuilder != IMPOSSIBLE).findFirst().orElse(IMPOSSIBLE);
        return answer == IMPOSSIBLE ? IMPOSSIBLE : answer.reverse();
    }

    private static List<StringBuilder> recursiveSolution(Integer index, List<List<Integer>> activities, List<List<Integer>> jobCEntries, List<List<Integer>> jobJEntries) {
        if (index >= activities.size()) return new ArrayList<>();
        List<StringBuilder> response = new ArrayList<>();
        List<Integer> activity = activities.get(index);
        Boolean isCFree = isFree(activity, jobCEntries);
        Boolean isJFree = isFree(activity, jobJEntries);
        if (!isCFree && !isJFree) {
            return new ArrayList<>(Collections.singletonList(IMPOSSIBLE));
        }
        if (isCFree) {
            List<List<Integer>> cloneJobC = new ArrayList<>(jobCEntries);
            cloneJobC.add(activity);
            List<StringBuilder> jobCStatus = recursiveSolution(index + 1, activities, cloneJobC, jobJEntries);
            if (jobCStatus.isEmpty()) {
                response.add(new StringBuilder("C"));
            } else {
                List<StringBuilder> validEntries = jobCStatus.stream().filter(stringBuilder -> stringBuilder != IMPOSSIBLE).collect(toList());
                validEntries.forEach(stringBuilder -> response.add(stringBuilder.append("C")));
                if (validEntries.isEmpty()) response.add(IMPOSSIBLE);
            }
        }
        if (isJFree) {
            List<List<Integer>> cloneJobJ = new ArrayList<>(jobJEntries);
            cloneJobJ.add(activity);
            List<StringBuilder> jobJStatus = recursiveSolution(index + 1, activities, jobCEntries, cloneJobJ);
            if (jobJStatus.isEmpty()) {
                response.add(new StringBuilder("J"));
            } else {
                List<StringBuilder> validEntries = jobJStatus.stream().filter(stringBuilder -> stringBuilder != IMPOSSIBLE).collect(toList());
                validEntries.forEach(stringBuilder -> response.add(stringBuilder.append("J")));
                if (validEntries.isEmpty()) response.add(IMPOSSIBLE);
            }
        }
        return response;
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
