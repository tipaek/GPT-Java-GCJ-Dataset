import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numEntries = Integer.parseInt(scnr.nextLine());

        for (int i = 0; i < numEntries; i++) {
            char[] entries = scnr.nextLine().toCharArray();
            StringBuilder retVal = new StringBuilder("Case #" + (i + 1) + ": ");
            int currParenthesis = 0;

            for (char entryChar : entries) {
                int entry = Character.getNumericValue(entryChar);
                int toChange = currParenthesis - entry;

                while (toChange != 0) {
                    if (toChange < 0) {
                        retVal.append("(");
                        currParenthesis++;
                        toChange++;
                    } else {
                        retVal.append(")");
                        currParenthesis--;
                        toChange--;
                    }
                }

                retVal.append(entry);
            }

            while (currParenthesis != 0) {
                retVal.append(")");
                currParenthesis--;
            }

            System.out.println(retVal);
        }
    }
}