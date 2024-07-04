import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int k = 1; k <= t; k++) {
            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            String path = xy[2];

            int px = 0, py = 0;
            int mins = -1;

            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);

                switch (c) {
                    case 'N':
                        py--;
                        break;
                    case 'S':
                        py++;
                        break;
                    case 'E':
                        px++;
                        break;
                    case 'W':
                        px--;
                        break;
                }

                if (x > px) {
                    x--;
                } else if (x < px) {
                    x++;
                } else if (y > py) {
                    y--;
                } else if (y < py) {
                    y++;
                }

                if (x == px && y == py) {
                    mins = i + 1;
                    break;
                }
            }

            String result = (mins == -1) ? "IMPOSSIBLE" : String.valueOf(mins);
            System.out.println("Case #" + k + ": " + result);
        }
    }
}