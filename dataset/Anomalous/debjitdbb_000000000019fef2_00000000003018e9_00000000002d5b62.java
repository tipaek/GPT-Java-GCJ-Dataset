import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = reader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            StringBuilder path = new StringBuilder();
            boolean possible = true;

            while (x != 0 || y != 0) {
                if (Math.abs(x) % 2 == Math.abs(y) % 2) {
                    path.setLength(0); // Clear path to indicate impossibility
                    possible = false;
                    break;
                }

                if (Math.abs(x) % 2 == 1) {
                    if ((x - 1) / 2 == 0 && y == 0) {
                        path.append("E");
                        x -= 1;
                    } else if ((x + 1) / 2 == 0 && y == 0) {
                        path.append("W");
                        x += 1;
                    } else if (((x - 1) / 2 + y / 2) % 2 == 0) {
                        path.append("W");
                        x += 1;
                    } else {
                        path.append("E");
                        x -= 1;
                    }
                } else if (Math.abs(y) % 2 == 1) {
                    if ((y - 1) / 2 == 0 && x == 0) {
                        path.append("N");
                        y -= 1;
                    } else if ((y + 1) / 2 == 0 && x == 0) {
                        path.append("S");
                        y += 1;
                    } else if (((y - 1) / 2 + x / 2) % 2 == 0) {
                        path.append("S");
                        y += 1;
                    } else {
                        path.append("N");
                        y -= 1;
                    }
                }

                x /= 2;
                y /= 2;
            }

            result.append("Case #").append(caseNumber).append(": ");
            if (possible) {
                result.append(path);
            } else {
                result.append("IMPOSSIBLE");
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}