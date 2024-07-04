import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                activities[j] = new Activity(sc.nextInt(), sc.nextInt());
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static String assignActivities(Activity[] activities) {
        StringBuilder result = new StringBuilder();
        boolean conflict = false;
        for (int j = 0; j < activities.length; j++) {
            if (j == 0) {
                result.append(assignNextParent(result, true));
            } else {
                if (!conflict) {
                    if (activities[j].s >= activities[j - 1].e) {
                        result.append(assignNextParent(result, true));
                    } else {
                        result.append(assignNextParent(result, false));
                        conflict = true;
                    }
                } else {
                    if (activities[j].s >= activities[j - 1].e) {
                        result.append(assignNextParent(result, true));
                        conflict = false;
                    } else {
                        if (j == 1 || activities[j].s >= activities[j - 2].e) {
                            result.append(assignNextParent(result, false));
                        } else {
                            return "IMPOSSIBLE";
                        }
                    }
                }
            }
        }
        return result.toString();
    }

    public static String assignNextParent(StringBuilder result, boolean same) {
        if (result.length() == 0) {
            return "C";
        }
        char lastChar = result.charAt(result.length() - 1);
        return same ? Character.toString(lastChar) : (lastChar == 'J' ? "C" : "J");
    }

    public static class Activity {
        int s;
        int e;

        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}