import java.util.*;
import java.io.*;
public class Solution {
public static void main(String[] args)
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine(); 
    for (int i = 1; i <= t; ++i) 
    {
    String s = in.nextLine();    
    String sn="";
    int op=0;
    for (int j = 0; j < s.length(); j++) 
    {
		int num = Character.getNumericValue(s.charAt(j));
		String fix="";
		if(num<op)
		{
		   for(int k=0;k<op-num;k++)
		     fix+=")";
		}
		else
		{
		    for(int k=0;k<num-op;k++)
		     fix+="(";
		}
		op = num;
		sn += fix + s.charAt(j);
    }
    for(int k=0;k<op;k++)
	  sn+=")";
    System.out.println("Case #" + i + ": " + sn);
    }
  }
}