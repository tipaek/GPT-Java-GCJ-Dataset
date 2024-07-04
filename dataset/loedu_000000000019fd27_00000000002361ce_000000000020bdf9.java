import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(getReader());

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            int numberOfActivities = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int j=0; j < numberOfActivities; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), j + 1));
            }

            String s = in.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + processCase(activities));
        }

    }

    private String processCase(List<Activity> activities) {
        Collections.sort(activities);
        final Person c = new Person('C');
        final Person j = new Person('J');

        for (Activity activity : activities) {
            if (!c.busy(activity.getStart())) {
                c.setStart(activity.getStart());
                c.setEnd(activity.getEnd());
                activity.setWho(c);
            } else if (!j.busy(activity.getStart())) {
                j.setStart(activity.getStart());
                j.setEnd(activity.getEnd());
                activity.setWho(j);
            } else {
                return "IMPOSSIBLE";
            }
        }

        activities.sort((a1, a2) -> a1.getSequential() - a2.getSequential());

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getWho().getName());
        }
        return result.toString();
    }


    private InputStreamReader getReader() throws IOException {
        return new InputStreamReader(System.in);
        // return new InputStreamReader(getClass().getClassLoader().getResourceAsStream("activities.txt"));
    }

    class Person {
        private final char name;
        private int start;
        private int end;

        public Person(char name) {
            this.name = name;
        }

        public boolean busy(int when) {
            return when > getStart() && when <= getEnd();
        }

        public char getName() {
            return name;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

    }

    class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;
        private final int sequential;
        private Person who;

        public Activity(int start, int end, int sequential) {
            this.start = start;
            this.end = end;
            this.sequential = sequential;
        }

        public boolean overlaps(Activity other) {
            return getStart() >= other.getStart() && getStart() <= other.getEnd();
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getSequential() {
            return sequential;
        }

        public Person getWho() {
            return who;
        }

        public void setWho(Person who) {
            this.who = who;
        }


        @Override
        public int compareTo(Activity o) {
            return getStart() - o.getStart();
        }
    }
}