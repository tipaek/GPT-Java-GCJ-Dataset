import java.io.*;
import java.util.*;

class Solution 
{ 

 static int flag=0;
static class Interval 
{ 
	int start; 
	int end; 
	public Interval(int start, int end) 
	{ 
		super(); 
		this.start = start; 
		this.end = end; 
	} 
}; 


static void isOverlap(Interval arr[], int n) 
{
    
    
    flag++;

	int max_ele = 0; 

	
	for (int i = 0; i < n; i++) 
	{ 
		if (max_ele < arr[i].end) 
			max_ele = arr[i].end; 
	} 

	
	int []aux = new int[max_ele + 1]; 
	for (int i = 0; i < n; i++) 
	{ 
	int x = arr[i].start; 

		int y = arr[i].end; 
		aux[x]++; 
		aux[y ]--; 
	} 
	

	int count=0;
	for (int i = 1; i <= max_ele; i++) 
	{ 
		
		aux[i] += aux[i - 1]; 
		if (aux[i] >= 3) 
			count++; 
	} 

	
     char[] ch=new char[n];
    if (count>=1)
    {
     System.out.println("Case #"+flag+": "+"IMPOSSIBLE");   
    }
    else
    {
        int[] ccc=new int[max_ele+1];
        int[] jjj=new int[max_ele+1];
        int cc=-1,jj=-1;
       for (int i = 0; i < n; i++) 
	{ 

		
		
		int x = arr[i].start;
		int y = arr[i].end; 
		if(i==0)
		{
		    ch[i]='c';
		    for(int j=x;j<y;j++)
		    {
		        ccc[j]=1;
		    }
		    cc=i;
		    continue;
		}
        else
        {
            
           if(aux[x]==1 && aux[y]==1)
           {
               
            //System.out.println(" ram ji ");
               ch[i]='c';
               for(int j=x;j<=y;j++)
		    {
		        ccc[j]=1;
		    }
		    
		    cc=i;
           }
           else
           {
           if (ccc[x]!=1 && ccc[y]!=1)
           {
               
               ch[i]='c';
		    for(int j=x;j<=y;j++)
		    {
		        ccc[j]=1;
		    }
		    
		    cc=i;
               
           }
           else
           {
                ch[i]='j';
		        jj=i;
               
           }
           }
          
            
        }
                
                
            }
        
	      System.out.println("Case #"+flag+": "+String.valueOf(ch));
        }

} 

 
public static void main(String[] args) 
{ 
    
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int n=0;
	while(t!=0){
	n=sc.nextInt();
	Interval arr1[] = new Interval[n];

	for(int i=0;i<n;i++){
	    int a=sc.nextInt();
	    int b=sc.nextInt();
	arr1[i]=new Interval(a,b);
	}
     isOverlap(arr1,n);
	    t--;
	}
	
	 
} 
} 


