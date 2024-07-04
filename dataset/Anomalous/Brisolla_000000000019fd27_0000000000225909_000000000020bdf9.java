import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<Schedule> schedules = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                schedules.add(new Schedule(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(schedules);

            boolean isJamieFree = true;
            boolean isCameronFree = true;
            int jamieFreeAt = -1;
            int cameronFreeAt = -1;
            StringBuilder resultBuilder = new StringBuilder();

            for (Schedule schedule : schedules) {
                if (!isJamieFree && schedule.start >= jamieFreeAt) {
                    isJamieFree = true;
                }

                if (!isCameronFree && schedule.start >= cameronFreeAt) {
                    isCameronFree = true;
                }

                if (isCameronFree) {
                    resultBuilder.append("C");
                    cameronFreeAt = schedule.finish;
                    isCameronFree = false;
                } else if (isJamieFree) {
                    resultBuilder.append("J");
                    jamieFreeAt = schedule.finish;
                    isJamieFree = false;
                } else {
                    resultBuilder.setLength(0);
                    resultBuilder.append("IMPOSSIBLE");
                    break;
                }
            }

            String result = resultBuilder.toString();
            if (!result.equals("IMPOSSIBLE")) {
                result = normalizeResult(schedules, result);
            }

            System.out.printf("Case #%d: %s\n", caseNum, result);
        }
    }

    private static String normalizeResult(List<Schedule> schedules, String unbalancedResult) {
        char[] resultArray = new char[schedules.size()];
        for (Schedule schedule : schedules) {
            resultArray[schedule.originOrder] = unbalancedResult.charAt(schedules.indexOf(schedule));
        }
        return new String(resultArray);
    }
}

class Schedule implements Comparable<Schedule> {
    int start;
    int finish;
    int originOrder;

    Schedule(int start, int finish, int originOrder) {
        this.start = start;
        this.finish = finish;
        this.originOrder = originOrder;
    }

    @Override
    public int compareTo(Schedule other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " - " + finish + "]";
    }
}