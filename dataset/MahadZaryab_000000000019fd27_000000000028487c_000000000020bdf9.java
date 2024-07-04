import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int test = 1; test <= numTests; test++) {
            int numActivities = in.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            for (int num = 0; num < numActivities*2; num++) {
                int time = in.nextInt();
                int index = num / 2;
                if (num % 2 == 0)
                    startTimes[index] = time;
                else
                    endTimes[index] = time;
            }

            HashMap<Integer,Integer> startToInitialIndex = new HashMap<>();

            for (int i = 0; i < startTimes.length; i++) {
                startToInitialIndex.put(startTimes[i], i);
            }

            // int [] sortedEndTimes = endTimes.clone();
            int [] sortedStartTimes = startTimes.clone();
            Arrays.sort(sortedStartTimes);
            int [] sortedEndTimes = new int[endTimes.length];
            for (int i = 0; i < sortedStartTimes.length; i++) {
                int value = sortedStartTimes[i];
                int index = startToInitialIndex.get(value);
                sortedEndTimes[i] = endTimes[index];
            }

            String tempResult = getSchedule(sortedStartTimes, sortedEndTimes);
            String result = "";
            if (tempResult.equals("IMPOSSIBLE"))
                result = "IMPOSSIBLE";
            else
                result = revert(sortedStartTimes, startToInitialIndex, tempResult);

            System.out.printf("Case #%s: %s", test, result);
            System.out.println();
        }
    }

    public static String getSchedule(int[] startTimes, int[] endTimes) {
        StringBuilder builder = new StringBuilder();
        boolean isCFree = false;
        boolean isJFree = true;
        int cFreeTime = endTimes[0];
        int jFreeTime = 0;
        builder.append("C");
        for (int i = 1; i < startTimes.length; i++) {
            //System.out.println(cFreeTime);
            int currTime = startTimes[i];
            isCFree = currTime >= cFreeTime;
            isJFree = currTime >= jFreeTime;

            if (isCFree) {
                builder.append("C");
                cFreeTime = endTimes[i];
            }
            else if (isJFree) {
                builder.append("J");
                jFreeTime = endTimes[i];
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return builder.toString();
    }

    public static String revert (int [] sortedStartTimes, HashMap<Integer, Integer> map, String schedule) {
        StringBuilder builder = new StringBuilder(schedule.length());
        for (int i = 0; i < schedule.length(); i++)
            builder.append(' ');

        for (int i = 0; i < sortedStartTimes.length; i++) {
            int currentValue = sortedStartTimes[i];
            int actualIndex = map.get(currentValue);
            char currSchedule = schedule.charAt(i);
            builder.insert(actualIndex, currSchedule);
        }

        return builder.toString().replaceAll("\\s+","");
    }
}