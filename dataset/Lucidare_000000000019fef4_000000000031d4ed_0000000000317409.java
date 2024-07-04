import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String tour = scanner.next();
        int currX = x;
        int currY = y;
        x = Math.abs(x);
        y = Math.abs(y);
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < tour.length(); i++) {
            if (tour.charAt(i) == 'S') currY--;
            if (tour.charAt(i) == 'N') currY++;
            if (tour.charAt(i) == 'E') currX++;
            if (tour.charAt(i) == 'W') currX--;
            int dist = Math.abs(currX) + Math.abs(currY);
            if (dist <= i + 1) minTime = Math.min(minTime, i+1);
        }
        
        if (minTime != Integer.MAX_VALUE) return String.valueOf(minTime);
        return  "IMPOSSIBLE";
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}