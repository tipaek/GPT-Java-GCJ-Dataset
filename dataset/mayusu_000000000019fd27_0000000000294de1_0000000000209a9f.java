import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String string = in.nextLine();
            StringBuilder solutionBuilder = new StringBuilder();
            String solution = "";
            for (int j = 0; j < string.length(); j++) {
                int current = Integer.parseInt(String.valueOf(string.charAt(j)));
                String openings = new String(new char[current]).replace("\0", "(");
                String closings = new String(new char[current]).replace("\0", ")");
                solutionBuilder.append(openings).append(current).append(closings);
            }
            solution = solutionBuilder.toString();
            while (solution.contains(")(")) {
                solution = solution.replace(")(", "");
            }
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}