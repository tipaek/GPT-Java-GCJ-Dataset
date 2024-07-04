import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            StringBuilder output = new StringBuilder(in.next());
            
            int currentDepth = 0, index = 0;
            
            while (index < output.length())
            {
                if (Character.isDigit(output.charAt(index)))
                {
                    int c = (int)(output.charAt(index) - '0');
                    
                    int temp = currentDepth;
                    
                    if (temp < c)
                    {
                        for (int i = 1; i <= c - temp; i++)
                        {
                            output.insert(index, '(');
                            index++;
                            currentDepth++;
                        }
                    }
                    else
                    {
                        for (int i = 1; i <= temp - c; i++)
                        {
                            output.insert(index, ')');
                            index++;
                            currentDepth--;
                        }
                    }
                }
                index++;
            }

            for (int i = 1; i <= currentDepth; i++)
            {
                output.append(')');
            }
            
            //print output
            System.out.print("Case #" + testCase + ": ");
            System.out.print(output);
            System.out.println();
        }
    }
}