import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int[] dx = {-1, 0, 1,  0};
    static int[] dy = {0,  1, 0, -1};
    static Map<Character, Integer> ds = new HashMap<Character, Integer>() {{
        put('N', 1);
        put('S', 3);
        put('E', 2);
        put('W', 0);
    }};

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String[] line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]), Y = Integer.parseInt(line[1]);
            String M = line[2];
            int minTime = Integer.MAX_VALUE;
            int currX = X, currY = Y, currT = 0;
            for (Character c : M.toCharArray()) {
                int d = ds.get(c);
                currX += dx[d];
                currY += dy[d];
                currT++;
                int dist = getDistance(currX, currY, 0, 0);
                //System.out.println(c + " " + currX + " " + currY + " " + currT + " " + dist);
                if (dist <= currT) {
                    minTime = Math.min(minTime, currT);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + (minTime == Integer.MAX_VALUE?"IMPOSSIBLE":""+minTime));
        }
    }
}
