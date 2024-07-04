import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = in.nextInt();
            Map<Integer, Integer> activities = new LinkedHashMap<>();
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                activities.put(startTime, endTime);
            }
            System.out.println("Case #" + caseNumber + ": " + solution(activities));
        }
    }

    private static StringBuilder solution(Map<Integer, Integer> activities) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> jobCStartTimes = new ArrayList<>();
        List<Integer> jobJStartTimes = new ArrayList<>();
        for (Integer startTime : activities.keySet()) {
            if (isFree(startTime, jobJStartTimes, activities)) {
                jobJStartTimes.add(startTime);
                stringBuilder.append("J");
            }
            else if (isFree(startTime, jobCStartTimes, activities)) {
                jobCStartTimes.add(startTime);
                stringBuilder.append("C");
            }
            else {
                return new StringBuilder("IMPOSSIBLE");
            }
        }
        return stringBuilder;
    }

    private static Boolean isFree(Integer currentStartTime, List<Integer> startTimes, Map<Integer, Integer> activities) {
        if (startTimes.isEmpty()) return true;
        Integer currentEndTime = activities.get(currentStartTime);
        return startTimes.stream().allMatch(startTime -> {
            Integer endTime = activities.get(startTime);
            return (currentStartTime <= startTime || currentStartTime >= endTime) &&
                    (currentEndTime <= startTime || currentEndTime >= endTime);
        });
    }
}
