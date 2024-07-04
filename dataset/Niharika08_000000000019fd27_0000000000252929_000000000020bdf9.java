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

            System.out.println("Case #" + (i + 1) + ": " + getSchedule(inputTimings));
        }

    }

    private static String getSchedule(ArrayList<ArrayList<Integer>> inputTimings) {
        String outputString = "";
        ArrayList<ArrayList<Integer>> CList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> JList = new ArrayList<>();
        ArrayList<Integer> CIntList = new ArrayList<>();
        ArrayList<Integer> JIntList = new ArrayList<>();


        int CStartTime = inputTimings.get(0).get(0), CEndTime = inputTimings.get(0).get(1);
        CIntList = new ArrayList<>();
        CIntList.add(0, CStartTime);
        CIntList.add(1, CEndTime);
        CList.add(CIntList);
        inputTimings.remove(0);
        outputString = outputString + 'C';
        for (ArrayList<Integer> list : inputTimings) {
            if (findOverlap(CList, (int) list.get(0), (int) list.get(1))) {
                if (findOverlap(JList, (int) list.get(0), (int) list.get(1))) {
                    return "IMPOSSIBLE";
                } else {
                    outputString = outputString + 'J';
                    JIntList = new ArrayList<>();
                    JIntList.add(0, list.get(0));
                    JIntList.add(1, list.get(1));
                    JList.add(JIntList);
                }
            } else {
                outputString = outputString + 'C';
                CIntList = new ArrayList<>();
                CIntList.add(0, list.get(0));
                CIntList.add(1, list.get(1));
                CList.add(CIntList);
            }
        }
        return outputString;
    }


    private static boolean findOverlap(ArrayList<ArrayList<Integer>> ScheduledList, int currentStartTime, int currentEndTime) {
        int startTime;
        int endTime;
        boolean isOverlapped = false;
        for (ArrayList<Integer> list : ScheduledList) {
            startTime = list.get(0);
            endTime = list.get(1);
            isOverlapped = isOverLap(startTime, endTime, currentStartTime, currentEndTime);
            if(isOverlapped ==  true)
                return true;
        }
        return false;
    }

    private static boolean isOverLap(int startTime, int endTime, int currentStartTime, int currentEndTime) {
        if (currentStartTime >= startTime && currentStartTime < endTime)
            return true;
        else if (currentEndTime > startTime && currentEndTime <= endTime)
            return true;
        else if (currentStartTime < startTime && currentEndTime > endTime)
            return true;
        else
            return false;
    }
}
