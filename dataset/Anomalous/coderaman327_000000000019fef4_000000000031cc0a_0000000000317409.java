import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int j = 1; j <= t; j++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];
            int len = directions.length();
            int curDist = Math.abs(x) + Math.abs(y);
            int result = 0;

            for (int i = 0; i < len; i++) {
                char direction = directions.charAt(i);

                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }

                curDist = Math.abs(x) + Math.abs(y);

                if (curDist <= i + 1) {
                    result = i + 1;
                    break;
                }
            }

            if (result != 0) {
                System.out.println("Case #" + j + ": " + result);
            } else {
                System.out.println("Case #" + j + ": IMPOSSIBLE");
            }
        }
    }
}