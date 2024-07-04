import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        int T;

        T = input.nextInt();
        
        for (int i = 0; i < T; i++) {
            String res = solution(input.next().toCharArray());
            output.println(String.format("Case #%d: %s",(i+1), res));
            output.flush();
        }
    }
    
    public static String solution(char[] str) {
        StringBuilder builder = new StringBuilder();
        int N = str.length;
        
        
        for (int i = 0; i <= N; i++) {            
            
            if (i == 0)  {
             // first elem
                appendParentheses(builder, '0', str[i]);
                builder.append(str[i]);
            } else if (i == N) {
                // last elem
                appendParentheses(builder, str[i - 1], '0'); 
                
            } else {
                // base case
                appendParentheses(builder, str[i - 1], str[i]);
                builder.append(str[i]);
            }                        
        }
        
       return builder.toString();
    }
    
    
    public static void appendParentheses(StringBuilder builder, char prev, char curr) {
        int nbrP = '9' - prev;
        int nbrC = '9' - curr;
        int diff = 0;
        char par = '(';
        
        if (nbrP > nbrC) {
            // we need to Open the diff
            diff = nbrP - nbrC;
            par = '(';
        } else {
            // we need to Close off the diff;
            diff = nbrC - nbrP;
            par = ')';
        }       
     
        for (int i = 0; i < diff; i++) {
            builder.append(par);
        }
    }
}