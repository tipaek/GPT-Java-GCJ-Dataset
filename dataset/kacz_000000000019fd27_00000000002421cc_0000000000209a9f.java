import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static Scanner input = null;
    private static PrintStream logger = null;
    private static PrintStream output = null;
    private static boolean debug = false;

    public static <E> void log(E msg) {
        if(debug) {
            logger.println("LOG: " + msg);
        }
    }

    public static <E> void out(E msg) {
        out(msg, false);
    }

    public static <E> void outln(E msg) {
        out(msg, true);
    }

    private static <E> void out(E msg, boolean println) {
        output.print(msg);
        if(println) {
            output.println();
        }
        output.flush();

        if(debug) {
            logger.print("OUT: " + msg);
            if(println) {
                logger.println("\\n");
            } else {
                logger.println();
            }
            logger.flush();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("-debug")) {
            debug = true;
            input = new Scanner(new File("in.txt"));
            output = new PrintStream(new File("out.txt"));
            logger = new PrintStream(new File("log.txt"));
        } else {
            input = new Scanner(System.in);
            output = new PrintStream(System.out);
        }

        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; ++i) {
            solve(i + 1);
        }
    }

    private static void solve(int testCaseNumber) {
        out("Case #" + testCaseNumber + ": ");
        String line = input.nextLine();

        int currentNesting = 0;
        StringBuilder result = new StringBuilder();
        char zeroChar = '0';
        for (int i = 0; i < line.length(); i++) {
            int d = line.charAt(i) - zeroChar;
            if(d > currentNesting) {
                for (int j = 0; j < d - currentNesting; j++) {
                    result.append('(');
                }
            } else if (d < currentNesting) {
                for (int j = 0; j < currentNesting - d; j++) {
                    result.append(')');
                }
            }
            result.append(d);
            currentNesting = d;
        }
        if (currentNesting > 0) {
            for (int j = 0; j < currentNesting; j++) {
                result.append(')');
            }
        }

        outln(result.toString());
    }
}