
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = scanner.nextInt();

        for (int c = 0; c < inputCount; c++) {
            int N = scanner.nextInt();

            System.out.print("Case #" + (c + 1) + ":");

            List<Action> actions = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                actions.add(new Action(i, scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(actions, new Comparator<Action>() {
                @Override
                public int compare(Action o1, Action o2) {
                    return o1.startTime.compareTo(o2.startTime);
                }
            });

            int cIndex = -1;
            int jIndex = -1;

            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            for (int i = 0; i < actions.size(); i++) {
                Action action = actions.get(i);

                if (cIndex != -1) {
                    Action cAction = actions.get(cIndex);
                    if (cAction.endTime <= action.startTime) {
                        cIndex = -1;
                    }
                }
                if (jIndex != -1) {
                    Action jAction = actions.get(jIndex);
                    if (jAction.endTime <= action.startTime) {
                        jIndex = -1;
                    }
                }

                if (cIndex == -1) {
                    cIndex = i;
                    action.assignedTo = "C";
                } else if (jIndex == -1) {
                    jIndex = i;
                    action.assignedTo = "J";
                } else {
                    sb = new StringBuilder();
                    sb.append(" IMPOSSIBLE");
                    break;
                }
            }

            if (!sb.toString().contains("IMPOSSIBLE")) {
                Collections.sort(actions, new Comparator<Action>() {
                    @Override
                    public int compare(Action o1, Action o2) {
                        return o1.actionIndex.compareTo(o2.actionIndex);
                    }
                });

                for (Action a : actions) {
                    sb.append(a.assignedTo);
                }
            }


            System.out.println(sb.toString());
        }

    }


    private static class Action {
        private final Integer actionIndex;
        private final Integer startTime;
        private final Integer endTime;
        private String assignedTo;

        public Action(int actionIndex, int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.actionIndex = actionIndex;
        }

    }
}
