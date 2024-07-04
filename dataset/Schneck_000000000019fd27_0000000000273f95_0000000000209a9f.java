import java.io.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        line = line.trim();
        StringBuilder res = new StringBuilder();
        int currLevel = 0;
        for (int i = 0; i < line.length(); i++) {
            int nextLevel = line.charAt(i) - '0';
            char paren = 0;
            if (currLevel > nextLevel) {
                paren = ')';
            } else {
                paren = '(';
            }
            for (int j = 0; j < Math.abs(currLevel - nextLevel); j++) {
                res.append(paren);
            }
            currLevel = nextLevel;
            res.append(line.charAt(i));
        }
        for (int j = 0; j < currLevel; j++) {
            res.append(')');
        }
        System.out.println(res);
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
