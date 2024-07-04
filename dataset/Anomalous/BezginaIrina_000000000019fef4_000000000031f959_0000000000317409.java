import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String moves = input[2];

            String result = "IMPOSSIBLE";
            int minSteps = Integer.MAX_VALUE;

            char[] moveArray = moves.toCharArray();
            int stepCount = 0;

            for (char move : moveArray) {
                stepCount++;
                switch (move) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= stepCount) {
                    minSteps = stepCount;
                    result = Integer.toString(stepCount);
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}