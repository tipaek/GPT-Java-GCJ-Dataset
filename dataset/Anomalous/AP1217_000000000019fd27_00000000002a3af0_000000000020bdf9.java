import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> {
            if (entry1[col] > entry2[col]) 
                return 1;
            else 
                return -1;
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Integer[][]> schedules = new ArrayList<>();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            if (activitiesCount != 0) {
                Integer[][] activities = new Integer[activitiesCount][2];
                for (int j = 0; j < activitiesCount; j++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int k = 0; k < 2; k++) {
                        activities[j][k] = Integer.parseInt(values[k]);
                    }
                }
                schedules.add(activities);
            }
        }
        scanner.close();

        for (int t = 0; t < schedules.size(); t++) {
            Integer[][] activities = schedules.get(t);
            int n = activities.length;
            int[] startTimes = new int[n];
            String[] result = new String[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = activities[i][0];
            }

            sortByColumn(activities, 0);

            String[] assignments = new String[n];
            assignments[0] = "J";
            int lastEndTime = activities[0][1];

            for (int i = 1; i < n; i++) {
                if (activities[i][0] >= lastEndTime) {
                    assignments[i] = "J";
                    lastEndTime = activities[i][1];
                }
            }

            int startIndex = 0;
            for (int i = 0; i < n; i++) {
                if (assignments[i] == null) {
                    startIndex = i;
                    break;
                }
            }

            lastEndTime = activities[startIndex][0];
            for (int i = startIndex; i < n; i++) {
                if (activities[i][0] >= lastEndTime && assignments[i] == null) {
                    assignments[i] = "C";
                    lastEndTime = activities[i][1];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (activities[i][0] != null && activities[i][0].equals(startTimes[j])) {
                        result[i] = assignments[j];
                        activities[i][0] = null;
                        startTimes[j] = -1;
                        break;
                    }
                }
            }

            boolean isImpossible = Arrays.stream(result).anyMatch(Objects::isNull);

            StringBuilder output = new StringBuilder();
            if (isImpossible) {
                output.append("Case #").append(t + 1).append(": IMPOSSIBLE");
            } else {
                for (String res : result) {
                    output.append(res);
                }
                System.out.println("Case #" + (t + 1) + ": " + output.toString().trim());
            }
        }
    }
}