import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int k = 1; k <= t; k++) {
            String s_n = bf.readLine().trim();
            findAnswer(s_n, k);
        }
    }
    public static void findAnswer(String s, int testCaseNo){
        // iterate over 0 to 9

        
        for(int i=0; i<9; i++){
            LinkedList<Integer> stack = new LinkedList<>();
            int n = s.length();

            for(int j=0; j<n; j++){
               if(s.charAt(j)=='(' || s.charAt(j)==')')
                   continue;
               if(stack.size()%2==0)
                   stack.push(j);
               if((int)s.charAt(j)<=i+48){
                   if(stack.peek()==j)
                       stack.pop();
                   else
                       stack.push(j);
               }

            }

           if(stack.size()%2!=0)
               stack.push(n);
           if(stack.size()>0)
               s = putBracketsInString(s,stack);

        }

        // for each iteration, iterate over s.
            // check for brackets, if yes continue
            // at start of iteration put starting position of bracket in the stack if stack size is even
            // if value is not greater than the above mentioned value, close the brackets. if no value in inside brackets, pop the starting position
        System.out.println();
        System.out.format("Case #%d: %s",testCaseNo,s);

    }

    public static String putBracketsInString(String s, LinkedList<Integer> stack){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i< stack.size(); i++){
            if(i%2==0)
                sb = sb.insert(stack.get(i), ")");
            else
                sb = sb.insert(stack.get(i), "(");
        }
        return sb.toString();
    }
}
