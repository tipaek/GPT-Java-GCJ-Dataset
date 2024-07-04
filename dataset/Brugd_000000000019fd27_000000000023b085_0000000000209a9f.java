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
                
        // state: 0, not ongoing parentheses
        // state: 1, ongoing parentheses
    
        int state = 0;
        
        if (str[0] == '1') {
            state = 1;
            builder.append('(');
        }
        
        for (int i = 0; i < str.length; i++) {
            
            // Should close ongoing before appending next item
            if (state == 0 && str[i] == '1') {
                state = 1;
                builder.append('(');
            }
            
            // should open before appending next item
            if (state == 1 && str[i] == '0') {
                state = 0;
                builder.append(')');
            }
            
            builder.append(str[i]);           
        }
        
        // handle end case        
        if (state == 1) {
            builder.append(')');
        }        
        
        return builder.toString();        
    }    
}