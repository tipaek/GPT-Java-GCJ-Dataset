import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        
       Scanner scan = new Scanner(System.in);
       
       int tests = scan.nextInt();
       scan.nextLine();
       for(int k =0; k<tests; k++)
       {
           String s = scan.nextLine();
           Stack<Character> stack = new Stack<Character>();
           for(int i=0; i<Character.getNumericValue(s.charAt(0)); i++)
           {
               stack.push('(');
           }
           stack.push(s.charAt(0));
           int num = Character.getNumericValue(s.charAt(0));
           for(int i=1; i<s.length(); i++)
           {
                num = Character.getNumericValue(s.charAt(i));
               int pre = Character.getNumericValue(s.charAt(i-1));
               int after = 0;
               if(i<s.length() - 1)
                   after = Character.getNumericValue(s.charAt(i+1));
               if(num >= pre)
               {
                   for(int j=0; j<(num-pre);j++)
                   {
                       stack.push('(');
                   }
               }
               else
               {
                   for(int j=0; j<(pre-num); j++)
                   {
                       stack.push(')');
                   }
               }
               stack.push(s.charAt(i));
           }
           for(int i=0; i<num; i++)
           {
               stack.push(')');
           }
           Object[] arr = stack.toArray();
           char[] arr2 = new char[arr.length];
           for(int t=0; t<arr.length; t++)
           {
               arr2[t] = (char)arr[t];
           }
           String str = new String(arr2);
           System.out.println("Case #" + (k+1) + ": " + str);
       }
       
    }  
}