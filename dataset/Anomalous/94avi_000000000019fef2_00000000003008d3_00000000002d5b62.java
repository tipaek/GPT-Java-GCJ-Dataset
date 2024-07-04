import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            int maxDistance = Math.abs(x) + Math.abs(y);
            int attempts = (int) (Math.log(maxDistance) / Math.log(2));
            StringBuilder path = new StringBuilder();
            int power = (int) Math.pow(2, attempts);
            int step = 1;
            int currentX = 0;
            int currentY = 0;

            while (power >= 1) {
                if (Math.abs(x) < Math.abs(y)) {
                    if (currentX < x) {
                        currentX += step;
                        path.append("W");
                    } else if (currentX > x) {
                        currentX -= step;
                        path.append("E");
                    }
                } else {
                    if (currentY < y) {
                        currentY += step;
                        path.append("S");
                    } else if (currentY > y) {
                        currentY -= step;
                        path.append("N");
                    }
                }

                step *= 2;
                power /= 2;
            }

            if (currentX == x && currentY == y) {
                System.out.println("Case #" + test + ": " + path.toString());
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}