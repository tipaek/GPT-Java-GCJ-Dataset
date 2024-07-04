import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        class Calcul {
            int x, y, power;
            String path;

            Calcul(int x, int y, int power, String path) {
                this.x = x;
                this.y = y;
                this.power = power;
                this.path = path;
            }
        }

        for (int t = 0; t < testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = "IMPOSSIBLE";
            int maxIterations = 500;

            Queue<Calcul> queue = new LinkedList<>();
            queue.offer(new Calcul(x, y, 0, ""));

            while (!queue.isEmpty() && maxIterations-- > 0) {
                Calcul current = queue.poll();
                int powerValue = (int) Math.pow(2, current.power);

                if (powerValue > 2000000000) break;

                if (current.x == 0 && current.y == 0) {
                    result = current.path;
                    break;
                }

                if (Math.pow(current.x, 2) + Math.pow(current.y, 2) < powerValue) continue;

                queue.offer(new Calcul(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
                queue.offer(new Calcul(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
                queue.offer(new Calcul(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
                queue.offer(new Calcul(current.x, current.y - powerValue, current.power + 1, current.path + "N"));
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}