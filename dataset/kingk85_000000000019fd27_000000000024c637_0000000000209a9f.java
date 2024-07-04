    import java.util.*;
    import java.io.*;
    
    import java.util.Stack;
    
    
    public class Solution 
    {
        
        
        public String buildSolution(String input)
        {
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<Character>();
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
