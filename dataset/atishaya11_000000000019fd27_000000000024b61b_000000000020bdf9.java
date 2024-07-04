import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int t = 1; t <= count; t++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities[i] = new Activity(s, e, i);
            }
            Arrays.sort(activities, (a, b) -> {
                if (a.s == b.s) {
                    return Integer.compare(a.e, b.e);
                }
                return Integer.compare(a.s, b.s);
            });

            char[] arr = new char[n];
            boolean impossible = false;
            int c = 0;
            int j = 0;
            for (int i = 0; i < n; i++) {
                int s = activities[i].s;
                int e = activities[i].e;
                int idx = activities[i].i;
                if (c <= s) {
                    arr[idx] = 'C';
                    c = e;
                } else if (j <= s) {
                    arr[idx] = 'J';
                    j = e;
                } else {
                    impossible = true;
                    break;
                }
            }
            String ans = impossible ? "IMPOSSIBLE" : new String(arr);
            System.out.printf("Case #%d: %s\n", t, ans);
        }
    }

    static class Activity {
        int s;
        int e;
        int i;
        Activity(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.i = i;
        }
    }
}