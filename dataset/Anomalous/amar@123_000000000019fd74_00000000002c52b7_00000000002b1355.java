import java.io.*;

public class PascalTriangle {

    public static void printPascal(int rows) {
        for (int line = 0; line < rows; line++) {
            int value = 1;
            for (int i = 0; i <= line; i++) {
                System.out.print(value + " ");
                value = value * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numberOfRows = 5;
        printPascal(numberOfRows + 1);
    }
}