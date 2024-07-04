import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Interval {
    int start;
    int end;
    int index;
    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int numIntervals = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(numIntervals);
                for (int i = 0; i < numIntervals; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    intervals.add(new Interval(start, end, i));
                }

                Collections.sort(intervals, Comparator.comparing((Interval interval) -> interval.start));
                boolean isNotPossible = numPersonsRequired(intervals) > 2;

                String result = isNotPossible ? "IMPOSSIBLE" : schedule(intervals);
                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static int numPersonsRequired(List<Interval> intervals) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (Interval interval: intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(interval.end);
            } else {
                if (interval.start >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
                heap.offer(interval.end);
            }
        }
        return count;
    }

    private static String schedule(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparing((Interval itl)->itl.start));

        Interval t = intervals.get(0);
        char[] output = new char[intervals.size()];
        output[t.index] = 'C';
        char currentRunning = 'C';
        for(int i=1; i<intervals.size(); i++){
            Interval c = intervals.get(i);
            if(c.start < t.end) {
                if (currentRunning == 'C')
                    output[c.index] = 'J';
                else
                    output[c.index] = 'C';
                t.end = Math.max(t.end, c.end);
                if (t.end == c.end)
                    currentRunning = output[c.index];
                else
                    currentRunning = output[t.index];
            } else {
                t = c;
                output[c.index] = 'C';
                currentRunning = 'C';
            }
        }
        return new String(output);
    }
}