import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String movements = tokenizer.nextToken();
            int length = movements.length();

            int result = -1;
            for (int i = 0; i < length; i++) {
                char direction = movements.charAt(i);
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
                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= i + 1) {
                    result = i + 1;
                    break;
                }
            }

            if (result != -1) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}