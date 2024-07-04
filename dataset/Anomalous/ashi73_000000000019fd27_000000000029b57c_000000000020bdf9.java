import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            List<Time> schedules = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedules.add(new Time(start, end, j));
            }

            schedules.sort(Comparator.comparingInt(o -> o.e));

            StringBuilder output = new StringBuilder();
            String currentPerson = "C";
            int cBusyTill = 0;
            int jBusyTill = 0;
            boolean impossible = false;

            if (!schedules.isEmpty()) {
                schedules.get(0).person = currentPerson;
                cBusyTill = schedules.get(0).e;
            }

            for (int j = 1; j < n; j++) {
                Time previous = schedules.get(j - 1);
                Time current = schedules.get(j);

                if (previous.e <= current.s) {
                    current.person = currentPerson;
                    if (currentPerson.equals("C")) {
                        cBusyTill = current.e;
                    } else {
                        jBusyTill = current.e;
                    }
                } else {
                    if ((currentPerson.equals("C") && jBusyTill > current.s) ||
                        (currentPerson.equals("J") && cBusyTill > current.s)) {
                        impossible = true;
                        break;
                    } else {
                        currentPerson = switchPerson(currentPerson);
                        current.person = currentPerson;
                        if (currentPerson.equals("C")) {
                            cBusyTill = current.e;
                        } else {
                            jBusyTill = current.e;
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            schedules.sort(Comparator.comparingInt(o -> o.index));

            for (Time schedule : schedules) {
                output.append(schedule.getPerson());
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String switchPerson(String current) {
        return current.equals("C") ? "J" : "C";
    }
}

class Time {
    int s, e;
    String person = "";
    int index;

    Time(int s, int e, int index) {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}