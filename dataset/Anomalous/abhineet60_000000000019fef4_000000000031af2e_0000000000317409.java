import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i_t = 1; i_t <= t; i_t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String s = input[2];

            int ans = 0;
            boolean found = false;

            for (int i = 0; i < s.length(); i++) {
                int distance = Math.abs(x) + Math.abs(y);

                if (distance <= i) {
                    ans = i;
                    found = true;
                    break;
                }

                char direction = s.charAt(i);
                switch (direction) {
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

            if (found) {
                System.out.println("Case #" + i_t + ": " + ans);
            } else {
                int finalDistance = Math.abs(x) + Math.abs(y);
                if (finalDistance <= s.length()) {
                    System.out.println("Case #" + i_t + ": " + s.length());
                } else {
                    System.out.println("Case #" + i_t + ": IMPOSSIBLE");
                }
            }
        }
    }
}