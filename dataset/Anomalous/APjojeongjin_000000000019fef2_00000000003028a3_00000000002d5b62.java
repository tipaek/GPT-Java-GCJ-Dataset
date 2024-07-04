import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        class Calculation {
            long x;
            long y;
            int power;
            String path;

            public Calculation(long x, long y, int power, String path) {
                this.x = x;
                this.y = y;
                this.power = power;
                this.path = path;
            }
        }

        for (int t = 0; t < testCases; t++) {
            String result = "";
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            long powerValue = 0;

            Queue<Calculation> queue = new LinkedList<>();
            queue.add(new Calculation(x, y, 0, ""));
            
            int iterationLimit = 500000;
            int iterations = 0;
            boolean found = false;

            while (!queue.isEmpty()) {
                iterations++;
                if (iterations >= iterationLimit) break;
                
                Calculation current = queue.poll();
                powerValue = (long) Math.pow(2, current.power);
                
                if (powerValue > 2000000000L) break;
                
                if (current.x == 0 && current.y == 0) {
                    result = current.path;
                    found = true;
                    break;
                }

                if (Math.pow(current.x, 2) + Math.pow(current.y, 2) <= powerValue) {
                    continue;
                }

                queue.add(new Calculation(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
                queue.add(new Calculation(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
                queue.add(new Calculation(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
                queue.add(new Calculation(current.x, current.y - powerValue, current.power + 1, current.path + "N"));
            }

            if (found && powerValue <= 2000000000L && iterations < iterationLimit) {
                System.out.println("Case #" + (t + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
}