import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i <= t; i++) {

            int activities = in.nextInt();
            if (activities > 0) {
                System.out.print("Case #" + i + ": ");
            }

            StringBuffer sb = new StringBuffer();

            int[] cS = new int[24*60+1];
            int[] jS = new int[24*60+1];

            for (int j=0;j<activities;j++) {
                int[] currentSchedule = new int[]{in.nextInt(), in.nextInt()};
                if (isAvailable(cS, currentSchedule)) {
                    sb.append("C");
                } else if(isAvailable(jS, currentSchedule)) {
                    sb.append("J");
                } else {
                    sb = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            if (sb.toString().length() > 0) {
                System.out.println(sb.toString());
            }
        }

    }

    public static boolean isAvailable(int[] allS, int[] iS) {

        int count = 0;

        for (int i = 0; i <= iS[1]; i++) {
            count += allS[i];
            if (i >= iS[0] && count != 0) {
                return false;
            }
        }

        if (count != 0) {
            return false;
        }

        allS[iS[0]] = allS[iS[0]]+1;
        allS[iS[1]] = allS[iS[1]]-1;
        return true;
    }



}


