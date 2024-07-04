import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

class vestige 
{
 
    public static void main(String args[]) 
    { 
    	Scanner in=new Scanner(System.in);
    	int k=in.nextInt();
    	for(int l=0;l<k;l++)
    	{
    		int g=in.nextInt();
    		Integer arr[][]=new Integer[g][g];
    		Integer arrr[][]=new Integer[g][g];
    		int rcount=0;
    		int ccount=0;
    		int trace=0;
    		for(int h=0;h<g;h++)
    		{
    			for(int f=0;f<g;f++)
    			{
    				int j=in.nextInt();
    				if(h==f)
    					trace+=j;
    				arr[h][f]=j;
    				arrr[f][h]=j;
    			}
    			
        		Set<Integer> rset = new HashSet<Integer>(Arrays.asList(arr[h]));
    		    Object ar1[]=rset.toArray();
    		    if(ar1.length<arr[0].length) 
    		    {
    		    	rcount++;
    		    } 
    		  
    		}
    		for(int h=0;h<g;h++)
    		{
    			Set<Integer> cset = new HashSet<Integer>(Arrays.asList(arrr[h]));
    		    Object ar2[]=cset.toArray();
    		    if(ar2.length<arr[0].length) 
    		    {
    		    	ccount++;
    		    }
    		}
    		System.out.println("Case #"+(l+1)+ ":"+trace+" "+rcount+" "+ccount);
    	
    	}
   
    } 
} 