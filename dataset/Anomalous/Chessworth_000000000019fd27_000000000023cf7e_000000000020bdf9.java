import java.util.*;
import java.io.*;

class Solution {

    private static final int MAX_PRIORITY = 24 * 60 + 1;

    public static int calculatePriority(List<Integer> schedule, int start, int end) {
        int priority = 0;

        if (schedule.isEmpty()) {
            return 0;
        }

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
                priority = MAX_PRIORITY;
            }
        }

        return priority;
    }

    public static int findOrdinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1) {
            pos = str.indexOf(substr, pos + 1);
        }
        return pos;
    }

    public static String resolveOverlap(List<Integer> primary, List<Integer> secondary, int start, int end, StringBuilder output) {
        for (int i = 0; i < primary.size(); i += 2) {
            if ((start > primary.get(i) && start < primary.get(i + 1) && (i + 2 >= primary.size() || end < primary.get(i + 2))) ||
                (end > primary.get(i) && end < primary.get(i + 1) && (i == 0 || start > primary.get(i - 1)))) {

                int errorStart = primary.get(i);
                int errorEnd = primary.get(i + 1);
                int otherPriority = calculatePriority(secondary, errorStart, errorEnd);

                if (otherPriority != MAX_PRIORITY) {
                    secondary.add(errorStart);
                    secondary.add(errorEnd);
                    primary.remove(i + 1);
                    primary.remove(i);
                    primary.add(start);
                    primary.add(end);
                    Collections.sort(primary);
                    Collections.sort(secondary);

                    int changeIndex = findOrdinalIndexOf(output.toString(), "J", i / 2 + 1);
                    output.replace(changeIndex, changeIndex + 1, "C");
                    output.append("J");
                    return output.toString();
                }
            }
        }

        for (int i = 0; i < secondary.size(); i += 2) {
            if ((start > secondary.get(i) && start < secondary.get(i + 1) && (i + 2 >= secondary.size() || end < secondary.get(i + 2))) ||
                (end > secondary.get(i) && end < secondary.get(i + 1) && (i == 0 || start > secondary.get(i - 1)))) {

                int errorStart = secondary.get(i);
                int errorEnd = secondary.get(i + 1);
                int otherPriority = calculatePriority(primary, errorStart, errorEnd);

                if (otherPriority != MAX_PRIORITY) {
                    primary.add(errorStart);
                    primary.add(errorEnd);
                    secondary.remove(i + 1);
                    secondary.remove(i);
                    secondary.add(start);
                    secondary.add(end);
                    Collections.sort(primary);
                    Collections.sort(secondary);

                    int changeIndex = findOrdinalIndexOf(output.toString(), "C", i / 2 + 1);
                    output.replace(changeIndex, changeIndex + 1, "J");
                    output.append("C");
                    return output.toString();
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = input.nextInt();
            List<Integer> jamieSchedule = new ArrayList<>();
            List<Integer> cameronSchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int j = 1; j <= n; j++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();

                if (j == 1) {
                    jamieSchedule.add(startTime);
                    jamieSchedule.add(endTime);
                    output.append('J');
                } else {
                    int jamiePriority = calculatePriority(jamieSchedule, startTime, endTime);
                    int cameronPriority = calculatePriority(cameronSchedule, startTime, endTime);

                    if (jamiePriority <= cameronPriority && jamiePriority != MAX_PRIORITY) {
                        jamieSchedule.add(startTime);
                        jamieSchedule.add(endTime);
                        Collections.sort(jamieSchedule);
                        output.append('J');
                    } else if (jamiePriority == MAX_PRIORITY && cameronPriority == MAX_PRIORITY) {
                        StringBuilder result = new StringBuilder(resolveOverlap(jamieSchedule, cameronSchedule, startTime, endTime, output));
                        if (result.toString().isEmpty()) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            continue;
                        } else {
                            output = result;
                        }
                    } else {
                        cameronSchedule.add(startTime);
                        cameronSchedule.add(endTime);
                        Collections.sort(cameronSchedule);
                        output.append('C');
                    }
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}