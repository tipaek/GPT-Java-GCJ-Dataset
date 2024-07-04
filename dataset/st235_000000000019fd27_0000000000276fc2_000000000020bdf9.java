import java.io.BufferedInputStream;
import java.util.*;

class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';
    private static final int ADD = 0;
    private static final int REMOVE = 1;

    static class Activity {
        final int id;
        final int start;
        final int finish;

        Activity(int id, int start, int finish) {
            this.id = id;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return id == activity.id &&
                    start == activity.start &&
                    finish == activity.finish;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, start, finish);
        }
    }

    static class Command implements Comparable<Command> {
        final int type;
        final Activity activity;

        public Command(int type, Activity activity) {
            this.type = type;
            this.activity = activity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Command command = (Command) o;
            return type == command.type &&
                    Objects.equals(activity, command.activity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, activity);
        }

        @Override
        public int compareTo(Command o) {
            return -Integer.compare(type, o.type);
        }
    }

    static class AvailabilitySemaphore {
        private boolean isCameronAvailable = true;
        private boolean isJamieAvailable = true;

        char assign() {
            if (isCameronAvailable) {
                isCameronAvailable = false;
                return CAMERON;
            }

            if (isJamieAvailable) {
                isJamieAvailable = false;
                return JAMIE;
            }

            throw new IllegalStateException("Everybody assigned");
        }

        void release(char asignee) {
            if (asignee == CAMERON) {
                isCameronAvailable = true;
            } else if (asignee == JAMIE) {
                isJamieAvailable = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();

                activities.add(new Activity(j, start, finish));
            }

            System.out.printf("Case #%d: %s\n", (i + 1), solve(activities));
        }
    }

    private static String solve(List<Activity> activities) {
        AvailabilitySemaphore availabilitySemaphore = new AvailabilitySemaphore();
        TreeMap<Integer, ArrayList<Command>> lookup = new TreeMap<>();
        Map<Integer, Character> assignes = new HashMap<>();

        for (Activity activity: activities) {
            ArrayList<Command> startCommands = lookup.getOrDefault(activity.start, new ArrayList<>());
            startCommands.add(new Command(ADD, activity));
            lookup.put(activity.start, startCommands);

            ArrayList<Command> endCommands = lookup.getOrDefault(activity.finish, new ArrayList<>());
            endCommands.add(new Command(REMOVE, activity));
            lookup.put(activity.finish, endCommands);
        }

        Set<Activity> balance = new HashSet<>();

        for (Map.Entry<Integer, ArrayList<Command>> entry: lookup.entrySet()) {

            List<Command> commands = entry.getValue();
            Collections.sort(commands);

            for (Command command: commands) {
                if (command.type == ADD) {
                    balance.add(command.activity);
                } else if (command.type == REMOVE) {
                    balance.remove(command.activity);
                    availabilitySemaphore.release(assignes.get(command.activity.id));
                }
            }

            if (balance.size() >= 3) {
                return IMPOSSIBLE;
            }

            for (Activity activity: balance) {
                if (assignes.containsKey(activity.id)) {
                    continue;
                }

                assignes.put(activity.id, availabilitySemaphore.assign());
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Activity activity: activities) {
            builder.append(assignes.get(activity.id));
        }

        return builder.toString();
    }
}