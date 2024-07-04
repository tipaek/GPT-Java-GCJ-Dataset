import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<TreeMap<int[], Integer>> dataList = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            TreeMap<int[], Integer> testCaseData = new TreeMap<>(Comparator.comparingInt(o -> o[0]));
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int[] activityTiming = new int[2];
                activityTiming[0] = sc.nextInt();
                activityTiming[1] = sc.nextInt();
                testCaseData.put(activityTiming, j);
            }
            dataList.add(testCaseData);
        }
        
        for (int i = 0; i < dataList.size(); i++) {
            String output = getScheduledTasksIfPossible(dataList.get(i));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    public static String getScheduledTasksIfPossible(TreeMap<int[], Integer> testCaseData) {
        int lastActivityTimeCompletionC = -1;
        int lastActivityTimeCompletionJ = -1;
        char[] ansArray = new char[testCaseData.size()];

        for (Map.Entry<int[], Integer> activityTimeEntry : testCaseData.entrySet()) {
            int startTime = activityTimeEntry.getKey()[0];
            int endTime = activityTimeEntry.getKey()[1];
            int activityIndex = activityTimeEntry.getValue();
            if (lastActivityTimeCompletionJ <= startTime) {
                ansArray[activityIndex] = 'J';
                lastActivityTimeCompletionJ = endTime;
            } else if (lastActivityTimeCompletionC <= startTime) {
                ansArray[activityIndex] = 'C';
                lastActivityTimeCompletionC = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(ansArray);
    }
}