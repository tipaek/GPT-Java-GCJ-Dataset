import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<Time> schedules = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedules.add(new Time(start, end, j));
            }
            
            schedules.sort(Comparator.comparingInt(o -> o.end));
            
            boolean impossible = false;
            StringBuilder output = new StringBuilder();
            String currentPerson = "C";
            int cBusyTill = 0;
            int jBusyTill = 0;
            
            if (!schedules.isEmpty()) {
                schedules.get(0).setPerson(currentPerson);
                cBusyTill = schedules.get(0).end;
            }

            for (int j = 1; j < n; j++) {
                Time previous = schedules.get(j - 1);
                Time current = schedules.get(j);

                if (previous.end <= current.start) {
                    current.setPerson(currentPerson);
                } else {
                    if ((currentPerson.equals("C") && jBusyTill > current.start) ||
                        (currentPerson.equals("J") && cBusyTill > current.start)) {
                        impossible = true;
                        break;
                    } else {
                        currentPerson = togglePerson(currentPerson);
                        current.setPerson(currentPerson);
                    }
                }

                if (currentPerson.equals("C")) {
                    cBusyTill = current.end;
                } else {
                    jBusyTill = current.end;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            schedules.sort(Comparator.comparingInt(o -> o.index));
            
            for (Time time : schedules) {
                output.append(time.getPerson());
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String togglePerson(String person) {
        return person.equals("C") ? "J" : "C";
    }
}

class Time {
    int start, end;
    private String person = "";
    int index;

    Time(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}