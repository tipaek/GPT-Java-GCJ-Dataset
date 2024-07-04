import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            StringBuilder output = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                output.append("X");
            }
            int cameronCanStartAt = -1;
            int jamieCanStartAt = -1;
            ArrayList<ArrayList<Integer> > listOfTimes = new ArrayList<ArrayList<Integer> >(n);
            ArrayList<ArrayList<Integer>> originalTime = new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> newTimeSlot = new ArrayList<Integer>();
                newTimeSlot.add(in.nextInt());
                newTimeSlot.add(in.nextInt());
                listOfTimes.add(newTimeSlot);
            }
            originalTime = (ArrayList<ArrayList<Integer>>) listOfTimes.clone();
            Collections.sort(listOfTimes, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    // Sort the lists using the start times
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> currTimeSlot = listOfTimes.get(j);
                int currStart = currTimeSlot.get(0);
                int currEnd = currTimeSlot.get(1);
                if (currStart >= cameronCanStartAt) {
                    int strIndex = originalTime.indexOf(currTimeSlot);
                    output.setCharAt(strIndex, 'C');
                    originalTime.set(strIndex, new ArrayList<Integer>());
                    cameronCanStartAt = currEnd;
                } else if (currStart >= jamieCanStartAt) {
                    int strIndex = originalTime.indexOf(currTimeSlot);
                    output.setCharAt(strIndex, 'J');
                    originalTime.set(strIndex, new ArrayList<Integer>());
                    jamieCanStartAt = currEnd;
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            String finalSchedule = output.toString();
            System.out.println("Case #" + t + ": " + finalSchedule);
        }
    }
}