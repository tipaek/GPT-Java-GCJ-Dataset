import java.io.*;
import java.lang.Math;
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
	       
	        for(int i =1;i<path.length();i++)
	        {
	               switch(path.charAt(i))
	               {
	                   case 'S':y--;
	                            break;
	                   case 'N' : y++;
	                            break;
	                   case 'E' : x++;
	                                break;
	                   case 'W' : x--;
	                                break;
	               }
	        }
	     if((Math.abs(x) + Math.abs(y)) > (path.length()-1))
    	     res.append("Case #" + it++ + ": IMPOSSIBLE");
	   else if((Math.abs(x) + Math.abs(y)) == (path.length()-1))    
	     res.append("Case #" + it++ + ": " + (path.length()-1));
	   else
	        res.append("Case #" + it++ + ": " + (path.length() - (Math.abs(x) + Math.abs(y))-1));
	       res.append("\n");
	    }
		System.out.println(res);
}
}