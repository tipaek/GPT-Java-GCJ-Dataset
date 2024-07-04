import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rows do you want to input: ");
        int rows = scanner.nextInt();
        
        System.out.println("Pascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            // Print leading spaces for formatting
            for (int j = 0; j < rows - i; j++) {
                System.out.print("   ");
            }
            int binomialCoefficient = 1;
            for (int k = 0; k <= i; k++) {
                System.out.printf("%6d", binomialCoefficient);
                binomialCoefficient = binomialCoefficient * (i - k) / (k + 1);
            }
            System.out.println();
        }
    }
}