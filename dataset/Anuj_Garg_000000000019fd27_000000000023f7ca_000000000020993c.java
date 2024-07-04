import java.io.*;
import java.util.*;
class aa
{
	static int unique(int a[])
	{
      int l=a.length;boolean flag=false;
      for(int i=0;i<l;i++)
      {
       for(int j=i+1;j<l;j++)
       if(a[i]==a[j])flag=true;
       if(flag)break;
	  }
	  if(flag)return 1;
	  else return 0;
	}
	public static void main(String args[])throws Exception
	{
		BufferedReader d=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(d.readLine());
		if(t<0&&t>=101)System.exit(0);
		else
		{
			int u=1;
			while(t>0)
			{
		int n=Integer.parseInt(d.readLine());
		if(n<=1&&n>=101)System.exit(0);
		else
		{
		int a[][]=new int[n][n];int sum=0,r=0,c=0;
		for(int i=0;i<n;i++)
		{
           String s=d.readLine();
           String b[]=s.split(" ");
           for(int j=0;j<n;j++)
           {
           a[i][j]=Integer.parseInt(b[j]);
           if(i==j)sum+=a[i][i];
           }
           r+=unique(a[i]);
         }
         int h[]=new int[n];
         for(int i=0;i<n;i++)
         {
         	for(int j=0;j<n;j++)
         	h[j]=a[j][i];
         	c+=unique(h);
         }  
         System.out.println("case#"+u+": "+sum+" "+r+" "+c);
        }
	    t--;u++;
	}
	}

	}
}
