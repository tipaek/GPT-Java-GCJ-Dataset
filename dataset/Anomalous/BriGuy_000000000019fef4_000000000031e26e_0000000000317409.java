import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String directions = tokenizer.nextToken();

            boolean possible = false;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x++;
                        break;
                    case 'E':
                        x--;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.println("Case #" + t + ": " + (i + 1));
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}