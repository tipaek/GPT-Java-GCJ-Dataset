import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];

            int result = findShortestTime(x, y, path);
            String output = (result == -1) ? "IMPOSSIBLE" : Integer.toString(result);

            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    private static int findShortestTime(int x, int y, String path) {
        char[] pathArr = path.toCharArray();

        for (int i = 0; i < pathArr.length; i++) {
            switch (pathArr[i]) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }

            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                return i + 1;
            }
        }

        return -1;
    }
}