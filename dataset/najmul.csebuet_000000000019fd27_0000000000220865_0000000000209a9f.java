//package Codejam.Year2020.Qualification.NestingDepth;

import java.io.*;
import java.util.*;

public class Solution {
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            String s = sc.next();
            new Solution().solution(i+1, s);
        }

        if (fileInOut) {
            verify(Solution.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solution(int caseNumber, String s) {

        StringBuilder sPrime = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '0') {
                sPrime.append(ch);
                continue;
            }

            char start = ch;
            //ch is start, now search for all adjacent start
            sPrime.append("(" + start);

            boolean allSame = true;
            for (int j = i+1; j < s.length(); j++) {

                ch = s.charAt(j);
                if (ch == start) {
                    sPrime.append(ch);
                    continue;
                }

                allSame = false;
                sPrime.append(")");
                i = j - 1;
                break;
            }

            if (allSame) {
                sPrime.append(")");
            }
        }

        out.println("Case #" + caseNumber + ": " + sPrime.toString());
    }
}
