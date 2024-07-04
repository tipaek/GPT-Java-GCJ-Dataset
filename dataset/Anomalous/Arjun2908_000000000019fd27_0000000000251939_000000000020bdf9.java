import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            int c1 = -1, c2 = -1;
            StringBuilder schedule = new StringBuilder("C");
            
            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= endTimes[c1] || c1 == -1) {
                    schedule.append('C');
                    c1 = i;
                } else if (startTimes[i] >= endTimes[c2] || c2 == -1) {
                    schedule.append('J');
                    c2 = i;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + schedule);
        }
        
        scanner.close();
    }
}