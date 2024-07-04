import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            for (int j = 0; j < N; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt(), j);
            }
            String res = solve(activities);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static String solve(Activity[] activities) {
        String res = "";
        ArrayList<Activity> C = new ArrayList<>(), J = new ArrayList<>();
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return Integer.compare(a1.s, a2.s);
            }
        });
        if (activities.length == 1) { return "C"; } else if (activities.length == 2) {return "CJ";}

        for (int i = 2; i < activities.length; i++) {
            if (isIntersects(activities[i - 2], activities[i - 1], activities[i])) {
                return "IMPOSSIBLE";
            }
        }
        for (int i = 0; i < activities.length; i++) {
            if (isGood(activities[i], C)) {
                C.add(activities[i]);
            } else if (isGood(activities[i], J)) {
                J.add(activities[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }
        Collections.sort(C, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return Integer.compare(a1.index, a2.index);
            }
        });
        boolean[] isC = new boolean[activities.length];
        for (int i = 0; i < C.size(); i++) {
            isC[C.get(i).index] = true;
        }
        for (int i = 0; i < isC.length; i++) {
            res += isC[i] ? "C" : "J";
        }
        return res;
    }

    public static boolean isGood(Activity a, ArrayList<Activity> list) {
        for (int i = 0; i < list.size(); i++) {
            if (isIntersects(list.get(i), a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIntersects(Activity a1, Activity a2) {
        return a2.s < a1.e;
    }

    public static boolean isIntersects(Activity a1, Activity a2, Activity a3) {
        return a2.s < a1.e && a3.s < a1.e && a3.s < a2.e;
    }
}

class Activity {
    int s, e, index;
    public Activity(int s, int e, int index) {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "s=" + s +
                ", e=" + e +
                ", index=" + index +
                '}';
    }
}
