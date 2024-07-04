import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String target = reader.readLine();
            String[] parts = target.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            String movement = parts[2];
            System.out.println("Case #" + i + ": " + process(x, y, movement));
        }

    }

    public String process(int x, int y, String movements) {
        int answer = -1;
        for (int i = 0; i <= movements.length(); i++) {
            int moves = test(x, y, i);
            if (moves <= i)
                answer = answer == -1 ? moves : Math.min(moves, answer);
            if (i < movements.length()) {
                char move = movements.charAt(i);
                if (move == 'N') {
                    y++;
                } else if (move == 'S') {
                    y--;
                } else if (move == 'W') {
                    x--;
                } else if (move == 'E') {
                    x++;
                }
            }
        }
        if (answer == -1)
            return "IMPOSSIBLE";

        return String.valueOf(answer);
    }

    public int test(int x, int y, int step) {
        return Math.max(Math.abs(x) + Math.abs(y), step);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
