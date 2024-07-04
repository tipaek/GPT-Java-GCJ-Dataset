import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int currentCase = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalOrder = new int[n];
            HashMap<Integer, Integer> endTimeMap = new HashMap<>();
            HashMap<Integer, Integer> secondaryEndTimeMap = new HashMap<>();
            int[] countPerTime = new int[1441];
            char[] assignedTo = new char[1441];
            char[] secondaryAssignment = new char[1441];
            String result = "";

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                startTimes[i] = start;
                endTimes[i] = end;
                originalOrder[i] = start;
                countPerTime[start]++;

                if (!endTimeMap.containsKey(start)) {
                    endTimeMap.put(start, end);
                    secondaryEndTimeMap.put(start, end);
                } else {
                    if (endTimeMap.get(start) < end) {
                        endTimeMap.put(start, end);
                        secondaryAssignment[start] = 's';
                    } else {
                        secondaryEndTimeMap.put(start, end);
                        secondaryAssignment[start] = 'l';
                    }
                }
            }

            Arrays.sort(startTimes);
            TreeMap<Integer, Integer> sortedEndTimeMap = new TreeMap<>(endTimeMap);
            int cameronEnd = 0, jamieEnd = 0;
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                if (countPerTime[startTimes[i]] > 2) {
                    isImpossible = true;
                    result = "IMPOSSIBLE";
                    break;
                }

                if (startTimes[i] >= cameronEnd) {
                    assignedTo[startTimes[i]] = 'C';
                    cameronEnd = sortedEndTimeMap.get(startTimes[i]);
                    if (countPerTime[startTimes[i]] == 2) {
                        if (startTimes[i] >= jamieEnd) {
                            jamieEnd = secondaryEndTimeMap.get(startTimes[i]);
                        }
                        i++;
                    }
                } else if (startTimes[i] >= jamieEnd) {
                    assignedTo[startTimes[i]] = 'J';
                    jamieEnd = sortedEndTimeMap.get(startTimes[i]);
                } else {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                int[] occurrence = new int[1441];
                for (int i = 0; i < n; i++) {
                    occurrence[originalOrder[i]]++;

                    if ((secondaryAssignment[originalOrder[i]] == 's' && occurrence[originalOrder[i]] == 1) ||
                        (secondaryAssignment[originalOrder[i]] == 'l' && occurrence[originalOrder[i]] == 2)) {
                        result += (assignedTo[originalOrder[i]] == 'C') ? 'J' : 'C';
                    } else {
                        result += assignedTo[originalOrder[i]];
                    }
                }
            }

            System.out.println("Case #" + currentCase + ": " + result);
            currentCase++;
        }
    }
}