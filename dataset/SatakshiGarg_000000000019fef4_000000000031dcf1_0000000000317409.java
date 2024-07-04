import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)throws IOException {
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(read);
		int t=Integer.parseInt(in.readLine());
		for(int z=1;z<=t;z++)
		{
		    String line[]=in.readLine().trim().split(" ");
		    int x=Integer.parseInt(line[0]);
		    int y=Integer.parseInt(line[1]);
		    String s=line[2];
		    int l=s.length();
		    int a[][]=new int[l+1][l+1];
		    a[0][0]=x;
		    a[0][1]=y;
		    int i,j;
		    for(i=0;i<l;i++)
		    {
		        char ch=s.charAt(i);
		        if(ch=='S')
		        y--;
		        if(ch=='N')
		        y++;
		        if(ch=='E')
		        x++;
		        if(ch=='W')
		        x--;
		        a[i+1][0]=x;
		        a[i+1][1]=y;
		     }
		     int mini=10000;
		     for(i=0;i<=l;i++)
		     {
		         int sum=Math.abs(a[i][0])+Math.abs(a[i][1]);
		         if(sum<=i)
		         {
		         if(i<mini)
		         mini=i;
		         }
		     }
		     if(mini!=10000)
		     {
		         if(mini!=0)
		         System.out.println("Case #"+z+": "+mini);
		         else
		         System.out.println("Case #"+z+": "+"1");
		     }
		     else
		     System.out.println("Case #"+z+": "+"IMPOSSIBLE");
		     
		}
	}
}
