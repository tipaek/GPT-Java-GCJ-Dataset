import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end, index;
        String assignment;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            Pair[] activities = new Pair[numActivities + 1];
            activities[0] = new Pair(0, 0, -1);

            for (int j = 1; j <= numActivities; j++) {
                activities[j] = new Pair(scanner.nextInt(), scanner.nextInt(), j);
            }

            Arrays.sort(activities, (a1, a2) -> {
                if (a1.end != a2.end) {
                    return Integer.compare(a1.end, a2.end);
                }
                return Integer.compare(a1.start, a2.start);
            });

            System.out.println(assignActivities(activities).toString());
        }
    }

    private static StringBuffer assignActivities(Pair[] activities) {
        StringBuffer result;
        int lastCamEnd = 0, lastJamEnd = 0;
        boolean isImpossible = false;
        int numActivities = activities.length;

        for (int j = 1; j < numActivities; j++) {
            if (activities[j].start >= activities[lastCamEnd].end || activities[j].end <= activities[lastCamEnd].start) {
                activities[j].assignment = "C";
                lastCamEnd = j;
            } else if (activities[j].start >= activities[lastJamEnd].end || activities[j].end <= activities[lastJamEnd].start) {
                activities[j].assignment = "J";
                lastJamEnd = j;
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            result = new StringBuffer("IMPOSSIBLE");
        } else {
            String[] assignments = new String[numActivities];
            assignments[0] = "";
            for (int i = 1; i < numActivities; i++) {
                assignments[activities[i].index] = activities[i].assignment;
            }

            result = new StringBuffer();
            for (String assignment : assignments) {
                result.append(assignment);
            }
        }

        return result;
    }
}