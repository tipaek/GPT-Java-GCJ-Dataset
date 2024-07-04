import java.util.*;

class Solution {
    static String findValue(int n,int a[][])
    {
        if(n==1) return "C";
        if(n==2) return "CJ";
        String temp="CJ";
        for(int i=2;i<n;i++)
        {
            if(a[i][0]>=a[i-2][1])
              temp+="C";
            else if(a[i][0]>a[i-1][1])
             temp+="J";
             else
             return "IMPOSSIBLE";
        }
        return temp;
         
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int l=1;
		while(l<=t)
		{
		    int n=sc.nextInt();
		    int a[][]=new int[n][2];
		    for(int i=0;i<n;i++)
		    {
		        a[i][0]=sc.nextInt();
		        a[i][1]=sc.nextInt();
		    }
		    for(int i=0;i<n;i++)
		    {
		        for(int j=i+1;j<n;j++)
		        {
		            if(a[i][0]>a[j][0])
		            {
		                int temp=a[i][0];
		                a[i][0]=a[j][0];
		                a[j][0]=temp;
		                
		                temp=a[i][1];
		                a[i][1]=a[j][1];
		                a[j][1]=temp;
		            }
		        }
		    }
		    String s=findValue(n,a);
		    
		    System.out.println("Case #"+l+": "+s);
		    l++;
		}
	}
}