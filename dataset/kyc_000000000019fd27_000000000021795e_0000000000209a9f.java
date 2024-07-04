import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String s = input.next();

            StringBuilder sb = new StringBuilder();
            int numOpen = 0;
            for (char c : s.toCharArray()) {
                int d = c - '0';
                if (numOpen < d)
                    while (numOpen < d) {
                        sb.append('(');
                        numOpen++;
                    }
                else
                    while (numOpen > d) {
                        sb.append(')');
                        numOpen--;
                    }
                sb.append(c);
            }
            while (numOpen > 0) {
                sb.append(')');
                numOpen--;
            }

            System.out.printf("Case #%d: %s\n", caseNum, sb);
        }
    }
}
