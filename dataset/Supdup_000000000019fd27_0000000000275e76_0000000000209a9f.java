import java.io.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T,l,i; String str,s; char ch;
        T=Integer.parseInt(in.readLine());
        for(int x=1;x<=T;x++)
        {
            str=in.readLine();
            s="";
            l=str.length();
            for(i=0;i<l;i++)
            {
                ch=str.charAt(i);
                if(ch=='1')
                {
                    s=s+"("+ ch; i++;
                    while(i<l && str.charAt(i)=='1')
                    {
                        s=s+str.charAt(i); i++;
                    }
                    s=s+")"; i--;
                }
                else
                    s=s+ch;
            }
            //Case #2: (1)0(1)
            System.out.println("Case #"+x+": "+s);
        }
        in.close();
    }
}