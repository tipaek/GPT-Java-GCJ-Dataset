import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[])
	{
		    try{
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    in.nextLine(); //skipping the first line with number of cases.
		    
		    for (int i = 1; i <= t; ++i) {
		      String s = in.nextLine();
		      System.out.println("Case #" + i + ": "+ nestIt(s));
		      }
		    in.close();
		    }catch(Exception e){}
	}
	
	private static String nestIt(String s)
	{
	    String s1 = "";
	    if(s == null || "".equals(s))
	      return s;
	    char[] c = s.toCharArray();
	    String left = "";
	    String current = "";
	    boolean prevZero = false;
	    StringBuilder sb = new StringBuilder();
        if(s!= null && s.indexOf("0") < 0)
          return processNonZero(s);
        
	    for(int i=0; i<c.length; i++)
	    {
	        if(c[i] == '0' && !prevZero)
	        {
	            left = current;
	            current = "";
	            current += c[i];
	            prevZero = true;
	        }
	        else if(prevZero && c[i] != '0')
	        {
	          return processNonZero(left) + current + nestIt(s.substring(i));
	        }
	        else
	          current += c[i];
	    }
	    
	    return current;
	}
	
	private static String processNonZero(String s)
	{
	    char[] c = s.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    int prev = 0;
	    int par = -1;
	    for(int i =0; i< c.length; i++)
	    {
	        par = Integer.parseInt(c[i]+"");
	        if(i == 0 )
	        {
	            sb.append(paren(par, true));
	        }
	        else if( par > prev)
	        {
	            sb.append(paren(par-prev, true));
	        }
	        else if(par < prev)
	        {
	            sb.append(paren(prev-par, false));
	        }
	        sb.append(c[i]);
	        prev = par;
	    }
	    sb.append(paren(prev,false));
	    return sb.toString();
	}
	
	private static String paren(int num, boolean open)
	{
	    String brackets = "";
	    for(int j=0; j<num; j++)
	    {
	       if(open)
	         brackets += "(";
	       else
	         brackets += ")";
	    }
	    return brackets;
	}
}