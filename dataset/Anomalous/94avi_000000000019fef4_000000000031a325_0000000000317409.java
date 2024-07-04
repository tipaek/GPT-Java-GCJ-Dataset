import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String[] path = input[2].split("");
            int stepsCount = 0;

            for (String step : path) {
                if (x == 0 && y == 0) {
                    break;
                }
                if (x != 0) {
                    if (step.equals("S")) {
                        y--;
                        x--;
                    } else {
                        y++;
                        x--;
                    }
                } else {
                    if (step.equals("S")) {
                        y = Math.max(y - 1, y - 2);
                    }
                }
                stepsCount++;
            }

            if (x == 0 && y == 0) {
                System.out.println("Case #" + test + ": " + stepsCount);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}