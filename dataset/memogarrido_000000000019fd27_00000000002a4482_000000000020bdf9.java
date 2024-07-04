package com.company;

import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public class Appointment {
        public int start;
        public int end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Appointment> comparator = new Comparator<Appointment>() {
            @Override
            public int compare(Appointment appointment, Appointment appointment2) {
                return appointment.start - appointment2.end;
            }
        };
        int testCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int activities = scanner.nextInt();
            boolean[] J = new boolean[24 * 60 + 1];
            boolean[] C = new boolean[24 * 60 + 1];
            StringBuilder schedule = new StringBuilder();
            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isAvailable(J, start, end)) {
                    schedule.append("J");
                    bookAppointment(J, start, end);
                } else if (isAvailable(C, start, end)) {
                    schedule.append("C");
                    bookAppointment(C, start, end);
                } else schedule = new StringBuilder("IMPOSSIBLE");
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, schedule.toString()));
        }
    }

    public static boolean isAvailable(boolean[] schedule, int from, int to) {
        int collition = 0;
        for (int i = from; i <= to; i++) {
            if (schedule[i])
                collition++;
        }
        return collition <= 1 && to-from>0;
    }

    public static void bookAppointment(boolean[] schedule, int from, int to) {
        for (int i = from; i <= to; i++) {
            schedule[i] = true;
        }
    }
}