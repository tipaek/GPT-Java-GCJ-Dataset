import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int a = 0; a < T; a++) {
            int N = scan.nextInt();
            StringBuilder ans = new StringBuilder();
            boolean possible = true;
            List<Activity> listC = new ArrayList<>();
            List<Activity> listJ = new ArrayList<>();
            List<Activity> wholeList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                wholeList.add(new Activity(start, end));
            }

            for (int i = 0; i < wholeList.size(); i++) {
                if (!possible) continue;
                Activity act = wholeList.get(i);

                if (i == 0) {
                    listC.add(act);
                    ans.append("C");
                } else {
                    if (activityOverlaps(act, listC)) {
                        if (listJ.isEmpty()) {
                            listJ.add(act);
                            ans.append("J");
                        } else {
                            if (activityOverlaps(act, listJ)) {
                                possible = false;
                            } else {
                                listJ.add(act);
                                ans.append("J");
                            }
                        }
                    } else {
                        listC.add(act);
                        ans.append("C");
                    }
                }
            }
            System.out.print("Case #" + (a + 1) + ": ");
            System.out.println(possible ? ans.toString() : "IMPOSSIBLE");
        }
    }

    public boolean activityOverlaps(Activity a, List<Activity> list) {
        for (Activity activity : list) {
            if (a.overlap(activity)) return true;
        }
        return false;
    }

    class Activity {
        private final int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlap(Activity act) {
            return (act.start < end && act.start >= start) || (start < act.end && start >= act.start);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}