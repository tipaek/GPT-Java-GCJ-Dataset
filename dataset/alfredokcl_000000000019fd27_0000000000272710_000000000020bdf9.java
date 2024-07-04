import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Person person1 = new Person("C");
        Person person2 = new Person("J");
        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int totActivities = in.nextInt();
            in.nextLine();

            System.out.println("Case #" + i + ": " + calculateTime(people, in, totActivities));
        }
    }

    private static String calculateTime(ArrayList<Person> people, Scanner scanner, int totActivities) {
        String order = "";
        for(Person person : people)
            person.getActivities().clear();

        for(int index = 0; index < totActivities; index++) {
            String row = scanner.nextLine();
            String[] time = row.trim().split("\\s+");

            int startTime = Integer.parseInt(time[0]);
            int endTime = Integer.parseInt(time[1]);

            order += assignActivity(people.get(0), startTime, endTime);
            if(order.contains("IMPOSSIBLE")) {
                order = order.replaceAll("IMPOSSIBLE","");
                order += assignActivity(people.get(1), startTime, endTime);
                if(order.contains("IMPOSSIBLE")) {
                    order = "IMPOSSIBLE";
                }
            }
        }
        return order;
    }

    private static String assignActivity(Person p, int start, int end) {
        if(p.getActivities().isEmpty()) {
            p.addActivity(start, end);
            return p.getName();
        }
        else {
            for (HashMap.Entry<Integer, Integer> entry : p.getActivities().entrySet()) {
                if((start < entry.getKey() && end <= entry.getKey()) ||
                        (start >= entry.getValue() && end > entry.getValue())) {
                    p.addActivity(start, end);
                    return p.getName();
                }
            }
        }
        return "IMPOSSIBLE";
    }
}

class Person {
    private String name;
    private HashMap<Integer, Integer> activities;

    public Person(String name) {
      this.name = name;
      activities = new HashMap<>();
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
}