import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int intervalsCount = scanner.nextInt();
            Interval[] intervals = new Interval[intervalsCount];
            Point[] points = new Point[2 * intervalsCount];
            
            for (int i = 0; i < intervalsCount; i++) {
                Point start = new Point(scanner.nextInt(), i);
                Point end = new Point(scanner.nextInt(), i);
                points[2 * i] = start;
                points[2 * i + 1] = end;
                intervals[i] = new Interval(start, end);
            }
            
            Arrays.sort(points);
            boolean[] assignments = new boolean[intervalsCount];
            boolean isImpossible = false;
            List<Interval> activeIntervals = new ArrayList<>();
            
            for (Point point : points) {
                Interval currentInterval = intervals[point.index];
                
                if (activeIntervals.contains(currentInterval)) {
                    activeIntervals.remove(currentInterval);
                } else {
                    currentInterval.assignedToPerson = false;
                    int countPerson1 = 0;
                    int countPerson2 = 0;
                    
                    for (Interval interval : activeIntervals) {
                        if (point.compareTo(interval.end) < 0) {
                            if (interval.assignedToPerson) {
                                countPerson2++;
                            } else {
                                countPerson1++;
                            }
                        }
                    }
                    
                    if (countPerson1 > 0 && countPerson2 > 0) {
                        isImpossible = true;
                    } else if (countPerson1 > 0) {
                        currentInterval.assignedToPerson = true;
                    }
                    activeIntervals.add(currentInterval);
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Interval interval : intervals) {
                    result.append(interval.assignedToPerson ? "J" : "C");
                }
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
    }
}

class Interval {
    Point start, end;
    boolean assignedToPerson;
    
    public Interval(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

class Point implements Comparable<Point> {
    int time, index;
    
    public Point(int time, int index) {
        this.time = time;
        this.index = index;
    }
    
    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.time, other.time);
    }
}