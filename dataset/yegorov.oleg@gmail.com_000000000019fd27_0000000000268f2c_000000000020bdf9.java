import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int j=0; j < n; j++) {
                activities.add(new Activity(j, in.nextInt(), in.nextInt()));
            }
            activities.sort(Comparator.comparingInt(Activity::getEnd));

            boolean impossible = false;
            int lastC = -1;
            int lastJ = -1;
            for (int j=0; j < activities.size(); j++) {
                Activity a = activities.get(j);
                if (a.getStart() >= lastC) {
                    lastC = a.getEnd();
                    a.setAssignee('C');
                } else if (a.getStart() >= lastJ){
                    lastJ = a.getEnd();
                    a.setAssignee('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i);
                continue;
            }

            activities.sort(Comparator.comparingInt(Activity::getNumber));

            StringBuilder sb = new StringBuilder();
            for (int j=0; j < activities.size(); j++) {
                sb.append(activities.get(j).getAssignee());
            }
            System.out.printf("Case #%d: %s%n", i, sb.toString());
        }
    }

    static class Activity {
        private int start;
        private int end;
        private int number;
        private char assignee;

        public Activity(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        public int getNumber() {
            return number;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public char getAssignee() {
            return assignee;
        }

        public void setAssignee(char assignee) {
            this.assignee = assignee;
        }
    }
}

