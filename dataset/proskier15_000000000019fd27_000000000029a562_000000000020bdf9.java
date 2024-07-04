

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());

            int[][] activities = new int[numberOfActivities][2];
            for (int j = 0; j < numberOfActivities; j++) {
                activities[j] = new int[3];
                String[] input = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(input[0]);
                activities[j][1] = Integer.parseInt(input[1]);
                activities[j][2] = j;
            }

            process(activities, numberOfActivities, i + 1);
        }
    }

    private static void process(int[][] activities, int numberOfActivities, int testCaseNumber) {
        Arrays.sort(activities, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr1[1] - arr2[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });

        char[] order = new char[numberOfActivities];
        int jamie = 0;
        int cameron = 0;
        boolean impossible = false;
        for (int i = 0; i < numberOfActivities; i++) {
            int[] currentActivity = activities[i];

            //assign to jamie
            if (jamie < cameron) {
                if (jamie <= currentActivity[0]) {
                    jamie = currentActivity[1];
                    order[currentActivity[2]] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            } else { //assign to cameron
                if (cameron <= currentActivity[0]) {
                    cameron = currentActivity[1];
                    order[currentActivity[2]] = 'C';
                } else {
                    impossible = true;
                    break;
                }
            }
        }

        StringBuilder output = new StringBuilder("Case #");
        output.append(testCaseNumber);
        output.append(": ");
        if (impossible) {
            output.append("IMPOSSIBLE");
        } else {
            for (char x : order) {
                output.append(x);
            }
        }

        System.out.println(output.toString());
    }
}
