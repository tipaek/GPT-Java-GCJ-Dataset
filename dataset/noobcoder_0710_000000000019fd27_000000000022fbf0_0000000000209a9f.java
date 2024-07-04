import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            String s=br.readLine();
            StringBuffer temp=new StringBuffer();
            if(s.length()==1)
            {
                for(int i=0;i<s.charAt(0)-'0';i++)
                {
                    temp.append('(');
                }
                temp.append(s.charAt(0));
                for(int i=0;i<s.charAt(0)-'0';i++)
                temp.append(')');
            }
            else
            {
                int cntr=0;
                for(int i=0;i<s.length();i++)
                {
                    if(temp.length()==0)
                    {
                        for(int j=0;j<s.charAt(0)-'0';j++)
                        {
                            temp.append('(');
                            cntr++;
                        }
                        temp.append(s.charAt(i));
                        continue;
                    }
                    else
                    {
                        if(s.charAt(i)-s.charAt(i-1)>0)
                        {
                            for(int j=0;j<s.charAt(i)-s.charAt(i-1);j++)
                            {
                                temp.append('(');
                                cntr++;
                            }
                            temp.append(s.charAt(i));
                        }
                        else if(s.charAt(i)-s.charAt(i-1)<0)
                        {
                            for(int j=0;j<s.charAt(i-1)-s.charAt(i);j++)
                            {
                                temp.append(')');
                                cntr--;
                            }
                            temp.append(s.charAt(i));
                        }
                        else
                        temp.append(s.charAt(i));
                    }
                }
                while(cntr>0)
                {
                    temp.append(')');
                    cntr--;
                }
            }
            pw.println("Case #"+(x+1)+": "+temp);
        }
        pw.flush();
        pw.close();
    }
}