import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int kase = 1; kase <= t; ++kase) {
            int N = in.nextInt();

            char currentPerson = 'J';
            char nextPerson = 'C';

            List<Integer[]> jamie = new ArrayList<>(N);
            List<Integer[]> cameron = new ArrayList<>(N);

            Map<Character, List<Integer[]>> activities = new HashMap<>();
            activities.put('J', jamie);
            activities.put('C', cameron);

            StringBuilder ans = new StringBuilder();

            boolean skipProcessing = false;

            for (int i = 0; i < N; i++) {
                Integer[] activity = new Integer[] {in.nextInt(), in.nextInt()};

                if (!skipProcessing) {
                    boolean currentConflict = processConflict(activities.get(currentPerson), activity);

                    if (!currentConflict) {
                        activities.get(currentPerson).add(activity);
                        ans.append(currentPerson);
                    } else {
                        boolean nextConflict = processConflict(activities.get(nextPerson), activity);

                        if (!nextConflict) {
                            activities.get(nextPerson).add(activity);
                            ans.append(nextPerson);

                            char tmp = currentPerson;
                            currentPerson = nextPerson;
                            nextPerson = tmp;
                        } else {
                            ans = new StringBuilder();
                            ans.append("IMPOSSIBLE");
                            skipProcessing = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + kase + ": " + ans.toString());
        }
    }

    private static boolean processConflict(final List<Integer[]> activities, final Integer[] activity) {
        boolean conflict = false;

        for (Integer[] act : activities) {
            if ((act[1] > activity[0] && act[1] < activity[1]) || (activity[1] > act[0] && activity[1] < act[1])) {
                conflict = true;
                break;
            }
        }

        return conflict;
    }
}