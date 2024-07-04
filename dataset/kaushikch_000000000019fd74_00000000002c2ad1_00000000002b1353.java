import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        while(t-->0)
        {
        c++;
            int n=sc.nextInt();
            int count=1;
            System.out.println("Case #"+c+": ");
           for(int i=1;i<=n;i++)
           {
             System.out.println(count+" "+count);
             count++;
           }
        }
    }
}