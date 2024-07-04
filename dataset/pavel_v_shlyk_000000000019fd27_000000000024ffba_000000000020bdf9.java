// package codejam.q_2020;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {

//        String s = "4\n" +
//                "3\n" +
//                "360 480\n" +
//                "420 540\n" +
//                "600 660\n" +
//                "3\n" +
//                "0 1440\n" +
//                "1 3\n" +
//                "2 4\n" +
//                "5\n" +
//                "99 150\n" +
//                "1 100\n" +
//                "100 301\n" +
//                "2 5\n" +
//                "150 250\n" +
//                "2\n" +
//                "0 720\n" +
//                "720 1440";

//        String s = "1\n" +
//                "3\n" +
//                "0 2\n" +
//                "0 1\n" +
//                "0 1";


        int T;
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(s);

        long time = System.currentTimeMillis();

        class Activity implements Comparable<Activity> {
            int order;
            int from;
            int to;
            Activity(int o, int f, int t) { order=o; from=f; to=t; }
            public int compareTo(Activity o) {
                return Integer.compare(from, o.from);
            }
        }

        T = scan.nextInt();
        label:
        for (int t=1; t<=T; ++t) {
            int N=scan.nextInt();
            Activity[] activities = new Activity[N];
            for (int n=0; n<N; ++n) activities[n] = new Activity(n, scan.nextInt(), scan.nextInt());
            Arrays.parallelSort(activities);

            Activity aC=null;
            Activity aJ=null;
            char[] result = new char[N];
            for (int n=0; n<N; ++n) {
                Activity a = activities[n];
                if (aC!=null && aC.to<=a.from) aC = null;
                if (aJ!=null && aJ.to<=a.from) aJ = null;
                if (aC==null) {aC=a; result[a.order]='C'; continue;}
                if (aJ==null) {aJ=a; result[a.order]='J'; continue;}
                System.out.println("Case #"+t+": " + "IMPOSSIBLE");
                continue label;
            }

            System.out.println("Case #"+t+": " + String.valueOf(result));
        }
    }
}
