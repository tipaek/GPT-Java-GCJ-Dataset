import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();

            try (Scanner in = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int to = in.nextInt();
                int b = in.nextInt();
                JavaSolution solution = new JavaSolution(in, out, b);

                for (int i = 0; i < to; i++) {
                    solution.run();
                }

            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
                }
            }
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static Reader getReader(boolean isInteractiveMode, boolean isDebugMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new BufferedReader(new InputStreamReader(process.getInputStream()));
        } else if (isDebugMode) {
            return new FileReader("input.txt");
        } else {
            return new InputStreamReader(System.in);
        }
    }

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private final Scanner in;
    private final PrintWriter out;
    private final int b;

    private JavaSolution(Scanner in, PrintWriter out, int b) {
        this.in = in;
        this.out = out;
        this.b = b;
    }

    private boolean checkBit(int i) {
        out.println(i + 1);
        out.flush();
        return in.next().equals("0");
    }

    private void run() {
        int half = b / 2;
        boolean[] prefix = new boolean[half];
        boolean[] suffix = new boolean[half];
        int count = 0;
        int equalIndex = -1;
        int notEqualIndex = -1;

        for (; count < 5; count++) {
            prefix[count] = checkBit(count);
            suffix[count] = checkBit(b - 1 - count);

            if (prefix[count] == suffix[count]) {
                equalIndex = count;
            } else {
                notEqualIndex = count;
            }
        }

        while (count < half) {
            if (equalIndex != -1) {
                if (checkBit(equalIndex) != prefix[equalIndex]) {
                    invertArray(prefix, count);
                    invertArray(suffix, count);
                }
            } else {
                checkBit(0);
            }

            if (notEqualIndex != -1) {
                if (checkBit(notEqualIndex) != prefix[notEqualIndex]) {
                    boolean[] temp = prefix;
                    prefix = suffix;
                    suffix = temp;
                }
            } else {
                checkBit(0);
            }

            for (int i = 0; i < 4 && count < half; i++, count++) {
                prefix[count] = checkBit(count);
                suffix[count] = checkBit(b - 1 - count);

                if (prefix[count] == suffix[count]) {
                    equalIndex = count;
                } else {
                    notEqualIndex = count;
                }
            }
        }

        printArray(prefix);
        printArray(suffix);
        out.println();
        out.flush();

        if (in.next().equals("N")) {
            throw new IllegalArgumentException();
        }
    }

    private void invertArray(boolean[] array, int length) {
        for (int i = 0; i < length; i++) {
            array[i] = !array[i];
        }
    }

    private void printArray(boolean[] array) {
        for (boolean bit : array) {
            out.print(bit ? '0' : '1');
        }
    }
}