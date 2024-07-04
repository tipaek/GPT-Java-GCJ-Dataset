import java.util.*;
import java.io.*;
public class solution{
     public static void main(String []args)
     { 
    Scanner kb =new Scanner(System.in);
	int t=kb.nextInt();
	int c=0;
	while(t-->0)
	{int n=kb.nextInt();
	int a[][] =new int[n][n];
	long sum=0;
	int cr=0,cc=0;
	for(int i=0;i<n;i++)
   for(int j=0;j<n;j++)
	{a[i][j]=kb.nextInt();
	   if(i==j)
	   sum+=a[i][j];
	}
	HashSet<Integer> hr=new HashSet<Integer>();
       HashSet<Integer> hc=new HashSet<Integer>();
for(int i=0;i<n;i++)
{    
    for(int j=0;j<n;j++)
{    
    hr.add(a[i][j]);
    hc.add(a[j][i]);
}
if(hr.size()!=n)
cr++;
if(hc.size()!=n)
cc++; 
    hr.clear();
    hc.clear();
}

c++;
System.out.println("Case #"+c+":"+" "+sum+" "+cr+" "+cc);
     }
 }
 }