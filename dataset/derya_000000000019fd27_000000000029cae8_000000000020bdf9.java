import java.util.*;
import java.io.*;

public class Solution {
    private static PrintStream o = System.out;

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = Integer.parseInt(in.nextLine());

        for (int testCaseIdx = 0; testCaseIdx < T; ++testCaseIdx) {
            final int numActivities = Integer.parseInt(in.nextLine());

            Action[] actionsForOutput = new Action[numActivities];
            Action[] actions = new Action[numActivities * 2];

            for (int i = 0; i < numActivities; i++) {
                String[] line = in.nextLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);

                actions[i * 2] = new Action(start, null);
                actionsForOutput[i] = actions[i * 2];
                actions[(i * 2) + 1] = new Action(end, actions[i * 2]);
            }

            Arrays.sort(actions, (action1, action2) -> {
                if (action1.timestamp == action2.timestamp) {
                    if (action1.isStart() && !action2.isStart()) {
                        return 1;
                    } else if (!action1.isStart() && action2.isStart()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    return action1.timestamp - action2.timestamp;
                }
            });

            boolean impossible = false;
            Action CameronJob = null;
            Action JamieJob = null;

            for (Action action : actions) {
                if (action.isStart()) {
                    if (CameronJob == null) {
                        CameronJob = action;
                        action.assignment = 'C';
                    } else if (JamieJob == null) {
                        JamieJob = action;
                        action.assignment = 'J';
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (action.ref == CameronJob) {
                        CameronJob = null;
                    } else if (action.ref == JamieJob) {
                        JamieJob = null;
                    } else {
                        throw new RuntimeException("AAAA");
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (Action action : actionsForOutput) {
                output.append(action.assignment);
            }

            o.printf("Case #%d: ", testCaseIdx + 1);
            o.printf("%s", impossible ? "IMPOSSIBLE" : output.toString());
            o.printf("%n");
        }
    }

    static class Action {
        final int timestamp;
        final Action ref;
        char assignment;

        Action(int timestamp, Action ref) {
            this.timestamp = timestamp;
            this.ref = ref;
        }

        boolean isStart() {
            return ref == null;
        }
    }
}
