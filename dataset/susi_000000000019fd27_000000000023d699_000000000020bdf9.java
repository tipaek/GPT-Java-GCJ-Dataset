
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= cases; i++) {
            int N = Integer.parseInt(input.nextLine());
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] se = input.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(se[0]);
                activities[j][1] = Integer.parseInt(se[1]);
            }
            System.out.println("Case #" + i + ": " + schedule(N, activities));
        }
    }

    private static String schedule(int N, int[][] activities) {
        List<Activity> acts = new ArrayList<>();
        for (int i = 0; i < activities.length; i++) {
            int[] act = activities[i];
            acts.add(new Activity(act[0], act[1], i));
        }
        acts.sort(Comparator.comparingInt(a -> a.start));

        int nextC = -1;
        int nextJ = -1;

        char[] result = new char[N];
        for (int i = 0; i < acts.size(); i++) {
            Activity act = acts.get(i);
            if (act.start >= nextC) {
                result[act.idx] = 'C';
                nextC = act.end;
            } else if (act.start >= nextJ) {
                result[act.idx] = 'J';
                nextJ = act.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(result[i]);
        }
        return builder.toString();
    }

    private static class Activity {
        int start;
        int end;
        int idx;
        public Activity(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
}