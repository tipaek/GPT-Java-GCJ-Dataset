import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 0; c < t; c++) {
            int N = in.nextInt();
            in.nextLine();
            ArrayList<Activity> list = new ArrayList<Activity>();

            for (int i = 0; i < N; i++) {
                String[] SE = in.nextLine().split("\\s+");
                int start = Integer.parseInt(SE[0]);
                int end = Integer.parseInt(SE[1]);
                Activity a = new Activity(start, end, i);
                list.add(a);
            }

            Collections.sort(list, new ActivityComparator());
            // System.err.println("list " + list);

            String sol = parenting(list);

            System.out.println("Case #" + (c + 1) + ": " + sol);
        }
    }

    public static String parenting(ArrayList<Activity> list) {
        String res = "";

        int lastJ = 0;
        int lastC = 0;
        for (Activity a : list) {
            if (a.start < lastC && a.start < lastJ) {
                return Parenting.IMPOSSIBLE;
            }
            if (a.start < lastC) {
                a.assignee = 'J';
                lastJ = a.end;
            } else {
                a.assignee = 'C';
                lastC = a.end;
            }
        }

        Collections.sort(list, new ActivityOriginalCompoarator());
        for (Activity a : list) {
            res += a.assignee;
        }
        return res;
    }

    static class Activity {
        int start;
        int end;
        int order;
        char assignee;

        public Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }

        @Override
        public String toString() {
            return this.start + " " + this.end;
        }

    }

    static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity act1, Activity act2) {
            return act1.end - act2.end;
        }
    }

    static class ActivityOriginalCompoarator implements Comparator<Activity> {
        public int compare(Activity act1, Activity act2) {
            return act1.order - act2.order;
        }
    }
}
