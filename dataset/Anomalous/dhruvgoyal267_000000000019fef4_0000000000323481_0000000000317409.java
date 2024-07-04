import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();

            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }

            int distance = Math.abs(x) + Math.abs(y);
            int pathLength = path.length();

            if (distance > pathLength) {
                result.append("Case #").append(caseNumber++).append(": IMPOSSIBLE\n");
            } else {
                result.append("Case #").append(caseNumber++).append(": ").append(pathLength - distance).append("\n");
            }
        }

        System.out.print(result);
    }
}