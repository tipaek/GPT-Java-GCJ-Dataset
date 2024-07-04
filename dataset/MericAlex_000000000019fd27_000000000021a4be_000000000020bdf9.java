import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxCases = Integer.valueOf(scanner.nextLine());
        int currentCase = 0;
        while (maxCases != currentCase) {
            String answerString = "";
            boolean stringEditable = true;
            ArrayList<Integer> scheduleCameron = new ArrayList<>();
            ArrayList<Integer> scheduleJamie = new ArrayList<>();
            Integer activityNumber = Integer.valueOf(scanner.nextLine());
            for (int currentActivity = 0; currentActivity < activityNumber; currentActivity++) {
                String values = scanner.nextLine();
                Scanner valScan = new Scanner(values);
                int startTime = valScan.nextInt();
                int endTime = valScan.nextInt();
                if (startTime / 1440 > 1) {
                    startTime = startTime % 1440;
                }
                if (endTime / 1440 > 1) {
                    endTime = endTime % 1440;
                }
                if (endTime < startTime) {
                    endTime = 1440;
                }
                valScan.close();
                boolean done = false;
                boolean cameronFree = true;
                boolean jamieFree = true;
                for (int time = startTime; time < endTime; time++) {
                    if (scheduleCameron.contains(time)) {
                        cameronFree = false;
                        break;
                    }
                }
                if (cameronFree && !done) {
                    for (int time = startTime; time < endTime; time++) {
                        scheduleCameron.add(time);
                    }
                    done = true;
                    if (stringEditable) {
                        answerString = answerString + "C";
                    }
                }
                for (int time = startTime; time < endTime; time++) {
                    if (scheduleJamie.contains(time)) {
                        jamieFree = false;
                        break;
                    }
                }
                if (jamieFree && !done) {
                    for (int time = startTime; time < endTime; time++) {
                        scheduleJamie.add(time);
                    }
                    done = true;
                    if (stringEditable) {
                        answerString = answerString + "J";
                    }
                }
                if (done == false) {
                    if (stringEditable) {
                        answerString = "IMPOSSIBLE";
                    }
                    stringEditable = false;
                }
            }
            System.out.println("Case #" + (currentCase + 1) + ": " + answerString);
            currentCase++;
        }
    }
}
