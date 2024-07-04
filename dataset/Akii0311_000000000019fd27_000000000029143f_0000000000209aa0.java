
import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int a=1; a<=t; a++)
        {
            int c=1;
            int n= sc.nextInt();
            int trace= sc.nextInt();
//            int a[][] = new int[n][n];
            int sum;
            boolean flag=false;
            for(int i=1; i<=n; i++)
            {
                sum=i*n;
                if(sum==trace)
                {
                    System.out.println("Case #"+c +": POSSIBLE");
                    flag=true;
                    int start=i;
                    if(i==1)
                    {
                    start=n+1;
                    }
                    System.out.println();
                    latinsquare(n,start);
                }
            }
            if(flag==false)
            {
                System.out.println("Case #"+c +": IMPOSSIBLE");
            }
            c++;
           
        }//while loop
       
    } //closing for main
    public static void latinsquare(int n,int k)
    {
        for(int i=1; i<=n; i++)
{
int temp= k;
while(temp<=n)
{
System.out.print(temp +" ");
temp++;
}
for(int j=1; j<k; j++)
{
System.out.print(j+" ");
}
k--;
if(k==0)
{
k=n;
}
System.out.println();
}
    }
   
}