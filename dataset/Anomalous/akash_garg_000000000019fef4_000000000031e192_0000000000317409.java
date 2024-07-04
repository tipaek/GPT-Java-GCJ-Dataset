import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int steps = 0;
            boolean reached = false;

            for (int k = 0; k < directions.length(); k++, steps++) {
                if (steps >= Math.abs(x) + Math.abs(y)) {
                    reached = true;
                    System.out.println(steps);
                    break;
                }
                char direction = directions.charAt(k);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }

            if (!reached) {
                if (steps >= Math.abs(x) + Math.abs(y)) {
                    System.out.println(steps);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
}