import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            result.append("Case #").append(i).append(": ");
            int xStart = sc.nextInt();
            int yStart = sc.nextInt();
            String path = sc.next();
            int steps = 0;
            int x = 0, y = 0;
            boolean reached = false;

            for (char step : path.toCharArray()) {
                steps++;
                switch (step) {
                    case 'N': yStart++; break;
                    case 'E': xStart++; break;
                    case 'W': xStart--; break;
                    case 'S': yStart--; break;
                }

                int difX = xStart - x;
                int difY = yStart - y;

                if (difX == 0 && difY == 0) {
                    reached = true;
                    break;
                }

                if (difX > 0) x++;
                else if (difX < 0) x--;
                else if (difY > 0) y++;
                else if (difY < 0) y--;
            }

            if (reached) {
                result.append(steps).append("\n");
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
    }
}