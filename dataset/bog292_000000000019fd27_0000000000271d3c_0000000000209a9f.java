import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int nr = 1; nr <= t; ++nr) {
            String s = in.nextLine();
            solve(nr, s);
        }
    }

    private static void solve(int testNr, String str) {
        List<Character> solution = seq(str.charAt(0), str.charAt(0) - '0');

        for (int i = 1; i < str.length(); i++) {
            int nr = str.charAt(i) - '0';

            int j = solution.size() - 1;

            int par = 0;
            while (j >= 0 && solution.get(j) == ')' && par < nr) {
                j--;
                par++;
            }

            int rem = nr - par;

            List<Character> list = seq(str.charAt(i), rem);

            solution.addAll(j + 1, list);
        }

        String solutionString = solution.stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println("Case #" + testNr + ": " + solutionString);
    }

    private static List<Character> seq(char nr, int par) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < par; i++) { list.add('('); }

        list.add(nr);

        for (int i = 0; i < par; i++) { list.add(')'); }

        return list;
    }
}
