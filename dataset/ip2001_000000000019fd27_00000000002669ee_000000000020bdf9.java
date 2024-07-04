
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
            System.out.print("Case #" + (i + 1) + " ");
            printAnswer(start[i], end[i]);
            if (i != numberOfDays - 1) {
                System.out.print("\n");
            }

        }


    }

    public static void printAnswer(int[] start, int[] end) {


        String answer = "";

        PriorityQueue<Range> pq = new PriorityQueue<>();

        LinkedList<Range> events1 = new LinkedList();
        LinkedList<Range> events2 = new LinkedList();

        for (int i = 0; i < start.length; i++) {
            pq.add(new Range(start[i], end[i]));
        }

        events1.add(new Range(0, 0));
        events2.add(new Range(0, 0));

        while (pq.peek() != null) {
            Range r = pq.poll();
            int s = r.getStart();
            int e = r.getEnd();

            if (events1.getLast().getEnd() <= s) {
                events1.add(new Range(s, e));
                answer += "J";
            } else if (events2.getLast().getEnd() <= s) {
                events2.add(new Range(s, e));
                answer += "C";
            } else {
                answer = "IMPOSSIBLE";
                break;
            }

        }

        System.out.print(answer);

    }

}

class Range implements Comparable<Range> {

    int start;
    int end;

    public Range(int start, int end) {
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
