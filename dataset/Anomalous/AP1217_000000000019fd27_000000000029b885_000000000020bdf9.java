import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(entry -> entry[col]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        List<Integer[][]> testCases = new ArrayList<>();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            if (activitiesCount != 0) {
                Integer[][] activities = new Integer[activitiesCount][2];
                for (int j = 0; j < activitiesCount; j++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int k = 0; k < 2; k++) {
                        activities[j][k] = values[k].isEmpty() ? 0 : Integer.parseInt(values[k]);
                    }
                }
                testCases.add(activities);
            }
        }

        scanner.close();

        for (Integer[][] activities : testCases) {
            int numActivities = activities.length;
            int[] startTimes = new int[numActivities];
            String[] result = new String[numActivities];

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = activities[i][0];
            }

            sortByColumn(activities, 0);

            String[] assignments = new String[numActivities];
            assignments[0] = "J";
            int lastEndTimeJ = activities[0][1];

            for (int i = 1; i < numActivities; i++) {
                if (activities[i][0] >= lastEndTimeJ) {
                    assignments[i] = "J";
                    lastEndTimeJ = activities[i][1];
                }
            }

            int firstUnassigned = 0;
            while (firstUnassigned < numActivities && assignments[firstUnassigned] != null) {
                firstUnassigned++;
            }

            if (firstUnassigned < numActivities) {
                int lastEndTimeC = activities[firstUnassigned][0];
                for (int i = firstUnassigned; i < numActivities; i++) {
                    if (activities[i][0] >= lastEndTimeC && assignments[i] == null) {
                        assignments[i] = "C";
                        lastEndTimeC = activities[i][1];
                    }
                }
            }

            boolean impossible = false;
            for (String assignment : assignments) {
                if (assignment == null) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < numActivities; i++) {
                    for (int j = 0; j < numActivities; j++) {
                        if (activities[i][0].equals(startTimes[j])) {
                            result[j] = assignments[i];
                            break;
                        }
                    }
                }
                for (String r : result) {
                    System.out.print(r);
                }
                System.out.println();
            }
        }
    }
}