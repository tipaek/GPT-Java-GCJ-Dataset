package codejam2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<TreeMap<int[], Integer>> dataList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            TreeMap<int[], Integer> testCaseData = new TreeMap<>((a, b) -> Integer.compare(a[0], b[0]));
            for (int j = 0; j < N; j++) {
                int[] activityTiming = new int[2];
                activityTiming[0] = sc.nextInt();
                activityTiming[1] = sc.nextInt();
                testCaseData.put(activityTiming, j);
            }
            dataList.add(testCaseData);
        }

        for (int i = 0; i < dataList.size(); i++) {
            String output = getScheduledActivities(dataList.get(i));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    public static String getScheduledActivities(TreeMap<int[], Integer> testCaseData) {
        char[] ansArray = new char[testCaseData.size()];
        int lastActivityEndC = -1;
        int lastActivityEndJ = -1;

        for (Map.Entry<int[], Integer> entry : testCaseData.entrySet()) {
            int startTime = entry.getKey()[0];
            int endTime = entry.getKey()[1];
            int index = entry.getValue();

            if (startTime >= lastActivityEndJ) {
                ansArray[index] = 'J';
                lastActivityEndJ = endTime;
            } else if (startTime >= lastActivityEndC) {
                ansArray[index] = 'C';
                lastActivityEndC = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(ansArray);
    }
}