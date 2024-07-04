import java.util.*;
import java.io.*;

class TimeSection {
    int startTime;
    int endTime;
}

public class Solution {
    
    static boolean isOverlap(TimeSection t1, TimeSection t2) {
        return (t1.startTime <= t2.startTime && t1.endTime > t2.startTime) ||
               (t1.startTime < t2.endTime && t1.endTime >= t2.endTime) ||
               (t1.startTime >= t2.startTime && t1.endTime <= t2.endTime);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            boolean isPossible;
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            ArrayList<TimeSection> listC = new ArrayList<>();
            ArrayList<TimeSection> listJ = new ArrayList<>();
            TimeSection[] timeSections = new TimeSection[n];
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                timeSections[j] = new TimeSection();
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                timeSections[j].startTime = startTimes[j];
                timeSections[j].endTime = endTimes[j];
                
                if (j == 0) {
                    listC.add(timeSections[j]);
                    result.append("C");
                } else {
                    isPossible = true;
                    for (TimeSection ts : listC) {
                        if (isOverlap(timeSections[j], ts)) {
                            isPossible = false;
                            break;
                        }
                    }
                    
                    if (isPossible) {
                        listC.add(timeSections[j]);
                        result.append("C");
                        continue;
                    }
                    
                    isPossible = true;
                    for (TimeSection ts : listJ) {
                        if (isOverlap(timeSections[j], ts)) {
                            isPossible = false;
                            break;
                        }
                    }
                    
                    if (isPossible) {
                        listJ.add(timeSections[j]);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}