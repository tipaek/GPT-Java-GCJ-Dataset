import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            
            ArrayList<Character> schedule = new ArrayList<>();
            schedule.add('C');
            schedule.add('J');
            
            int startC = start[0], endC = end[0];
            int startJ = start[1], endJ = end[1];
            boolean isPossible = true;
            
            for (int k = 2; k < n; k++) {
                if ((start[k] >= endJ && end[k] >= endJ) || (start[k] <= startJ && end[k] < startJ)) {
                    schedule.add('J');
                    startJ = Math.min(startJ, start[k]);
                    endJ = Math.max(endJ, end[k]);
                } else if ((start[k] >= endC && end[k] >= endC) || (start[k] <= startC && end[k] < startC)) {
                    schedule.add('C');
                    startC = Math.min(startC, start[k]);
                    endC = Math.max(endC, end[k]);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char ch : schedule) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
        
        sc.close();
    }
}