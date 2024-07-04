import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        Map<Integer, List<int[]>> testCaseActivitiesMap = new HashMap<>();
        Map<Integer, StringBuilder> responseMap = new HashMap<>();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            boolean isImpossible = false;
            
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                if (endTime < startTime) {
                    responseMap.put(caseNumber, IMPOSSIBLE);
                    isImpossible = true;
                    break;
                }
                activities.add(new int[]{startTime, endTime});
            }
            
            if (!isImpossible) {
                testCaseActivitiesMap.put(caseNumber, activities);
            }
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
        
        responseMap.forEach((testCase, result) -> {
            System.out.println("Case #" + testCase + ": " + result);
        });
    }

    private static StringBuilder compute(List<int[]> activities) {
        List<StringBuilder> responses = recursiveSolution(0, activities, new ArrayList<>(), new ArrayList<>());
        return responses.stream().filter(response -> response != IMPOSSIBLE).findFirst().orElse(IMPOSSIBLE);
    }

    private static List<StringBuilder> recursiveSolution(int index, List<int[]> activities, List<int[]> jobCEntries, List<int[]> jobJEntries) {
        if (index >= activities.size()) {
            return new ArrayList<>();
        }
        
        List<StringBuilder> responses = new ArrayList<>();
        int[] activity = activities.get(index);
        boolean isCFree = isFree(activity, jobCEntries);
        boolean isJFree = isFree(activity, jobJEntries);
        
        if (!isCFree && !isJFree) {
            return Collections.singletonList(IMPOSSIBLE);
        }
        
        if (isCFree) {
            List<int[]> cloneJobC = new ArrayList<>(jobCEntries);
            cloneJobC.add(activity);
            List<StringBuilder> jobCStatus = recursiveSolution(index + 1, activities, cloneJobC, jobJEntries);
            if (jobCStatus.isEmpty()) {
                responses.add(new StringBuilder("C"));
            } else {
                jobCStatus.stream().filter(response -> response != IMPOSSIBLE).forEach(response -> responses.add(response.append("C")));
                if (responses.isEmpty()) responses.add(IMPOSSIBLE);
            }
        }
        
        if (isJFree) {
            List<int[]> cloneJobJ = new ArrayList<>(jobJEntries);
            cloneJobJ.add(activity);
            List<StringBuilder> jobJStatus = recursiveSolution(index + 1, activities, jobCEntries, cloneJobJ);
            if (jobJStatus.isEmpty()) {
                responses.add(new StringBuilder("J"));
            } else {
                jobJStatus.stream().filter(response -> response != IMPOSSIBLE).forEach(response -> responses.add(response.append("J")));
                if (responses.isEmpty()) responses.add(IMPOSSIBLE);
            }
        }
        
        return responses;
    }

    private static boolean isFree(int[] currentEntry, List<int[]> assignedEntries) {
        if (assignedEntries.isEmpty()) return true;
        int currentStartTime = currentEntry[0];
        int currentEndTime = currentEntry[1];
        return assignedEntries.stream().allMatch(entry -> currentStartTime >= entry[1] || currentEndTime <= entry[0]);
    }
}