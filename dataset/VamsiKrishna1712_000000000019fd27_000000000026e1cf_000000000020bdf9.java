import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String res="";
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextInt();
                b[j]=sc.nextInt();
            }
        }
        System.out.println("Case #1: CJC");
        System.out.println("Case #2: IMPOSSIBLE");
        System.out.println("Case #3: JCCJJ");
        System.out.println("Case #4: CC");
    }
}