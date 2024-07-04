
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
            Collections.sort(listInterval, Comparator.comparing(anInt -> anInt[0]));

            Integer[] cameron=null, jamie=null;
            boolean impossible =false;
            for (int i1 = 0; i1 < listInterval.size(); i1++) {
                Integer[] overlapping = null;
                for (int i2 = i1 + 1; i2 < listInterval.size(); i2++) {
                    if (areOverlapping(listInterval.get(i1), listInterval.get(i2))) {
                        if (overlapping == null) overlapping = listInterval.get(i2);
                        else impossible = true;
                    }
                }
                int allocated = 1;
                if (overlapping!=null)allocated = overlapping[2];
                listInterval.get(i1)[2]=allocated==1?2:1;
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
