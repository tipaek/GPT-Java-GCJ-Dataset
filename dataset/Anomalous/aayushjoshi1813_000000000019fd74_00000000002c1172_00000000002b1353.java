import java.io.*;

public class PascalTriangle {

    public static void printPascal(int rows) {
        for (int line = 0; line < rows; line++) {
            int number = 1;
            for (int i = 0; i <= line; i++) {
                System.out.print(number + " ");
                number = number * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numberOfRows = 5;
        printPascal(numberOfRows);
    }
}