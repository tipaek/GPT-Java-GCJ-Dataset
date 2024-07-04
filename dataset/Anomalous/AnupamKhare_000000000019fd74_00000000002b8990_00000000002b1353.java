import java.io.*;

class GFG {
    public static void printPascal(int n) {
        for (int line = 0; line < n; line++) {
            int c = 1; // The first value in a line is always 1
            for (int i = 0; i <= line; i++) {
                System.out.print(c + " ");
                c = c * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 5;
        printPascal(n);
    }
}