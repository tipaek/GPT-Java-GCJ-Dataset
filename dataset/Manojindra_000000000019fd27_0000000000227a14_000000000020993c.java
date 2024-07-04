import java.util.*;
import java.lang.*;
import java.io.*;
class MyClass {
    public static void main(String args[]) {
	//	Scanner s=new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int t=Integer.parseInt(br.readLine());
		//s.nextInt();
		int out=1;
		while(t>0)
		{
			int n=Integer.parseInt(br.readLine());
			//s.nextInt();
			int tr=0,r=0,c=0;
			int d=0,d1=0;
			int arr[][]=new int[n][n];
			int i=0,j=0;
			for(i=0;i<n;i++)
			{
			    String line = br.readLine(); 
                String[] strs = line.trim().split("\\s+");
				for(j=0;j<n;j++)
				//while(j<n)
				{
					arr[i][j]=Integer.parseInt(strs[j]);
					if(i==d && d1==j)
					{
						tr=tr+arr[i][j];
					}
					//j++;
				}
				//j=0;
				//i++;
				d++;
				d1++;
			}
			i=0;
			j=0;
			int count=0,max=0;
			for(i=0;i<n;i++)
			{
				count=0;
				for(j=0;j<n;j++)
				{
					count=comrow(arr[i][j],arr,i,j+1,n);
					if(count>r)
					{
					    r=count;
					}
					count=comcol(arr[i][j],arr,i+1,j,n);
					if(count>c)
					{
					    c=count;
					}
				}
			}
			System.out.println("Case #"+out+": "+tr+" "+r+" "+c);
			out++;
			t--;
		}
   }
   public static int comrow(int val,int arr[][],int i,int j,int len)
   {
       int count=0;
       while(j<len)
       {
           if(val==arr[i][j])
           {
               count++;
           }
           j++;
       }
       if(count > 0)
       {
           count=count+1;
       }
       return count;
   }
   public static int comcol(int val,int arr[][],int i,int j,int len)
   {
       int count=0;
       while(i<len)
       {
           if(arr[i][j]==val)
           {
               count++;
           }
           i++;
       }
       if(count > 0)
       {
           count=count+1;
       }
       return count;
   }
}