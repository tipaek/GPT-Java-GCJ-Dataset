import java.util.ArrayList;
import java.util.Scanner;

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

//            int[][] activities = new int[][] {
//                    {2, 3},
//                    {2, 4},
//                    {8, 9},
//                    {4, 5},
//                    {4, 7},
//                    {6, 9},
//                    {3, 4},
//            };

            answers = new ArrayList<>();
            ArrayList<int[]> c = new ArrayList<>();
            ArrayList<int[]> j = new ArrayList<>();
            String answer = "C";
            addRange(c, activities[0][0], activities[0][1]);
            solve(activities, answer, c, j);
            String out;
            if (answers.size() == 0) {
                out = "IMPOSSIBLE";
            } else {
                out = answers.get(0);
            }
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static void solve(int[][] activities, String answer, ArrayList<int[]> c, ArrayList<int[]> j) {
        for (int i = answer.length(); i < activities.length; i++) {
            if (i == 6) {
            }
            int start = activities[i][0];
            int end = activities[i][1];
            boolean cCont = !containsRange(c, start, end);
            boolean jCont = !containsRange(j, start, end);

            ArrayList<int[]> newJ = (ArrayList<int[]>) j.clone();
            ArrayList<int[]> newC = (ArrayList<int[]>) c.clone();
            if (cCont && jCont) {
                addRange(newC, start, end);
                solve(activities, answer + "C", newC, (ArrayList<int[]>) j.clone());
                addRange(newJ, start, end);
                solve(activities, answer + "J", (ArrayList<int[]>) c.clone(), newJ);
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
//        System.out.println("final: " + answer);
//        System.out.print("c: ");
//        for (int[] arr : c) {
//            System.out.print(Arrays.toString(arr) + " ");
//        }
//        System.out.print("\n" + "j: ");
//        for (int[] arr : j) {
//            System.out.print(Arrays.toString(arr) + " ");
//        }
//        System.out.println();
//        System.out.println();

        answers.add(answer);
    }

    private static void addRange(ArrayList<int[]> set, int start, int end) {
        set.add(new int[]{start, end});
    }

    private static boolean containsRange(ArrayList<int[]> set, int start, int end) {

        for (int[] range : set) {
            for (int i = start + 1; i < end; i++) {
                if (i >= range[0] && i <= range[1]) {
                    return true;
                }
            }

            if (start != range[1]) {
                if (start >= range[0] && start < range[1]) {
                    return true;
                }
            }

            if (end != range[0]) {
                if (end > range[0] && end <= range[1]) {
                    return true;
                }
            }

            if (start == range[0]) {
                return true;
            }

            if (end == range[1]) {
                return true;
            }
        }

        return false;
    }
}