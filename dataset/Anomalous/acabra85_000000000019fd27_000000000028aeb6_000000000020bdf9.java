import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    private static final String RESULT = "%sCase #%d: %s";
    private final Helper helper;

    static class Helper {
        private final BufferedReader reader;
        private final PrintWriter writer;
        private StringTokenizer tokenizer;

        public Helper(BufferedReader reader, PrintWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        private String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public void close() throws IOException {
            reader.close();
            writer.flush();
        }
    }

    public static Solution ofConsole() {
        return new Solution(System.in, new OutputStreamWriter(System.out));
    }

    public static Solution ofTestFile(String fileName) {
        InputStream resourceStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceStream, new OutputStreamWriter(System.out));
    }

    public Solution(InputStream input, OutputStreamWriter output) {
        this.helper = new Helper(new BufferedReader(new InputStreamReader(input)), new PrintWriter(output));
    }

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).process();
    }

    public void process() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = solveCase(buildActivities(helper));
            helper.writer.printf(RESULT, i == 1 ? "" : "\n", i, result);
            helper.writer.flush();
        }
        helper.close();
    }

    private PriorityQueue<Activity> buildActivities(Helper helper) throws IOException {
        int n = helper.nextInt();
        PriorityQueue<Activity> activities = new PriorityQueue<>(Activity.BY_START);
        for (int i = 0; i < n; i++) {
            activities.offer(Activity.of(helper.nextInt(), helper.nextInt(), i));
        }
        return activities;
    }

    protected static String solveCase(PriorityQueue<Activity> activities) {
        Parent jamie = new Parent('C');
        Parent cameron = new Parent('J');
        PriorityQueue<Activity> assigned = new PriorityQueue<>(Activity.BY_ID);

        while (!activities.isEmpty()) {
            Activity activity = activities.poll();
            int currentTime = activity.start;

            if (jamie.isAvailable(currentTime)) {
                jamie.assign(activity);
            } else if (cameron.isAvailable(currentTime)) {
                cameron.assign(activity);
            } else {
                return "IMPOSSIBLE";
            }

            assigned.offer(activity);
        }

        return buildSchedule(assigned);
    }

    private static String buildSchedule(PriorityQueue<Activity> assigned) {
        StringBuilder schedule = new StringBuilder();
        while (!assigned.isEmpty()) {
            schedule.append(assigned.poll().resolvedBy);
        }
        return schedule.toString();
    }

    static class Parent {
        private final char name;
        private Activity currentActivity;

        public Parent(char name) {
            this.name = name;
        }

        public void assign(Activity activity) {
            if (isBusy(activity.start)) {
                throw new IllegalStateException("Cannot assign activity when the parent is busy.");
            }
            currentActivity = activity;
            activity.resolve(this);
        }

        public boolean isBusy(int time) {
            return currentActivity != null && currentActivity.start <= time && time < currentActivity.end;
        }

        public boolean isAvailable(int time) {
            return !isBusy(time);
        }
    }

    static class Activity {
        private final int start;
        private final int end;
        private final int id;
        private char resolvedBy = '\0';

        public static final Comparator<Activity> BY_START = Comparator.comparingInt(a -> a.start);
        public static final Comparator<Activity> BY_ID = Comparator.comparingInt(a -> a.id);

        private Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public static Activity of(int start, int end, int id) {
            return new Activity(start, end, id);
        }

        public void resolve(Parent parent) {
            this.resolvedBy = parent.name;
        }

        @Override
        public String toString() {
            return String.format("{start:%d, end:%d, id:%d, resolvedBy:%s}", start, end, id, resolvedBy == '\0' ? "_" : resolvedBy);
        }
    }
}