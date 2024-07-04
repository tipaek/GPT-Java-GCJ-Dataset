import java.util.Scanner;

public class MatrixGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int size = scanner.nextInt();
        generateMatrix(size);
    }

    public static void generateMatrix(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print((int)(Math.random() * 2) + " ");
            }
            System.out.println();
        }
    }
}