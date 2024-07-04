import java.util.*;
public class Solution
{
public static int rchec(int a[][])
{
    int count=0;
    for(int i=0;i<a.length;i++)
    {
        boolean flag=false;
        HashSet<Integer>set=new HashSet();
        for(int j=0;j<a.length;j++)
        {
            if(set.contains(a[i][j]))
            {flag=true;break;}
            else
                set.add(a[i][j]);
        }
        if(flag)
        count=count+1;
    }
    return count;
}
public static int lchec(int a[][])
{
    int count=0;
    for(int j=0;j<a.length;j++)
    {
        HashSet<Integer>set=new HashSet();
        boolean flag=false;
        for(int i=0;i<a.length;i++)
        {
            if(set.contains(a[i][j]))
            {flag=true;break;}
            else
                set.add(a[i][j]);
        }
        if(flag)
        count=count+1;
    }
    return count;
}
public static int trace(int a[][])
{
    int sum=0;
    for(int i=0;i<a.length;i++)
    {
        sum=sum+a[i][i];
    }
    return sum;
}
public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 for(int i=0;i<t;i++)
 {
    int n=sc.nextInt();
    int a[][]=new int[n][n];
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    for(int j=0;j<n;j++)
    {
        for(int k=0;k<n;k++)
        {
            a[j][k]=sc.nextInt();
            if(a[j][k]>max)
                max=a[j][k];
            if(a[j][k]<min)
                min=a[j][k];
        }
    }
    int tr=trace(a);
    int le=lchec(a);
    int re=rchec(a);
    System.out.println("Case #"+(i+1)+": "+tr+" "+re+" "+le);
 }
}
}