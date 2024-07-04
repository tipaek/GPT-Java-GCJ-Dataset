import java.util.*;
import java.io.*;

class Solution {

    public static int getPriority(List<Integer> schedule, int start, int end) {
        int priority = 0;
        for (int i = 0; i < schedule.size(); i += 2) {
            int taskStart = schedule.get(i);
            int taskEnd = schedule.get(i + 1);

            if (i == 0 && end <= taskStart) {
                priority = taskStart - end;
                break;
            } else if (start >= taskEnd) {
                if (i == schedule.size() - 2) {
                    priority = start - taskEnd;
                    break;
                } else if (end <= schedule.get(i + 2)) {
                    priority = (schedule.get(i + 2) - end) + (start - taskEnd);
                    break;
                }
            } else {
                priority = 24 * 60;
            }
        }
        return priority;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            List<Integer> jamie = new ArrayList<>();
            List<Integer> cameron = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int j = 1; j <= n; j++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();

                if (j == 1) {
                    jamie.add(startTime);
                    jamie.add(endTime);
                    output.append('J');
                } else {
                    int jamiePriority = getPriority(jamie, startTime, endTime);
                    int cameronPriority = getPriority(cameron, startTime, endTime);

                    if (jamiePriority <= cameronPriority && jamiePriority != 24 * 60) {
                        jamie.add(startTime);
                        jamie.add(endTime);
                        Collections.sort(jamie);
                        output.append('J');
                    } else if (jamiePriority == 24 * 60 && cameronPriority == 24 * 60) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        continue;
                    } else {
                        cameron.add(startTime);
                        cameron.add(endTime);
                        Collections.sort(cameron);
                        output.append('C');
                    }
                }
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}