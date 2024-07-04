import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String number = (in.nextLine());
            printWithBraces(number, i);

        }
    }

    public static void printWithBraces(String num, int caseNumber) {

        StringBuilder updatedString = new StringBuilder();
        int countOfOnes = 0;
        int prev = Integer.parseInt(String.valueOf(num.charAt(0)));
        if (prev == 1) {
            updatedString.append("(");
            updatedString.append(prev);
            countOfOnes++;
        }else{
            updatedString.append("0");
        }
        for (int i = 1; i < num.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (digit == 0) {
                if (prev == 1) {
                    updatedString.append(")");
                }
                updatedString.append("0");
            } else {
                if (prev == 0) {
                    updatedString.append("(");
                }
                updatedString.append("1");
            }
            prev = digit;
        }

        if (prev == 1) {
            updatedString.append(")");
        }


        System.out.println("Case #" + caseNumber + ": " + updatedString.toString());


    }
}
