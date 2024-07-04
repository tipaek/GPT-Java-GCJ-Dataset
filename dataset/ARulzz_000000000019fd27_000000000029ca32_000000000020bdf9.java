/*
https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9

4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

out:
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC
*/

import java.util.*;
import java.io.*;

class Activity {
    int start;
    int end;
    int index;

    public Activity(int s, int e, int i) {
        start = s;
        end = e;
        index = i;
    }

    public String toString() {
        return start + " " + end;
    }
}

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int a0 = 1; a0 <= t; a0++) {
            int n = in.nextInt();
            Activity[] schedule = new Activity[n];

            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                schedule[i] = new Activity(s, e, i);
            }
            
            System.out.println("Case #" + a0 + ": " + getResult(schedule));
        }
    }

    private static String getResult(Activity[] schedule) {
        Arrays.sort(schedule, (r1, r2) -> Integer.compare(r1.start, r2.start));
        
        char[] answer = new char[schedule.length];
        int c = -1;
        int j = -1;

        for (int i = 0; i < schedule.length; i++) {
            int start = schedule[i].start;
            int end = schedule[i].end;

            if (start >= c) {
                c = end;
                answer[schedule[i].index] = 'C';
            }
            else if (start >= j) {
                j = end;
                answer[schedule[i].index] = 'J';
            }
            else return "IMPOSSIBLE";
        }

        return String.valueOf(answer);
    }
}
