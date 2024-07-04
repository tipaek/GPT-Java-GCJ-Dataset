import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            boolean flag = true;
            int[][] intervals = new int[x][2];
            int[] timeline = new int[24 * 60];
            
            for (int i = 0; i < x; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }
            
            for (int i = 0; i < x; i++) {
                timeline[intervals[i][0]]++;
                timeline[intervals[i][1]]--;
            }
            
            int count = 0;
            for (int i = 0; i < 24 * 60; i++) {
                count += timeline[i];
                if (count > 2) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                int cEnd = -1;
                int jEnd = -1;
                StringBuilder result = new StringBuilder("C");
                
                cEnd = intervals[0][1];
                
                for (int i = 1; i < x; i++) {
                    if (intervals[i][0] >= cEnd) {
                        cEnd = intervals[i][1];
                        result.append("C");
                    } else if (intervals[i][0] >= jEnd) {
                        jEnd = intervals[i][1];
                        result.append("J");
                    } else {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    System.out.println("Case #" + (m + 1) + ": " + result.toString());
                } else {
                    System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
            }
        }
        
        in.close();
    }
}