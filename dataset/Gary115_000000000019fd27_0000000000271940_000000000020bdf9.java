import java.lang.*;
import java.util.*;

class Pair { 
    int x; 
    int y;
    int ind;
  
    // Constructor 
public Pair(int x, int y, int ind) 
    { 
        this.x = x; 
        this.y = y; 
        this.ind=ind;
    } 
}
class Compare { 
	  
    static void compare(Pair arr[], int n) 
    { 
        // Comparator to sort the pair according to second element 
        Arrays.sort(arr, new Comparator<Pair>() { 
            @Override public int compare(Pair p1, Pair p2) 
            { 
                return p1.x - p2.x; 
            } 
        }); 
  
        /*for (int i = 0; i < n; i++) { 
            System.out.print(arr[i].x + " " + arr[i].y + " "); 
        } 
        System.out.println(); */
    } 
} 
public class Solution {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			Pair arr[] = new Pair[n];
			for(int j=0;j<n;j++)
			{
			arr[j]=new Pair(s.nextInt(),s.nextInt(),j);	
			}
			Compare obj = new Compare(); 
			  
	        obj.compare(arr, n); 
	       
	        
	        int k=0;
	        String str="";
          for(int e=0;e<n;e++)
	        	
	        {
	        	 str+='Z';
	        }
          str=str.substring(0,0) + 'C' + str.substring(1);
          for( int j=1;j<n;j++)
	        {
	        	if(arr[j].x>=arr[k].y)
	        	{
	        		
	        		
	        		str=str.substring(0,j) + 'C' + str.substring(j+1);
	        		k=j;
	        	}
	        }
         // System.out.println(str);
           int q=-1;
          for( int j=0;j<n;j++)
	        {
        	  if(str.charAt(j)=='Z')
        	  {
	        	 if(q==-1)
	        	 {
	        		 str=str.substring(0,j) + 'J' + str.substring(j+1);
	        		 q=j;
	        	 }
	        	 else if(arr[j].x>=arr[q].y)
	        	{
	        		
        			  str=str.substring(0,j) + 'J' + str.substring(j+1);
	        		
	        		q=j;
	        	}
        		  else
        		  {
        			  str="IMPOSSIBLE";
        			  break;
        		  }
        	  }
	        }
          if(str!="IMPOSSIBLE")
          {
          char[] ch=str.toCharArray();
          char[] res=new char[str.length()];
	        for(int j=0;j<n;j++)
	        {
	        	res[arr[j].ind]=ch[j];
	        }
          String ans="";
          for(int j=0;j<n;j++)
          {
        	  ans+=res[j];
          }
          System.out.println("Case #"+(i+1)+": "+ans);
          }
          else
          {
        	  System.out.println("Case #"+(i+1)+": "+str);  
          }
	        
	        
	}
	}
	}