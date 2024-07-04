import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int numAct = Integer.parseInt(br.readLine().trim());
            char[] C = new char[1441];
            char[] J = new char[1441];
            Arrays.fill(C, '0');
            Arrays.fill(J, '0');

            boolean impossible = false;
            char[] activities = new char[numAct];

            for (int j = 0; j < numAct; j++) {
                String[] split = br.readLine().trim().split(" ");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);

                activities[j] = schedule(C, J, start, end);

                if (activities[j] == 'N') {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                } else if (activities[j] == 'C') {
                    Arrays.fill(C, start, end, '1');
                } else {
                    Arrays.fill(J, start, end, '1');
                }
            }

            if (!impossible) {
                System.out.println("Case #" + i + ": " + new String(activities));
            }
        }
    }

    public static char schedule(char[] C, char[] J, int start, int end) {
        if (isOccupied(C, start, end)) {
            if (isOccupied(J, start, end)) {
                return 'N';
            } else {
                return 'J';
            }
        } else {
            return 'C';
        }
    }

    private static boolean isOccupied(char[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == '1') {
                return true;
            }
        }
        return false;
    }
}