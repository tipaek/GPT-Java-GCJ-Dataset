import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    static boolean DEBUG = false;
    
    private static String generateParentheses(int count, char parenthesisType) {
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesisType);
        }
        return parentheses.toString();
    }
    
    private static String getOpenParentheses(int count) {
        return generateParentheses(count, '(');
    }
    
    private static String getClosedParentheses(int count) {
        return generateParentheses(count, ')');
    }

    public static void main(String[] args) throws Exception {
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/nestingdepth.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String S = scanner.next();
                StringBuilder result = new StringBuilder();
                
                int prevInt = Character.getNumericValue(S.charAt(0));
                result.append(getOpenParentheses(prevInt)).append(prevInt);
                
                int openParentheses = prevInt;
                
                for (int i = 1; i < S.length(); i++) {
                    int nextInt = Character.getNumericValue(S.charAt(i));
                    
                    if (prevInt == nextInt) {
                        result.append(nextInt);
                    } else if (prevInt > nextInt) {
                        result.append(getClosedParentheses(prevInt - nextInt)).append(nextInt);
                        openParentheses = nextInt;
                    } else {
                        result.append(getOpenParentheses(nextInt - prevInt)).append(nextInt);
                        openParentheses = nextInt;
                    }
                    
                    prevInt = nextInt;
                }
                
                result.append(getClosedParentheses(openParentheses));
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }
}