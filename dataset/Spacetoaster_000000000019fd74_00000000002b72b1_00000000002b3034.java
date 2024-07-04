import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int P = Integer.parseInt(in.nextLine());
            ArrayList<String> suffixes = new ArrayList<>();
            for (int j = 0; j < P; j++) {
                String input = in.nextLine();
                String[] parts = input.split("\\*");
                if (input.length() > 1) {
                    suffixes.add(parts[1]);
                } else {
                    suffixes.add("");
                }
            }
            suffixes.sort(Comparator.comparingInt(String::length));

            String longestSuffix = suffixes.get(suffixes.size() - 1);
            boolean canBeSolved = true;
            if (suffixes.size() > 1) {
                for (int j = 0; j < P; j++) {
                    if (!longestSuffix.endsWith(suffixes.get(j))) {
                        canBeSolved = false;
                        break;
                    }
                }
            }
            String solution = "*";
            if (canBeSolved) {
                solution = "A" + longestSuffix;
            }
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}
