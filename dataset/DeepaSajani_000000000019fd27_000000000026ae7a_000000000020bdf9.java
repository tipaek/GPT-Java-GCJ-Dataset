import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = in.nextInt();
            TreeMap<Integer, Integer> activities = new TreeMap<>();
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                activities.put(startTime, endTime);
            }
            System.out.println("Case #" + caseNumber + ": " + solution(activities));
        }
    }

    private static StringBuilder solution(TreeMap<Integer, Integer> activities) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> sortedStartTimes = activities.keySet();
        Integer jobCEndTime = Integer.MIN_VALUE;
        Integer jobJEndTime = Integer.MIN_VALUE;
        for (Integer startTime : sortedStartTimes) {
            if (jobCEndTime == Integer.MIN_VALUE || jobCEndTime <= startTime) {
                jobCEndTime = activities.get(startTime);
                stringBuilder.append("C");
            } else if (jobJEndTime == Integer.MIN_VALUE || jobJEndTime <= startTime) {
                jobJEndTime = activities.get(startTime);
                stringBuilder.append("J");
            } else {
                return new StringBuilder("IMPOSSIBLE");
            }
        }
        return stringBuilder;
    }
}
