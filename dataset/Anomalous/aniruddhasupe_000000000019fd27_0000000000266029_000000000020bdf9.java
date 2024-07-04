import java.io.*;
import java.util.*;

public class Solution {

    public static boolean checkExists(List<int[]> schedules, int start, int end, int index) {
        schedules.sort(Comparator.comparingInt(o -> o[0]));

        for (int i = index; i < schedules.size(); i++) {
            int[] current = schedules.get(i);
            if ((current[1] <= start || current[0] >= end)) {
                if (i != schedules.size() - 1) {
                    return checkExists(schedules, start, end, i + 1);
                } else {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int work = scanner.nextInt();
            List<int[]> jamie = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            int start = scanner.nextInt();
            int end = scanner.nextInt();
            jamie.add(new int[]{start, end});
            schedule.append("J");

            for (int i = 1; i < work; i++) {
                start = scanner.nextInt();
                end = scanner.nextInt();

                if (checkExists(jamie, start, end, 0)) {
                    jamie.add(new int[]{start, end});
                    schedule.append("J");
                } else if (cameron.isEmpty() || checkExists(cameron, start, end, 0)) {
                    cameron.add(new int[]{start, end});
                    schedule.append("C");
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }
}