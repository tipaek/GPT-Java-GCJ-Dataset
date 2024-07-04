import java.util.*;
class Solution
{
    static int[] genarray(int a)
    {
        int gen[]=new int[a];
        for(int i=1;i<=a;i++)
        {
            gen[i-1]=i*a;
        }
        return gen;
    }
    static int check (int a[],int k)
    {
        int c=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==k)
            {
                c=1;
                break;
            }
        }
        return c;
    }
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=0;t<test;t++)
        {
            int n= sc.nextInt();
            int k= sc.nextInt();
            int arr[]= genarray(n);
            int c= check(arr,k);
            if(c==1)
            {
                System.out.println("Case #"+t+": POSSIBLE");
            }
            else
            {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}