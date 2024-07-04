import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        String result = "";
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < numberOfTestCases; i++) {
            String testCase = scanner.nextLine();
            result = result + "Case #" + (i + 1) + ": " + getMinNestedByParenthes(testCase) + "\n";
        }
        System.out.println(result);
    }

    public static String getMinNestedByParenthes(String input){
        String[] numbers = input.split("");
        String answer = "";
        int opened = 0;
        for (String number: numbers) {
            int num = Integer.parseInt(number);
            if(opened < num){
                for (int i = opened; i < num; i++) {
                    answer += "(";
                    opened++;
                }
            }else if(opened > num){
                int deduct = opened - num;
                for (int i = 0; i < deduct ; i++) {
                    answer += ")";
                    opened--;
                }
            }
            answer += num;
        }
        // filling the last parentheses
        for (int i = 0; i < opened; i++) {
            answer += ")";
        }

        return answer;
    }
}
