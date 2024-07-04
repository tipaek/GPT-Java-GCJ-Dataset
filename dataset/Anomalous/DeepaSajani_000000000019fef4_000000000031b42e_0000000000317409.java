import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer st;

    private static void readLine() throws IOException {
        st = new StringTokenizer(bufferedReader.readLine());
    }

    private static int getInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static String getString() {
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readLine();
        int testCases = getInt();
        for (int tc = 1; tc <= testCases; tc++) {
            readLine();
            int x = getInt();
            int y = getInt();
            String sequence = getString();
            int time = calculateTimeToReach(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int calculateTimeToReach(int x, int y, String sequence) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{x, y});
        for (int i = 0; i < sequence.length(); i++) {
            int[] prevPosition = positions.get(i);
            int[] newPosition = new int[2];
            switch (sequence.charAt(i)) {
                case 'N':
                    newPosition[0] = prevPosition[0];
                    newPosition[1] = prevPosition[1] + 1;
                    break;
                case 'S':
                    newPosition[0] = prevPosition[0];
                    newPosition[1] = prevPosition[1] - 1;
                    break;
                case 'E':
                    newPosition[0] = prevPosition[0] + 1;
                    newPosition[1] = prevPosition[1];
                    break;
                case 'W':
                    newPosition[0] = prevPosition[0] - 1;
                    newPosition[1] = prevPosition[1];
                    break;
            }
            positions.add(newPosition);
        }

        for (int i = 1; i < positions.size(); i++) {
            if (canReach(0, 0, positions.get(i)[0], positions.get(i)[1], i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canReach(int x, int y, int targetX, int targetY, int time) {
        if (x == targetX && y == targetY && time == 0) return true;
        if (time < 0) return false;
        return canReach(x + 1, y, targetX, targetY, time - 1) ||
               canReach(x - 1, y, targetX, targetY, time - 1) ||
               canReach(x, y + 1, targetX, targetY, time - 1) ||
               canReach(x, y - 1, targetX, targetY, time - 1) ||
               canReach(x, y, targetX, targetY, time - 1);
    }
}