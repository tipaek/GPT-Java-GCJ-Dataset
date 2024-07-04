import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }
            String answer = "";
            int[] j = new int[24 * 60];
            int[] c = new int[24 * 60];

            for (int k = 0; k < n && !answer.equals("IMPOSSIBLE"); k++) {
                Activity currentActivity = activities.get(k);
                boolean flag = true;
                for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                    flag = flag && (j[l] == 0);
                }
                if (flag) {
                    answer += 'J';
                    for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                        j[l] = 1;
                    }
                } else {
                    flag = true;
                    for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                        flag = flag && (c[l] == 0);
                    }
                    if (flag) {
                        answer += 'C';
                        for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                            c[l] = 1;
                        }
                    } else {
                        answer = "IMPOSSIBLE";
                    }

                }
            }
            System.out.println(String.format("Case #%d: %s", i + 1, answer));
        }
    }
    private static class Activity {
        private int s, e;

        Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }
    }
}

