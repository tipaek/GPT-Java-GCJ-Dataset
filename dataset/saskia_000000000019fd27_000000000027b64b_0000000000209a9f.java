import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        in.nextLine();
        //System.out.println(testCases);
        if (testCases == 0)
            return;
        for (int i = 0; i < testCases; i++) {
            StringBuilder outputString = new StringBuilder(new String(""));
            String testCase = in.nextLine();
            //System.out.println(testCase);
            int caseL = testCase.length();
            //System.out.println(caseL);
            int parOpen = 0;
            for (int j = 0; j < caseL; j++) {
                char curr_c = testCase.charAt(j);
                int curr = Integer.parseInt(String.valueOf(curr_c));
                while (parOpen < curr) {
                    outputString.append("(");
                    parOpen++;
                }

                while (parOpen > curr) {
                    outputString.append(")");
                    parOpen--;
                }

                outputString.append(curr);
            }

            while (parOpen > 0) {
                outputString.append(")");
                parOpen--;
            }

            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + outputString);

        }

    }
}