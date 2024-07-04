import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
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
                Interval[] intervals = new Interval[numIntervals];
                char[] output = new char[numIntervals];
                for (int i = 0; i < numIntervals; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    intervals[i] = new Interval(start, end);
                }

                boolean isNotPossible = false;
                output[0] = 'C';
                outer:
                for (int i = 1; i < numIntervals; i++) {
                    int currentStart = intervals[i].start;
                    int currentEnd = intervals[i].end;
                    boolean isFound = false;
                    int overLapIndex = -1;
                    char overLapPerson = '-';
                    for (int j = 0; j < i; j++) {
                        if ((currentStart > intervals[j].start && currentStart < intervals[j].end) || 
                            (currentEnd > intervals[j].start && currentEnd < intervals[j].end) || 
                            (intervals[j].start > currentStart && intervals[j].start < currentEnd) || 
                            (intervals[j].end > currentStart && intervals[j].end < currentEnd)) {
                            /*
                            if (isFound) {
                                isNotPossible = true;
                                break outer;
                            }*/
                            if (overLapIndex == -1) {
                                overLapIndex = j;
                                overLapPerson = output[j];
                            } else {
                                if (overLapPerson != output[j]) {
                                    isNotPossible = true;
                                    break outer;
                                }
                            }
                            /*
                            overLapIndex = j;
                            overLapPerson = output[j];
                            if (overLapPerson) {
                                isFound = true;
                            }*/
                        }
                    }
                    if (overLapIndex == -1) {
                        output[i] = 'C';
                    } else {
                        if (overLapPerson == 'C')
                            output[i] = 'J';
                        else
                            output[i] = 'C';
                    }
                }

                String result = isNotPossible ? "IMPOSSIBLE" : new String(output);
                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}