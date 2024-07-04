import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
   public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       StringBuilder builder;
       String s;
       int test, par, digit;
       int absval;
       int currIndex = 0;
       
       test = in.nextInt();
       for(int t = 0; t < test; t++){
           s = in.next();
           par = 0;
           builder = new StringBuilder();
           for(int i = 0; i < s.length(); i++){
               digit = Character.getNumericValue(s.charAt(i));
               par = par - digit;
               absval = Math.abs(par);
               if(par != 0){
                    for(int j = 0; j < absval; j++){
                        if(par < 0)
                            builder.append('(');
                        else
                            builder.append(')');
                    }
               }
               builder.append(s.charAt(i));
               par = digit;
           }
           for(int j = 0; j < par; j++)
               builder.append(')');
           System.out.println("Case #" + (t+1) + ": " + builder.toString());
       }
   } 
}