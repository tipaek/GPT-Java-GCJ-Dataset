import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void p(String s) {System.out.print(s);}
    public static void pn(String s) {System.out.println(s);}
    public static void ep(String s) {System.err.print(s);}
    public static void epn(String s) {System.err.println(s);}

    static class Activity {
        public Integer index;
        public Integer start;
        public Integer end;
        public String by = "";
        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", by='" + by + '\'' +
                    '}';
        }
    }

    public static void caseN(Scanner s, int t) {
        p("Case #" + t + ": ");
        int n = s.nextInt();
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(i, s.nextInt(), s.nextInt()));
        }
        activities.sort(Comparator.comparing(a -> a.start));

        String by = "C";
        int cEnd = 0;
        int jEnd = 0;
        for (int i = 0; i < n; i++) {
            Activity ai = activities.get(i);
            if (ai.start >= cEnd) {
                ai.by = "C";
                cEnd = ai.end;
            } else if (ai.start >= jEnd) {
                ai.by = "J";
                jEnd = ai.end;
            } else {
                pn("IMPOSSIBLE");
                System.out.flush();
                return;
            }
        }
        activities.sort(Comparator.comparing(a -> a.index));
        for (int i = 0; i < n; i++) {
            p(activities.get(i).by);
        }
        pn("");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tNum = s.nextInt();
        for (int t = 1; t <= tNum; t++) {
            caseN(s, t);
        }
    }
}
