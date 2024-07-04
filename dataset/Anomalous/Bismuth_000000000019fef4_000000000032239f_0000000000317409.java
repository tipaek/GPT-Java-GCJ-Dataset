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
            boolean reached = false;

            for (char step : path.toCharArray()) {
                switch (step) {
                    case 'N': yStart++; break;
                    case 'E': xStart++; break;
                    case 'S': yStart--; break;
                    case 'W': xStart--; break;
                }
                steps++;
                if (Math.abs(xStart) + Math.abs(yStart) <= steps) {
                    reached = true;
                    result.append(steps).append("\n");
                    break;
                }
            }

            if (!reached) {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
        sc.close();
    }
}