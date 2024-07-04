import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int i=0; i<t; i++)
            System.out.println(String.format("Case #%d: %s", (i+1), doit(i)));
    }

    private static String doit(int t) {
        int n = sc.nextInt();
        SortedSet<Activity> acts = new TreeSet<>();
        char[] res = new char[n];

        // Ongoing activities
        Activity actC = null, actJ = null;

        for(int i=0; i<n; ++i) {
            acts.add(new Activity(sc.nextInt(), sc.nextInt(), i));
        }

        for(Activity a : acts) {
            if(actC != null && actC.end <= a.start)
                actC = null;

            if(actJ != null && actJ.end <= a.start)
                actJ = null;

            if(actC == null) {
                res[a.idx] = 'C';
                actC = a;
            }
            else if(actJ == null) {
                res[a.idx] = 'J';
                actJ = a;
            }
            else
                return "IMPOSSIBLE";
        }

        return String.format("%s", String.valueOf(res));
    }

    private static class Activity implements Comparable<Activity>{
        public Integer start;
        public Integer end;
        public Integer idx;

        public Activity(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Activity b) {
            if(start == b.start) return idx - b.idx;
            return start - b.start;
        }
    }
}

