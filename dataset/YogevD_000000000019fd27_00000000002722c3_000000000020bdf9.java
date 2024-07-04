import java.util.*;

class Activity {
    int start;
    int end;
    Character c;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList();
            int[] s = new int[N];
            int[] e = new int[N];
            Map<Integer, List<Integer>> endByStartTime = new HashMap<>();

            for (int i = 0; i < N; i++) {
                s[i] = scanner.nextInt();
                e[i] = scanner.nextInt();

                List<Integer> list = endByStartTime.get(s[i]);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(e[i]);
                endByStartTime.put(s[i], list);
                activities.add(new Activity(s[i], e[i]));
            }

            endByStartTime.forEach((key, list) -> Collections.sort(list));

            Arrays.sort(s);
            Arrays.sort(e);

            System.out.print("Case #" + (t + 1) + ": ");
            try {
                nestingDepth(s, e, endByStartTime, activities);
                activities.forEach(a -> System.out.print(a.c));
                System.out.println();
            } catch (Exception ex) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }


    private static void nestingDepth(int[] s, int[] e, Map<Integer, List<Integer>> map, List<Activity> list) {
        int sIndex = 0;
        int eIndex = 0;

        int cEnd = -1;
        int jEnd = -1;

        while (sIndex < s.length) {
            if (s[sIndex] <= e[eIndex]) {
                if (cEnd < 0 || cEnd <= s[sIndex]) {
                    List<Integer> endTimeList = map.get(s[sIndex]);
                    cEnd = endTimeList.remove(0);
                    Activity activity = findActivity(list, s[sIndex], cEnd);
                    activity.c = 'C';
                } else if (jEnd < 0 || jEnd <= s[sIndex]) {
                    List<Integer> endTimeList = map.get(s[sIndex]);
                    jEnd = endTimeList.remove(0);
                    Activity activity = findActivity(list, s[sIndex], jEnd);
                    activity.c = 'J';
                } else {
                    throw new RuntimeException();
                }
                sIndex++;
            } else {
                eIndex++;
                if (cEnd > jEnd) {
                    jEnd = -1;
                } else {
                    cEnd = -1;
                }
            }
        }
    }

    private static Activity findActivity(List<Activity> list, int s, int e) {
        for (Activity activity : list) {
            if (activity.start == s && activity.end == e) {
                return activity;
            }
        }
        return null;
    }
}