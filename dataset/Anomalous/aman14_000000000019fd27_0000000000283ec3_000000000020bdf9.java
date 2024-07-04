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
            
            StringBuilder output = new StringBuilder("C");
            boolean impossible = false;
            
            for (int i = 1; i < n && !impossible; i++) {
                char currentChar = 'C';
                int overlaps = 0;

                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0])) {
                        overlaps++;
                        currentChar = output.charAt(j);
                    }
                    if (overlaps > 1) {
                        impossible = true;
                        break;
                    }
                }
                
                if (impossible) {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                
                output.append(currentChar == 'C' ? 'J' : 'C');
            }
            
            System.out.println("Case #" + t1 + ": " + output);
        }
        
        sc.close();
    }
}