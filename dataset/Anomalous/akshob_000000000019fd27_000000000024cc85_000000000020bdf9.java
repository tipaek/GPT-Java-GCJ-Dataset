import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    Integer startTime;
    Integer finishTime;

    Time(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Time other) {
        return this.finishTime.compareTo(other.finishTime);
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
            ArrayList<Time> timeIntervals = new ArrayList<>();
            for (int j = 0; j < intervals; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                timeIntervals.add(new Time(start, end));
            }
            processIntervals(timeIntervals, i + 1);
        }
        scanner.close();
    }

    private static void processIntervals(ArrayList<Time> timeIntervals, int caseNumber) {
        Person cameron = new Person("C", new Time(0, 0));
        Person jamie = new Person("J", new Time(0, 0));

        Collections.sort(timeIntervals);

        StringBuilder schedule = new StringBuilder();
        boolean possible = true;

        for (Time interval : timeIntervals) {
            if (interval.startTime >= cameron.time.finishTime) {
                cameron.time = interval;
                schedule.append("C");
            } else if (interval.startTime >= jamie.time.finishTime) {
                jamie.time = interval;
                schedule.append("J");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("Case #" + caseNumber + ": " + schedule);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}