import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc=new Scanner(System.in);
		  int nt= sc.nextInt();
		  int n=0;
		  String result="";
		  for(int t=0; t< nt;t++)
		  {
		     n=sc.nextInt()	; int k=0;
		     int first[][] = new int[n][n]; 
		     for (int i = 0; i < n; i++) 
	                for (int j = 0; j < n; j++) 
	                {  first[i][j] = sc.nextInt();
	                   if(i==j) 
	                	   k += first[i][j];
	                } 

		     result = result.concat(helper(first,t+1, k)); 
		  }
	System.out.print(result);
		  
	}

	
	private static String helper(int[][] first,int t, int k) {
		// TODO Auto-generated method stub
	    int r=0, c=0;
	    int n=first.length;
	    HashSet<Integer> seenx=new HashSet<Integer>();
	    HashSet<Integer> seeny=new HashSet<Integer>();
	    //row check
	    for (int i = 0; i < n; i++) 
	    {    for (int j = 0; j < n; j++)
            {
            	seenx.add(first[i][j]);
            	seeny.add(first[j][i]);
            }
	      
	    if(seenx.size()!=n)
	    	r++;
	    
	    if(seeny.size()!=n)
	    	c++;
	    
	    seenx.clear(); seeny.clear();
	    }
	    
	 return("Case #"+t+": "+k+" "+" "+r+" "+c + "\n");
	}

}
