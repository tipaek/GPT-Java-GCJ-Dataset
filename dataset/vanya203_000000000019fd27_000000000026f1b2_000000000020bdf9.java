import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cs.nextInt();

        for (int i = 1; i <= T; ++i) {
            int periods = cs.nextInt();
            int[][] schedule = new int[periods][3];
            
            for (int j = 0; j < periods; j++){
                schedule[j][0] = cs.nextInt();
                schedule[j][1] = cs.nextInt();
                schedule[j][2] = j;
            }
            String res = prepareSchedule(schedule);
            System.out.printf("Case #%d: %s\n", i, res.length() == 0 ? "IMPOSSIBLE" : res);
        }
    }

    public static String prepareSchedule(int[][] schedule){

        Arrays.sort(schedule, (a,b) -> {
            if (a[0] == b[0]){
                if (a[1] == b[1]){
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        String res = makeSchedule(schedule, 0, 0, 0, "");
        if (res.length() == 0){
            return res;
        }
        char[] resScheduleOdered = new char[schedule.length];
        for (int i = 0; i < res.length(); i++){
            char v = res.charAt(i);
            resScheduleOdered[schedule[i][2]] = v;
        }
        StringBuilder finalRes = new StringBuilder();
        for(char v : resScheduleOdered){
            finalRes.append(v);
        }
        return finalRes.toString();
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
