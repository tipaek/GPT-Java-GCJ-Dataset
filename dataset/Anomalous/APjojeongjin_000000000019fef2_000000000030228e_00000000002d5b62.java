import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();

        class Calcul {
            long x;
            long y;
            int power;
            String path;

            public Calcul(long x, long y, int power, String path) {
                this.x = x;
                this.y = y;
                this.power = power;
                this.path = path;
            }
        }

        for (int i = 0; i < T; i++) {
            String result = "";
            long x = scan.nextInt();
            long y = scan.nextInt();
            long powerValue = 0;

            Queue<Calcul> queue = new LinkedList<>();
            queue.add(new Calcul(x, y, 0, ""));

            int iterationLimit = 1000000;
            boolean found = false;

            while (!queue.isEmpty() && !found) {
                Calcul current = queue.poll();
                powerValue = (long) Math.pow(2, current.power);

                if (powerValue > 2000000000) {
                    break;
                }

                if (current.x == 0 && current.y == 0) {
                    result = current.path;
                    found = true;
                    break;
                }

                if (Math.pow(current.x, 2) + Math.pow(current.y, 2) <= powerValue) {
                    continue;
                }

                queue.add(new Calcul(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
                queue.add(new Calcul(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
                queue.add(new Calcul(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
                queue.add(new Calcul(current.x, current.y - powerValue, current.power + 1, current.path + "N"));

                if (--iterationLimit == 0) {
                    break;
                }
            }

            if (found && powerValue <= 2000000000) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}