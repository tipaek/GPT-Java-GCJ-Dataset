import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            executeSecretFunction();
        }
    }

    private static class Position {
        int row;
        int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position))
                return false;
            Position pos = (Position) obj;
            return pos.row == row && pos.column == column;
        }
    }

    private static void executeSecretFunction() {
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

            for (int r = 2; r <= logValue; r++) {
                remainingSum--;
                System.out.println(r + " 1");
            }

            int currentRow = logValue;
            boolean flag = false;

            while (remainingSum >= 1) {
                powerValue = calculatePowerValue(currentRow);
                if (!flag) {
                    remainingSum -= (powerValue - 1);
                    for (int c = 2; c <= (currentRow + 1); c++) {
                        System.out.println((currentRow + 1) + " " + c);
                    }
                }

                if (remainingSum >= 1) {
                    if (remainingSum <= currentRow - 1) {
                        for (int j = 0; j < remainingSum; j++) {
                            System.out.println((currentRow - j) + " " + (currentRow - j));
                        }
                        remainingSum = 0;
                        return;
                    } else {
                        if ((powerValue / 2) + (powerValue / 4) - 2 > remainingSum) {
                            System.out.println(currentRow + " " + currentRow);
                            remainingSum--;
                            currentRow--;
                            flag = true;
                        } else {
                            for (int c = currentRow; c >= 2; c--) {
                                System.out.println(currentRow + " " + c);
                            }
                            remainingSum -= (powerValue / 2);
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