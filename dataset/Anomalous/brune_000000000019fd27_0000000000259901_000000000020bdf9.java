package uke8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            int g = Integer.parseInt(in.readLine());
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();
            HashMap<Integer, Integer> startTable = new HashMap<>();
            HashMap<Integer, Integer> endTable = new HashMap<>();

            for (int j = 0; j < g; j++) {
                String[] s = in.readLine().split(" ");
                int startTime = Integer.parseInt(s[0]);
                int endTime = Integer.parseInt(s[1]);
                start.add(startTime);
                end.add(endTime);
                startTable.put(startTime, j);
                endTable.put(endTime, j);
            }

            String result = findSchedule(start, end, g, startTable, endTable);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findSchedule(ArrayList<Integer> start, ArrayList<Integer> end, int length, 
                                       HashMap<Integer, Integer> startTable, HashMap<Integer, Integer> endTable) {
        String[] output = new String[length];
        ArrayList<Integer> sortedEnd = new ArrayList<>(end);
        Collections.sort(sortedEnd);
        ArrayList<Integer> sortedStart = sortBasedOnEnd(sortedEnd, start, endTable);

        int[] increasing = new int[length];
        int[] parent = new int[length];
        for (int i = 0; i < length; i++) {
            increasing[i] = 1;
            parent[i] = i;
        }

        findIncreasingSubsequence(sortedEnd, sortedStart, length, increasing, parent);

        ArrayList<Integer> first = extractSubsequence(length, increasing, parent, sortedEnd, endTable, output, "J");
        ArrayList<Integer> remainingSortedEnd = new ArrayList<>(sortedEnd);
        ArrayList<Integer> remainingSortedStart = new ArrayList<>(sortedStart);

        removeSubsequence(first, remainingSortedEnd, remainingSortedStart);

        findIncreasingSubsequence(remainingSortedEnd, remainingSortedStart, remainingSortedEnd.size(), increasing, parent);
        ArrayList<Integer> second = extractSubsequence(remainingSortedEnd.size(), increasing, parent, remainingSortedEnd, endTable, output, "C");

        if (!remainingSortedEnd.isEmpty()) {
            return "IMPOSSIBLE";
        }

        return String.join("", output);
    }

    private static void findIncreasingSubsequence(ArrayList<Integer> sortedEnd, ArrayList<Integer> sortedStart, int length, 
                                                  int[] increasing, int[] parent) {
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedEnd.get(i) > sortedEnd.get(j) && increasing[i] < increasing[j] + 1 &&
                    sortedStart.get(i) >= sortedEnd.get(j)) {
                    increasing[i] = increasing[j] + 1;
                    parent[i] = j;
                }
            }
        }
    }

    private static ArrayList<Integer> extractSubsequence(int length, int[] increasing, int[] parent, 
                                                         ArrayList<Integer> sortedEnd, HashMap<Integer, Integer> endTable, 
                                                         String[] output, String label) {
        int max = 0, index = 0;
        for (int i = 0; i < length; i++) {
            if (increasing[i] > max) {
                max = increasing[i];
                index = i;
            }
        }

        ArrayList<Integer> subsequence = new ArrayList<>();
        for (int i = max; i > 0; i--) {
            int originalIndex = endTable.get(sortedEnd.get(index));
            subsequence.add(originalIndex);
            output[originalIndex] = label;
            index = parent[index];
        }
        return subsequence;
    }

    private static void removeSubsequence(ArrayList<Integer> subsequence, ArrayList<Integer> sortedEnd, ArrayList<Integer> sortedStart) {
        for (int index : subsequence) {
            sortedEnd.remove(index);
            sortedStart.remove(index);
        }
    }

    private static ArrayList<Integer> sortBasedOnEnd(ArrayList<Integer> sortedEnd, ArrayList<Integer> start, HashMap<Integer, Integer> endTable) {
        ArrayList<Integer> sortedStart = new ArrayList<>();
        for (int endTime : sortedEnd) {
            int originalIndex = endTable.get(endTime);
            sortedStart.add(start.get(originalIndex));
        }
        return sortedStart;
    }
}