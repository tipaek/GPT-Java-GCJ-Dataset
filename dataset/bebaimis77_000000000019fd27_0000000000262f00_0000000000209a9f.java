import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int z=1;z<=T;z++) {
            String input = scanner.nextLine();

            int firstNum = Integer.parseInt(String.valueOf(input.charAt(0)));
            String parenthesis = generateOpeningParenthesis(firstNum);
            String result = parenthesis.concat(input.substring(0, 1));
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    result += input.charAt(i);
                } else if (input.charAt(i) < input.charAt(i - 1)) {
                    int diff = input.charAt(i - 1) - input.charAt(i);
                    result += generateClosingParenthesis(diff) + input.charAt(i);

                } else {
                    int diff = input.charAt(i) - input.charAt(i - 1);
                    result += generateOpeningParenthesis(diff) + input.charAt(i);
                }

            }
            int lastNum = Integer.parseInt(String.valueOf(result.charAt(result.length() - 1)));
            result += generateClosingParenthesis(lastNum);

            System.out.println("Case #"+z+": "+result);
        }
    }

   static String generateOpeningParenthesis(int n){
        char parenthesis = '(';
        String result="";
        for(int i = 0;i<n;i++){
            result+=parenthesis;
        }
        return result;
    }

    static String generateClosingParenthesis(int n){
        char parenthesis = ')';
        String result="";
        for(int i = 0;i<n;i++){
            result+=parenthesis;
        }
        return result;
    }
}

