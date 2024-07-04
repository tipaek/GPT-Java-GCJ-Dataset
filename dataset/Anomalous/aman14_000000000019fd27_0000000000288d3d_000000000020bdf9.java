import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            StringBuilder result = new StringBuilder("C");
            boolean possible = true;

            for (int i = 1; i < n && possible; i++) {
                int overlaps = 0;
                char currentChar = 'J', previousChar = 'J';
                
                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0]) ||
                        (intervals[j][0] < intervals[i][1] && intervals[j][1] > intervals[i][0])) {
                        overlaps++;
                        currentChar = result.charAt(j);
                    }
                    
                    if (overlaps >= 2 && currentChar != previousChar) {
                        possible = false;
                        break;
                    }
                    previousChar = currentChar;
                }
                
                if (!possible) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                
                if (overlaps >= 1) {
                    result.append(currentChar == 'J' ? 'C' : 'J');
                } else {
                    result.append('C');
                }
            }
            
            System.out.println("Case #" + t1 + ": " + result);
        }
        
        sc.close();
    }
}