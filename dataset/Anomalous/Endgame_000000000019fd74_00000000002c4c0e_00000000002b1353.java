import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            processCase();
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

    private static void processCase() {
        int N = scanner.nextInt();
        System.out.println("1 1");

        int logValue = calculateLogValue(N);
        int powerValue = calculatePowerValue(logValue);

        if (N <= 500) {
            for (int i = 1; i < N; i++) {
                System.out.println((i + 1) + " 1");
            }
        } else {
            int remainingSum = N - 2;
            if (logValue + powerValue > N) {
                logValue--;
                powerValue = calculatePowerValue(logValue);
            }

            for (int row = 2; row <= logValue; row++) {
                remainingSum--;
                System.out.println(row + " 1");
            }

            int currentRow = logValue;
            boolean flag = false;

            while (remainingSum >= 1) {
                powerValue = calculatePowerValue(currentRow);
                if (!flag) {
                    remainingSum -= (powerValue - 1);
                    for (int col = 2; col <= (currentRow + 1); col++) {
                        System.out.println((currentRow + 1) + " " + col);
                    }
                    currentRow--;
                }

                if (remainingSum >= 1) {
                    if (remainingSum <= currentRow - 1 + 1) {
                        for (int j = 0; j < remainingSum; j++) {
                            System.out.println((currentRow - j) + " " + (currentRow - j));
                        }
                        return;
                    } else {
                        if ((powerValue / 2) + (powerValue / 4) - 2 > remainingSum) {
                            System.out.println((currentRow + 1) + " " + (currentRow + 1));
                            remainingSum--;
                            currentRow--;
                            flag = true;
                        } else {
                            for (int col = currentRow + 1; col >= 2; col--) {
                                System.out.println((currentRow + 1) + " " + col);
                            }
                            remainingSum -= (powerValue / 2);
                            currentRow--;
                            flag = false;
                        }
                    }
                }
            }
        }
    }

    private static int calculatePowerValue(int logValue) {
        return 1 << logValue;
    }

    private static int calculateLogValue(int N) {
        int power = 1;
        int times = 0;
        for (int val = 2; val <= 30; val++) {
            if (power * val > N) {
                return power;
            }
            times++;
            power *= val;
        }
        return times;
    }
}