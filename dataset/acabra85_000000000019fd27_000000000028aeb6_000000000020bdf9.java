
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
        private final static String RESULT = "%sCase #%d: %s";

        private final Solution.Help help;

        static class Help {
            final BufferedReader bf;
            final PrintWriter out;
            StringTokenizer tokenizer;

            public Help(BufferedReader bf, PrintWriter out) {
                this.bf = bf;
                this.out = out;
            }

            public int nInt() throws IOException {
                return Integer.parseInt(next());
            }

            public long nLong() throws IOException {
                return Long.parseLong(next());
            }

            public double nDouble() throws IOException {
                return Double.parseDouble(next());
            }

            String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(bf.readLine());
                }
                return tokenizer.nextToken();
            }

            public void close() throws IOException {
                bf.close();
                out.flush();
            }
        }

        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }

        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }

        public void read() throws Exception {
            int testCases = help.nInt();
            for (int i = 1; i <= testCases; i++) {
                String result = solveCase(buildActivities(help));
                help.out.printf(RESULT, i == 1 ? "" : "\n", i, result);
                help.out.flush();
            }
            help.close();
        }

        private PriorityQueue<Activity> buildActivities(Help help) throws IOException {
            int n = help.nInt();
            PriorityQueue<Activity> activities = new PriorityQueue<>(Activity.ACTIVITY_COMPARATOR_BY_START);
            for (int i = 0; i < n; i++) {
                activities.offer(Activity.of(help.nInt(), help.nInt(), i));
            }
            return activities;
        }

        protected static String solveCase(PriorityQueue<Activity> activities) {
            Parent jamie = new Parent('C');
            Parent cameron = new Parent('J');
            Activity activity;
            PriorityQueue<Activity> assigned = new PriorityQueue<>(Activity.ACTIVITY_COMPARATOR_BY_ID);
            while (!activities.isEmpty()) {
                activity = activities.remove();
                int now = activity.start;
                if (jamie.isAvailable(now)) {
                    jamie.assignActivity(activity);
                } else if (cameron.isAvailable(now)) {
                    cameron.assignActivity(activity);
                } else {
                    return "IMPOSSIBLE";
                }
                assigned.offer(activity);
            }
            return buildSchedule(assigned);
        }

        private static String buildSchedule(PriorityQueue<Activity> assigned) {
            StringBuilder sb = new StringBuilder();
            while(!assigned.isEmpty()) {
                sb.append(assigned.remove().resolvedBy);
            }
            //System.out.println(sb.toString());
            return sb.toString();
        }

        static class Parent {
            final char name;

            Activity current = null;

            Parent(char name) {
                this.name = name;
            }

            public void assignActivity(Activity activity) {
                if (isBusy(activity.start)) {
                    throw new RuntimeException("can't assign activity when the person is busy");
                }
                current = activity;
                activity.resolve(this);
            }

            public boolean isBusy(int time) {
                if (null == current) {
                    return false;
                }
                return current.start <= time && time < current.end;
            }

            public boolean isAvailable(int time) {
                return !isBusy(time);
            }
        }

        static class Activity {
            final int start, end, id;
            private char resolvedBy = '\0';


            final static Comparator<Activity> ACTIVITY_COMPARATOR_BY_START = new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    return Integer.compare(o1.start, o2.start);
                }
            };

            final static Comparator<Activity> ACTIVITY_COMPARATOR_BY_ID = new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    return Integer.compare(o1.id, o2.id);
                }
            };

            private Activity(int start, int end, int id) {
                this.start = start;
                this.end = end;
                this.id = id;
            }

            public static Activity of(int s, int e, int id) {
                return new Activity(s, e, id);
            }

            public void resolve(Parent parent) {
                this.resolvedBy = parent.name;
            }

            @Override
            public String toString() {
                return String.format("{s:%d e:%d id:%d r:%s}", start, end, id, resolvedBy == '\0' ? '_' : resolvedBy);
            }
        }
    }