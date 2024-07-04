import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int[][] activities;
    static ArrayList<String> possible;
    static ArrayList<String> answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input[j] = scanner.nextLine();
            }
            activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] inputs = input[j].split(" ");
                for (int k = 0; k < inputs.length; k++) {
                    activities[j][k] = Integer.valueOf(inputs[k]);
                }
            }

            possible = new ArrayList<>();
            answer = new ArrayList<>();
            generate("");
            for (String possibleA : possible) {
                if (check(possibleA)) {
                    answer.add(possibleA);
                }
            }
            String out;
            if (answer.size() == 0) {
                out = "IMPOSSIBLE";
            } else {
                out=answer.get(0);
            }
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static boolean check(String possibleA) {
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();
        for (int i = 0; i < possibleA.length(); i++) {
            ArrayList<Integer> current = (possibleA.charAt(i) == 'C') ? c : j;
            if (alreadyInRange(current, activities[i][0], activities[i][1])) {
                return false;
            } else {
                addRange(current, activities[i][0], activities[i][1]);
            }
        }
        return true;
    }

    private static void generate(String answer) {
        if (answer.length() < activities.length) {
            generate(answer + "C");
            generate(answer + "J");
        } else {
            possible.add(answer);
        }
    }


    private static void addRange(ArrayList<Integer> set, int start, int end) {
        for (int i = start; i <= end; i++) {
            set.add(i);
        }
    }

    private static boolean alreadyInRange(ArrayList<Integer> set, int start, int end) {
        boolean startIn = false;
        boolean endIn = false;

        if (set.contains(start + 1)) {
            startIn = set.contains(start);
        }

        if (set.contains(end - 1)) {
            endIn = set.contains(end);
        }

        return startIn || endIn;
    }
}
