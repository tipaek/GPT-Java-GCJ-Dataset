import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Person cameron = new Person("C");
        Person jamie = new Person("J");
        ArrayList<Person> people = new ArrayList<>();
        people.add(cameron);
        people.add(jamie);

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + i + ": " + scheduleActivities(people, scanner, totalActivities));
        }
    }

    private static String scheduleActivities(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (!assignActivity(people.get(0), startTime, endTime, schedule)) {
                if (!assignActivity(people.get(1), startTime, endTime, schedule)) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return schedule.toString();
    }

    private static boolean assignActivity(Person person, int start, int end, StringBuilder schedule) {
        if (person.isAvailable(start, end)) {
            person.addActivity(start, end);
            schedule.append(person.getName());
            return true;
        }
        return false;
    }
}

class Person {
    private final String name;
    private final HashMap<Integer, Integer> activities;

    public Person(String name) {
        this.name = name;
        this.activities = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addActivity(int start, int end) {
        activities.put(start, end);
    }

    public void clearActivities() {
        activities.clear();
    }

    public boolean isAvailable(int start, int end) {
        for (HashMap.Entry<Integer, Integer> entry : activities.entrySet()) {
            if (!(end <= entry.getKey() || start >= entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}