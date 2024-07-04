import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution {
	
	
	
	
	
	
	public static String getconsc(String line)
	{	String minianswer="";
		String[] cutter = line.split("");
		String hacker="";

		for(int i=0;i<cutter.length;i++)
		{
			boolean yes=true;

			if(cutter.length==1)
			{
				if(cutter[i].equals("0"))
				{
					yes=false;
					
				}
				hacker=hacker+cutter[i];
				for(int k=0;k<Integer.parseInt(cutter[i]);k++)
				{
					hacker = "("+hacker+")";
				}
				minianswer=minianswer+hacker;
				break;
			}
			
			
			if(i==cutter.length-1 && cutter.length!=1)
			{
				
					if(cutter[i].equals("0"))
					{
						yes=false;
						
					}
					hacker=hacker+cutter[i];
					for(int k=0;k<Integer.parseInt(cutter[i]);k++)
					{
						hacker = "("+hacker+")";
					}
					minianswer=minianswer+hacker;
				break;

			}
			
			
			if(cutter[i].equals(cutter[i+1]))
			{
				
				
				
				if(cutter[i].equals("0"))
				{
					yes=false;
				}
				hacker=hacker+cutter[i];
				continue;
				
			}
			
			
			else 
			{	
				hacker=hacker+cutter[i];
				
				for(int k=0;k<Integer.parseInt(cutter[i]);k++)
				{
					hacker = "("+hacker+")";
				}
				minianswer=minianswer+hacker;
				 hacker="";

				
			}
			
		}
		return minianswer;
	}
	
	
	public static void main(String args[])
	{
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
 	    int numberoftestcases = Integer.parseInt(in.nextLine());
 	    String answer ="";
 	    for(int i=1;i<=numberoftestcases;i++)
 	    {
 	    	answer = answer+ "Case #"+i+": ";
 	    	String Line= in.nextLine();
 	    	String mini=getconsc(Line);
 	    	answer= answer+mini+"\n";
 	    	
 	    }
 	    
 	    System.out.println(answer);
	}
	    
	    
	    
	
}
