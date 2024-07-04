import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Solution {
    public static class task{
        int start;
        int end;
    }
    
	public static void main(String[] args) throws IOException {
		Scanner s1 = new Scanner(System.in);
		int T = Integer.parseInt(s1.nextLine());
	    for(int i = 1; i <= T; i++)
	    {
	        int n = Integer.parseInt(s1.nextLine());
	        task[] tasks = new task[n];

	        for(int j = 0; j < n; j++)
	        {
	            String[] s = s1.nextLine().split(" ");
	            task k = new task();
	            k.start = Integer.parseInt(s[0]);
	            k.end = Integer.parseInt(s[1]);
	            tasks[j] = k;
	        }
	        boolean[] filledc = new boolean[24*60 + 1];
	        boolean[] filledj = new boolean[24*60 + 1];
	        boolean flag = true;
	        for(int j = 0; j < Math.pow(2,n); j++) 
	        {
	            flag = true;   
    	        for(int a = 0; a < 24*60+1; a++) 
    	        {
    	            filledc[a]=false;
    	            filledj[a]=false;
    	        }
    	        int b = j;
	            for(int l = 0; l < n; l++)
	            {
	                if(b%2 == 0)
    	            {
    	                for(int k = tasks[l].start; k < tasks[l].end; k++)
        	                {
        	                    if(filledc[k] == true)
        	                        flag = false;
        	                    filledc[k] = true; 
        	                }
    	            }
    	            else
    	            {
    	                for(int k = tasks[l].start; k < tasks[l].end; k++)
        	                {
        	                    if(filledj[k] == true)
                                    flag = false;
                                    filledj[k] = true; 
        	                }
    	            }
    	            
    	            b = b/2;
	            }
	            if(flag)
	            {    
	                String s = "";
	                b = j;
    	            for(int l = 0; l < n; l++)
    	            {
    	                if(b%2 == 0)
        	            {
        	                s += "J";
        	            }
        	            else
        	                s += "C";
        	            b = b/2;
    	            }
	                System.out.println("Case #" + i + ": " + s);
	                break;
	            }
                
	        }
	        if(!flag)
	            System.out.println("Case #" + i + ": IMPOSSIBLE");

	    }
	}

}
