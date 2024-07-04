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
            boolean isPossible = false;

            for (String direction : path) {
                switch (direction) {
                    case "S":
                        y--;
                        break;
                    case "N":
                        y++;
                        break;
                    case "W":
                        x--;
                        break;
                    case "E":
                        x++;
                        break;
                }

                steps++;
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + test + ": " + steps);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}