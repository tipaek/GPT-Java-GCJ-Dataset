import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int noOfActivities = Integer.parseInt(scanner.nextLine());
            int[] start = new int[noOfActivities];
            int[] end = new int[noOfActivities];

            for (int activityIndex = 0; activityIndex < noOfActivities; activityIndex++) {
                String[] startAndEndTime = scanner.nextLine().split(" ");
                start[activityIndex] = Integer.parseInt(startAndEndTime[0]);
                end[activityIndex] = Integer.parseInt(startAndEndTime[1]);
            }

            bubbleSort(end, start);

            int cameron = 0, jamie = -1;
            StringBuilder output = new StringBuilder("C");

            for (int assignIndex = 1; assignIndex < noOfActivities; assignIndex++) {
                if (end[cameron] <= start[assignIndex]) {
                    output.append("C");
                    cameron = assignIndex;
                } else if (jamie == -1 || end[jamie] <= start[assignIndex]) {
                    output.append("J");
                    jamie = assignIndex;
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + output.toString());
        }
    }

    private static void bubbleSort(int[] end, int[] start) {
        int n = end.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (end[j] > end[j + 1]) {
                    int temp = end[j];
                    end[j] = end[j + 1];
                    end[j + 1] = temp;

                    int tempStart = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = tempStart;
                }
            }
        }
    }
}