import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int idx = 1; idx <= testCases; idx++) {
            String[] input = br.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            int units = Math.abs(x) + Math.abs(y);
            int val = 1;
            int i = 1;
            while (units > val) {
                val += (1 << i); // Equivalent to Math.pow(2, i)
                i++;
            }
            if (findJumps(x, y, i, val)) {
                System.out.println("Case #" + idx + ": " + str);
                str.setLength(0); // Clear the StringBuilder
            } else {
                System.out.println("Case #" + idx + ": IMPOSSIBLE");
                str.setLength(0); // Clear the StringBuilder
            }
        }
    }

    static boolean findJumps(int x, int y, int k, int val) {
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

        int power = 1 << (k - 1); // Equivalent to Math.pow(2, k-1)
        int[][] moves = {
            {x, y + power, 'S'},
            {x, y - power, 'N'},
            {x + power, y, 'W'},
            {x - power, y, 'E'}
        };

        for (int[] move : moves) {
            int newX = move[0];
            int newY = move[1];
            char direction = (char) move[2];
            if ((Math.abs(newX) + Math.abs(newY)) <= val) {
                if (findJumps(newX, newY, k - 1, val - power)) {
                    str.append(direction);
                    return true;
                }
            }
        }
        return false;
    }
}