import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GCGParentingPartner {

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
        String outputString = "";
        ArrayList<ArrayList<Integer>> CList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> JList = new ArrayList<>();
        ArrayList<Integer> CIntList;
        ArrayList<Integer> JIntList;


        int CStartTime = inputTimings.get(0).get(0), CEndTime = inputTimings.get(0).get(1);
        CIntList = new ArrayList<>();
        CIntList.add(0, CStartTime);
        CIntList.add(1, CEndTime);
        CList.add(CIntList);
        inputTimings.remove(0);
        outputString = outputString + 'C';
        for (ArrayList<Integer> list : inputTimings) {
            if (isOverlap(JList, (int) list.get(0), (int) list.get(1))) {
                if (isOverlap(CList, (int) list.get(0), (int) list.get(1))) {
                    return "IMPOSSIBLE";
                } else {
                    outputString = outputString + 'C';
                    CIntList = new ArrayList<>();
                    CIntList.add(0, list.get(0));
                    CIntList.add(1, list.get(1));
                    CList.add(CIntList);

                }
            } else {
                outputString = outputString + 'J';
                JIntList = new ArrayList<>();
                JIntList.add(0, list.get(0));
                JIntList.add(1, list.get(1));
                JList.add(JIntList);
            }
        }
        return outputString;
    }


//    private static boolean findOverlap(ArrayList<ArrayList<Integer>> ScheduledList, int currentStartTime, int currentEndTime) {
//        int startTime;
//        int endTime;
//        boolean isOverlapped;
//        for (ArrayList<Integer> list : ScheduledList) {
//            startTime = list.get(0);
//            endTime = list.get(1);
//            isOverlapped = isOverLap(startTime, endTime, currentStartTime, currentEndTime);
//            if(isOverlapped ==  true)
//                return true;
//        }
//        return false;
//    }
//
//    private static boolean isOverLap(int startTime, int endTime, int currentStartTime, int currentEndTime) {
//        if (currentStartTime >= startTime && currentStartTime < endTime)
//            return true;
//        else if (currentEndTime > startTime && currentEndTime <= endTime)
//            return true;
//        else if (currentStartTime < startTime && currentEndTime > endTime)
//            return true;
//        else
//            return false;
//    }

    static boolean isOverlap(ArrayList<ArrayList<Integer>> ScheduledList, int startTime, int endTime) {
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
                newList.addAll(ScheduledList);
        newList.add(new ArrayList<>(Arrays.asList(startTime, endTime)));
        int max_ele = 0;

        // Find the overall maximum element
        for (ArrayList<Integer> list : newList) {
            if (max_ele < list.get(0))
                max_ele = list.get(0);
            if (max_ele < list.get(1))
                max_ele = list.get(1);
        }

        // Initialize an array of size max_ele
        int[] aux = new int[max_ele + 1];
        for (ArrayList<Integer> list : newList) {

            // starting point of the interval
            int x = list.get(0);

            // end point of the interval
            int y = list.get(1);
            aux[x]++;
            aux[y]--;
        }
        for (int i = 1; i <= max_ele; i++) {
            // Calculating the prefix Sum
            aux[i] += aux[i - 1];

            // Overlap
            if (aux[i] > 1)
                return true;
        }

        // If we reach here, then no Overlap
        return false;

    }


}
