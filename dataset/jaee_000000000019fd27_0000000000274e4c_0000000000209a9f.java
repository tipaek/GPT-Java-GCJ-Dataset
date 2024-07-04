import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<String>ans=new ArrayList<>();
        int T=in.nextInt();
        for(int t=0;t<T;t++)
        {
            String s=in.next();
            String a="";
            int count=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='0')
                {
                    a=a+'0';
                    count=0;
                }
                else
                {
                    count++;
                    if(count==1)
                    {
                        a=a+'(';
                    }
                    a=a+'1';
                    if((i+1<s.length() && s.charAt(i+1)=='0') || i==s.length()-1)
                        a=a+')';
                }
            }
            ans.add(a);
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #"+(i+1)+": "+ans.get(i));
    }
    
}
