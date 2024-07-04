import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int ii=0;ii<t;ii++)
        {
            int n=sc.nextInt();
            String[] arr=new String[n];
            
            int len=arr[0].length();
            String temp=arr[0];
            for(int i=0;i<n;i++)
            {
                if(arr[i].length()>len)
                {
                    temp=arr[i];
                    len=arr[i].length();
                }
            }
            System.out.println("Case #"+(ii+1)+": "+temp.substring(1));
        }
    }
}