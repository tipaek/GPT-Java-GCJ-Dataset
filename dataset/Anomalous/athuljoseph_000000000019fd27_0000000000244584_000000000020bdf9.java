import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        String[] finalOutput = new String[testCaseCount];

        for (int t = 0; t < testCaseCount; t++) {
            int noOfActivities = sc.nextInt();
            Activity[] activities = new Activity[noOfActivities];

            for (int n = 0; n < noOfActivities; n++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[n] = new Activity(start, end, n);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            boolean cAvailable = true, jAvailable = true, impossible = false;
            int preEndC = 0, preEndJ = 0;
            char[] output = new char[noOfActivities];

            for (Activity activity : activities) {
                if (activity.start >= preEndC) {
                    output[activity.index] = 'C';
                    preEndC = activity.end;
                    cAvailable = false;
                } else if (activity.start >= preEndJ) {
                    output[activity.index] = 'J';
                    preEndJ = activity.end;
                    jAvailable = false;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                finalOutput[t] = "IMPOSSIBLE";
            } else {
                StringBuilder schedule = new StringBuilder();
                for (char ch : output) {
                    schedule.append(ch);
                }
                finalOutput[t] = schedule.toString();
            }
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + finalOutput[i]);
        }
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}