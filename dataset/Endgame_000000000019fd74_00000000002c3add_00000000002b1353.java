import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ":");
            secret();
        }
    }

    private static class Position {
        int r;
        int k;

        Position(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position))
                return false;
            Position pos = (Position) obj;
            return pos.r == r && pos.k == k;
        }
    }

    private static void secret() {
        int N = in.nextInt();

        // We need N = 1 + X + 2^X + Y, where Y completes the N...

        System.out.println("1 1");

        int logVal = getLogVal(N);
        int powVal = getPowVal(logVal);

        int numSInRoad = logVal + (logVal + 1);

        if (N <= 500) {
            for (int i = 0; i < N - 1; i++) {
                System.out.println("" + (i + 2) + " " + 1);
            }
        } else {
            int leftToSum = N - 2;

            if (logVal + powVal > N) {
                logVal--;
                powVal = getPowVal(logVal);
            }

            for (int r = 2; r <= logVal; r++) {
                leftToSum--;
                System.out.println("" + r + " " + 1);
            }

            int row = logVal;
            boolean flag = false;

            while (leftToSum >= 1) {
                powVal = getPowVal(row);
                if(!flag) {
                    leftToSum -= (powVal - 1);
                    for (int c = 2; c <= (row + 1); c++) {
                        System.out.println("" + (row + 1) + " " + c);
                    }
                }

                if (leftToSum >= 1) {
                    if (leftToSum <= row - 2 + 1) {
                        for (int j = 0; j < leftToSum; j++) {
                            System.out.println("" + (row - j) + " " + (row - j));
                        }

                        leftToSum = 0;
                        return;
                    }
                    else {
                        if((powVal / 2) + (powVal / 4) - 2 > leftToSum) {
                            // continue
                            System.out.println("" + (row) + " " + (row));
                            leftToSum--;
                            row--;
                            flag = true;
                        }
                        else {
                            for (int c = row; c >= 2; c--) {
                                System.out.println("" + (row) + " " + c);
                            }
                            leftToSum -= (powVal / 2);
                            flag = false;
                        }
                    }
                }
            }


        }
        // S <= 500
        // First position: (1,1)

    }

    private static int getPowVal(int logVal) {
        int pow = 1;

        for (int i = 0; i < logVal; i++) {
            pow *= 2;
        }

        return pow;
    }

    private static int getLogVal(int N) {
        int pow = 1;
        int times = 0;

        for (int val = 2; val <= 30; val++) {
            if (pow * val > N)
                return pow;
            times++;
            pow *= val;
        }

        return times;
    }
}
