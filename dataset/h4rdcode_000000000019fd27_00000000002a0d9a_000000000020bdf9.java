import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            String answer = "";

            int[] j = new int[24 * 60];
            int[] c = new int[24 * 60];

            int[] check = new int[24 * 60];
            for (Activity activity : activities) {
                for (int k = activity.getS(); k < activity.getE(); k++) {
                    check[k] = check[k] + 1;
                }
            }

            activities.sort(Comparator.comparingInt(Activity::getS));
            for (int k = 0; k < 24 * 60; k++) {
                if (check[k] > 2) {
                    answer = "IMPOSSIBLE";
                }
            }
            List<String> roles = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                roles.add("J");
            }
            for (int k = 0; k < n && !answer.equals("IMPOSSIBLE"); k++) {
                Activity currentActivity = activities.get(k);
                boolean flag = true;
                for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                    flag = flag && (j[l] == 0);
                }
                if (flag) {
                    roles.set(currentActivity.pos, "J");
                    for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                        j[l] = 1;
                    }
                } else {
                    flag = true;
                    for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                        flag = flag && (c[l] == 0);
                    }
                    if (flag) {
                        roles.set(currentActivity.pos, "C");
                        for (int l = currentActivity.getS(); l < currentActivity.getE(); l++) {
                            c[l] = 1;
                        }
                    } else {
                        answer = "IMPOSSIBLE";
                    }
                }
            }
            
            System.out.println(String.format("Case #%d: %s", i + 1, answer.equals("IMPOSSIBLE") ? "IMPOSSIBLE" :
                    roles.stream().map(q -> "" + q).reduce((a, b) -> a + b).get()));
        }
    }
    private static class Activity {
        private int s, e, pos;

        Activity(int s, int e, int pos) {
            this.s = s;
            this.e = e;
            this.pos = pos;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }

        public int getPos() {
            return pos;
        }
    }
}

