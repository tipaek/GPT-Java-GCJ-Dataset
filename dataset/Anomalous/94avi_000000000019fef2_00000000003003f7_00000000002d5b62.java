import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            String[] data = br.readLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);

            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            int maxDistance = Math.abs(x) + Math.abs(y);
            int attempts = (int) (Math.log(maxDistance) / Math.log(2));
            StringBuilder result = new StringBuilder();
            int power = (int) Math.pow(2, attempts);
            int step = 1;
            int currentX = 0;
            int currentY = 0;

            while (power > 1) {
                if (Math.abs(x) < Math.abs(y)) {
                    if (currentX < x) {
                        currentX += step;
                        result.append("W");
                    } else if (currentX > x) {
                        currentX -= step;
                        result.append("E");
                    }
                } else {
                    if (currentY < y) {
                        currentY += step;
                        result.append("S");
                    } else if (currentY > y) {
                        currentY -= step;
                        result.append("N");
                    }
                }
                step *= 2;
                power /= 2;
            }

            if (currentX == x && currentY == y) {
                System.out.println("Case #" + test + ": " + result.toString());
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}