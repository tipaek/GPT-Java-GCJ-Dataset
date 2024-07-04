import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();

        class Calculation {
            long x, y;
            int power;
            String path;

            public Calculation(long x, long y, int power, String path) {
                this.x = x;
                this.y = y;
                this.power = power;
                this.path = path;
            }
        }

        for (int i = 0; i < T; i++) {
            long x = scan.nextInt();
            long y = scan.nextInt();
            String answer = "IMPOSSIBLE";
            long powerValue;
            
            Queue<Calculation> queue = new LinkedList<>();
            queue.add(new Calculation(x, y, 0, ""));
            
            boolean found = false;
            while (!queue.isEmpty()) {
                Calculation current = queue.poll();
                powerValue = (long) Math.pow(2, current.power);
                
                if (powerValue > 2000000000) {
                    break;
                }
                
                if (current.x == 0 && current.y == 0) {
                    answer = current.path;
                    found = true;
                    break;
                }

                if (Math.pow(x, 2) + Math.pow(y, 2) <= powerValue) {
                    break;
                }
                
                queue.add(new Calculation(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
                queue.add(new Calculation(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
                queue.add(new Calculation(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
                queue.add(new Calculation(current.x, current.y - powerValue, current.power + 1, current.path + "N"));
            }

            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }
}