import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		String s1;
		for(int i=0;i<T;i++)
		{
		    int X=sc.nextInt();
		    int Y=sc.nextInt();
		    
		    s1="";
		   s1=sc.nextLine().trim();
		  // System.out.println(X+" "+Y+" "+s1);
		  int dX=X;
		  int dY=Y;
		  int flag=0;
		  int dTotal=dX+dY;
		  if(dTotal==0){
		      flag=1;
		  System.out.println("Case #" + (i+1) + ": " + dTotal);
		  }
		  else{
		       int l=s1.length();
		      for(int j=0;j<l;j++){
		      char ch=s1.charAt(j);
		      switch(ch){
		          case 'N':dY=dY+1;
		          break;
		          case 'S':dY=dY-1;
		          break;
		          case 'W':dX=dX-1;
		          break;
		          case 'E':dX=dX+1;
		          break;
		          
		      }
		      dTotal=Math.abs(dX)+Math.abs(dY);
		      if(dTotal<=(j+1)){
		          System.out.println("Case #" + (i+1) + ": " + (j+1));
		          flag=1;
		          break;
		      }
		      }
		  }
		    if(flag==0)
		      System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");


		}
	}
}
