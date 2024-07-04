import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                activities.add(new Activity(i, sc.nextInt(), sc.nextInt()));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            List<Activity> C = new ArrayList<>();
            List<Activity> J = new ArrayList<>();

            boolean impossible = false;
            for (Activity act : activities) {
                if (C.isEmpty() || C.get(C.size() - 1).end <= act.start) {
                    C.add(act);
                } else if (J.isEmpty() || J.get(J.size() - 1).end <= act.start) {
                    J.add(act);
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                StringBuilder output = new StringBuilder(new String(new char[N]).replace('\0', ' '));
                for (Activity act : C) {
                    output.setCharAt(act.id, 'C');
                }
                for (Activity act : J) {
                    output.setCharAt(act.id, 'J');
                }
                System.out.println("Case #" + testCase + ": " + output);
            }
        }
    }

    static class Activity {
        int id;
        int start;
        int end;

        Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}