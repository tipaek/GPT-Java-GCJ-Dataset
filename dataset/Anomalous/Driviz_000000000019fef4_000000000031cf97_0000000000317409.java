import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String moves = tokenizer.nextToken();

            for (char move : moves.toCharArray()) {
                switch (move) {
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

            int distance = Math.abs(x) + Math.abs(y);

            System.out.print("Case #" + testCase + ": ");
            if (distance > moves.length()) {
                System.out.println("IMPOSSIBLE");
            } else if (distance < moves.length()) {
                System.out.println(moves.length() - distance);
            } else {
                System.out.println(distance);
            }
        }
    }
}