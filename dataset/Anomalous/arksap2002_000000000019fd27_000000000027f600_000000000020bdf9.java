import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[2 * n];
            
            for (int i = 0; i < n; i++) {
                intervals[2 * i] = new Interval(scanner.nextInt(), i, 1);
                intervals[2 * i + 1] = new Interval(scanner.nextInt(), i, -1);
            }
            
            Arrays.sort(intervals, (a, b) -> {
                if (a.time == b.time) {
                    return a.type - b.type;
                }
                return a.time - b.time;
            });
            
            char[] assignments = new char[n];
            boolean impossible = false;
            int balance = 0;
            boolean[] inUse = new boolean[2];
            
            for (Interval interval : intervals) {
                balance += interval.type;
                
                if (balance >= 3) {
                    impossible = true;
                }
                
                if (interval.type == -1) {
                    if (assignments[interval.index] == 'C') {
                        inUse[0] = false;
                    } else {
                        inUse[1] = false;
                    }
                }
                
                if (balance == 1 && interval.type == 1) {
                    if (!inUse[0]) {
                        assignments[interval.index] = 'C';
                        inUse[0] = true;
                    } else {
                        assignments[interval.index] = 'J';
                        inUse[1] = true;
                    }
                }
                
                if (balance == 2) {
                    if (!inUse[0]) {
                        assignments[interval.index] = 'C';
                        inUse[0] = true;
                    } else {
                        assignments[interval.index] = 'J';
                        inUse[1] = true;
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (testCase + 1) + ": " + new String(assignments));
            }
        }
        
        scanner.close();
    }

    static class Interval {
        int time;
        int index;
        int type;
        
        Interval(int time, int index, int type) {
            this.time = time;
            this.index = index;
            this.type = type;
        }
    }
}