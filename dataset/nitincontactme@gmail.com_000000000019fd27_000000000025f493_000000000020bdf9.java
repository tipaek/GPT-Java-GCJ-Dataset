package year202.gcj.qual;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, c
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt();
            List<Integer[]> listInterval = new ArrayList<>(n);

            for (int i = 0; i < n; i++)
                listInterval.add(new Integer[]{in.nextInt(), in.nextInt(),-1,i});
            List<Integer[]> listIntervalArr = new ArrayList<>(listInterval);
            List<Integer[]> listIntervalDep = new ArrayList<>(listInterval);

            listIntervalArr.sort(Comparator.comparing(anInt -> anInt[0]));
            listIntervalDep.sort(Comparator.comparing(anInt -> anInt[1]));

            int people_needed = 0, arr1=0, dep1=0;
            boolean isJBusy=false, isCBusy = false, impossible=false;
            while (arr1<n && dep1 < n) {
                Integer[] arrival = listIntervalArr.get(arr1), departure = listIntervalDep.get(dep1);
                if (arrival[0]<departure[1]) {
                    people_needed++;
                    arr1++;
                    Integer[] correspondingActivity = listInterval.get(arrival[3]);
                    if (people_needed>2) {
                        impossible=true;
                        break;
                    }
                    correspondingActivity[2]=!isJBusy?1:2;
                    if (!isJBusy)isJBusy=true;else isCBusy=true;

                    //System.out.println(Arrays.toString(correspondingActivity));
                } else {
                    if (listInterval.get(departure[3])[2]==1)
                        isJBusy=false;
                    else isCBusy=false;
                    people_needed--;
                    dep1++;

                }
            }
            if (impossible) {
                System.out.println("Case #"+(i11+1)+": IMPOSSIBLE");
            } else {
                listInterval.sort(Comparator.comparing(int1 -> int1[3]));
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
