import java.util.*;

class Time implements Comparable<Time> {
    Integer startTime;
    Integer finishTime;

    Time(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Time o) {
        return this.startTime.compareTo(o.startTime);
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

            List<Time> timeObjects = new ArrayList<>();
            Map<Integer, Time> maps = new HashMap<>();

            for (int z = 0; z < intervals; z++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int finish = Integer.parseInt(times[1]);

                Time time = new Time(start, finish);
                timeObjects.add(time);
                maps.put(z, time);
            }

            processInput(timeObjects, i, maps);
        }

        scanner.close();
    }

    private static void processInput(List<Time> timeObjects, int caseNumber, Map<Integer, Time> maps) {
        caseNumber++;
        char[] finalResult = new char[timeObjects.size()];

        Person c = new Person("C", new Time(0, 0));
        Person j = new Person("J", new Time(0, 0));

        Collections.sort(timeObjects);

        boolean possible = true;

        for (Time time : timeObjects) {
            if (time.startTime >= c.time.finishTime) {
                c.time = time;
                finalResult[getMapsKey(maps, time)] = 'C';
            } else if (time.startTime >= j.time.finishTime) {
                j.time = time;
                finalResult[getMapsKey(maps, time)] = 'J';
            } else {
                possible = false;
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + (possible ? String.valueOf(finalResult) : "IMPOSSIBLE"));
    }

    private static int getMapsKey(Map<Integer, Time> maps, Time time) {
        for (Map.Entry<Integer, Time> entry : maps.entrySet()) {
            if (Objects.equals(time, entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}