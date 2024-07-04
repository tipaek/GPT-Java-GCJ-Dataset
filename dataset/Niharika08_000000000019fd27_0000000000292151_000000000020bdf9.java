import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        int noOfTask; int startTime; int endTime; boolean flag = false;
        ArrayList<ArrayList<Integer>> inputTimings;
        ArrayList<Integer> startTimeEndTime;
        for (int i = 0; i < testCases; i++) {
            flag = false;
            inputTimings = new ArrayList<>();
            noOfTask = s.nextInt();

            for (int j = 0; j < noOfTask; j++) {
                startTimeEndTime = new ArrayList<>();
                startTime =  s.nextInt();
                if((startTime < 0) || (startTime > 1440)) {
                    System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                    flag = true;
                    break;
                }
                endTime = s.nextInt();
                if((endTime < 0) || (endTime > 1440)) {
                    System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                    flag = true;
                    break;
                }

                if((endTime < startTime) || (startTime > endTime)) {
                    System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                    flag = true;
                    break;
                }
                startTimeEndTime.add(0,startTime);
                startTimeEndTime.add(1, endTime);
                inputTimings.add(startTimeEndTime);
            }

            if(flag == false)
                System.out.println("Case #" + (i + 1) + ": " + getSchedule(inputTimings));
        }

    }

    private static String getSchedule(ArrayList<ArrayList<Integer>> inputTimings) {
        int[] cArray = new int[1441];
        int[] jArray = new int[1441];
        String outputString = "";
        int CStartTime = inputTimings.get(0).get(0), CEndTime = inputTimings.get(0).get(1);
        for (int i = CStartTime; i <= CEndTime; i++) {
            cArray[i] = 1;
        }
        inputTimings.remove(0);
        outputString = outputString + 'C';
        for (ArrayList<Integer> list : inputTimings) {
            int startTime = list.get(0);
            int endTime = list.get(1);
            if (findOverlap(jArray, startTime, endTime)) {
                if (findOverlap(cArray, startTime, endTime)) {
                    return "IMPOSSIBLE";
                } else {
                    for (int i = startTime; i <= endTime; i++) {
                        cArray[i] = 1;
                    }
                    outputString += 'C';
                }
            } else {
                for (int i = startTime; i <= endTime; i++) {
                    jArray[i] = 1;
                }
                outputString += 'J';
            }
        }
        return outputString;
    }

    public static boolean findOverlap(int[] arr, int startTime, int endTime) {
        for (int j = startTime+1; j < endTime; j++) {
            if (arr[j] == 1 ) {
                return true;
            }

        }
        return false;
    }

}
