import java.util.Scanner;

public class Solution {

    private static boolean intersect(int x1, int y1, int x2, int y2) {
        if (y1 <= x2 || y2 <= x1) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            int N = in.nextInt();
            in.nextLine();
            int[][] values = new int[N][3];
            boolean done = false;

            for (int j = 0; j < N; j++) {
                values[j][0] = in.nextInt();
                values[j][1] = in.nextInt();
                values[j][2] = -1;
            }
            values[0][2] = 0;

            for (int j = 1; j < N; j++) {
                int collCnt = 0;
                boolean result = intersect(values[j][0], values[j][1], values[j - 1][0],
                                           values[j - 1][1]);
                if (!result) {
                    values[j][2] = values[j - 1][2];
                }
                else {
                    values[j][2] = (values[j - 1][2] + 1) % 2;
                    collCnt++;
                }

                for (int k = j - 2; k >= 0; k--) {

                    result = intersect(values[j][0], values[j][1], values[k][0], values[k][1]);

                    if (result) {
                        collCnt++;
                        if (values[j][2] == values[k][2]) {
                            if (collCnt > 1) {
                                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                                done = true;
                                break;
                            }
                            else {
                                values[j][2] = (values[j][2] + 1) % 2;
                            }
                        }
                    }
                }

                if (done) break;
            }

            if (done) continue;

            char[] output = new char[N];

            for (int j = 0; j < N; j++) output[j] = (values[j][2] == 0 ? 'C' : 'J');

            System.out.println("Case #" + (i + 1) + ": " + new String(output));

        }
    }
}
