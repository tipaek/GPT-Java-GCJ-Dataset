import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void process() {
        final String directions = "NESW";
        final int[] xMove = {0, 1, 0, -1};
        final int[] yMove = {1, 0, -1, 0};
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] path = scanner.next().toCharArray();
            String result = "IMPOSSIBLE";
            
            for (int step = 0; step < path.length; step++) {
                int directionIndex = directions.indexOf(path[step]);
                x += xMove[directionIndex];
                y += yMove[directionIndex];
                int distance = Math.abs(x) + Math.abs(y);
                
                if (distance <= step + 1) {
                    result = Integer.toString(step + 1);
                    break;
                }
            }
            
            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }
    }

    public static void main(String[] args) {
        new Solution().process();
    }
}