import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final Boolean DEBUG = false;
    private static final Boolean FROM_FILE = false;
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
        double msPerNs = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        BigInteger max = a.max(b);
        BigInteger min = a.min(b);
        BigInteger rem = max.mod(min);
        BigInteger zero = BigInteger.ZERO;

        while (!rem.equals(zero)) {
            max = min;
            min = rem;
            rem = max.mod(min);
        }

        return min;
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
        int taskNum = scanner.nextInt();
        Task[] tasks = new Task[taskNum];

        for (int i = 0; i < taskNum; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            tasks[i] = new Task(i, startTime, endTime);
        }

        Arrays.sort(tasks, new TaskSorterByStartTime());

        Integer cEndTime = null;
        Integer jEndTime = null;
        boolean impossible = false;

        for (Task t : tasks) {
            if (cEndTime == null || cEndTime <= t.startTime) {
                cEndTime = t.endTime;
                t.setAssigned('C');
            } else if (jEndTime == null || jEndTime <= t.startTime) {
                jEndTime = t.endTime;
                t.setAssigned('J');
            } else {
                impossible = true;
                break;
            }
        }

        StringBuilder result = new StringBuilder();

        if (impossible) {
            result.append("IMPOSSIBLE");
        } else {
            Arrays.sort(tasks, new TaskSorterById());
            for (Task t : tasks) {
                result.append(t.assigned);
            }
        }

        writer.print("Case #" + caseNum + ": " + result);
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