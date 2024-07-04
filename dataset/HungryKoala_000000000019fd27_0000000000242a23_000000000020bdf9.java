import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static boolean[] visited;
    private static char[] assign;
    private static boolean possible;

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();
        in.nextLine();

        for (int x = 1; x <= T; ++x) {
            final int N = in.nextInt();
            assign = new char[N + 1];
            final Activity[] activities = new Activity[N + 1];
            for (int i = 1; i <= N; ++i) {
                activities[i] = new Activity(i, in.nextInt(), in.nextInt());
                assign[i] = '-';
            }

            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (i < j && overlap(activities[i], activities[j])) {
                        activities[i].addChild(activities[j]);
                        activities[j].addChild(activities[i]);
                    }
                }
            }

            possible = true;
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; ++i) {
                if (!visited[i]) {
                    dfs(activities[i], null);
                }
            }

            String answer = null;
            if (!possible) {
                answer = "IMPOSSIBLE";
            } else {
                answer = String.valueOf(assign).substring(1);
            }

            System.out.println("Case #" + x + ": " + answer);
            System.out.flush();
        }
    }

    private static void dfs(final Activity current, final Activity parent) {
        visited[current.number] = true;

        if (parent == null) {
            assign[current.number] = 'C';
        } else {
            if (assign[current.number] == '-') {
                assign[current.number] = (assign[parent.number] == 'C') ? 'J' : 'C';
            } else {
                if (parent != null && assign[parent.number] != '-' && assign[current.number] == assign[parent.number]) {
                    possible = false;
                    return;
                }
            }
        }

        for (Activity child : current.children) {
            if (!visited[child.number]) {
                dfs(child, current);
            } else {
                if (assign[current.number] == assign[child.number]) {
                    possible = false;
                    return;
                }
            }
        }
    }

    private static boolean overlap(final Activity a, final Activity b) {
        if (a.end <= b.start) {
            return false;
        }
        if (b.end <= a.start) {
            return  false;
        }
        return true;
    }

    private static final class Activity {

        private final int number;
        private final int start;
        private final int end;

        private final List<Activity> children;

        public Activity(final int number, final int start, final int end) {
            this.number = number;
            this.start = start;
            this.end = end;
            this.children = new ArrayList<>();
        }

        public void addChild(final Activity child) {
            children.add(child);
        }
    }
}
