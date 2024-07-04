import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String line) {
        StringBuffer result = new StringBuffer();
        int depth = 0;
        for(int i=0; i<line.length(); i++) {
            int c = Integer.parseInt(line.substring(i, i+1));
            // Open necessary parenthesis
            for(int d=0;d+depth<c;d++) {
                result.append('(');
            }
            // Close necessary parenthesis
            for(int d=0;d+depth>c;d--) {
                result.append(')');
            }
            result.append(c);
            depth = c;
        }
        // Close necessary parenthesis
        for(int d=depth;d>0;d--) {
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Read T
        int test_cases_T = Integer.parseInt(in.nextLine());
        // For each testcase
        for(int tc = 1; tc <= test_cases_T; tc++) {
            // Read The Line
            String line = in.nextLine();
            // Solve
            System.out.println("Case #"+tc+": "+nestingDepth(line));
        }
    }
}
