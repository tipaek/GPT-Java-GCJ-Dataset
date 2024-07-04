import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numEntries = Integer.parseInt(scnr.nextLine());

        for (int i = 0; i < numEntries; i++) {
            int entries = scnr.nextInt();
            scnr.nextLine();
            StringBuilder retVal = new StringBuilder("Case #" + (i + 1) + ": ");
            Schedule cameron = new Schedule();
            Schedule jamie = new Schedule();

            boolean possible = true;
            for (int j = 0; j < entries; j++) {
                Event newEvent = new Event(scnr.nextInt(), scnr.nextInt());
                if (!cameron.addEvent(newEvent)) {
                    if (!jamie.addEvent(newEvent)) {
                        retVal = new StringBuilder("Case #" + (i + 1) + ": IMPOSSIBLE");
                        possible = false;
                        scnr.nextLine(); // Skip remaining input for this case
                        break;
                    } else {
                        retVal.append("J");
                    }
                } else {
                    retVal.append("C");
                }
            }
            if (possible) {
                System.out.println(retVal.toString());
            } else {
                System.out.println(retVal.toString());
            }
        }
        scnr.close();
    }

    static class Event {
        int startTime;
        int endTime;

        Event(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Schedule {
        List<Event> events;

        Schedule() {
            this.events = new ArrayList<>();
        }

        boolean addEvent(Event eventToAdd) {
            for (Event currEvent : events) {
                if (eventToAdd.startTime < currEvent.endTime && eventToAdd.endTime > currEvent.startTime) {
                    return false;
                }
            }
            events.add(eventToAdd);
            return true;
        }
    }
}