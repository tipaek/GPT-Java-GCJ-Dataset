import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        String str = scanner.next();
        String soln = "";

        int currBrackets = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = Character.getNumericValue(str.charAt(i));
            while (currBrackets > num) {
                currBrackets--;
                soln += ")";
            }
            while (currBrackets < num) {
                currBrackets++;
                soln += "(";
            }
            soln += Integer.toString(num);
        }
        while (currBrackets > 0) {
            currBrackets--;
            soln += ")";
        }
        return soln;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}