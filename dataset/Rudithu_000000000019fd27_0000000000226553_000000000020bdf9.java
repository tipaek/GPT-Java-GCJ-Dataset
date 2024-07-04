import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i <= t; i++) {

            System.out.print("Case #" + i + ": ");
            int activities = in.nextInt();

            StringBuffer sb = new StringBuffer();

            List<int[]> lC = new ArrayList<>();
            List<int[]> lJ = new ArrayList<>();

            for (int j=0;j<activities;j++) {
                int[] currentSchedule = new int[]{in.nextInt(), in.nextInt()};
                if (isAvailable(lC, currentSchedule)) {
                    sb.append("C");
                } else if(isAvailable(lJ, currentSchedule)) {
                    sb.append("J");
                } else {
                    sb = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static boolean isAvailable(List<int[]> schedules, int[] schedule) {
        int[] linkedSchedule = null;
        for (int[] s : schedules) {
            if (schedule[0] >= s[1] || schedule[1] <= s[0]) {
                if (schedule[0] == s[1] || schedule[1] == s[0]) {
                    linkedSchedule = s;
                }
            } else {
                return false;
            }
        }
        if (linkedSchedule != null) {
            if (schedule[1] == linkedSchedule[0]) {
                linkedSchedule[0] = schedule[0];
            } else {
                linkedSchedule[1] = schedule[1];
            }
        } else {
            schedules.add(schedule);
        }
        return true;
    }

}


