import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfDays = scanner.nextInt();

        int[][] start = new int[numberOfDays][];
        int[][] end = new int[numberOfDays][];

        for (int i = 0; i < numberOfDays; i++) {
            int activities = scanner.nextInt();

            start[i] = new int[activities];
            end[i] = new int[activities];

            for (int j = 0; j < activities; j++) {
                start[i][j] = scanner.nextInt();
                end[i][j] = scanner.nextInt();

            }
        }

        for (int i = 0; i < numberOfDays; i++) {
            System.out.println("Case #" + (i + 1) + " " + printAnswer(start[i], end[i]));

        }


    }

    public static String printAnswer(int[] start, int[] end) {


        char[] answer = new char[start.length];

        PriorityQueue<Range> pq = new PriorityQueue<>();

        LinkedList<Range> events1 = new LinkedList();
        LinkedList<Range> events2 = new LinkedList();

        for (int i = 0; i < start.length; i++) {
            pq.add(new Range(start[i], end[i], i));
        }

        events1.add(new Range(0, 0));
        events2.add(new Range(0, 0));

        while (pq.peek() != null) {
            Range r = pq.poll();
            int s = r.getStart();
            int e = r.getEnd();
            int index = r.getNumber();

            if (events1.getLast().getEnd() <= s) {
                events1.add(new Range(s, e));
                answer[index] = 'J';
            } else if (events2.getLast().getEnd() <= s) {
                events2.add(new Range(s, e));
                answer[index] = 'C';
            } else {
                return "IMPOSSIBLE";
                
            }

        }

        
        
        
        return new String(answer);

    }

}

class Range implements Comparable<Range> {

    int start;
    int end;
    int number;

    public Range(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public void setRange(int start, int end) {
        if (end > start && start >= 0) {
            this.start = start;
            this.end = end;
        }

    }

    public int getSize() {

        return end - start;
    }

    @Override
    public int compareTo(Range o) {
        return start - o.start;
    }

}