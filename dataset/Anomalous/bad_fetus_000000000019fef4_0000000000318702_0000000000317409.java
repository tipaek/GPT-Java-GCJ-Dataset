import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 0; testCase < numberOfTests; testCase++) {
            String[] input = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];

            int[] position = new int[]{x, y};
            int steps = 0;
            boolean reached = false;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N': position[1]++; break;
                    case 'S': position[1]--; break;
                    case 'E': position[0]++; break;
                    case 'W': position[0]--; break;
                }

                if (Math.abs(position[0]) + Math.abs(position[1]) <= i + 1) {
                    steps = i + 1;
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + (testCase + 1) + ": " + steps);
            } else {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }
        }
    }
}