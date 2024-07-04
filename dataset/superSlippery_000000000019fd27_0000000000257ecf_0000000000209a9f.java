import java.util.Scanner;

public class Solution {
    public static String putParenthesis(int[] arr) {
        int needToOpen = 0;
        int alreadyOpened = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            needToOpen = arr[i];

            if(needToOpen > alreadyOpened) {
                int temp = needToOpen - alreadyOpened;

                for(int j = 0; j < temp; j++ ) {
                    res.append('(');
                }
                alreadyOpened = needToOpen;
            } else if(alreadyOpened > needToOpen) {
                int temp = alreadyOpened - needToOpen;
                for(int j = 0; j < temp; j++ ) {
                    res.append(')');
                }
                alreadyOpened = needToOpen;
            }
            res.append(arr[i]);
        }

        while(alreadyOpened-- > 0) {
            res.append(')');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//.useDelimiter("");
        int testCaseN = scanner.nextInt();
        int testCase = 1;
        StringBuilder builder = new StringBuilder();
        scanner.skip("\n");
        while(testCase <= testCaseN) {
            char[] digits = scanner.nextLine().toCharArray();
            int[] arr = new int[digits.length];
            for(int i =0;  i < digits.length; i++) {
                arr[i] = Character.getNumericValue(digits[i]);
            }
            String res = putParenthesis(arr);
            builder.append("Case #" + testCase + ": " + res + "\n");
            testCase++;
        }

        System.out.println(builder.toString());
    }
}