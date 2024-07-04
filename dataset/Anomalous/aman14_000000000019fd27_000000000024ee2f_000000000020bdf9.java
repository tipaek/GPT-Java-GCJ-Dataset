import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] schedule = new char[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            schedule[0] = 'J';
            boolean impossible = false;
            
            for (int i = 1; i < n; i++) {
                boolean conflict = false;
                char assignedChar = ' ';
                
                for (int j = 0; j < i; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        conflict = true;
                        if (assignedChar == ' ') {
                            assignedChar = schedule[j];
                        } else if (assignedChar != schedule[j]) {
                            impossible = true;
                            break;
                        }
                    }
                }
                
                if (impossible) {
                    break;
                }
                
                if (conflict) {
                    schedule[i] = (assignedChar == 'J') ? 'C' : 'J';
                } else {
                    schedule[i] = 'J';
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + t1 + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t1 + ": " + new String(schedule));
            }
        }
        
        sc.close();
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}