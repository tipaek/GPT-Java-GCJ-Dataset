import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<=t;i++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(n%2!=0 &&k%2==0 || n%2==0 && k%2==0 )
            System.out.println("Case "+"#"+t+": "+"POSSIBLE");
            else 
            System.out.println("Case "+"#"+t+": "+"IMPOSSIBLE");
        }
    }
}