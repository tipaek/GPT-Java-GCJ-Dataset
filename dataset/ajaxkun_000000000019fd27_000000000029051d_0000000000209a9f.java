import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int x=1;x<=t;x++)
        {
            String S=scan.nextLine();
            String Str="";
            for(int i=0;i<S.length();i++)
            {
                char ch=S.charAt(i);
                if(ch=='1')
                    Str=Str+"(1)";
                else
                    Str=Str+ch;
            }
        System.out.println("Case #"+x+": "+Str);
        }
    }
}