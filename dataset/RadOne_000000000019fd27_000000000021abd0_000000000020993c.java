import java.util.*;
public class proba
{
public static int rchec(int a[][],int pr)
{
    int count=0;
    for(int i=0;i<a.length;i++)
    {
        int rep=a[i][0];
        for(int j=1;j<a.length;j++)
        {
            rep=rep^a[i][j];
        }
        if(rep!=pr)
        count=count+1;
        System.out.println();
    }
    return count;
}
public static int lchec(int a[][],int pr)
{
    int count=0;
    for(int j=0;j<a.length;j++)
    {
        int rep=a[0][j];
        for(int i=1;i<a.length;i++)
        {
            rep=rep^a[i][j];
        }
        if(rep!=pr)
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
    int pr=min;
    for(int k=min+1;k<max+1;k++)
    {
        pr=pr^k;
    }
    int le=lchec(a,pr);
    int re=rchec(a,pr);
    System.out.println("Case #"+(i+1)+": "+tr+" "+re+" "+le);
 }
}
}