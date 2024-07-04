import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int idx = 1; idx <= testCases; idx++) {
            String[] line = br.readLine().trim().split(" ");
            long x = Long.parseLong(line[0]);
            long y = Long.parseLong(line[1]);

            long units = Math.abs(x) + Math.abs(y);
            long val = 1;
            long i = 1;

            while (units > val) {
                val += (long) Math.pow(2, i);
                i++;
            }

            if (calculateJumps(x, y, i, val)) {
                System.out.println("Case #" + idx + ": " + str);
                str.setLength(0);
            } else {
                System.out.println("Case #" + idx + ": IMPOSSIBLE");
                str.setLength(0);
            }
        }
    }

    private static boolean calculateJumps(long x, long y, long k, long val) {
        if (val == 1) {
            if ((Math.abs(x) + Math.abs(y)) == val) {
                if (x == 1 && y == 0) {
                    str.insert(0, 'E');
                } else if (x == -1 && y == 0) {
                    str.insert(0, 'W');
                } else if (x == 0 && y == 1) {
                    str.insert(0, 'N');
                } else if (x == 0 && y == -1) {
                    str.insert(0, 'S');
                }
                return true;
            } else {
                return false;
            }
        }

        long power = (long) Math.pow(2, k - 1);

        long[][] directions = {
            {x, y + power, 'S'},
            {x, y - power, 'N'},
            {x + power, y, 'W'},
            {x - power, y, 'E'}
        };

        for (long[] dir : directions) {
            long newX = dir[0];
            long newY = dir[1];
            char direction = (char) dir[2];

            if ((Math.abs(newX) + Math.abs(newY)) <= val) {
                if (calculateJumps(newX, newY, k - 1, val - power)) {
                    str.append(direction);
                    return true;
                }
            }
        }

        return false;
    }
}