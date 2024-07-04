import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    private final Integer startTime;
    private final Integer finishTime;

    Time(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getFinishTime() {
        return finishTime;
    }

    @Override
    public int compareTo(Time other) {
        return this.startTime.compareTo(other.startTime);
    }
}

class Person {
    private final String name;
    private Time time;

    Person(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                int intervals = scanner.nextInt();
                scanner.nextLine();

                ArrayList<Time> timeObjects = new ArrayList<>();
                for (int z = 0; z < intervals; z++) {
                    String[] times = scanner.nextLine().split(" ");
                    int startTime = Integer.parseInt(times[0]);
                    int finishTime = Integer.parseInt(times[1]);
                    timeObjects.add(new Time(startTime, finishTime));
                }

                processInput(timeObjects, i);
            }
        }
    }

    private static void processInput(ArrayList<Time> timeObjects, int caseNumber) {
        Person c = new Person("C", new Time(0, 0));
        Person j = new Person("J", new Time(0, 0));

        Collections.sort(timeObjects);

        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (Time time : timeObjects) {
            if (time.getStartTime() >= c.getTime().getFinishTime()) {
                c.setTime(time);
                result.append("C");
            } else if (time.getStartTime() >= j.getTime().getFinishTime()) {
                j.setTime(time);
                result.append("J");
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("Case #" + (caseNumber + 1) + ": " + result);
        } else {
            System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
        }
    }
}