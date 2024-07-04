import java.io.*;

public class Main {
    public static void printPascal(int n) {
        for (int line = 0; line < n; line++) {
            int C = 1;
            for (int i = 0; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5; // Example value, you can change it to test with different values
        printPascal(n);
    }
}