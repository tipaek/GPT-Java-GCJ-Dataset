
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < testCases; i++) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String inputString = scanner.nextLine();
            generateOutputStringWithNestedDepth(inputString, i);
        }
    }

    private static void generateOutputStringWithNestedDepth(String inputString, int testCase) {
        int leftOpen = 0, rightOpen = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == '0') {
                int diff = leftOpen - rightOpen;
                for (int j = 0; j < diff; j++) {
                    builder.append(')');

                }
                leftOpen = 0;
                rightOpen = 0;

            }else {
                int val = Integer.parseInt(String.valueOf(inputString.charAt(i)));
                int diff = val - leftOpen;
                for (int j = 0; j < diff; j++) {
                    builder.append('(');
                    leftOpen++;
                }
            }
            builder.append(inputString.charAt(i));
        }

        int diff = leftOpen - rightOpen;
        for (int i = 0; i < diff; i++) {
            builder.append(')');
        }
        printOutput(builder.toString(), testCase);
    }

    static void printOutput(String resultString, int testCase) {
        System.out.println( "Case #"+testCase+": "+resultString);
    }
}
