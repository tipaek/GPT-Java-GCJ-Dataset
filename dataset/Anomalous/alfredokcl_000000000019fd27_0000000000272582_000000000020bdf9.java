import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("C"));
        people.add(new Person("J"));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int activitiesCount = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Case #" + i + ": " + scheduleActivities(people, scanner, activitiesCount));
        }
    }

    private static String scheduleActivities(ArrayList<Person> people, Scanner scanner, int activitiesCount) {
        StringBuilder schedule = new StringBuilder();
        people.forEach(person -> person.clearActivities());

        for (int i = 0; i < activitiesCount; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            if (!assignActivity(people.get(0), start, end, schedule)) {
                if (!assignActivity(people.get(1), start, end, schedule)) {
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
        return activities.entrySet().stream()
                .noneMatch(entry -> !(end <= entry.getKey() || start >= entry.getValue()));
    }
}