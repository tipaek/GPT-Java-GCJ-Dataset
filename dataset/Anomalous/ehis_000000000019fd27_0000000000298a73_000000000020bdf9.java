import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static class Task implements Comparable<Task> {
        public int start;
        public int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<Task> tasks;

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            tasks = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                tasks.add(new Task(start, end));
            }

            solve(tasks, N, ks);
        }
    }

    public static String generatePermutations(String s, int n) {
        if (s.length() == n) {
            return s + "\n";
        } else {
            return generatePermutations(s + "0", n) + generatePermutations(s + "1", n);
        }
    }

    public static boolean isValidTaskList(List<Task> taskList) {
        List<Task> sortedTaskList = new ArrayList<>(taskList);
        Collections.sort(sortedTaskList);

        for (int i = 1; i < sortedTaskList.size(); i++) {
            if (sortedTaskList.get(i - 1).end > sortedTaskList.get(i).start) {
                return false;
            }
        }
        return true;
    }

    public static void solve(List<Task> tasks, int N, int iteration) {
        List<Task> tasksC = new ArrayList<>();
        List<Task> tasksJ = new ArrayList<>();
        String result = "";

        String permutations = generatePermutations("", N);
        String[] permutationArray = permutations.split("\n");

        for (String perm : permutationArray) {
            tasksC.clear();
            tasksJ.clear();
            result = "";

            for (int j = 0; j < perm.length(); j++) {
                if (perm.charAt(j) == '0') {
                    result += "C";
                    tasksC.add(tasks.get(j));
                } else {
                    result += "J";
                    tasksJ.add(tasks.get(j));
                }
            }

            if (isValidTaskList(tasksC) && isValidTaskList(tasksJ)) {
                System.out.println("Case #" + iteration + ": " + result);
                return;
            }
        }

        System.out.println("Case #" + iteration + ": IMPOSSIBLE");
    }
}