//package Codejam.Year2020.Qualification.ESAbATAd;

import java.io.*;
import java.util.*;

public class Solution {
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();
        int B = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            new Solution().solve(testCaseNumber, B, sc);
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

    public void solve(int testCaseNumber, int B, Scanner sc) {

        //List<int[]> list = new ArrayList<>();

        for (int query = 1; query <= 15; query++) {

            int[] array = new int[11];

            for (int i = query*10 - 9; i <= query*10; i++) {
                int P = i;
                out.println(P);
                out.flush();

                //0/1/P
                int value = sc.nextInt();
                array[P] = value;
            }

            //Now lets review "array"
            for (int i = 1; i <= 10; i++) {
                out.print(array[i]);
            }
            out.println();
            out.flush();

            String response = sc.next();
            if (response.equals("Y"))return;
            if (response.equals("N"))return;
        }
    }
}
