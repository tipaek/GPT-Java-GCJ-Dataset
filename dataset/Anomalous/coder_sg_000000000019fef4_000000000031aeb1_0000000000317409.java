import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    private static int meetTime;
    private static int time;

    private static void recurse(int x1, int y1, int x2, int y2, int currIndex, String path) {
        if (x1 == x2 && y1 == y2) {
            meetTime = time;
            return;
        }
        if (meetTime != -1 || currIndex == path.length()) {
            return;
        }
        time++;
        if (x1 == x2) {
            y2 += path.charAt(currIndex) == 'N' ? 1 : -1;
            if (x1 == x2 && y1 == y2) {
                meetTime = time;
                return;
            }
            y1 += (y1 < y2) ? 1 : -1;
        } else {
            y2 += path.charAt(currIndex) == 'N' ? 1 : -1;
            if (x1 == x2 && y1 == y2) {
                meetTime = time;
                return;
            }
            x1 += (x1 < x2) ? 1 : -1;
        }
        recurse(x1, y1, x2, y2, currIndex + 1, path);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];

            time = 0;
            meetTime = -1;
            recurse(0, 0, x, y, 0, path);

            sb.append("Case #").append(i + 1).append(": ");
            sb.append(meetTime != -1 ? meetTime : "IMPOSSIBLE").append("\n");
        }
        System.out.print(sb);
    }
}