/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i<t;i++)
		{
		    int x = in.nextInt();
		    int y = in.nextInt();
		    String s  = in.next();
		    
		    int l = s.length();
		    
		    int ux = x;
		    int uy = y;
		    int j;
		    int time = 0;
		    for( j=0;j<l;j++)
		    {
		        char c = s.charAt(j);
		        int dist = 0;
		        switch(c){
		            
		            case 'N':
		                uy++;
		            break;
		            
		            case 'S':
		                uy--;
		            break;
		            
		            case 'E':
		                ux++;
		            break;
		            
		            case 'W':
		                ux--;
		            break;
		                      
		        }
		        dist = Math.abs(ux) + Math.abs(uy);
		        
		        //System.out.println(dist+ " "+j);
		        if(dist <= j+1)
		        {
		            time = j+1;
		            break;
		        }
		        
		        
		    }
		    if(j>=l){
		        System.out.println("Case #" +i+": "+ "IMPOSSIBLE");
		    }
		    else{
		        System.out.println("Case #" + i + ": "+ time);
		    }
		    
		    
		}
	}
}
