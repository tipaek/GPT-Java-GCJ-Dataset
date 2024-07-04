import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
           String input = in.next();
           StringBuilder answer = new StringBuilder(input);
           int currentindex = 0 ;
           int openPCount = 0;
          
           for(int index=0;index<input.length();index++,currentindex++)
           {
               int digit = input.charAt(index)-'0';
               if(openPCount<digit)
               {
                   insertParentheses(true,digit-openPCount,currentindex,answer);
                   currentindex+=digit-openPCount;
                   openPCount=digit-openPCount;
               }
               else if(openPCount>digit)
               {
                   insertParentheses(false,openPCount-digit,currentindex,answer);
                   currentindex+=openPCount-digit;
                   openPCount-=openPCount-digit;
               }               
           }
           insertParentheses(false,openPCount,currentindex,answer);
           System.out.println("Case #"+i+": "+answer);
        }
    }
    
    public static void insertParentheses(boolean type,int count, int index, StringBuilder answer)
    {
        StringBuilder sub = new StringBuilder("");
        if(type)
        {
            for(int i=0;i<count;i++)
            {
                sub.append("(");
            }
        }
        else
        {
            for(int i=0;i<count;i++)
            {
                sub.append(")");
            }
        }
        answer.insert(index, sub);
    }
}
