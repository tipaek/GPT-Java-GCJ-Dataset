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

            String result = processIntervals(start, end, g, startTable, endTable);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String processIntervals(ArrayList<Integer> start, ArrayList<Integer> end, int length, HashMap<Integer, Integer> startTable, HashMap<Integer, Integer> endTable) {
        String[] output = new String[length];
        ArrayList<Integer> sortedEnd = new ArrayList<>(end);
        Collections.sort(sortedEnd);
        ArrayList<Integer> sortedStart = sortAccordingToEnd(sortedEnd, start, endTable);

        int[] increasing = new int[length];
        int[] parent = new int[length];
        for (int i = 0; i < length; i++) {
            increasing[i] = 1;
            parent[i] = i;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedEnd.get(i) > sortedEnd.get(j) && increasing[i] < increasing[j] + 1 && sortedStart.get(i) >= sortedEnd.get(j)) {
                    increasing[i] = increasing[j] + 1;
                    parent[i] = j;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (increasing[i] > max) {
                max = increasing[i];
                index = i;
            }
        }

        ArrayList<Integer> first = new ArrayList<>();
        for (int i = max; i > 0; i--) {
            first.add(endTable.get(sortedEnd.get(index)));
            index = parent[index];
        }

        for (int i = 0; i < length; i++) {
            if (first.contains(i)) {
                output[i] = "J";
            }
        }

        for (int i = 0; i < length; i++) {
            increasing[i] = 1;
            parent[i] = i;
        }

        for (int i = 1; i < sortedEnd.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sortedEnd.get(i) > sortedEnd.get(j) && increasing[i] < increasing[j] + 1 && sortedStart.get(i) >= sortedEnd.get(j)) {
                    increasing[i] = increasing[j] + 1;
                    parent[i] = j;
                }
            }
        }

        max = 0;
        index = 0;
        for (int i = 0; i < sortedEnd.size(); i++) {
            if (increasing[i] > max) {
                max = increasing[i];
                index = i;
            }
        }

        for (int i = max; i > 0; i--) {
            index = parent[index];
        }

        if (!sortedEnd.isEmpty()) {
            return "IMPOSSIBLE";
        } else {
            for (int i = 0; i < length; i++) {
                if (output[i] == null) {
                    output[i] = "C";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : output) {
            result.append(s);
        }

        return result.toString();
    }

    private static ArrayList<Integer> sortAccordingToEnd(ArrayList<Integer> sortedEnd, ArrayList<Integer> start, HashMap<Integer, Integer> endTable) {
        ArrayList<Integer> sortedStart = new ArrayList<>();
        for (Integer endTime : sortedEnd) {
            sortedStart.add(start.get(endTable.get(endTime)));
        }
        return sortedStart;
    }
}