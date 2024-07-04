import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] p1 = new int[1440];
            int[] p2 = new int[1440];
            
            int numActivities = in.nextInt();
            int[] start = new int[numActivities];
            int[] end = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();
            
            for (int j = 0; j < numActivities; j++) {
                start[j] = in.nextInt();
                end[j] = in.nextInt();
                sortedActivities.put(start[j], j);
            }

            int[] sortedStart = new int[numActivities];
            int[] sortedEnd = new int[numActivities];
            int count = 0;
            for (int index : sortedActivities.values()) {
                sortedStart[count] = start[index];
                sortedEnd[count] = end[index];
                count++;
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < numActivities; j++) {
                if (!result.toString().equals("IMPOSSIBLE")) {
                    if (isEmpty(p1, sortedStart[j], sortedEnd[j])) {
                        change(p1, sortedStart[j], sortedEnd[j]);
                        result.append("C");
                    } else if (isEmpty(p2, sortedStart[j], sortedEnd[j])) {
                        change(p2, sortedStart[j], sortedEnd[j]);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                char[] finalResult = new char[numActivities];
                for (int j = 0; j < numActivities; j++) {
                    finalResult[sortedActivities.get(start[j])] = result.charAt(j);
                }
                results[i] = new String(finalResult);
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        in.close();
    }

    public static boolean isEmpty(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean change(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i]++;
            if (arr[i] > 2) {
                return false;
            }
        }
        return true;
    }
}