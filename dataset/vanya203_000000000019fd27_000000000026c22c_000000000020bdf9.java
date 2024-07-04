import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cs.nextInt();

        for (int i = 1; i <= T; ++i) {
            int periods = cs.nextInt();
            int[][] schedule = new int[periods][2];
            
            for (int j = 0; j < periods; j++){
                schedule[j][0] = cs.nextInt();
                schedule[j][1] = cs.nextInt();
            }
            Arrays.sort(schedule, (a,b) -> {
                if (a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            String res = makeSchedule(schedule, 0, 0, 0, "");
            System.out.printf("Case #%d: %s\n", i, res.length() == 0 ? "IMPOSSIBLE" : res);
        }
    }

    public static String makeSchedule(int[][] schedule, int position, int Cameron, int Jam, String plannedAlready) {
        if (position == schedule.length){
            return plannedAlready;
        }
        int start = schedule[position][0];
        int end = schedule[position][1];
        if (Cameron <= start){
            String found = makeSchedule(schedule, position+1, end, Jam, plannedAlready + "C");
            if (found.length() > 0){
                return found;
            }
        }
        if (Jam <= start){
            String found = makeSchedule(schedule, position+1, Cameron, end, plannedAlready + "J");
            if (found.length() > 0){
                return found;
            }
        }
        return "";
    }


}
