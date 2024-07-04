import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < nTestCases; i++) {
            int nActivities = in.nextInt();
            Map<Integer, ArrayList<Integer>> activityMap = new TreeMap<Integer, ArrayList<Integer>>();
            Map<String, Integer> activityNumberMap = new HashMap<>();
            for (int j = 0; j < nActivities; j++) {
                int startMinutes = in.nextInt();
                int endMinutes = in.nextInt();
                String activityNumberKey = startMinutes + "-" + endMinutes;
                activityNumberMap.put(activityNumberKey, j);

                if (activityMap.containsKey(startMinutes)) {
                    activityMap.get(startMinutes).add(endMinutes);

                } else {
                    ArrayList<Integer> endList = new ArrayList<>();
                    endList.add(endMinutes);
                    activityMap.put(startMinutes, endList);
                }
            }
            scheduleActivities(activityMap, activityNumberMap, i + 1);
        }
    }

    private static void scheduleActivities(Map<Integer, ArrayList<Integer>> activityMap, Map<String, Integer> activityNumberMap, int nCase) {
        int cameronTimeline[] = new int[1441];
        int jamieTimeline[] = new int[1441];

        StringBuilder activityTimeline = new StringBuilder();
        activityTimeline.append(String.format("%" + activityMap.size() + "s", "").replace(' ', '0'));
        boolean isImpossible = false;

        for (Integer startTime : activityMap.keySet()) {
            ArrayList<Integer> endTimeList = activityMap.get(startTime);
            if ( !isImpossible ) {
                if ( endTimeList.size() > 2) {
                    isImpossible = true;
                } else {
                    for (Integer endTime: endTimeList) {
                        String activityKey = startTime + "-" + endTime;
                        int activityNumberIndex = activityNumberMap.get(activityKey);
                        // Check Cameron is busy or not
                        if (!checkPersonBusyInRange(startTime, endTime, cameronTimeline)) {
                            for (int i = startTime; i <= endTime; i++) {
                                cameronTimeline[i] = 1;
                            }
                            activityTimeline.setCharAt( activityNumberIndex, 'C');
                        } else {
                            // Check if Jamie is busy
                            if (!checkPersonBusyInRange(startTime, endTime, jamieTimeline)) {
                                for (int i = startTime; i <= endTime; i++) {
                                    jamieTimeline[i] = 1;
                                }
                                activityTimeline.setCharAt( activityNumberIndex, 'J');
                            } else {
                                isImpossible = true;
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }

        if ( isImpossible ) {
            System.out.println("Case #" + nCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + nCase + ": " + activityTimeline.toString());
        }
    }

    private static boolean checkPersonBusyInRange(Integer start, Integer end, int[] timeline) {
        for (int i = start+1; i < end ; i++) {
            if (timeline[i] == 1) {
                return true;
            }
        }

        return false;
    }
}
