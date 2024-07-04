import java.util.*;

public class Solution {

    public static void sortbyColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(final Integer[] entry1, final Integer[] entry2) {
                return Integer.compare(entry1[col], entry2[col]);
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        List<Integer[][]> testCases = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            if (activityCount != 0) {
                Integer[][] activities = new Integer[activityCount][2];
                for (int j = 0; j < activityCount; j++) {
                    String[] input = scanner.nextLine().split(" ");
                    activities[j][0] = Integer.parseInt(input[0]);
                    activities[j][1] = Integer.parseInt(input[1]);
                }
                testCases.add(activities);
            }
        }
        scanner.close();

        for (int i = 0; i < testCases.size(); i++) {
            Integer[][] activities = testCases.get(i);
            int numActivities = activities.length;
            
            int[] startTimes = new int[numActivities];
            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = activities[j][0];
            }

            sortbyColumn(activities, 0);

            String[] schedule = new String[numActivities];
            schedule[0] = "C";
            int endC = activities[0][1];
            int endJ = -1;

            for (int j = 1; j < numActivities; j++) {
                if (activities[j][0] >= endC) {
                    schedule[j] = "C";
                    endC = activities[j][1];
                } else if (endJ == -1 || activities[j][0] >= endJ) {
                    schedule[j] = "J";
                    endJ = activities[j][1];
                } else {
                    schedule = null;
                    break;
                }
            }

            if (schedule == null) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder("Case #" + (i + 1) + ": ");
                for (int j = 0; j < numActivities; j++) {
                    for (int k = 0; k < numActivities; k++) {
                        if (activities[j][0] == startTimes[k]) {
                            result.append(schedule[j]);
                            break;
                        }
                    }
                }
                System.out.println(result.toString());
            }
        }
    }
}