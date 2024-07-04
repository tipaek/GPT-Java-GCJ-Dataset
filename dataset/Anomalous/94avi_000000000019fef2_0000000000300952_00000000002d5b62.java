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
            int steps = (int) (Math.log(maxDistance) / Math.log(2));
            StringBuilder path = new StringBuilder();
            int power = (int) Math.pow(2, steps);
            int i = 1;
            int currentX = 0;
            int currentY = 0;

            while (i <= power) {
                if (Math.abs(x) < Math.abs(y)) {
                    if (currentX < x) {
                        currentX += i;
                        path.append("W");
                    } else if (currentX > x) {
                        currentX -= i;
                        path.append("E");
                    }
                } else {
                    if (currentY < y) {
                        currentY += i;
                        path.append("S");
                    } else if (currentY > y) {
                        currentY -= i;
                        path.append("N");
                    }
                }
                i *= 2;
            }

            if (currentX == x && currentY == y) {
                System.out.println("Case #" + test + ": " + path.toString());
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}