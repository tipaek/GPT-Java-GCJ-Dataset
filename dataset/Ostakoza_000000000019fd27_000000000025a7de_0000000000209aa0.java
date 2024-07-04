
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Solution {
	
	
	
	

	    public static String getmatrix(int num,int matsize)
	    {
	    	Vector<Integer> ar= new Vector<Integer>();
	    	String mini ="";
	    	ar.add(num);
	    	for(int i=1;i<=matsize;i++)
	    	{
	    		if(i!=num)
	    		{
	    			ar.add(i);
	    		}
	    	}
	    	
	    	mini=mini+getinside(ar)+"\n";
	    	int looper = ar.get(ar.size()-1);
	    	ar.remove(ar.size()-1);
	    	ar.add(0, looper);
	    	for(int i=0;i<matsize-1;i++)
	    	{
	    		mini = mini + getinside(ar)+"\n";
	    		looper = ar.get(ar.size()-1);
		    	ar.remove(ar.size()-1);
		    	ar.add(0, looper);
	    	}
	    	
	    	return mini;
	    	
	    	
	    }
	    public static  String getinside (Vector<Integer> ar)
	    {
	    	String returner="";
	    	for(int i =0; i<ar.size();i++)
	    	{
	    		returner= returner+ ar.get(i)+" ";
	    	}
	    	return returner;
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
	    	int Matrixsize =Integer.parseInt(Line.split(" ")[0]);
	    	int possiblesum = Integer.parseInt(Line.split(" ")[1]);
	    	if(possiblesum%Matrixsize>0)
	    	{
	    		answer=answer+"IMPOSSIBLE"+"\n";
	    		continue;
	    	}
	    	else 
	    	{
	    		answer=answer+"POSSIBLE"+"\n";
	    		int numberdiag = possiblesum/Matrixsize;
	    		String mini=getmatrix(numberdiag,Matrixsize);
	    		answer= answer+mini;
	    	}
	    
	    }
 	   System.out.println(answer);
	}
}
