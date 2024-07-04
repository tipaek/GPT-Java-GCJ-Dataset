import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            processTestCase();
        }
    }

    private static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position))
                return false;
            Position pos = (Position) obj;
            return pos.row == row && pos.col == col;
        }
    }

    private static void processTestCase() {
        int N = scanner.nextInt();
        System.out.println("1 1");

        int logValue = calculateLogValue(N);
        int powerValue = calculatePowerValue(logValue);

        if (N <= 500) {
            for (int i = 0; i < N - 1; i++) {
                System.out.println((i + 2) + " 1");
            }
        } else {
            int remainingSum = N - 2;

            if (logValue + powerValue > N) {
                logValue--;
                powerValue = calculatePowerValue(logValue);
            }

            for (int r = 2; r <= logValue; r++) {
                remainingSum--;
                System.out.println(r + " 1");
            }

            int row = logValue;
            boolean switchFlag = false;

            while (remainingSum >= 1) {
                powerValue = calculatePowerValue(row);
                if (!switchFlag) {
                    remainingSum -= (powerValue - 1);
                    for (int c = 2; c <= (row + 1); c++) {
                        System.out.println((row + 1) + " " + c);
                    }
                    row--;
                }

                if (remainingSum >= 1) {
                    if (remainingSum <= row - 1) {
                        for (int j = 0; j < remainingSum; j++) {
                            System.out.println((row - j) + " " + (row - j));
                        }
                        remainingSum = 0;
                        return;
                    } else {
                        if ((powerValue / 2) + (powerValue / 4) - 2 > remainingSum) {
                            System.out.println((row + 1) + " " + (row + 1));
                            remainingSum--;
                            row--;
                            switchFlag = true;
                        } else {
                            for (int c = row + 1; c >= 2; c--) {
                                System.out.println((row + 1) + " " + c);
                            }
                            remainingSum -= (powerValue / 2);
                            row--;
                            switchFlag = false;
                        }
                    }
                }
            }
        }
    }

    private static int calculatePowerValue(int logValue) {
        int power = 1;
        for (int i = 0; i < logValue; i++) {
            power *= 2;
        }
        return power;
    }

    private static int calculateLogValue(int N) {
        int power = 1;
        int count = 0;
        for (int val = 2; val <= 30; val++) {
            if (power * val > N)
                return power;
            count++;
            power *= val;
        }
        return count;
    }
}