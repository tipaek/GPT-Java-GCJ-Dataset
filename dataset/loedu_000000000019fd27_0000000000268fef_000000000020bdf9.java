import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final String PROPERTY_USE_LOCAL_FILE = "use-local-file";

    final Person c;
    final Person j;
    Properties config;

    public Solution(Person c, Person j) {
        this.c = c;
        this.j = j;

        loadProperties();
    }

    private void loadProperties() {
        config = new Properties();

        InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");

        if (in != null) {
            try {
                config.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            config.setProperty(PROPERTY_USE_LOCAL_FILE, "false");
        }
    }

    public static void main(String[] args) throws Exception {
        final Person c = new Person('C');
        final Person j = new Person('J');

        new Solution(c, j).run();
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
        resetPersonsActivities();
        Collections.sort(activities);

        try {
            processActivities(activities);
        } catch (Exception e) {
            return "IMPOSSIBLE";
        }

        return getResultFromActivities(activities);
    }

    private void resetPersonsActivities() {
        c.resetActivities();
        j.resetActivities();
    }

    private void processActivities(List<Activity> activities) throws Exception {
        for (Activity activity : activities) {
            Optional<Person> p = findAvailablePerson(activity);
            if (!p.isPresent()) {
                throw new Exception("Impossible to schedule.");
            }

            establishActivityProperties(activity, p.get());
        }
    }

    private Optional<Person> findAvailablePerson(Activity activity) {
        if (c.free(activity.getStart())) {
            return Optional.of(c);
        } else if (j.free(activity.getStart())) {
            return Optional.of(j);
        }

        return Optional.empty();
    }

    private void establishActivityProperties(Activity activity, Person p) {
        p.setStart(activity.getStart());
        p.setEnd(activity.getEnd());
        activity.setWho(p);
    }

    private String getResultFromActivities(List<Activity> activities) {
        activities.sort((a1, a2) -> a1.getSequential() - a2.getSequential());

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getWho().getName());
        }
        return result.toString();
    }

    private InputStreamReader getReader() throws IOException {
        return new InputStreamReader(
                useFile() ?
                getClass().getClassLoader().getResourceAsStream("activities.txt") :
                System.in
        );
    }

    private boolean useFile() {
        return "true".equals(config.getProperty(PROPERTY_USE_LOCAL_FILE));
    }
}

class Person {
    private final char name;
    private int start;
    private int end;

    public Person(char name) {
        this.name = name;
    }

    public void resetActivities() {
        this.start = Integer.MAX_VALUE;
        this.end = Integer.MIN_VALUE;
    }
    public boolean free(int when) {
        return instantTask() || when < getStart() || when >= getEnd();
    }

    private boolean instantTask() {
        return getStart() == getEnd();
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
        return (getStart() >= other.getStart() && getStart() <= other.getEnd()) ||
                (getEnd() >= other.getStart() && getEnd() <= other.getEnd()) ||
                (getStart() <= other.getStart() && getEnd() >= other.getEnd());
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
