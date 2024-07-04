import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Person cameron = new Person("C");
            Person jamie = new Person("J");

            Time[] times = new Time[n];
            for (int j = 0; j < n; j++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                times[j] = new Time(from, to, j);
            }

            Arrays.sort(times, Comparator.comparingInt(Time::getFrom));

            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Time time : times) {
                if (time.getFrom() >= cameron.getTo()) {
                    time.setName(cameron.getName());
                    cameron.setTo(time.getTo());
                } else if (time.getFrom() >= jamie.getTo()) {
                    time.setName(jamie.getName());
                    jamie.setTo(time.getTo());
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Arrays.sort(times, Comparator.comparingInt(Time::getIndex));
                for (Time time : times) {
                    result.append(time.getName());
                }
            }

            System.out.println(String.format("Case #%d: %s", i, result.toString()));
        }
    }
}

class Person {
    private int to;
    private final String name;

    public Person(String name) {
        this.name = name;
        this.to = 0;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }
}

class Time {
    private final int from;
    private final int to;
    private final int index;
    private String name;

    public Time(int from, int to, int index) {
        this.from = from;
        this.to = to;
        this.index = index;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}