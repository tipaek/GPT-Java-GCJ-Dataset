import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int c = 1; c <= t; ++c) {
            int n = s.nextInt();
            HashSet<Integer> tempSet = new HashSet<>();
            HashMap<Integer, LinkedList<Integer>> startTimes = new HashMap<>();
            HashMap<Integer, LinkedList<Integer>> endTimes = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                int startTime = s.nextInt();
                int endTime = s.nextInt();
                startTimes.computeIfAbsent(startTime, k -> new LinkedList<>()).add(i);
                endTimes.computeIfAbsent(endTime, k -> new LinkedList<>()).add(i);
            }
            tempSet.addAll(startTimes.keySet());
            tempSet.addAll(endTimes.keySet());
            TreeSet<Integer> sortedTimes = new TreeSet<>(tempSet);

            String output = getOutput(n, startTimes, endTimes, sortedTimes);
            System.out.println("Case #" + c + ": " + output);
        }
    }

    private static String getOutput(int n, HashMap<Integer, LinkedList<Integer>> startTimes, HashMap<Integer, LinkedList<Integer>> endTimes, TreeSet<Integer> sortedTimes) {
        char output[] = new char[n];
        int[] cjStatus = {0, 0};
        for (int time : sortedTimes) {
            LinkedList<Integer> list;
            if (endTimes.containsKey(time)) {
                list = endTimes.get(time);
                for (int pos : list) {
                    char cOrJ = output[pos];
                    freeUpStatus(cjStatus, cOrJ);
                }
            }
            if (startTimes.containsKey(time)) {
                list = startTimes.get(time);
                for (int pos : list) {
                    if (!hasFree(cjStatus)) {
                        return "IMPOSSIBLE";
                    }
                    char cOrJ = getFree(cjStatus);
                    output[pos] = cOrJ;
                    markNotFree(cjStatus, cOrJ);
                }
            }
        }
        return new String(output);
    }

    private static void markNotFree(int[] cjStatus, char cOrJ) {
        int pos = 0;
        if (cOrJ == 'J') pos = 1;
        cjStatus[pos] = 1;
    }

    private static char getFree(int[] cjStatus) {
        if (cjStatus[0] == 0) return 'C';
        else return 'J';
    }

    private static boolean hasFree(int[] cjStatus) {
        return cjStatus[0] == 0 || cjStatus[1] == 0;
    }

    private static void freeUpStatus(int[] cjStatus, char cOrJ) {
        int pos = 0;
        if (cOrJ == 'J') pos = 1;
        cjStatus[pos] = 0;
    }
}