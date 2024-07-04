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

            int steps = 0;
            boolean reached = false;

            for (String step : path) {
                if (x == 0 && y == 0) {
                    reached = true;
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
                } else if (y != 0) {
                    if (step.equals("S")) {
                        if (y < 0) {
                            // Do nothing if y is negative and step is "S"
                        } else if (y - 2 < 0) {
                            y--;
                        } else {
                            y -= 2;
                        }
                    }
                }
                steps++;
            }

            if (x == 0 && y == 0 || reached) {
                System.out.println("Case #" + test + ": " + steps);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}