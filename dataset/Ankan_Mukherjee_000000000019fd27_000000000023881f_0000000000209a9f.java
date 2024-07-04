import java.util.*;
public class Nest
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int t=Integer.parseInt(obj.nextLine());
        for(int f=1;f<=t;f++)
        {
            String s=obj.nextLine();
            int n=s.length();
            int l=0;
            System.out.print("Case #"+f+": ");
            for(int i=0;i<n;i++)
            {
                int d=Integer.parseInt(s.substring(i,i+1));
                if(l<d)
                {
                    open(d-l);
                    l=d;
                    System.out.print(d);
                }
                else if(l>d)
                {
                    close(l-d);
                    l=d;
                    System.out.print(d);
                }
                else
                {
                    System.out.print(d);
                }
            }
            close(l);
            System.out.println();
        }
    }
    
    private static void open(int n)
    {
        for(int i=1;i<=n;i++)
        {
            System.out.print("(");
        }
    }
    
    private static void close(int n)
    {
        for(int i=1;i<=n;i++)
        {
            System.out.print(")");
        }
    }
}