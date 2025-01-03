import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        class Activity implements Comparable<Activity> {
            int s;
            int f;
            int index;
            public Activity(int start, int finish, int index) {
                this.s = start;
                this.f = finish;
                this.index = index;
            }
            @Override
            public int compareTo(Activity o) {
                return this.f - o.f;
            }
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String result = "";

            int n = in.nextInt();
            int cameron = 0;
            int jamie = 0;
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                activities[j] = new Activity(in.nextInt(),in.nextInt(), j);
            }
            Arrays.sort(activities); // sorted by finishing time

            boolean possible = true;
            String[] schedule = new String[n];
            for (Activity a: activities) {
                if (a.s >= cameron) {
                    schedule[a.index] = "C";
                    cameron = a.f;
                } else if (a.s >= jamie) {
                    schedule[a.index] = "J";
                    jamie = a.f;
                } else {
                    possible = false;
                    break;
                }
            }

            for (String s: schedule) {
                result += s;
            }
            if (possible) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }

    }
}