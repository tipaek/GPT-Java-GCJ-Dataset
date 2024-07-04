import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[])
    {
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            input = reader.readLine();
            
            int numOfCases = Integer.parseInt(input);
            
            for(int i = 1; i <= numOfCases; ++i)
            {
                input = reader.readLine();
                
                System.out.println("Case #" + i + ": " + NestingDepths(input));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static String RepeatCharacter(char c, int count)
    {
        StringBuilder strB = new StringBuilder();
        
        for(int i = 0; i < count; ++i)
            strB.append(c);
            
        return strB.toString();
    }
    
    public static String NestingDepths(String s)
    {
        int count = 0;
        StringBuilder strB = new StringBuilder();
        
        for(int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            int d = Character.getNumericValue(c);
            
            int num = d - count;
            
            if(num != 0)
            {
                if(num > 0)
                {
                    strB.append(RepeatCharacter('(', num));
                }
                else
                {
                    strB.append(RepeatCharacter(')', Math.abs(num)));
                }
                count = d;
            }
            
            strB.append(c);
        }
        
        strB.append(RepeatCharacter(')', count));
        
        return strB.toString();
    }
}