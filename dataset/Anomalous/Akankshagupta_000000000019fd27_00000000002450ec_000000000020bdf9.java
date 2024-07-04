import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());
        if (cases <= 0) return;

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int noOfActivities = Integer.parseInt(in.nextLine());
            if (noOfActivities <= 0) continue;

            int[] start = new int[noOfActivities];
            int[] end = new int[noOfActivities];
            int[] index = new int[noOfActivities];

            for (int activityIndex = 0; activityIndex < noOfActivities; activityIndex++) {
                String[] startAndEndTime = in.nextLine().split(" ");
                start[activityIndex] = Integer.parseInt(startAndEndTime[0]);
                end[activityIndex] = Integer.parseInt(startAndEndTime[1]);
                index[activityIndex] = activityIndex;
            }

            bubbleSort(end, start, index);

            int cameron = 0, jamie = -1;
            char[] outputChar = new char[noOfActivities];
            outputChar[0] = 'C';

            boolean possible = true;
            for (int i = 1; i < noOfActivities; i++) {
                if (end[cameron] <= start[i]) {
                    outputChar[i] = 'C';
                    cameron = i;
                } else if (jamie == -1 || end[jamie] <= start[i]) {
                    outputChar[i] = 'J';
                    jamie = i;
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder output = new StringBuilder();
            if (possible) {
                for (int i = 0; i < noOfActivities; i++) {
                    output.append(outputChar[index[i]]);
                }
                System.out.println("Case #" + (caseIndex + 1) + ": " + output.toString());
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }

    static void bubbleSort(int[] end, int[] start, int[] index) {
        int n = end.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (end[j] > end[j + 1]) {
                    swap(end, j, j + 1);
                    swap(start, j, j + 1);
                    swap(index, j, j + 1);
                }
            }
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}