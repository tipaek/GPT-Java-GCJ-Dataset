import java.util.*;
public class Solution
{
    public static void main(String ARGS[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=in.nextInt();
            int c=0;
            System.out.println("Case #"+z+":");
            while(n!=0)
            {
                if(n>Math.pow(2,c))
                {
                    for(int i=1;i<=c+1;i++)
                    {
                        if(c%2==1)
                        System.out.println((c+1)+" "+i);
                        else
                        System.out.println((c+1)+" "+(c+2-i));
                    }
                    n=n-(int)Math.pow(2,c);
                    c++;
                }
                else
                {
                    int d=c;
                    for(int a=1;a<=n;a++)
                    {
                        if(d%2==1)
                        System.out.println((c+1)+" "+1);
                        else
                        System.out.println((c+1)+" "+(c+1));
                        c++;
                    }
                    n=0;
                }
            }
        }
    }
}