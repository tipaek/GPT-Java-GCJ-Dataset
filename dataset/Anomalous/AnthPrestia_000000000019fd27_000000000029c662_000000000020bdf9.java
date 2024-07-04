import java.util.*;
import java.io.*;

public class Solution {

    public static List<Integer> findSmallest(List<Integer> start, List<Integer> end) {
        int smallest = Integer.MAX_VALUE;
        int smallestIdx = 0;

        for (int i = 0; i < start.size(); i++) {
            int temp = start.get(i);
            if (temp < smallest) {
                smallest = temp;
                smallestIdx = i;
            }
        }

        List<Integer> times = new ArrayList<>(Arrays.asList(smallest, end.get(smallestIdx), smallestIdx));
        start.remove(smallestIdx);
        end.remove(smallestIdx);
        return times;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int appts = in.nextInt();
            StringBuilder sched = new StringBuilder();
            String error = "";
            boolean isImpossible = false;
            int jEnd = 0; // end time of the previous appointment for J
            int cEnd = 0; // end time of the previous appointment for C

            List<Integer> aptStart = new ArrayList<>();
            List<Integer> aptEnd = new ArrayList<>();
            List<String> indexes = new ArrayList<>(Collections.nCopies(appts, ""));

            for (int j = 0; j < appts; j++) {
                aptStart.add(in.nextInt());
                aptEnd.add(in.nextInt());
            }

            for (int j = 0; j < appts; j++) {
                List<Integer> first = findSmallest(aptStart, aptEnd);
                int aStart = first.get(0);
                int aEnd = first.get(1);
                int idx = first.get(2);

                if (aStart >= jEnd) {
                    jEnd = aEnd;
                    indexes.set(idx, "J");
                } else if (aStart >= cEnd) {
                    cEnd = aEnd;
                    indexes.set(idx, "C");
                } else {
                    error = "IMPOSSIBLE";
                    isImpossible = true;
                    break;
                }
            }

            for (String index : indexes) {
                sched.append(index);
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": " + error);
            } else {
                System.out.println("Case #" + i + ": " + sched);
            }
        }
    }
}