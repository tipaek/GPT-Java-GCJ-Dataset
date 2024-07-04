import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int X = Integer.parseInt(tokenizer.nextToken());
            int Y = Integer.parseInt(tokenizer.nextToken());
            String tour = tokenizer.nextToken();
            
            boolean isPossible = false;

            for (int i = 0; i < tour.length(); i++) {
                char direction = tour.charAt(i);
                switch (direction) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }

                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    System.out.println("Case #" + t + ": " + (i + 1));
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}