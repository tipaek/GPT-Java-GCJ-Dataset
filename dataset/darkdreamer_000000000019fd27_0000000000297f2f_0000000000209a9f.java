import java.util.*;
public class Solution{
    static String solve(String str)
    {
        if(str.length()==0)
        {
            return "";
        }
        
        int i=1;
        while(i<str.length()&&str.charAt(i)==str.charAt(i-1))
        {
            i++;
        }
        if(i==str.length())
        {
            if(str.charAt(0)=='0')
            {
                return str;
            }
            else
            {
                return "("+str+")";
            }
        }
        else
        {
            if(str.charAt(0)=='0')
            {
                return str.substring(0,i)+solve(str.substring(i));
            }
            else
            {
                return "("+str.substring(0,i)+")"+solve(str.substring(i));
            }
        }
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int k=1;
        while(k<=t)
        {
            String str=s.next();
            String ans="Case #"+k+": "+solve(str);
            System.out.println(ans);
            k++;
        }
    }
}