import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();

        class Calcul {
            int x, y, power;
            String path;

            public Calcul(int x, int y, int power, String path) {
                this.x = x;
                this.y = y;
                this.power = power;
                this.path = path;
            }
        }

        for (int i = 0; i < T; i++) {
            String result = "";
            int x = scan.nextInt();
            int y = scan.nextInt();
            int powerValue = 0;

            Queue<Calcul> queue = new LinkedList<>();
            queue.add(new Calcul(x, y, 0, ""));
            
            int errorCount = 0;
            boolean found = false;

            while (!queue.isEmpty()) {
                if (errorCount == 1000) {
                    break;
                }
                Calcul current = queue.poll();
                powerValue = (int) Math.pow(2, current.power);

                if (powerValue > 2000000000) {
                    break;
                }

                if (current.x == 0 && current.y == 0) {
                    result = current.path;
                    found = true;
                    break;
                }

                if (Math.pow(current.x, 2) + Math.pow(current.y, 2) < powerValue) {
                    errorCount++;
                    continue;
                }

                queue.add(new Calcul(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
                queue.add(new Calcul(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
                queue.add(new Calcul(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
                queue.add(new Calcul(current.x, current.y - powerValue, current.power + 1, current.path + "N"));
            }

            if (found && powerValue <= 2000000000 && errorCount != 1000) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}