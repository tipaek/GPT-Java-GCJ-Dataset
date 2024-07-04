
import java.util.Scanner;
import java.io.*;

public class Solution{
      static String next_line = new String("");
     static Scanner good = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int test = Integer.parseInt(good.nextLine());
        int test_send = test;
        
        while(test > 0){
        
        String number = good.nextLine();
        String [] token = number.split("");
        int cur = Integer.parseInt(token[0]);
         for(int counter = 0; counter<cur; counter++){
             next_line = next_line.concat("(");
         }
        next_line = next_line.concat(token[0]);
        if(token.length == 1){
            for(int counter = 0; counter<cur; counter++){
             next_line = next_line.concat(")");
         }
        }
        
        for(int counter = 1; counter<token.length; counter++){
            int next = Integer.parseInt(token[counter]);
            int diff = cur - next;
            
            if(diff == 0){
                next_line = next_line.concat(token[counter]);
            }else if(diff > 0){
                for(int counter2 = 0; counter2<diff; counter2++){
                    next_line = next_line.concat(")");
                }
                next_line = next_line.concat(token[counter]);
            }else if(diff < 0){
                diff = -1 * diff;
                for(int counter2 = 0; counter2<diff; counter2++){
                    next_line = next_line.concat("(");
                }
                next_line = next_line.concat(token[counter]);
            }
            cur = next;
            if(counter == token.length - 1){
                diff = Integer.parseInt(token[counter]);
                for(int counter2 = 0; counter2<diff; counter2++){
                    next_line = next_line.concat(")");
            }
        }
    }
        
        System.out.println("Case #"+ (test_send - test + 1) +": " + next_line);
        next_line = "";
       test--; 
        }
    }
}
