import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String str = in.nextLine();
            char digits[] = str.toCharArray();
            StringBuffer output = new StringBuffer();
            int depth = 0;
            int openedParanthesis = 0;
            int closedParanthesis = 0;

            for (int i = 0; i < digits.length; i++) {
                int value = Character.getNumericValue(digits[i]);

                if (value < depth) {
                    int diff = depth - value;
                    output.append(repeat(")",diff));
                    closedParanthesis = closedParanthesis + diff;
                } else if (value > depth) {
                    int diff = value - depth;
                    output.append(repeat("(",diff));
                    openedParanthesis = openedParanthesis + diff;
                }
                output.append(value);
                depth = value;
            }
            if (openedParanthesis > closedParanthesis) {
                output.append(output.append(repeat(")",openedParanthesis - closedParanthesis)));
            }
            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    private static StringBuffer repeat(String strToRepeat, int times) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(strToRepeat);
        }
        return sb;
    }
}