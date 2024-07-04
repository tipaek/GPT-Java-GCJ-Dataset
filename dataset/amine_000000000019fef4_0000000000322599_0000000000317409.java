import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; ++i) {

            String response = "IMPOSSIBLE";

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();
            scanner.nextLine();

            int [] myPosition = new int[2];

            int [][] location = new int[m.length() + 1][2];

            location[0][0] = x;
            location[0][1] = y;

            for (int j = 0 ; j < m.length() ; j ++) {

                char move = m.charAt(j);

                switch (move) {
                    case 'S':
                        y --;
                        break;
                    case 'N':
                        y ++;
                        break;
                    case 'E':
                        x ++;
                        break;
                    case 'W':
                        x --;
                        break;
                }

                int [] positions = new int[2];
                positions[0] = x;
                positions[1] = y;
                location[j + 1] = positions;

            }

            int minute = Integer.MAX_VALUE;
            int [] distance = new int [m.length() + 1];

            for (int j = 0 ; j < m.length() + 1 ; j ++) {

                distance[j] = Math.abs(location[j][0] - myPosition[0]) + Math.abs(location[j][1] - myPosition[1]);

                if (distance[j] + Math.abs(distance[j] - j) < minute && distance[j] <= j) {
                    minute = distance[j] + Math.abs(distance[j] - j);
                }

            }

            if (minute <= m.length()) {
                response = Integer.toString(minute);
            }

            System.out.println("Case #" + i + ": " + response);

        }

        scanner.close();

    }

}