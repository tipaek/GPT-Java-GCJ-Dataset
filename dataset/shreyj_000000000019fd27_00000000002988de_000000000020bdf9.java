import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for (int t = 0; t < numberOfTestCases; t++) {
            MyCalendar cameron = new MyCalendar();
            MyCalendar jamie = new MyCalendar();
            StringBuilder eventAssigned = new StringBuilder();
            boolean possible = true;

            int numberOfActivities = in.nextInt();
            for (int a = 0; a < numberOfActivities; a++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                if (possible) {
                    if (cameron.addEvent(startTime, endTime)) {
                        eventAssigned.append("C");
                    } else if (jamie.addEvent(startTime, endTime)) {
                        eventAssigned.append("J");
                    } else {
                        possible = false;
                    }
                }
            }
            if (!possible) eventAssigned = new StringBuilder("IMPOSSIBLE");

            System.out.println("Case #" + (t + 1) + ": " + eventAssigned);
        }
    }
}

class MyCalendar {
    private ArrayList<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean addEvent(int start, int end) {
        if (events.size() == 0 || end < events.get(0)[0]) return addEvent(start, end, 0);
        else {
            int i;
            for (i = 0; i < events.size(); i++) {
                if (events.get(i)[1] > start) break;
            }

            if (i == events.size() || end <= events.get(i)[0]) return addEvent(start, end, i);
            else return false;
        }
    }

    private boolean addEvent(int start, int end, int index) {
        events.add(index, new int[]{start, end});
        return true;
    }
}