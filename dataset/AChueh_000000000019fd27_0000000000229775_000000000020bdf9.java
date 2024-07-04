import java.io.*;
import java.util.*;

class Solution {
    static class Act {
        final int start;
        final int end;
        final int index;
        Act(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Act[] activities = new Act[n];
            for(int j = 0; j < n; ++j) {
                activities[j] = new Act(in.nextInt(), in.nextInt(), j);
            }
            Arrays.sort(activities, (o1, o2) -> o1.start - o2.start);
            System.out.println("Case #" + i + ": " + parentingPartneringReturns(activities));
        }
    }

    static String parentingPartneringReturns(Act[] activities) {
        int jPivot = -1;
        int cPivot = -1;
        char[] answer = new char[activities.length];
        for(Act a: activities) {
            if(jPivot > a.start && cPivot > a.start)
                return "IMPOSSIBLE";
            if(jPivot > a.start) {
                cPivot = a.end;
                answer[a.index] = 'C';
            } else if(cPivot > a.start) {
                jPivot = a.end;
                answer[a.index] = 'J';
            } else {
                if(cPivot > jPivot) {
                    jPivot = a.end;
                    answer[a.index] = 'J';
                } else {
                    cPivot = a.end;
                    answer[a.index] = 'C';
                }
            }
        }
        return new String(answer);
    }
}