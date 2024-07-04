import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        int noOfTask;
        ArrayList<ArrayList<Integer>> inputTimings = new ArrayList<>();
        ArrayList<Integer> startTimeEndTime;
        for (int i = 0; i < testCases; i++) {
            inputTimings = new ArrayList<>();
            noOfTask = s.nextInt();

            for (int j = 0; j < noOfTask; j++) {
                startTimeEndTime = new ArrayList<>();
                startTimeEndTime.add(0, s.nextInt());
                startTimeEndTime.add(1, s.nextInt());
                inputTimings.add(startTimeEndTime);
            }

            System.out.println("Case #" + (i+1) + ": " + getSchedule(inputTimings));
        }

    }

    private static String getSchedule(ArrayList<ArrayList<Integer>> inputTimings) {
        String outputString = "";
        int CStartTime = inputTimings.get(0).get(0), CEndTime = inputTimings.get(0).get(1), JStartTime = 0, JEndTime = 0;
        inputTimings.remove(0);
        outputString = outputString + 'C';
        for (ArrayList<Integer> list : inputTimings) {
            if (isOverLap(CStartTime, CEndTime, (int) list.get(0), (int) list.get(1))) {
                if (isOverLap(JStartTime, JEndTime, (int) list.get(0), (int) list.get(1))) {
                    outputString = "IMPOSSIBLE";
                } else {
                    outputString = outputString + 'J';
                    JStartTime = list.get(0);
                    JEndTime = list.get(1);
                }
            } else {
                outputString = outputString + 'C';
                CStartTime = list.get(0);
                CEndTime = list.get(1);
            }
        }
        return outputString;
    }


    private static boolean isOverLap(int startTime, int endTime, int currentStartTime, int currentEndTime) {
        if (currentStartTime >= startTime && currentStartTime <= endTime)
            return true;
        else
            return false;
    }
}
