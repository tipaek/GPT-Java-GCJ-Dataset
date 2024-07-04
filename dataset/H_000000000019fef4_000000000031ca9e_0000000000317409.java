import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int t = 1; t <= tests; t++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();

            String m = sc.next();
            sc.nextLine();

            int answer = -1;
            for (int i = 0; i < m.length(); i++) {
                int distance = manDistance(x, y, 0, 0);
                //System.out.println(i + " distance: " + distance);
                if (i >= distance) {
                    answer = i;
                    break;
                }

                char dir = m.charAt(i);

                switch(dir) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }

            if (answer == -1) {
                int distance = manDistance(x, y, 0, 0);
                if (m.length() >= distance) {
                    answer = m.length();
                }
            }

            System.out.print("Case #" + t + ": ");
            if (answer == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }

    private static int manDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
