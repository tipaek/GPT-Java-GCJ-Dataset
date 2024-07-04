import java.util.*;

class Solution {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            System.out.printf("Case #%d: %s\n", i, solve(activities));
        }
    }

    static boolean isImpossible(List<Activity> activities) {
        List<Integer> limits = new ArrayList<>();
        for (Activity a : activities) {
            limits.add(a.start);
            limits.add(a.end);
        }
        Collections.sort(limits);

        Map<Activity, Integer> count = new HashMap<>();

        for (int i = 0; i < limits.size() - 1; i++) {
            Activity partial = new Activity(limits.get(i), limits.get(i + 1));

            for (Activity a : activities) {
                if (overlap(a, partial)) {
                    count.put(partial, count.getOrDefault(partial, 0) + 1);
                    if (count.get(partial) == 3) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static String solve(List<Activity> activities) {
        if (isImpossible(activities)) {
            return "IMPOSSIBLE";
        }
        for (Activity a : activities) {
            if (a.owner != '?') {
                continue;
            }
            List<Activity> overlapping = findOverlapping(a, activities);
            if (overlapping.size() == 1) {
                overlapping.get(0).owner = 'J';
            }
            a.owner = 'C';
        }
        StringBuilder result = new StringBuilder();
        for (Activity a : activities) {
            result.append(a.owner);
        }
        return result.toString();
    }

    static List<Activity> findOverlapping(Activity a, List<Activity> activities) {
        List<Activity> overlapping = new ArrayList<>();
        for (Activity b : activities) {
            if (a != b && overlap(a, b)) {
                overlapping.add(b);
            }
        }
        return overlapping;
    }

    static boolean overlap(Activity a, Activity b) {
        return a != b && (a.overlapsWith(b) || b.overlapsWith(a));
    }
}

class Activity {
    int start;
    int end;
    char owner = '?';

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean overlapsWith(Activity other) {
        return other != this && ((other.start < start && start < other.end) || (other.start < end && end < other.end));
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", start, end);
    }
}