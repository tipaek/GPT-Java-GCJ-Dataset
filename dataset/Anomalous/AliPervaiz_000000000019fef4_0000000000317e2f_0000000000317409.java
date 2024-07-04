import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            writer.print("Case #" + t + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String directions = tokenizer.nextToken();
            boolean reached = false;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    writer.println(i + 1);
                    reached = true;
                    break;
                }
            }
            if (!reached) {
                writer.println("IMPOSSIBLE");
            }
        }
        writer.flush();
        writer.close();
    }
}