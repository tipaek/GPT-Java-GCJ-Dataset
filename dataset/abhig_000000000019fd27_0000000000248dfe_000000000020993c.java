import java.io.*; 
import java.util.*;

 class Vestiguim {
	public static void main (String[] args) {
	    Scanner kb=new Scanner(System.in);
	    int t1=kb.nextInt();
	    int t=0;
	   while(t++<t1)
	      {
	        int n=kb.nextInt();
	        int sum=0,row=0,col=0;
	        int [][]arr=new int[n][n];
	      
	        for(int i=0;i<n;i++)
	          {  
	            ArrayList<Integer> list=new ArrayList<>(n);
	             int l=0;
	            for(int j=0;j<n;j++)
	               {
	                int a=kb.nextInt();
	                 arr[i][j]=a;
	                if(list.contains(a))
	                  {
	                      if(l==0)
	                       {
	                        row++;
	                         l=1;
	                       }
	                  }
	               list.add(a);
	              }
	              l=1;
	              sum=sum+arr[i][i];
	        }
	        
	        for(int i=0;i<n;i++)
	          {  
	            ArrayList<Integer> list=new ArrayList<>(n);
	             int l=0;
	            for(int j=0;j<n;j++)
	               {
	                   int a=arr[j][i];
	                if(list.contains(a))
	                  {
	                      if(l==0)
	                       {
	                         col++;
	                         l=1;
	                       }
	                  }
	               list.add(a);
	              }
	              l=1;
	        }
	        System.out.println("Case #"+t+": "+sum+" "+row+" "+col);
	        
	      }
	}
}