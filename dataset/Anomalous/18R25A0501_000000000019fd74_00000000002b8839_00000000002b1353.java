import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int binomialCoefficient = 1;

        for (int i = 0; i < rows; i++) {
            // Print leading spaces for alignment
            for (int j = 0; j < 40 - 3 * i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {
                if (k == 0 || i == 0) {
                    binomialCoefficient = 1;
                } else {
                    binomialCoefficient = binomialCoefficient * (i - k + 1) / k;
                }

                System.out.printf("%6d", binomialCoefficient);
            }

            System.out.println();
        }

        scanner.close();
    }
}