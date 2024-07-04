import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter output = new PrintWriter(System.out);
        Task solver = new Task();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, output);
        }
        output.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scanner, PrintWriter output) {
            int n = scanner.nextInt();
            PriorityQueue<Event> events = new PriorityQueue<>();
            int[] assignments = new int[n];
            int activeTasks = 0;

            for (int i = 0; i < n; i++) {
                events.add(new Event(scanner.nextInt(), i + 1));
                events.add(new Event(scanner.nextInt(), -(i + 1)));
            }

            int firstTask = -2;
            int secondTask = -2;

            while (!events.isEmpty()) {
                Event currentEvent = events.poll();
                if (currentEvent.taskId > 0) {
                    if (firstTask == -2) {
                        firstTask = currentEvent.taskId;
                    } else if (secondTask == -2) {
                        secondTask = currentEvent.taskId;
                        assignments[currentEvent.taskId - 1] = 1;
                    } else {
                        output.printf("Case #%d: IMPOSSIBLE%n", testNumber);
                        return;
                    }
                } else {
                    if (firstTask == -currentEvent.taskId) {
                        firstTask = -2;
                    }
                    if (secondTask == -currentEvent.taskId) {
                        secondTask = -2;
                    }
                }
            }

            output.printf("Case #%d: ", testNumber);
            for (int assignment : assignments) {
                output.print(assignment == 0 ? 'C' : 'J');
            }
            output.println();
        }
    }

    static class Event implements Comparable<Event> {
        int time;
        int taskId;

        Event(int time, int taskId) {
            this.time = time;
            this.taskId = taskId;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return Integer.compare(this.taskId, other.taskId);
            }
            return Integer.compare(this.time, other.time);
        }
    }

    static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            long temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(new File(fileName)));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}