import java.util.Scanner;
public class Solution 
{ 
    static int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
        for (int i = 0; i <= N - M; i++)
        { 
            int j; 
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
            if (j == M) 
                return i; 
        } 
        return -1; 
    }
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
            longestString = longestString.substring(1, longestString.length());
            int m = 0;
            for(int i=0;i<n;i++)
            {
                if(isSubstring(a[i].substring(1, a[i].length()), longestString)!=-1)
                {
                    m++;
                }
            }
            if(m==n)
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

