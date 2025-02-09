
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);

        int noOfTestCases = scanner1.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {

            processEachString(new StringBuilder(scanner1.next()), i + 1);
        }

    }

    private static void processEachString(StringBuilder gvnStr, int testCaseNo) {

        if (gvnStr.indexOf("0") == -1 && gvnStr.indexOf("1") == -1) {
//            System.out.print("Case #" + testCaseNo);
            return; //no zeroes no ones, not a valid input
        }
        StringBuilder toBeUpdatedString = new StringBuilder("");
        int firstOccurenceOne = gvnStr.indexOf("1");

        if (firstOccurenceOne == -1) {
            System.out.print("Case #" + testCaseNo + ": " + gvnStr);// all zeroes . print directly;and return
            return;
        }

        char prevInt = (char) '1';

        for (int i = firstOccurenceOne + 1; i < gvnStr.length(); i++) {

            if (prevInt != gvnStr.charAt(i)) {
                prevInt = gvnStr.charAt(i);
                if (prevInt == (char) '0')
                    gvnStr.insert(i, ')');
                else if (prevInt == (char) '1')
                    gvnStr.insert(i, '(');
                i++;
            }
        }
        System.out.print("\nCase #" + testCaseNo + ":" + " ");
        gvnStr.insert(firstOccurenceOne, "(");
        System.out.print(gvnStr);

        if (gvnStr.charAt(gvnStr.length() - 1) == '1')
            System.out.print(")");


    }
}