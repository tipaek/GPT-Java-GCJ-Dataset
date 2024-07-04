    import java.util.*;
    import java.io.*;
    
    import java.util.Stack;
    
    
    public class Solution 
    {
        
        
        public String buildSolution(String input)
        {
            int level = 0;
            int currentLevel = 0;
            
            StringBuilder sb = new StringBuilder();
            for(Character c : s.toCharArray())
    		{
    		    if (Character.isDigit(c))
    		    {
    			int requestedLevel = Integer.parseInt(c);
    			
    			while(currentLevel != level)
    			{
    			    if (currentLevel < level)
    			     {
    			         sb.append("(");
    			         currentLevel++;
    			     }
    			     
    			    if (currentLevel > level)
    			     {
    			         sb.append(")");
    			         currentLevel--;
    			     }    			    
    			     if (currentLevel == level)
    			     sb.append(c);
    			     
    			}
    			
    		    }
    		}
            return sb.toString();
        }
        
        
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String input = in.nextLine();
          System.out.println("Case #" + i + ": " + buildSolution(input));
        }
      }
    }
