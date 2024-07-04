import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        // Scanner sc=new Scanner(new File("inp.txt"));
        
        int p,t,i,n,x,xs,present;

        p=t=sc.nextInt();

        while(t-->0)
        {
            n=sc.nextInt();
            if(n<=500)
            {
                System.out.println("Case #"+(p-t)+":");
                for(i=1;i<=n;i++)
                    System.out.println(i+" 1");
            }
            else
            {
                System.out.println("Case #"+(p-t)+":");
                System.out.println("1 1\n2 1");
                x=1;
                xs=1;
                present=2;
                present+=xs;
                while((present+x)<n)
                {
                    // System.out.print(present+": ");
                    System.out.println((x+2)+" "+x);

                    x++;
                    xs+=x;
                    present+=xs;
                }
                present-=xs;
                x--;
                present+=x;
                while(present<n)
                {
                    // System.out.print(present+": ");
                    System.out.println((x+1)+" "+x);

                    x++;
                    present+=x;
                }
                present-=x;
                x--;
                present++;

                while(present<n)
                {
                    // System.out.print(present+": ");
                    System.out.println(x+" "+x);

                    x++;
                    present++;
                }
                // System.out.print(present+": ");
                System.out.println(x+" "+x);
            }
        }
    }
}