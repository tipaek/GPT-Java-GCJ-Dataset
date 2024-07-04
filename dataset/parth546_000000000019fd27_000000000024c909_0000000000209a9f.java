import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args)
    {
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            eachCase(i);
        }
    }
    static void eachCase(int testCaseNumber)
    {
        String s=sc.next();
        String a="";
        int depth=0;
        for(int i=0;i<s.length();i++)
        {
            String add="";
            if(s.charAt(i)=='(')
                depth++;
            if(s.charAt(i)==')')
                depth--;
            add=""+s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                int digit=s.charAt(i)-'0';
                int diff=digit-depth;
                add = multiply("(",diff)+s.charAt(i)+multiply(")",diff);
            }
            a+=add;
        }
        System.out.println("Case #"+(testCaseNumber+1)+": "+purify(a));
    }
    static String multiply(String a,int n)
    {
        String ans="";
        for(int i=0;i<n;i++)
        {
            ans+=a;
        }
        return ans;
    }

    static String purify(String s)
    {
        int i;
        while((i=s.indexOf(")("))!=-1)
        {
            s=s.substring(0,i)+s.substring(i+2);
        }
        return s;
    }
}
