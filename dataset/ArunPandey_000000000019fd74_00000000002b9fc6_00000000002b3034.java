import java.util.Scanner;
public class Solution 
{ 
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n = sc.nextInt();
            String a[] = new String[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.next();
            }
            int maxLength = 0;
            String longestString = null;
            for (String s : a) 
            {
                if (s.length() > maxLength) 
                {
                    maxLength = s.length();
                    longestString = s;
                }
            }
            boolean b = false;
            longestString = longestString.substring(1, longestString.length());
            for(int i=n-1;i>=0;i--)
            {
                int m = 0;
                int lo = longestString.length()-1;
                for(int j=a[i].length()-1;j>=1;j--)
                {
                    if(longestString.charAt(lo)!=a[i].charAt(j))
                    {
                        m = -1;
                        break;
                    }
                    lo--;
                }
                if(m==-1)
                {
                    b = true;
                }
            }
            if(!b)
            {
                System.out.println("Case #"+(k)+": "+longestString);
            }
            else
            {
                System.out.println("Case #"+(k)+": *");
            }
        } 
    }
}  

