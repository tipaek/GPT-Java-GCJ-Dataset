import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();
        key.nextLine();
        for(int i = 0; i < n; i++)
        {
        	
            int open = 0;
            String str = "";
            String s = key.nextLine();
            for(int j = 0; j < s.length(); j++)
            {
            	int num = Integer.parseInt(s.substring(j, j+1));
            	if(open < num)
            	{
            	for(int k = open; k < num; k++)
            	{
            		str = str + "(";
            		
            	}
            	open = num;
            	}else
            	{
            		for(int k = num; k < open; k++)
            		{
            			str = str + ")";
            			
            		}
            		open = num;
            	}
            	str = str + num;
            }
            for(int j = 0; j < open; j++)
            {
            	str = str + ")";
            }
            System.out.println("Case #" + (i+1) + ": " + str);
            
        }
      
    }

}