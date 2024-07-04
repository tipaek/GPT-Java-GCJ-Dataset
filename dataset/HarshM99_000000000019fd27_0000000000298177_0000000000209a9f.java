import java.util.*;
public class Solution
{
    public static String getAnswer(String str,int case_no)
    {
        String ans = "";
        for(int i=0;i<str.length();i++)
        {
            if(i==0)
            {
                for(int j=0;j < ((int)str.charAt(0) - (int)'0');j++)
                {
                    ans +="(";
                }
                ans += str.charAt(0);
            }
            else
            {
                if( ((int)str.charAt(i) - (int)'0') > ((int)str.charAt(i-1) - (int)'0') )
                {
                    for(int j=0;j < ((int)str.charAt(i) - (int)str.charAt(i-1)) ; j++)
                    {
                        ans += "(";
                    }
                    ans += str.charAt(i);
                }
                else if (((int)str.charAt(i) - (int)'0') < ((int)str.charAt(i-1) - (int)'0'))
                {
                    for(int j=0;j < ((int)str.charAt(i-1) - (int)str.charAt(i)) ; j++)
                    {
                        ans += ")";
                    }
                    ans += str.charAt(i);
                }
                else
                {
                    ans += str.charAt(i);
                }
            }
        }
        for(int j=0;j < ((int)str.charAt(str.length() - 1) - (int)'0');j++)
        {
            ans +=")";
        }
        return ("Case #"+case_no+": "+ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = t;String ans ="";
        while(t!=0)
        {
            String n = sc.next();
            ans += getAnswer(n,(x-t+1))+"\n";
            t--;
        } 
        System.out.print(ans);
    }
}