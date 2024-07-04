package com.company;

import java.util.*;

class Activity {
    int start;
    int end;
    int index;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cse = 1; cse <= t; cse++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].start = sc.nextInt();
                activities[i].end = sc.nextInt();
                activities[i].index = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int freeC = -1;
            int freeJ = -1;
            boolean possible = true;
            char[] result = new char[n];

            for (Activity activity : activities) {
                if (freeC <= activity.start) {
                    freeC = activity.end;
                    result[activity.index] = 'C';
                } else if (freeJ <= activity.start) {
                    freeJ = activity.end;
                    result[activity.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + cse + ": " + output);
        }
    }
}