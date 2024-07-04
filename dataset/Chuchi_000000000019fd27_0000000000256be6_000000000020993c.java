import java.util.*;
class Main{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
int sum=0;
int count1=0;
int count2=0;
for(int l=1;l<=t;l++)
{
    count1=0;
    count2=0;
    sum=0;
int n=sc.nextInt();
int a[][]=new int[n][n];
for(int i=0;i<n;i++)
{
    for(int j=0;j<n;j++)
    {
    a[i][j]=sc.nextInt();
    }
}
for(int i=0;i<n;i++)
{
    for(int j=0;j<n;j++)
    {
        if(i==j)
        {
         sum+=a[i][j];   
        }
    
    }
}
for(int i=0;i<a.length;i++)
{
    HashSet<Integer> hs=new HashSet<Integer>();
    for(int j=0;j<a[0].length;j++)
    {
        hs.add(a[i][j]);
    }
    if(hs.size()!=a.length)
    {
        count1++;
    }
}
for(int j=0;j<a[0].length;j++)
{
    HashSet<Integer> hs1=new HashSet<Integer>();
    for(int i=0;i<a.length;i++)
    {
        hs1.add(a[i][j]);
    }
    if(hs1.size()!=a[0].length)
    {
        count2++;
    }
}
System.out.println("case #"+l+": "+sum+" "+count1+" "+count2);
    }
    System.exit(0); 
    }
}
