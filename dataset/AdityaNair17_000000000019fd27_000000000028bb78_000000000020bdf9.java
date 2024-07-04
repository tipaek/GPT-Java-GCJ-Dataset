import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = input.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int N = input.nextInt();
            StringBuilder finalOutput = new StringBuilder("");
            for (int i = 0; i < N; i++) {
                finalOutput.append("X");
            }
            int cameronStart = -1;
            int jamieStart = -1;
            ArrayList<ArrayList<Integer> > listOfTimes = new ArrayList<ArrayList<Integer> >(N);
            ArrayList<ArrayList<Integer>> originalTime = new ArrayList<ArrayList<Integer> >(N);
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> newTimeSlot = new ArrayList<Integer>();
                newTimeSlot.add(input.nextInt());
                newTimeSlot.add(input.nextInt());
                listOfTimes.add(newTimeSlot);
            }
            originalTime = (ArrayList<ArrayList<Integer>>) listOfTimes.clone();
            Collections.sort(listOfTimes, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
            for (int j = 0; j < N; j++) {
                ArrayList<Integer> currentTimeSlot = listOfTimes.get(j);
                int currentStart = currentTimeSlot.get(0);
                int currentEnd = currentTimeSlot.get(1);
                if (currentStart >= cameronStart) {
                    int strIndex = originalTime.indexOf(currentTimeSlot);
                    finalOutput.setCharAt(strIndex, 'C');
                    originalTime.set(strIndex, new ArrayList<Integer>());
                    cameronStart = currentEnd;
                } else if (currentStart >= jamieStart) {
                    int strIndex = originalTime.indexOf(currentTimeSlot);
                    finalOutput.setCharAt(strIndex, 'J');
                    originalTime.set(strIndex, new ArrayList<Integer>());
                    jamieStart = currentEnd;
                } else {
                    finalOutput = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            String finalSchedule = finalOutput.toString();
            System.out.println("Case #" + t + ": " + finalSchedule);
        }
    }
}
