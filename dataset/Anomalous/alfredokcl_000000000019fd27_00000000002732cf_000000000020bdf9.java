import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Person personC = new Person("C");
        Person personJ = new Person("J");
        ArrayList<Person> people = new ArrayList<>();
        people.add(personC);
        people.add(personJ);

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + i + ": " + determineSchedule(people, scanner, totalActivities));
        }
    }

    private static String determineSchedule(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();
        for (Person person : people) {
            person.clearActivities();
        }

        for (int i = 0; i < totalActivities; i++) {
            String[] times = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            String assignment = assignActivity(people.get(0), startTime, endTime);
            if (assignment.equals("IMPOSSIBLE")) {
                assignment = assignActivity(people.get(1), startTime, endTime);
                if (assignment.equals("IMPOSSIBLE")) {
                    return "IMPOSSIBLE";
                }
            }
            schedule.append(assignment);
        }
        return schedule.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        if (person.isScheduleFree(start, end)) {
            person.addActivity(start, end);
            return person.getName();
        }
        return "IMPOSSIBLE";
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

    public boolean isScheduleFree(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : activities.entrySet()) {
            if (!(end <= entry.getKey() || start >= entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}