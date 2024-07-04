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
        int numStrings = input.nextInt();
        strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            strings[i] = input.next();
        }
        raw = new StringBuilder("*");
        possible = true;
    }

    public void solve() {
        for (String str : strings) {
            int j = 0;
            while (j < str.length() && str.charAt(j) != '*') {
                if (raw.charAt(j) == '*') {
                    raw.insert(j, str.charAt(j));
                } else if (str.charAt(j) != raw.charAt(j)) {
                    possible = false;
                    return;
                }
                j++;
            }

            int k = 1;
            while (k <= str.length() && str.charAt(str.length() - k) != '*') {
                if (raw.charAt(raw.length() - k) == '*') {
                    raw.insert(raw.length() - k + 1, str.charAt(str.length() - k));
                } else if (str.charAt(str.length() - k) != raw.charAt(raw.length() - k)) {
                    possible = false;
                    return;
                }
                k++;
            }
        }
    }

    public String getOutput() {
        if (!possible) {
            return "*";
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            if (raw.charAt(i) != '*') {
                output.append(raw.charAt(i));
            }
        }
        return output.toString();
    }
}