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
            System.out.println("Case #"+y+":");
            for(int x=1;x<=500;x++)
            {
                if(x>n)
                {break;}
                else if(x==3&&n==501)
                {System.out.println(x+" "+2);}
                else
                {System.out.println(x+" "+1);}
            }
        }
    }
}