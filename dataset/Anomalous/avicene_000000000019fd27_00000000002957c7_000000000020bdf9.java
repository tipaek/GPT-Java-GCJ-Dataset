package com.leprogrammeurmarocain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Interval interval = (Interval) obj;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            Map<String, List<Interval>> schedule = new HashMap<>();
            schedule.put("C", new ArrayList<>());
            schedule.put("J", new ArrayList<>());
            StringBuilder assignment = new StringBuilder();

            int activities = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < activities; j++) {
                String[] parts = scanner.nextLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                Interval interval = new Interval(start, end);

                if (!hasConflict(schedule.get("C"), interval)) {
                    assignment.append("C");
                    schedule.get("C").add(interval);
                } else if (!hasConflict(schedule.get("J"), interval)) {
                    assignment.append("J");
                    schedule.get("J").add(interval);
                } else {
                    assignment = new StringBuilder("IMPOSSIBLE");
                    while (++j < activities) scanner.nextLine();
                }
            }
            output.append("Case #").append(i + 1).append(": ").append(assignment).append("\n");
        }

        System.out.println(output.toString());
        scanner.close();
    }

    static boolean hasConflict(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (newInterval.getEnd() > interval.getStart() && newInterval.getEnd() <= interval.getEnd()) return true;
            if (newInterval.getStart() >= interval.getStart() && newInterval.getStart() < interval.getEnd()) return true;
        }
        return false;
    }
}