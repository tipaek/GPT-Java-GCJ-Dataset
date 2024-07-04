    import java.util.*;
    import java.io.*;
    import java.util.HashMap;
    import java.util.Map;
    
    
    public class Solution 
    {
        
        
        static public String buildSolution(String input)
        {
            int maxInt = 0;
            Map<Character, Integer> occurrences = new HashMap<Character, Integer>();
            int currentLevel = 0;
            StringBuilder sb = new StringBuilder();
            
            for(Character c : input.toCharArray())
    		{
    		    if (Integer.parseInt(c.toString()) > maxInt)
    		        maxInt = Integer.parseInt(c.toString());
    		        
                occurrences.put(c, occurrences.getOrDefault(c, 0)+1);
    		}
    		
    		for (int x = 0; x < maxInt; x++)
    		    sb.append("(");
    		
            for(int i = maxInt; i >= 0; i--)
            {
                String strC = Integer.toString(i);
                char c = strC.charAt(0);
                int howMany = occurrences.getOrDefault(c, 0);
                
                if (howMany > 0 )
                    sb.append(i+"".repeat(howMany));
                    
                    sb.append(")");
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
