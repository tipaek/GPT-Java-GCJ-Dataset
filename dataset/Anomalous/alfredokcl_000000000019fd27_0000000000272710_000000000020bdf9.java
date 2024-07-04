import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("C"));
        people.add(new Person("J"));

        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int totalActivities = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Case #" + i + ": " + calculateSchedule(people, scanner, totalActivities));
        }
    }

    private static String calculateSchedule(ArrayList<Person> people, Scanner scanner, int totalActivities) {
        StringBuilder schedule = new StringBuilder();
        people.forEach(person -> person.clearActivities());

        for (int i = 0; i < totalActivities; i++) {
            String[] time = scanner.nextLine().trim().split("\\s+");
            int startTime = Integer.parseInt(time[0]);
            int endTime = Integer.parseInt(time[1]);

            String assigned = assignActivity(people.get(0), startTime, endTime);
            if (assigned.equals("IMPOSSIBLE")) {
                assigned = assignActivity(people.get(1), startTime, endTime);
                if (assigned.equals("IMPOSSIBLE")) {
                    return "IMPOSSIBLE";
                }
            }
            schedule.append(assigned);
        }
        return schedule.toString();
    }

    private static String assignActivity(Person person, int start, int end) {
        for (HashMap.Entry<Integer, Integer> entry : person.getActivities().entrySet()) {
            if (!(start < entry.getValue() && end > entry.getKey())) {
                continue;
            }
            return "IMPOSSIBLE";
        }
        person.addActivity(start, end);
        return person.getName();
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

    public HashMap<Integer, Integer> getActivities() {
        return activities;
    }

    public void clearActivities() {
        activities.clear();
    }
}