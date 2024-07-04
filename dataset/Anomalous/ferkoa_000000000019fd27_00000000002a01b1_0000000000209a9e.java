import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static void printAndFlush(PrintStream out, int i) {
        out.println(i);
        out.flush();
    }

    private static void printAndFlush(PrintStream out, String s) {
        out.println(s);
        out.flush();
    }

    private static void processInput(Scanner in, PrintStream out) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            printAndFlush(out, i);
            sb.append(in.nextInt());
        }
        printAndFlush(out, sb.toString());
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            PrintStream out = System.out;

            int testCases = in.nextInt();
            int b = in.nextInt();
            in.nextLine();

            for (int i = 1; i <= testCases; ++i) {
                if (b == 10) {
                    processInput(in, out);
                }
            }
        }
    }
}