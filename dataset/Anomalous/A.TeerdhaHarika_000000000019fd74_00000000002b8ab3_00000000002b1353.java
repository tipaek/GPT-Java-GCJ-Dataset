import java.io.*;

public class PascalTriangle {

    public static void generatePascalTriangle(int rows) {
        for (int line = 1; line <= rows; line++) {
            int value = 1;  // The first value in a line is always 1
            for (int i = 1; i <= line; i++) {
                System.out.print(value + " ");
                value = value * (line - i) / i;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numberOfRows = 5;
        generatePascalTriangle(numberOfRows);
    }
}