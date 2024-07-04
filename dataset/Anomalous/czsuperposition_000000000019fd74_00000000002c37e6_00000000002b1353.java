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
            } else if (N == 2) {
                System.out.println("1 1");
                System.out.println("2 1");
                continue;
            }
            
            ArrayList<int[]> steps = new ArrayList<>();
            steps.add(new int[]{1, 1});
            steps.add(new int[]{2, 2});
            
            int currentTotal = 2;
            int nextNum = 2;
            int x = 2, y = 2;
            boolean goingFor1 = false;
            
            while (true) {
                currentTotal += nextNum;
                
                if (currentTotal > N) {
                    goingFor1 = true;
                    currentTotal -= nextNum;
                    nextNum = 1;
                    y = 1;
                } else if (currentTotal == N) {
                    steps.add(new int[]{++x, y});
                    break;
                } else {
                    steps.add(new int[]{++x, y});
                    if (!goingFor1) {
                        nextNum++;
                    }
                }
            }
            
            for (int[] step : steps) {
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }
}