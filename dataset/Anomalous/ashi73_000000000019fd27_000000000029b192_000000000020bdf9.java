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
            List<TimeSlot> timeSlots = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots.add(new TimeSlot(start, end, j));
            }
            
            timeSlots.sort(Comparator.comparingInt(ts -> ts.end));
            
            String result = "";
            String currentPerson = "C";
            int cBusyUntil = 0;
            int jBusyUntil = 0;
            boolean isImpossible = false;

            if (!timeSlots.isEmpty()) {
                timeSlots.get(0).person = currentPerson;
                cBusyUntil = timeSlots.get(0).end;
            }

            for (int j = 1; j < n; j++) {
                TimeSlot previous = timeSlots.get(j - 1);
                TimeSlot current = timeSlots.get(j);
                
                if (previous.end <= current.start) {
                    current.person = currentPerson;
                } else {
                    if (currentPerson.equals("C") && jBusyUntil > current.start) {
                        isImpossible = true;
                        break;
                    } else if (currentPerson.equals("J") && cBusyUntil > current.start) {
                        isImpossible = true;
                        break;
                    } else {
                        currentPerson = togglePerson(currentPerson);
                        current.person = currentPerson;
                        if (currentPerson.equals("C")) {
                            cBusyUntil = current.end;
                        } else {
                            jBusyUntil = current.end;
                        }
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            timeSlots.sort(Comparator.comparingInt(ts -> ts.index));
            
            for (TimeSlot slot : timeSlots) {
                result += slot.getPerson();
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String togglePerson(String current) {
        return current.equals("C") ? "J" : "C";
    }
}

class TimeSlot {
    int start, end, index;
    String person = "";

    TimeSlot(int start, int end, int index) {
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