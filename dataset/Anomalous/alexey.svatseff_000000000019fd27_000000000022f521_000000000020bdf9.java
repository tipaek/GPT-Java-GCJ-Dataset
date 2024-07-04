import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    private static boolean DEBUG = false;

    private static int T;
    private static int N;
    private static int[][] tasks;
    private static List<Integer> tasksIndex;

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {

                T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    readCaseInput(in);
                    solveCase(caseNumber, out);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCaseInput(Scanner in) {
        N = in.nextInt();
        tasks = new int[N][2];
        tasksIndex = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
            tasksIndex.add(i);
        }
        tasksIndex.sort(Comparator.comparingInt(idx -> tasks[idx][0]));
    }

    private static void solveCase(int caseNumber, PrintStream out) {
        char[] schedule = new char[N];
        int[] cTask = null, jTask = null;

        for (int idx : tasksIndex) {
            int[] task = tasks[idx];
            if (cTask != null && cTask[1] <= task[0]) cTask = null;
            if (jTask != null && jTask[1] <= task[0]) jTask = null;

            if (cTask == null) {
                cTask = task;
                schedule[idx] = 'C';
            } else if (jTask == null) {
                jTask = task;
                schedule[idx] = 'J';
            } else {
                writeCaseResult(out, caseNumber, "IMPOSSIBLE");
                return;
            }
        }

        writeCaseResult(out, caseNumber, new String(schedule));
    }

    private static void writeCaseResult(PrintStream out, int caseNumber, String result) {
        out.println("Case #" + caseNumber + ": " + result);
        out.flush();
    }

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        if (DEBUG) {
            File inFile = new File(args[0]);
            return new Scanner(new BufferedReader(new FileReader(inFile)));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        if (DEBUG) {
            String inPathBase = args[0].substring(0, args[0].lastIndexOf('.'));
            File outFile = new File(inPathBase + ".out");
            return new PrintStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        } else {
            return System.out;
        }
    }
}