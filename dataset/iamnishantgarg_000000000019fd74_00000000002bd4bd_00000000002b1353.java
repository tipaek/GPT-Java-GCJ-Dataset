import java.util.*;
class Solution{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++)
        {
            int n=in.nextInt();
            System.out.println("Case #"+l+":");
            if(n<=500)
            {
                for(int i=1;i<=n;i++)
                {
                    System.out.println(i+" 1");
                }
            }
            else
            {
                System.out.println("1 1\n2 1\n3 2\n3 3");
                for(int i=4;i<=n;i++)
            {
                System.out.println(i+" "+i);
            }
            }
            
            
        }
    }
}