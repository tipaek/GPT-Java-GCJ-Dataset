import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        int noOfTask;
        ArrayList<ArrayList<Integer>> inputTimings;
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
        int[] cArray = new int[1440];
        int[] jArray = new int[1440];
        String outputString = "";
        int CStartTime = inputTimings.get(0).get(0), CEndTime = inputTimings.get(0).get(1);

        for (int i = CStartTime; i < CEndTime; i++) {
            cArray[i] = 1;
        }
        inputTimings.remove(0);
        outputString = outputString + 'C';
        for (ArrayList<Integer> list : inputTimings) {
            if (findOverlap(cArray, (int) list.get(0), (int) list.get(1))) {
                if (findOverlap(jArray, (int) list.get(0), (int) list.get(1))) {
                    return "IMPOSSIBLE";
                } else {
                    for (int i = list.get(0); i < list.get(1); i++) {
                        jArray[i] = 1;
                    }
                    outputString = outputString + 'J';
                }
            } else {
                for (int i = list.get(0); i < list.get(1); i++) {
                    cArray[i] = 1;
                }
                outputString = outputString + 'C';
            }

        }
        return outputString;
    }

    public static boolean findOverlap(int[] cArray, int startTime, int endTime) {
        for (int j = startTime; j < endTime; j++) {
            if (cArray[j] == 1)
                return true;
        }
        return false;
    }

}
