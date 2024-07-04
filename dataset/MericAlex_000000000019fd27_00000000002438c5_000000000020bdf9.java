import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxCases = Integer.valueOf(scanner.nextLine());
        int currentCase = 0;
        while (maxCases != currentCase) {
            StringBuilder resultString = new StringBuilder();
            boolean stringEditable = true;
            ArrayList<Integer> scheduleCameron = new ArrayList<>();
            ArrayList<Integer> scheduleJamie = new ArrayList<>();
            Integer activityCount = Integer.valueOf(scanner.nextLine());
            for (int currentActivity = 0; currentActivity < activityCount; currentActivity++) {
                String values = scanner.nextLine();
                Scanner valScan = new Scanner(values);
                int startTime = valScan.nextInt();
                int endTime = valScan.nextInt();
                valScan.close();
                boolean done = false;
                boolean cameronFree = true;
                boolean jamieFree = true;
                for (int time = startTime; time <= endTime; time++) {
                    if (scheduleCameron.contains(time)) {
                        cameronFree = false;
                        break;
                    }
                }
                if (cameronFree) {
                    if (stringEditable) {
                        resultString.append("C");
                        for (int time = startTime; time < endTime; time++) {
                            scheduleCameron.add(time);
                        }
                        done = true;
                    }
                }
                for (int time = startTime; time <= endTime; time++) {
                    if (scheduleJamie.contains(time)) {
                        jamieFree = false;
                        break;
                    }
                }
                if (jamieFree && !done) {
                    if (stringEditable) {
                        resultString.append("J");
                        for (int time = startTime; time < endTime; time++) {
                            scheduleJamie.add(time);
                        }
                        done = true;
                    }
                }
                if (!done) {
                    if (stringEditable) {
                        resultString = new StringBuilder("IMPOSSIBLE");
                    }
                    stringEditable = false;
                }
            }
            System.out.println("Case #" + (currentCase + 1) + ": " + resultString);
            currentCase++;
        }
    }
}