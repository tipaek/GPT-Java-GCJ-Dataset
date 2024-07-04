import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testC.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String s) {
        if (DEBUG) {
            writer.println(s);
        }
    }

    private static void debugPrint(String s) {
        if (DEBUG) {
            writer.print(s);
        }
    }

    private static long now() {
        return System.nanoTime();
    }

    private static double round(double d, int sigDigits) {
        double q = Math.pow(10, sigDigits);
        return Math.round(d * q) / q;
    }

    private static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        BigInteger zero = BigInteger.ZERO;
        while (!b.equals(zero)) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    private static HashSet<BigInteger> arrayToHashSet(BigInteger[] array) {
        return new HashSet<>(Arrays.asList(array));
    }

    private static HashMap<BigInteger, Character> convertCodesToLetters(HashSet<BigInteger> codes) {
        BigInteger[] sortedCodes = codes.toArray(new BigInteger[0]);
        Arrays.sort(sortedCodes);

        HashMap<BigInteger, Character> mapping = new HashMap<>();
        char ch = 'A';
        for (BigInteger code : sortedCodes) {
            mapping.put(code, ch++);
        }

        return mapping;
    }

    private static class Task {
        int startTime;
        int endTime;
        int id;
        char assigned = 'x';

        Task(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        void setAssigned(char assigned) {
            this.assigned = assigned;
        }
    }

    private static class TaskSorterByStartTime implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            return Integer.compare(t1.startTime, t2.startTime);
        }
    }

    private static class TaskSorterById implements Comparator<Task> {
        @Override
        public int compare(Task t1, Task t2) {
            return Integer.compare(t1.id, t2.id);
        }
    }

    private static void nextCase(int caseNum) {
        int taskCount = scanner.nextInt();
        Task[] tasks = new Task[taskCount];

        for (int i = 0; i < taskCount; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            tasks[i] = new Task(i, startTime, endTime);
        }

        Arrays.sort(tasks, new TaskSorterByStartTime());

        Integer cEndTime = null;
        Integer jEndTime = null;
        boolean impossible = false;

        for (Task task : tasks) {
            if (cEndTime == null || cEndTime <= task.startTime) {
                cEndTime = task.endTime;
                task.setAssigned('C');
            } else if (jEndTime == null || jEndTime <= task.startTime) {
                jEndTime = task.endTime;
                task.setAssigned('J');
            } else {
                impossible = true;
                break;
            }
        }

        String result = impossible ? "IMPOSSIBLE" : getResultString(tasks);
        writer.print("Case #" + caseNum + ": " + result);
    }

    private static String getResultString(Task[] tasks) {
        Arrays.sort(tasks, new TaskSorterById());
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(task.assigned);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            nextCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}