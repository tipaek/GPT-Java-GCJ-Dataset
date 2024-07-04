import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int b=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String s="";
            for(int j=0;j<10;j++)
            {
                System.out.println(j+1);
                System.out.flush();
                char c=sc.next().charAt(0);
                s+=c;
            }
            System.out.println(s);
            System.out.flush();
            char br=sc.next().charAt(0);
            if(br=='N' || br=='n')
                break;
        }
    }
}