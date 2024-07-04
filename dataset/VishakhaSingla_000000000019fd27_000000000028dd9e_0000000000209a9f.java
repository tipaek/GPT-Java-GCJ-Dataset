import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++)
        {
            String input = sc.next();
            String output = new String();
            int open = 0, prev = 0, close = 0;
            for( int j = 0; j<input.length(); j++)
            {
                int num = Integer.valueOf(input.substring(j,j+1));
                if(num == prev)
                output = output + String.valueOf(num);
                else if(num > prev)
                {
                    open = num - prev;
                    for( int k = 0; k<open ;k++)
                    output = output + "(";
                    output = output + String.valueOf(num);
                }
                else
                {
                   close = prev - num;
                   open = open - close;
                   for( int k = 0; k<close ;k++)
                   output = output + ")";
                   output = output + String.valueOf(num);
                }
                prev = num;
            }
            for( int k = 0; k<prev ;k++)
            output = output + ")";
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
    
    

}