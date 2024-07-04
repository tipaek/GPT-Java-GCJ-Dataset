import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt(); int tt=1;
        in.nextLine();
        while(t-->0)
        {
            String s=in.nextLine();String st="";
            int l=s.length();
            char m=s.charAt(0);
            if(m=='1')
            st+="(1";
            else
            st+="0";
            for(int i=1;i<l;i++)
            {
                char ch=s.charAt(i);
                char ch1=s.charAt(i-1);
                if(ch=='1' && ch1=='0')
                st=st+"("+ch;
                if(ch=='1' && ch1=='1')
                st=st+ch;
                if(ch=='0' && ch1=='1')
                st=st+")"+ch;
                if(ch=='0' && ch1=='0')
                st=st+ch;
                
            }
            m=s.charAt(l-1);
            if(m=='1')
            st+=")";
            System.out.println("Case #"+tt+": "+st);
            tt++;
        }
    }
}