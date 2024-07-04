import java.util.*;
class MyClass {
    public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int out=1;
		while(t>0)
		{
			int n=s.nextInt();
			int tr=0,r=0,c=0;
			int d=0,d1=0;
			int arr[][]=new int[n][n];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=s.nextInt();
					if(i==d && d1==j)
					{
						tr=tr+arr[i][j];
					}
				}
				d++;
				d1++;
			}
			int count=0,max=0;
			for(int i=0;i<n;i++)
			{
				count=0;
				for(int j=0;j<n;j++)
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
       //System.out.println("entering values  : "+val+" "+k);
       //for(;j<len;j++)
       while(j<len)
       {
           if(val==arr[i][j])
           {
               //System.out.println("Comparing values : "+arr[i][j]+" "+val);
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
           //j++;
       }
       if(count > 0)
       {
           count=count+1;
       }
       return count;
   }
}