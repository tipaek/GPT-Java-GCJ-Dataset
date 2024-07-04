import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Solution {

    public static List findSmallest(List start, List end) {

        int smallest = 99999;
        int smallestIdx = 0;

        for (int i = 0; i < start.size(); i++) {
            int temp = (int) start.get(i);
            if (temp < smallest) {
                smallest = temp;
                smallestIdx = i;
            }
        }
        List<Integer> times = new ArrayList<>();
        times.add(smallest);
        times.add((Integer) end.get(smallestIdx));
        start.remove(smallestIdx);
        end.remove(smallestIdx);
        return times;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int appts = in.nextInt();
            StringBuilder sched = new StringBuilder();
            String error = "";
            int z = 0;
            int jS = 0; //end of previous appt
            int cS = 0;

            List<Integer> aptStart = new ArrayList<>();
            List<Integer> aptEnd = new ArrayList<>();

            for (int j = 0; j < appts; j++) {
                aptStart.add(in.nextInt());
                aptEnd.add(in.nextInt());
            }

            for (int j = 0; j < appts; j++) {
                List first = findSmallest(aptStart, aptEnd);
                int aStart = (int) first.get(0);
                int aEnd = (int) first.get(1);
                if (aStart >= jS) {
                    jS = aEnd;
                    sched.append("J");
                }
                else if (aStart >= cS) {
                    cS = aEnd;
                    sched.append("C");
                }
                else {
                    error = "IMPOSSIBLE";
                    z = 1;
                    break;
                }
            }

            if (z == 1) {
                System.out.println("Case #" + i + ": " + error);
            }
            else {
                System.out.println("Case #" + i + ": " + sched);
            }
        }
    }
}