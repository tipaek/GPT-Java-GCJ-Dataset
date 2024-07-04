import java.util.*;
import java.io.*;
public class Solution 
{
    public static void main(String[] args) 
    {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	int t = in.nextInt();
    	for (int i = 1; i <= t; ++i) 
	{
        
        	String s, sNew = "";
        	int i, j, iOpenBrac, iCloseBrac;
       
        	s = in.nextLine();
        
        	int iNum[] = new int[s.length()+2];
        
        	iNum[0] = 0;
        	iNum[s.length()+1] = 0;
        
        	for(i=1; i<=s.length(); i++)
        	{
            	iNum[i] = Integer.parseInt(String.valueOf(s.charAt(i-1)));
        	}
        
        	for(i=0; i<s.length()+1; i++)
        	{
            	if(iNum[i] < iNum[i+1])
            	{
                	iOpenBrac = iNum[i+1] - iNum[i];
                	for(j=0; j<iOpenBrac; j++)
                	{
                    		sNew = sNew + "(";
                	}
            	}
            	else if(iNum[i] > iNum[i+1])
            	{
                	iCloseBrac = iNum[i] - iNum[i+1];
                	for(j=0; j<iCloseBrac; j++)
                	{
                    		sNew = sNew + ")";
                	}
            	}
            	sNew = sNew + iNum[i+1];
        }
        
        sNew = sNew.substring(0, sNew.length()-1);
        System.out.println(sNew);
	}
    }
}