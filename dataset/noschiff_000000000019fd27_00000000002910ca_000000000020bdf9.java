//test set 1 works, 2 FAILS

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static String globalAnswer;

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

            globalAnswer = null;
            ArrayList<Integer> c = new ArrayList<>();
            ArrayList<Integer> j = new ArrayList<>();
            String answer = "C";
            addRange(c, activities[0][0], activities[0][1]);
            solve(activities, answer, c, j);
            if (globalAnswer == null) {
                globalAnswer = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (i + 1) + ": " + globalAnswer);
        }
    }

    private static void solve(int[][] activities, String answer, ArrayList<Integer> c, ArrayList<Integer> j) {
        for (int i = answer.length(); i < activities.length; i++) {

            if (globalAnswer != null) {
                return;
            }

            int start = activities[i][0];
            int end = activities[i][1];
            boolean cCont = !containsRange(c, start, end);
            boolean jCont = !containsRange(j, start, end);
            if (cCont && !jCont) {
                addRange(c, start, end);
                answer += "C";
            } else if (jCont && !cCont) {
                addRange(j, start, end);
                answer += "J";
            } else if (cCont && jCont) {
                ArrayList<Integer> newC = (ArrayList<Integer>) c.clone();
                addRange(newC, start, end);
                solve(activities, answer + "C", newC, (ArrayList<Integer>) j.clone());

                ArrayList<Integer> newJ = (ArrayList<Integer>) j.clone();
                addRange(newJ, start, end);
                solve(activities, answer + "J", (ArrayList<Integer>) c.clone(), newJ);
                return;
            } else {
                return;
            }
        }
//        System.out.println("final: " + answer);
//        System.out.println("c: " + c);
//        System.out.println("j: " + j);
//        System.out.println();

        globalAnswer = answer;
    }

    private static void addRange(ArrayList<Integer> set, int start, int end) {
        set.add(start);
        set.add(end);
    }

    private static boolean containsRange(ArrayList<Integer> set, int start, int end) {

        for (int k = 0; k < set.size(); k += 2) {
            int startR = set.get(k);
            int endR = set.get(k + 1);

            if (start == startR || end == endR) {
                return true;
            }

            if (start != endR) {
                if (start >= startR && start < endR) {
                    return true;
                }
            }

            if (end != startR) {
                if (end > startR && end <= endR) {
                    return true;
                }
            }

            for (int i = start + 1; i < end; i++) {
                if (i >= startR && i <= endR) {
                    return true;
                }
            }

        }

        return false;
    }
}