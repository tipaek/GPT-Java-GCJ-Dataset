import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    
	    Scanner s = new Scanner(System.in);
	    
	    int t = s.nextInt();
	    int it = 1;
	    StringBuffer res = new StringBuffer("");
	    while(t-->0)
	    {
	        int x = s.nextInt();
	        int y = s.nextInt();
	        
	        String path = s.nextLine();
	        int i = 1;
	        int count = 0;
	        
	        while(i<path.length() && y>0)
	        {
	            count++;
	            if(path.charAt(i) == 'N')
	                y++;
	           else if(path.charAt(i) == 'S')
	                   y--;
	            i++;
	        }
	   if(y == 0){     
	       if(count == x)
	            res.append("Case #" + it++ + ": " +count);
	       else if(count<x)
	               res.append("Case #" + it++ + ": " +"IMPOSSIBLE");
	       else
	            res.append("Case #" + it++ + ": " +(count-x));
	   }
	   else
	            res.append("Case #" + it++ + ": " +"IMPOSSIBLE");
	        res.append("\n");
	    }
		System.out.println(res);
	}
  
}