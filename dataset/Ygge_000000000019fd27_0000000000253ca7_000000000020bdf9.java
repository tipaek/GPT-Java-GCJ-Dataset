import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int c = 1; c <= cases; ++c) {
            int n = Integer.parseInt(in.readLine());
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                activities.add(new Activity(i, in.readLine()));
            }
            Collections.sort(activities);
            final State state = new State();
            activities.get(0).w = 'C';
            state.cEnd = activities.get(0).end;
            state.index = 1;
            if (calc(state, activities)) {
                char[] chars = new char[activities.size()];
                for (Activity activity : activities) {
                    chars[activity.index] = activity.w;
                }
                System.out.printf("Case #%d: %s\n", c, new String(chars));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", c);
            }
        }
    }

    private static boolean calc(State state, List<Activity> activities) {
        if (state.index == activities.size()) {
            return true;
        }
        Activity a = activities.get(state.index);
        if (a.start >= state.cEnd) {
            a.w = 'C';
            if (calc(new State(state, a.end, state.jEnd), activities)) {
                return true;
            }
        }
        if (a.start >= state.jEnd) {
            a.w = 'J';
            if (calc(new State(state, state.cEnd, a.end), activities)) {
                return true;
            }
        }
        return false;
    }

    private static class State {
        int cEnd, jEnd, index;

        State() {
            cEnd = 0;
            jEnd = 0;
            index = 0;
        }

        State(State state, int cEnd, int jEnd) {
            this.cEnd = cEnd;
            this.jEnd = jEnd;
            this.index = state.index + 1;
        }
    }

    private static class Activity implements Comparable<Activity> {
        private int index, start, end;
        private char w;

        Activity(int index, String row) {
            this.index = index;
            final String[] s = row.split(" ");
            start = Integer.parseInt(s[0]);
            end = Integer.parseInt(s[1]);
        }

        @Override
        public int compareTo(Activity o) {
            return start-o.start;
        }
    }
}
