import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int numTestCase = 0; numTestCase < numTestCases; ++numTestCase) {
            int N = in.nextInt();
            List<Integer[]> acts = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                acts.add(new Integer[]{startTime, endTime, i});
            }
            acts.sort(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] t1, Integer[] t2) {
                    int t1_start = t1[0];
                    int t2_start = t2[0];
                    return t1_start - t2_start;
                }
            });

            boolean[] person = new boolean[N];
            Integer[] cameron = new Integer[]{-1, -1};
            Integer[] jamie = new Integer[]{-1, -1};
            boolean impossible = false;
            for (int i = 0; i < N; ++i) {
                Integer[] act = acts.get(i);
                if (!overlaps(act, cameron)) {
                    cameron = act;
                } else if (!overlaps(act, jamie)) {
                    jamie = act;
                    person[act[2]] = true;
                } else {
                    impossible = true;
                    break;
                }
            }
            String output = "";
            if(impossible) {
                output = "IMPOSSIBLE";
            } else {
                for(boolean p : person) {
                    if(p) {
                        output += "J";
                    } else {
                        output += "C";
                    }
                }
            }
            System.out.println("Case #" + (numTestCase+1) + ": " + output);
        }
    }

    public static boolean overlaps(Integer[] i1, Integer[] i2) {
        int i1_start = i1[0];
        int i1_end = i1[1];
        int i2_start = i2[0];
        int i2_end = i2[1];
        boolean overlaps = i1_end > i2_start && i1_start < i2_end;
        return overlaps;
    }

}