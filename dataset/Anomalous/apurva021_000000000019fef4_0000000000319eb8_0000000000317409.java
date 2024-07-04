import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            char[] directions = input[2].toCharArray();

            int result = -1;

            for (int i = 0; i < directions.length; i++) {
                switch (directions[i]) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                int requiredTime = Math.abs(x) + Math.abs(y);

                if (requiredTime <= (i + 1)) {
                    result = i + 1;
                    break;
                }
            }

            if (result == -1) {
                writer.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                writer.println("Case #" + t + ": " + result);
            }
        }

        writer.flush();
        writer.close();
    }
}