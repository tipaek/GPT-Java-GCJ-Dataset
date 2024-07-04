import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int startTime;
    int finishTime;

    Time(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}

class Person {
    String name;
    Time time;

    Person(String name, Time time) {
        this.name = name;
        this.time = time;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int intervals = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Time> timeObjects = new ArrayList<>();

            for (int j = 0; j < intervals; j++) {
                String[] times = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(times[0]);
                int finishTime = Integer.parseInt(times[1]);
                timeObjects.add(new Time(startTime, finishTime));
            }

            processInput(timeObjects, i + 1);
        }

        scanner.close();
    }

    private static void processInput(ArrayList<Time> timeObjects, int caseNumber) {
        Person cameron = new Person("C", new Time(0, 0));
        Person jamie = new Person("J", new Time(0, 0));

        Collections.sort(timeObjects);

        StringBuilder result = new StringBuilder();
        boolean possible = true;

        for (Time time : timeObjects) {
            if (time.startTime >= cameron.time.finishTime) {
                cameron.time = time;
                result.append("C");
            } else if (time.startTime >= jamie.time.finishTime) {
                jamie.time = time;
                result.append("J");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("Case #" + caseNumber + ": " + result);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}