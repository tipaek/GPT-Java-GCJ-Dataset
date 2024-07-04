import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            executeSecret();
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
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return row == position.row && col == position.col;
        }
    }

    private static void executeSecret() {
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

            int row = logValue + 1;
            boolean switchFlag = false;

            while (remainingSum >= 1) {
                powerValue = calculatePowerValue(row - 1);
                if (!switchFlag) {
                    remainingSum -= (powerValue - 1);
                    for (int c = 2; c <= row; c++) {
                        System.out.println(row + " " + c);
                    }
                    row--;
                }

                if (remainingSum >= 1) {
                    if (remainingSum <= row - 2) {
                        for (int j = 0; j < remainingSum; j++) {
                            System.out.println((row - j - 1) + " " + (row - j - 1));
                        }
                        remainingSum = 0;
                        return;
                    } else {
                        if ((powerValue / 2) + (powerValue / 4) - 2 > remainingSum) {
                            System.out.println(row + " " + row);
                            remainingSum--;
                            row--;
                            switchFlag = true;
                        } else {
                            for (int c = row; c >= 2; c--) {
                                System.out.println(row + " " + c);
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
        return (int) Math.pow(2, logValue);
    }

    private static int calculateLogValue(int N) {
        int power = 1;
        int times = 0;

        for (int val = 2; val <= 30; val++) {
            if (power * val > N) return power;
            times++;
            power *= val;
        }

        return times;
    }
}