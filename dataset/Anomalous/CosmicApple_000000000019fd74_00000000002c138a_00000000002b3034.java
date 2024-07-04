import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
        }
    }
}

class Solver {
    private String[] strings;
    private StringBuilder raw;
    private boolean possible;

    public Solver(Scanner input) {
        int n = input.nextInt();
        strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = input.next();
        }
        raw = new StringBuilder("*");
        possible = true;
    }

    public void solve() {
        for (String str : strings) {
            int j = 0;
            while (j < str.length() && str.charAt(j) != '*') {
                if (raw.length() <= j || raw.charAt(j) == '*') {
                    raw.insert(j, str.charAt(j));
                } else if (raw.charAt(j) != str.charAt(j)) {
                    possible = false;
                    return;
                }
                j++;
            }

            int k = 1;
            while (k <= str.length() && str.charAt(str.length() - k) != '*') {
                if (raw.length() < k || raw.charAt(raw.length() - k) == '*') {
                    raw.insert(raw.length() - k + 1, str.charAt(str.length() - k));
                } else if (raw.charAt(raw.length() - k) != str.charAt(str.length() - k)) {
                    possible = false;
                    return;
                }
                k++;
            }

            int rawIndex = raw.indexOf("*");
            raw.replace(rawIndex, rawIndex + 1, str.substring(j, str.length() - k + 1));
        }
    }

    public String getOutput() {
        if (!possible) return "*";
        return raw.toString().replace("*", "");
    }
}