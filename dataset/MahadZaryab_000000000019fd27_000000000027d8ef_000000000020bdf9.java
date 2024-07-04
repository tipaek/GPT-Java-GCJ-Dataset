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

            HashMap<Integer,Integer> endToInitialIndex = new HashMap<>();

            for (int i = 0; i < endTimes.length; i++) {
                endToInitialIndex.put(endTimes[i], i);
            }

            int [] sortedEndTimes = endTimes.clone();
            Arrays.sort(sortedEndTimes);
            int [] sortedStartTimes = new int[startTimes.length];
            for (int i = 0; i < sortedEndTimes.length; i++) {
                int value = sortedEndTimes[i];
                int index = endToInitialIndex.get(value);
                sortedStartTimes[i] = startTimes[index];
            }
            String tempResult = getSchedule(sortedStartTimes, sortedEndTimes);
            String result = ""; 
            if (tempResult.equals("IMPOSSIBLE"))
                result = "IMPOSSIBLE"; 
            else 
                result = revert(sortedEndTimes, endToInitialIndex, tempResult);
            
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
                isCFree = false;
                cFreeTime = endTimes[i];
            }
            else if (isJFree) {
                builder.append("J");
                isJFree = false;
                jFreeTime = endTimes[i];
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return builder.toString();
    }

    public static String revert (int [] sortedEndTimes, HashMap<Integer, Integer> map, String schedule) {
        StringBuilder builder = new StringBuilder(schedule.length());
        for (int i = 0; i < schedule.length(); i++)
            builder.append(' ');

        for (int i = 0; i < sortedEndTimes.length; i++) {
            int currentValue = sortedEndTimes[i];
            int actualIndex = map.get(currentValue);
            char currSchedule = schedule.charAt(i);
            builder.insert(actualIndex, currSchedule);
        }

        return builder.toString().replaceAll("\\s+","");
    }
}