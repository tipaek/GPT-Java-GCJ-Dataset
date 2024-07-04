import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    static class Task implements Comparable<Task> {
        int index;
        int start;
        int end;
        String assignedTo;

        public Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
    }

    static Scanner scanner;

    public static void processTestCase(int testCaseNumber) {
        int n = getInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i, getInt(), getInt());
        }

        Arrays.sort(tasks);
        boolean cAvailable = true;
        int cLastEndTime = -1;
        boolean jAvailable = true;
        int jLastEndTime = -1;

        for (Task task : tasks) {
            if (cLastEndTime <= task.start) {
                cAvailable = true;
            }
            if (jLastEndTime <= task.start) {
                jAvailable = true;
            }
            if (!cAvailable && !jAvailable) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCaseNumber);
                return;
            }
            if (cAvailable) {
                task.assignedTo = "C";
                cAvailable = false;
                cLastEndTime = task.end;
            } else {
                task.assignedTo = "J";
                jAvailable = false;
                jLastEndTime = task.end;
            }
        }

        Arrays.sort(tasks, Comparator.comparingInt(task -> task.index));
        String result = Arrays.stream(tasks).map(task -> task.assignedTo).collect(Collectors.joining());
        System.out.printf("Case #%d: %s%n", testCaseNumber, result);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            processTestCase(i + 1);
        }
    }

    static int getInt() {
        return scanner.nextInt();
    }

    static long getLong() {
        return scanner.nextLong();
    }

    static String getString() {
        return scanner.next();
    }

    static Integer[] getIntArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = getInt();
        }
        return array;
    }

    static Long[] getLongArray(int size) {
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = getLong();
        }
        return array;
    }

    static Integer[][] getIntMatrix(int rows, int cols) {
        Integer[][] matrix = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = getIntArray(cols);
        }
        return matrix;
    }

    static <T> void forEach(String str, Consumer<Character> consumer) {
        for (int i = 0; i < str.length(); i++) {
            consumer.accept(str.charAt(i));
        }
    }

    static <T> void forEach(T[] array, Consumer<T> consumer) {
        for (T element : array) {
            consumer.accept(element);
        }
    }
}