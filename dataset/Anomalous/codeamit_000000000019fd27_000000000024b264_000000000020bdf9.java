package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PPR {

    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private int numCases;

    public static void main(String[] args) {
        try {
            new PPR().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            processCase(i);
        }
    }

    private void processCase(int caseNumber) throws IOException {
        long N = Long.parseLong(in.readLine());
        char[] result = new char[(int) N];
        LinkedList<Integer> J = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            String[] intervals = in.readLine().split(" ");
            int start = Integer.parseInt(intervals[0]);
            int end = Integer.parseInt(intervals[1]);

            if (J.isEmpty() && C.isEmpty()) {
                J.add(start);
                J.add(end);
                result[i] = 'J';
            } else if (J.isEmpty()) {
                if (canAddToList(C, start, end)) {
                    C.add(start);
                    C.add(end);
                    result[i] = 'C';
                } else {
                    J.add(start);
                    J.add(end);
                    result[i] = 'J';
                }
            } else if (C.isEmpty()) {
                if (canAddToList(J, start, end)) {
                    J.add(start);
                    J.add(end);
                    result[i] = 'J';
                } else {
                    C.add(start);
                    C.add(end);
                    result[i] = 'C';
                }
            } else {
                if (canAddToList(J, start, end)) {
                    J.add(start);
                    J.add(end);
                    result[i] = 'J';
                } else if (canAddToList(C, start, end)) {
                    C.add(start);
                    C.add(end);
                    result[i] = 'C';
                } else {
                    isPossible = false;
                    out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
                    break;
                }
            }
        }

        if (isPossible) {
            out.printf("Case #%d: %s%n", caseNumber, new String(result));
        }
    }

    private boolean canAddToList(LinkedList<Integer> list, int start, int end) {
        return list.getLast() <= start || list.getFirst() >= end;
    }
}