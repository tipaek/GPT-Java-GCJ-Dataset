import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for(int  i = 0; i < T; i++) {
            String parentheses = scan.next();
            System.out.println("Case #" + (i + 1) + ": "  + solution(parentheses));
        }

    }

    public static String solution(String number) {
        StringBuilder answer = new StringBuilder();
        int open = 0;
        int aux;
        for(int i  = 0; i < number.length(); i++) {
            aux = (int)number.charAt(i) -48;
            if(open < aux) {
                answer.append(leftParentheses(aux - open));
                open += aux - open;
            }
            else if(open == aux);
            else {
                answer.append(rightParentheses(open - aux));
                open -= open - aux;
            }
            answer.append(aux);
        }
        answer.append(rightParentheses(open));
        return answer.toString();
    }

    public static String leftParentheses(int i) {
        StringBuilder answer = new StringBuilder();
        for(int a = 0; a < i; a++)
            answer.append("(");
        return answer.toString();
    }

    public static String rightParentheses(int i) {
        StringBuilder answer = new StringBuilder();
        for(int a = 0; a < i; a++)
            answer.append(")");
        return answer.toString();
    }
}
