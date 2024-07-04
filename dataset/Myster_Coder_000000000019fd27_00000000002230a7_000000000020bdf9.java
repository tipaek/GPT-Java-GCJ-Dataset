import java.awt.*;
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        t = Integer.parseInt(in.readLine());
        for (int a = 0; a < t; a++) {
            n = Integer.parseInt(in.readLine());
            Activity activity[] = new Activity[n];
            int CStart = -1, CEnd = -1, JStart = -1, JEnd = -1;
            String ans = "";
            for (int b = 0; b < n; b++) {
                String str[] = in.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                activity[b] = new Activity(start, end, b);
            }
            Arrays.sort(activity, new SortByStart());
            //System.out.println(activity.toString());
            for (int b = 0; b < n; b++) {
                if (ans.equals("IMPOSSIBLE"))
                    continue;
                int start = activity[b].start;
                int end = activity[b].end;
                //System.out.println(start + " " + end);
//                if (!((start>=CStart && start<CEnd) || (end>=CStart && end<=CEnd) || (start<=CStart && end>=CEnd))) {
//                    CStart = start;
//                    CEnd = end;
//                    ans += "C";
//                } else if (!((start>=JStart && start<JEnd) || (end>=JStart && end<=JEnd) || (start<=JStart && end>=JEnd))) {
//
//                    JStart=start;
//                    JEnd=end;
//                    ans+="J";
//                }
                if (CStart >= end || CEnd <= start) {
                    CStart = start;
                    CEnd = end;
                    activity[b].person='C';
                } else if (JStart >= end || JEnd <= start) {

                    JStart = start;
                    JEnd = end;
                    activity[b].person='J';
                } else {
                    ans = "IMPOSSIBLE";
                }
            }
            if(!ans.equals("IMPOSSIBLE")){
                Arrays.sort(activity, new SortByIndex());
                ans="";
                for(int b=0;b<n;b++){
                    ans+=activity[b].person;
                }
            }
            System.out.println("Case #" + (a + 1) + ": " + ans);
        }
    }
}

class Activity {
    int start = -1, end = -1, index = -1;
    char person = 'X';

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class SortByStart implements Comparator<Activity> {

    @Override
    public int compare(Activity activity1, Activity activity2) {
        return activity1.start - activity2.start;
    }
}

class SortByIndex implements Comparator<Activity> {

    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.index - o2.index;
    }
}

