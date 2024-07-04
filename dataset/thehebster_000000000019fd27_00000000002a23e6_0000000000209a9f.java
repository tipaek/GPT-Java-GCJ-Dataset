import java.util.*;

public class Solution
{
    public static void main(String[] args) 
    {

        Scanner scanny = new Scanner(System.in); 
        int numCases = scanny.nextInt();
    
        for (int i = 0; i < numCases; i++)
        {
            String line = scanny.next();
            int len = line.length();
            int num = 0;
            int balance;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++)
            {
                int val = Character.getNumericValue(line.charAt(j));

                if (val == num)
                {
                    sb.append(line.charAt(j));
                }
                else if(val > num)
                {
                    balance = val-num;
                    sb.append("(").append(line.charAt(j));
                    num += balance;
                }
                else
                {
                    balance = num-val;
                    sb.append(")").append(line.charAt(j));
                    num -= balance;
                }
            }
            if(num > 0) 
            {
                sb.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": "  + sb.toString());

        }
      
    }



}
