import java.util.*;
import java.io.*;

class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int[][] schedule = new int[1440][2];
            boolean isImpossible = false;

            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][3];
            int[][] result = new int[activitiesCount][2];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];

                boolean cameronFree = true;
                boolean jamieFree = true;

                for (int time = start; time < end; time++) {
                    if (schedule[time][0] == 1) {
                        cameronFree = false;
                    }
                }

                if (cameronFree) {
                    for (int time = start; time < end; time++) {
                        schedule[time][0] = 1;
                    }
                    result[index] = new int[]{index, 1};
                } else {
                    for (int time = start; time < end; time++) {
                        if (schedule[time][1] == 1) {
                            jamieFree = false;
                        }
                    }

                    if (jamieFree) {
                        for (int time = start; time < end; time++) {
                            schedule[time][1] = 1;
                        }
                        result[index] = new int[]{index, 2};
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            if (isImpossible) {
                answer.append("IMPOSSIBLE");
            } else {
                Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
                for (int[] res : result) {
                    answer.append(res[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + answer);
        }
    }
}