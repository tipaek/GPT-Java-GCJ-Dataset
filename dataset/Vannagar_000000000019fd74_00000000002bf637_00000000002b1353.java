import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=1;y<=t;y++)
        {
            int n=sc.nextInt();
            boolean d=false;
            System.out.println("Case #"+y+":");
            for(int x=1;x<=100;x++)
            {
                if(x>n)
                {d=true;break;}
                else
                {System.out.println(x+" "+1);}
            }
            if(d)
            {continue;}
            int loc=101;int sum=100;
            for(int x=101;true;x++)
            {
                if(sum+x>n)
                {break;}
                else
                {sum+=loc;loc++;System.out.println(x+" "+2);}
            }
            for(int x=loc;sum<=n;x++)
            {
                if(sum>n)
                {d=true;break;}
                else
                {System.out.println(x+" "+1);sum++;}
            }
        }
    }
}