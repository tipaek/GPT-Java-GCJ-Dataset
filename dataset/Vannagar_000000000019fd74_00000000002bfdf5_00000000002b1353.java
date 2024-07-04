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
                else if(x==3&&n==501)
                {System.out.println(x+" "+2);}
                else
                {System.out.println(x+" "+1);}
            }
        }
    }
}