import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ": ");
            
            if (N == 1) {
                System.out.println("1 1");
                continue;
            }
            
            if (N == 2) {
                System.out.println("1 1");
                System.out.println("2 2");
                continue;
            }
            
            ArrayList<int[]> steps = new ArrayList<>();
            steps.add(new int[]{1, 1});
            steps.add(new int[]{2, 2});
            
            int currentTotal = 2;
            int nextNum = 2;
            int x = 2;
            int y = 2;
            boolean goingFor1 = false;
            
            while (true) {
                if (currentTotal + nextNum > N) {
                    goingFor1 = true;
                    nextNum = 1;
                    y = 1;
                    continue;
                }
                
                if (currentTotal + nextNum == N) {
                    steps.add(new int[]{++x, y});
                    break;
                }
                
                currentTotal += nextNum;
                steps.add(new int[]{++x, y});
                
                if (!goingFor1) {
                    nextNum++;
                }
            }
            
            for (int[] step : steps) {
                System.out.println(step[0] + " " + step[1]);
            }
        }
        
        scanner.close();
    }
}