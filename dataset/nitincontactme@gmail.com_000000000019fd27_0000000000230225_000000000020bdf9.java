
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, c
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt();
            List<Integer[]> listInterval = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
                listInterval.add(new Integer[]{in.nextInt(), in.nextInt(),-1,i});
            Collections.sort(listInterval, Comparator.comparing(anInt -> anInt[0]));

            //first run
            Set<Integer[]> set = new HashSet<>();
            Integer[] lastAcceptedInterval = null;
            for (Integer[] interval: listInterval) {
                if (lastAcceptedInterval == null) {
                    lastAcceptedInterval = interval;
                    set.add(interval);
                    interval[2]=1;
                    continue;
                }
                if (!areOverlapping(lastAcceptedInterval, interval)) {
                    lastAcceptedInterval = interval;
                    set.add(interval);
                    interval[2]=1;
                }
            }

            //secondRun
            lastAcceptedInterval = null;
            for (Integer[] interval: listInterval) {
                if (interval[2]==1)continue;
                if (lastAcceptedInterval == null) {
                    lastAcceptedInterval = interval;
                    set.add(interval);
                    interval[2]=2;
                    continue;
                }
                if (!areOverlapping(lastAcceptedInterval, interval)) {
                    lastAcceptedInterval = interval;
                    set.add(interval);
                    interval[2]=2;
                }
            }

            if (set.size()!=n) {
                System.out.println("Case #"+(i11+1)+": IMPOSSIBLE");
            } else {
                Collections.sort(listInterval, Comparator.comparing(int1->int1[3]));
                StringBuilder builder = new StringBuilder(n);
                listInterval.stream().sequential()
                        .forEach(int1 -> builder.append(int1[2]==1?'C':'J'));
                System.out.println("Case #"+(i11+1)+": "+builder.toString());
            }
        }
        in.close();
    }

    private static boolean areOverlapping(Integer[] int1, Integer[] int2) {
        if (int1[0]>int2[0] && int1[0]<int2[1])
            return true;
        if (int1[1]>int2[0] && int1[1]<int2[1])
            return true;
        if (int2[0]>int1[0] && int2[0]<int1[1])
            return true;
        if (int2[1]>int1[0] && int2[1]<int1[1])
            return true;
        return false;
    }
}
