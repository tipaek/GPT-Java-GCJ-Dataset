import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for (int testCase = 0; testCase < numTestCases; testCase++) {
            String digits = sc.nextLine();
            String result = "";
            for (int index = 0; index < digits.length(); index++) {
                int digit = digits.charAt(index) - 48;
                result = result.concat(new String(new char[digit]).replace("\0", "(")).concat(String.valueOf(digit)).concat(new String(new char[digit]).replace("\0", ")"));
            }
            while (true) {
                String newResult = result.replace(")(", "");
                if (newResult.length() == result.length()) {
                    break;
                }
                result = newResult;
            }
            System.out.println(String.format("Case #%s: %s", testCase + 1, result));
        }
    }

}
