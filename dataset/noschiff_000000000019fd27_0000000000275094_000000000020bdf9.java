import java.util.*;

public class Solution {

    private static ArrayList<String> answers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input[j] = scanner.nextLine();
            }
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] inputs = input[j].split(" ");
                for (int k = 0; k < inputs.length; k++) {
                    activities[j][k] = Integer.valueOf(inputs[k]);
                }
            }

            answers = new ArrayList<>();
            HashSet<Integer> c = new HashSet<>();
            HashSet<Integer> j = new HashSet<>();
            String answer = "C";
            addRange(c, activities[0][0], activities[0][1]);
            solve(activities, answer, c, j);
            String out;
            if (answers.size() == 0) {
                out = "IMPOSSIBLE";
            } else {
                out=answers.get(0);
            }
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }
    private static void solve(int[][] activities, String answer, HashSet<Integer> c, HashSet<Integer> j) {
        for (int i = answer.length(); i < activities.length; i++) {
            int start = activities[i][0];
            int end = activities[i][1];
            boolean cCont = !containsRange(c,start,end);
            boolean jCont = !containsRange(j,start,end);

            HashSet<Integer> newJ = (HashSet<Integer>) j.clone();
            HashSet<Integer> newC = (HashSet<Integer>) c.clone();
            if (cCont&&jCont) {
                addRange(newC, start, end);
                solve(activities, answer+"C", newC, (HashSet<Integer>) j.clone());
                addRange(newJ, start, end);
                solve(activities, answer+"J", (HashSet<Integer>) c.clone(), newJ);
                return;
            } else if (cCont) {
                addRange(c, start, end);
                answer += "C";
            } else if (jCont) {
                addRange(j, start, end);
                answer += "J";
            } else {
                return;
            }
        }
        answers.add(answer);
    }

    private static void addRange(Set<Integer> set, int start, int end) {
        for (int i = start; i <= end; i++) {
            set.add(i);
        }
    }

    private static boolean containsRange(Set<Integer> set, int start, int end) {
        boolean startIn = false;
        boolean endIn = false;
        boolean middle = false;

        if (set.contains(start+1)) {
            startIn = set.contains(start);
        }

        if (set.contains(end-1)) {
            endIn = set.contains(end);
        }

        for (int i = start+1; i < end; i++) {
            if (set.contains(i)) {
                middle = true;
            }
        }

        return startIn || endIn || middle;
    }
}