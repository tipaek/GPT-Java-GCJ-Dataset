package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0; i < cases; i++) {
            int times = scanner.nextInt();
            ArrayList<Times> timeSlots = new ArrayList<>();
            for(int j = 0; j < times; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots.add(new Times(start, end));
            }
            solveCase(i, timeSlots);
        }
    }

    public static void solveCase(int caseNum, ArrayList<Times> timeSlots) {
        System.out.print("Case #" + (caseNum + 1) + ": ");
        StringBuilder solution = new StringBuilder("");
        ArrayList<Times> Cs = new ArrayList<>();
        ArrayList<Times> Js = new ArrayList<>();

        if(assignTime(timeSlots, Cs, Js)) {
            for(int i = 0; i < timeSlots.size(); i++) {
                solution.append(timeSlots.get(i).assignee);
            }
        } else {
            solution.append("IMPOSSIBLE");
        }
        System.out.println(solution);
    }

    public static boolean assignTime(ArrayList<Times> timeSlots, ArrayList<Times> Cs, ArrayList<Times> Js) {
        if(timeSlots.size() == 0) {
            return true;
        }

        boolean possible;

        Times tryTimeSlot = timeSlots.get(0);
        if(canAdd(tryTimeSlot, Cs)) {
            Cs.add(tryTimeSlot);
            tryTimeSlot.assignee = "C";
            timeSlots.remove(0);
            possible = assignTime(timeSlots, Cs, Js);
            timeSlots.add(0, tryTimeSlot);
        } else if (canAdd(tryTimeSlot, Js)) {
            Js.add(tryTimeSlot);
            tryTimeSlot.assignee = "J";
            timeSlots.remove(0);
            possible = assignTime(timeSlots, Cs, Js);
            timeSlots.add(0, tryTimeSlot);
        } else {
            possible = false;
        }

        return possible;
    }

    public static boolean canAdd(Times possibleTimeSlot, ArrayList<Times> person) {
        for(Times timeSlot: person) {
            if(timesConflict(possibleTimeSlot, timeSlot)) {
                return false;
            }
        }
        return true;
    }

    public static boolean timesConflict(Times first, Times second) {
        if((first.start >= second.start && first.start < second.end) || (first.end > second.start && first.end <= second.end)) {
            return true;
        }
        if((second.start >= first.start && second.start < first.end) || (second.end > first.start && second.end <= first.end)) {
            return true;
        }
        return false;
    }
}

class Times {
    int start;
    int end;
    String assignee;

    public Times(int s, int e) {
        start = s;
        end = e;
        assignee = "";
    }
}