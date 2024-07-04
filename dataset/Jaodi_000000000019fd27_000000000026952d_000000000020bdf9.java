import java.util.*;
import java.io.*;

public class Solution {
    public static class Activity {
        public int start;
        public int end;
        public String assignee;
        public int order;
        public Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList<Activity> al = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                al.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            al.sort((a, b) -> a.start - b.start);
            int tj = 0;
            int tc = 0;
            boolean fail = false;
            for (int j = 0; j < al.size(); j++) {
                if (tc <= al.get(j).start) {
                    al.get(j).assignee = "C";
                    tc = al.get(j).end;
                } else if (tj <= al.get(j).start) {
                    al.get(j).assignee = "J";
                    tj = al.get(j).end;
                } else {
                    fail = true;
                    break;
                }
            }
            al.sort((a, b) -> a.order - b.order);
            StringBuilder sb = new StringBuilder();
            if (!fail) {
                for (int j = 0; j < al.size(); j++) {
                    sb.append(al.get(j).assignee);
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
        in.close();
    }
}