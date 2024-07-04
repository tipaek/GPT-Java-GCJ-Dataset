import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int currentCase = testCases;

        while (testCases > 0) {
            testCases--;
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalOrder = new int[n];
            Map<Integer, Integer> startToEndMap = new HashMap<>();
            Map<Integer, Integer> secondaryMap = new HashMap<>();
            int[] occurrences = new int[1440];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                startTimes[i] = start;
                endTimes[i] = end;
                originalOrder[i] = start;
                occurrences[start]++;
                if (!startToEndMap.containsKey(start)) {
                    startToEndMap.put(start, end);
                    secondaryMap.put(start, end);
                } else {
                    if (startToEndMap.get(start) < end) {
                        startToEndMap.put(start, end);
                    } else {
                        secondaryMap.put(start, end);
                    }
                }
            }

            Arrays.sort(startTimes);
            Map<Integer, Integer> sortedMap = new TreeMap<>(startToEndMap);
            StringBuilder result = new StringBuilder();
            char[] assignments = new char[1441];
            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = startTimes[i];
                if (occurrences[start] > 2) {
                    isImpossible = true;
                    result.append("IMPOSSIBLE");
                    break;
                }

                if (start >= cEnd) {
                    assignments[start] = 'C';
                    cEnd = sortedMap.get(start);
                    if (occurrences[start] == 2) {
                        if (start >= jEnd) {
                            jEnd = secondaryMap.get(start);
                        }
                        i++;
                    }
                } else if (start >= jEnd) {
                    assignments[start] = 'J';
                    jEnd = sortedMap.get(start);
                } else {
                    isImpossible = true;
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (currentCase - testCases) + ": " + result);
            } else {
                int[] taskCount = new int[1441];
                for (int i = 0; i < n; i++) {
                    int start = originalOrder[i];
                    taskCount[start]++;
                    if (taskCount[start] == 2) {
                        if (assignments[start] == 'C') {
                            result.append('J');
                        } else {
                            result.append('C');
                        }
                    } else {
                        result.append(assignments[start]);
                    }
                }
                System.out.println("Case #" + (currentCase - testCases) + ": " + result);
            }
        }
    }
}