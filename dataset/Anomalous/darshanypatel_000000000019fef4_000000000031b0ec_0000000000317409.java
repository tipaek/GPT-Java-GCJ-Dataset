import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (T-- > 0) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];

            if (x == 0 && y == 0) {
                System.out.printf("Case #%d: %d%n", caseNumber++, 0);
                continue;
            }

            boolean found = false;
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                int stepsRequired = Math.abs(x) + Math.abs(y);
                if (stepsRequired <= i + 1) {
                    System.out.printf("Case #%d: %d%n", caseNumber++, i + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber++);
            }
        }
    }
}