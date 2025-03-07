import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            restoreOriginalArray(arraySize);
        }
    }

    void restoreOriginalArray(int size) {
        if (size == 10) {
            char[] chars = new char[size];

            for (int i = 0; i < size; i++) {
                chars[i] = read(i) == 1 ? '1' : '0';
            }

            checkArray(String.valueOf(chars));
        }
    }

    protected int read(int i) {
        printStream.println(i + 1);
        printStream.flush();
        return scanner.nextInt();
    }

    protected boolean checkArray(String array) {
        printStream.println(array);
        printStream.flush();
        return scanner.nextLine().equals("Y");
    }
}
