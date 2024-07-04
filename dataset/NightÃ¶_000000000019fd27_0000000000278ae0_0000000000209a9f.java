import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class Solution{
    public static void nestingDepth(String s, int x) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(int i =0; i< s.length();i ++){
            int needed = Character.getNumericValue(s.charAt(i));
            if (open < needed){
                for(int k=0; k < open; k++){
                    sb.append(")");
                }
                for(int k=0; k < needed; k++){
                    sb.append("(");
                }
                open = needed;
                sb.append(needed);
                continue;
            }
            for(int k=0; k < open - needed; k++){
                sb.append(")");
            }
            open = needed;
            sb.append(needed);
        }
        for(int k=0; k < open; k++){
                sb.append(")");
        }
        System.out.println("Case #"+x+": "+sb.toString());
    }

     public static void main(String []args){
        Solution sol = new Solution();
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        stdin.nextLine();
        for(int t=0; t<T; t++){
            sol.nestingDepth(stdin.nextLine(), t+1);
        }
     }
}