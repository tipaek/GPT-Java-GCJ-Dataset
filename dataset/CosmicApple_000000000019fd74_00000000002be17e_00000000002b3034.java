import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
            
        }
    }
}

class Solver  {
    String[] strings;
    String raw = "*";
    boolean possible = true;
    public Solver(Scanner input) {
        strings = new String[input.nextInt()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = input.next();
        }        
    }
    public void solve() {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; !strings[i].substring(j, j+1).equals("*"); j++) {
                if (raw.substring(j, j+1).equals("*")) {
                    raw = raw.substring (0, j) + strings[i].substring(j, j+1) + raw.substring (j);
                } else if (!strings[i].substring(j, j+1).equals(raw.substring(j, j+1))) {
                    possible = false;
                    return;
                }
            }
            for (int j = 1; !strings[i].substring(strings[i].length() - j, strings[i].length() - j+1).equals("*"); j++) {
                if (raw.substring(raw.length() - j, raw.length() - j+1).equals("*")) {
                    raw = raw.substring (0, raw.length() - j + 1) + strings[i].substring(strings[i].length() - j, strings[i].length() - j+1) + raw.substring (raw.length() - j + 1);
                } else if (!strings[i].substring(strings[i].length() - j, strings[i].length() - j+1).equals(raw.substring(raw.length() - j, raw.length() - j+1))) {
                    possible = false;
                    return;
                }
            }
        }
    }
    
    public String getOutput () {
        if (!possible) return "*";
        String output = "";
        for (int i = 0; i < raw.length(); i++) {
            if (!raw.substring(i, i+1).equals("*")) {
                output = output + raw.substring(i, i+1);
            }
        }
        return output;
    }    
}
