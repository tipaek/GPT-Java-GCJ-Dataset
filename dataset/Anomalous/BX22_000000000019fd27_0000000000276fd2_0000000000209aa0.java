import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace = in.nextInt();
            List<String> choices = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                choices.add(String.valueOf(j));
            }
            List<String> permutations = new ArrayList<>();
            generatePermutations(permutations, choices, "", n);
            List<String> answers = new ArrayList<>();
            findValidPermutation("", n, trace, permutations, answers, false);
            if (answers.isEmpty()) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                String validPermutation = answers.get(0);
                for (int k = 0; k < validPermutation.length(); k++) {
                    String perm = permutations.get(Integer.parseInt(String.valueOf(validPermutation.charAt(k))));
                    for (int m = 0; m < perm.length(); m++) {
                        System.out.print(perm.charAt(m) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void generatePermutations(List<String> permutations, List<String> choices, String current, int max) {
        if (current.length() == max) {
            permutations.add(current);
        } else {
            for (int i = 0; i < choices.size(); i++) {
                String choice = choices.remove(i);
                generatePermutations(permutations, choices, current + choice, max);
                choices.add(i, choice);
            }
        }
    }

    public static void findValidPermutation(String current, int length, int trace, List<String> permutations, List<String> answers, boolean terminate) {
        if (!terminate && current.length() == length) {
            int total = 0;
            for (int i = 0; i < current.length(); i++) {
                int index = Integer.parseInt(String.valueOf(current.charAt(i)));
                int value = Integer.parseInt(String.valueOf(permutations.get(index).charAt(i)));
                total += value;
            }
            if (total == trace) {
                answers.add(current);
                terminate = true;
            }
        } else {
            for (int i = 0; i < permutations.size(); i++) {
                if (isValid(current, permutations, i)) {
                    findValidPermutation(current + i, length, trace, permutations, answers, terminate);
                }
            }
        }
    }

    public static boolean isValid(String current, List<String> permutations, int index) {
        String str = permutations.get(index);
        for (int i = 0; i < current.length(); i++) {
            int currentIndex = Integer.parseInt(String.valueOf(current.charAt(i)));
            String compare = permutations.get(currentIndex);
            for (int j = 0; j < compare.length(); j++) {
                if (compare.charAt(j) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}