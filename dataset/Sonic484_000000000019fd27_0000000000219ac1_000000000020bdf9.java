import java.util.*;
    import java.io.*;
    public class Solution {
     public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = in.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                int n = in.nextInt();
                List<Task> tasks = new ArrayList<>(n);
                for (int i = 0; i < n; ++i) {
                    tasks.add(new Task(in.nextInt(), in.nextInt(), i));
                }
                tasks.sort(Comparator.comparing(Task::getStart));

                boolean notImpossible = true;
                int i = 0;

                int j = 0;
                int c = 0;
                StringBuilder result = new StringBuilder(n);
                for (int k = 0; k < n; ++k) {
                    result.append('0');
                }

                while (notImpossible && i < n) {
                    Task actual = tasks.get(i);
                    if (j <= actual.start) {
                        j = actual.end;
                        result.setCharAt(actual.i, 'J');
                    } else if (c <= actual.start) {
                        c = actual.end;
                        result.setCharAt(actual.i, 'C');
                    } else {
                        notImpossible = false;
                    }
                    ++i;
                }

                if (notImpossible) {
                    System.out.println("Case #" + t + ": " + result.toString());
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }

            }
        }
    }

    private static class Task {
        int start;
        int end;
        int i;

        public Task(int start, int end, int i) {
            this.start = start;
            this.end = end;
            this.i = i;
        }

        public int getStart() {
            return start;
        }
    }
    }