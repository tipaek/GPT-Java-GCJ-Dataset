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
	        /*
	         i = 0; 
    printf("%d ", i); 
  
    // Consider rest of the activities 
    for (j = 1; j < n; j++) 
    { 
      // If this activity has start time greater than or 
      // equal to the finish time of previously selected 
      // activity, then select it 
      if (s[j] >= f[i]) 
      { 
          printf ("%d ", j); 
          i = j; 
      } 
    } 
	         */
	        
	       int k=0;
	      int l=-1;
	      String str="";
	        for(int e=0;e<n;e++)
	        	
	        {
	        	 str+='C';
	        }
	        for( int j=1;j<n;j++)
	        {
	        	if(arr[j].x>=arr[k].y)
	        	{
	        		
	        		
	        		str=str.substring(0,arr[j].ind) + 'C' + str.substring(arr[j].ind+1);
	        		k=j;
	        	}
	        	else if(l>=0 && arr[j].x>=arr[l].y)
	        	{
	        		str=str.substring(0,arr[j].ind) + 'J' + str.substring(arr[j].ind+1);
	        		  l=j;
	        	}
	        	
	        	else if(l==-1)
	        	{
	        		str=str.substring(0,arr[j].ind) + 'J' + str.substring(arr[j].ind+1);
	        		  l=j;
	        	}
	        	else
	        	{
	        		str="IMPOSSIBLE";
	        	}
	        }
	        System.out.println("Case #"+(i+1)+": "+str);
		}
	}
	}