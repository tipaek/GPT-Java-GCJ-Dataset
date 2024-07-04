package com.company;

import java.util.Scanner;

class Activity {
    int start;
    int end;
    int index;
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].start = scanner.nextInt();
                activities[i].end = scanner.nextInt();
                activities[i].index = i;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));

            int cameronEnd = -1;
            int jamieEnd = -1;
            boolean possible = true;
            char[] result = new char[n];

            for (Activity activity : activities) {
                if (cameronEnd <= activity.start) {
                    cameronEnd = activity.end;
                    result[activity.index] = 'C';
                } else if (jamieEnd <= activity.start) {
                    jamieEnd = activity.end;
                    result[activity.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + output);
        }
    }
}