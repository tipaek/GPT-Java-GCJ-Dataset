import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Pair other) {
        return this.x - other.x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            int tasks = scanner.nextInt();
            
            Pair[] times = new Pair[tasks];
            Pair[] originalTimes = new Pair[tasks];
            
            for (int i = 0; i < tasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                times[i] = new Pair(start, end);
                originalTimes[i] = new Pair(start, end);
            }
            
            Arrays.sort(times);
            
            int cEnd = 0;
            int jEnd = 0;
            boolean isPossible = true;
            char[] result = new char[tasks];
            boolean[] assigned = new boolean[tasks];
            
            for (Pair time : times) {
                if (cEnd <= time.x) {
                    cEnd = time.y;
                    assignTask(time, originalTimes, assigned, result, 'C');
                } else if (jEnd <= time.x) {
                    jEnd = time.y;
                    assignTask(time, originalTimes, assigned, result, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNum + ": ");
            
            if (isPossible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void assignTask(Pair time, Pair[] originalTimes, boolean[] assigned, char[] result, char worker) {
        for (int i = 0; i < originalTimes.length; i++) {
            if (!assigned[i] && time.x == originalTimes[i].x && time.y == originalTimes[i].y) {
                assigned[i] = true;
                result[i] = worker;
                break;
            }
        }
    }
}