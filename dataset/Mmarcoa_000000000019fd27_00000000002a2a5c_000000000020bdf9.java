import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Pair<K, V> {

        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    /**
     * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
     * and y is IMPOSSIBLE if there is no valid schedule according to the above rules, or a string of exactly N
     * characters otherwise. The i-th character in y must be C if the i-th activity is assigned to Cameron in your
     * proposed schedule, and J if it is assigned to Jamie.
     * <p>
     * If there are multiple solutions, you may output any one of them.
     * <p>
     * Sample input
     * 4
     * 3
     * 360 480
     * 420 540
     * 600 660
     * 3
     * 0 1440
     * 1 3
     * 2 4
     * 5
     * 99 150
     * 1 100
     * 100 301
     * 2 5
     * 150 250
     * 2
     * 0 720
     * 720 1440
     * <p>
     * Sample output
     * Case #1: CJC
     * Case #2: IMPOSSIBLE
     * Case #3: JCCJJ
     * Case #4: CC
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Number of test cases.

        for (int i = 0; i < t; ++i) {

            int n = in.nextInt(); // Number of activities to assign.

            List<Pair<Integer, Integer>> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities.add(new Pair<>(s, e));
            }


            StringBuilder builder = new StringBuilder();
            String result;

            List<Pair<Integer, Integer>> jActivities = new ArrayList<>();
            List<Pair<Integer, Integer>> cActivities = new ArrayList<>();

            boolean jOverlaps;
            boolean cOverlaps = false;

            checkActivities:
            for (Pair<Integer, Integer> activity : activities) {

                jOverlaps = false;

                for (Pair<Integer, Integer> jActivity : jActivities) {
                    if (overlaps(activity, jActivity)) {
                        jOverlaps = true;
                        break;
                    }
                }

                cOverlaps = false;
                if (jOverlaps) {
                    for (Pair<Integer, Integer> cActivity : cActivities) {
                        if (overlaps(activity, cActivity)) {
                            cOverlaps = true;
                            break checkActivities;
                        }
                    }
                    cActivities.add(activity);
                    builder.append("C");
                } else {
                    jActivities.add(activity);
                    builder.append("J");
                }
            }

            if (cOverlaps)
                result = "IMPOSSIBLE";
            else
                result = builder.toString();

            System.out.printf("Case #%d: %s\n", i + 1, result);
        }

        in.close();
    }

    private static boolean overlaps(Pair<Integer, Integer> activity, Pair<Integer, Integer> partnerActivity) {
        boolean overlaps = false;

        int s1 = activity.getKey();
        int s2 = partnerActivity.getKey();
        int e1 = activity.getValue();
        int e2 = partnerActivity.getValue();

        if ((s2 <= s1 && s1 < e2) || (s1 <= s2 && s2 < e1)) {
            overlaps = true;
        }

        return overlaps;
    }
}
