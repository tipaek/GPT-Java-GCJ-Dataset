import java.util.*;

class time implements Comparable<time> {
    public int startTime;
    public int endTime;
    public int originalIndex;

    public time(int startTime, int endTime, int originalIndex) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(time comparestu) {
        int compareStartingTime=((time)comparestu).startTime;
        /* For Ascending order*/
        return this.startTime-compareStartingTime;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int test = 1; test <= numTests; test++) {
            int numActivities = in.nextInt();
            List<time> times = new ArrayList<>();
            for (int num = 0; num < numActivities; num++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                time time = new time(startTime, endTime, num);
                times.add(time);
            }

            Collections.sort(times);

            String tempResult = getSchedule(times);
            String result = "";
            if (tempResult.equals("IMPOSSIBLE"))
                result = "IMPOSSIBLE";
            else
                result = revert(times, tempResult);

            System.out.printf("Case #%s: %s", test, result);
            if (test != numTests)
                System.out.println();
        }
    }

    public static String getSchedule(List<time> times) {
        StringBuilder builder = new StringBuilder();
        boolean isCFree = true;
        boolean isJFree = true;
        int cFreeTime = 0;
        int jFreeTime = 0;
        for (int i = 0; i < times.size(); i++) {
            //System.out.println(cFreeTime);
            int currTime = times.get(i).startTime;
            isCFree = currTime >= cFreeTime;
            isJFree = currTime >= jFreeTime;
            if (isCFree) {
//                System.out.println("C");
                builder.append("C");
                cFreeTime = times.get(i).endTime;
            }
            else if (isJFree) {
//                System.out.println("J");
                builder.append("J");
                jFreeTime = times.get(i).endTime;
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return builder.toString();
    }

    public static String revert (List<time> times, String schedule) {
        StringBuilder builder = new StringBuilder(schedule.length());
        for (int i = 0; i < schedule.length(); i++)
            builder.append(' ');

        for (int i = 0; i < schedule.length(); i++) {
            char currSchedule = schedule.charAt(i);
            int index = times.get(i).originalIndex;
            builder.insert(index, currSchedule);
        }

        return builder.toString().replaceAll("\\s+","");
    }
}