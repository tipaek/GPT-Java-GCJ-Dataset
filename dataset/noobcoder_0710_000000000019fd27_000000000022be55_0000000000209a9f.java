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
                temp.append('(');
                temp.append(s.charAt(0));
                for(int i=0;i<s.charAt(0)-'0';i++)
                temp.append(')');
            }
            else
            {
                int cntr=0;
                for(int i=0;i<s.length();i++)
                {
                    if(s.charAt(i)=='0')
                    {
                        if(cntr>0)
                        {
                            for(int j=0;j<cntr;j++)
                            {
                                temp.append(')');
                            }
                            cntr=0;
                        }
                        temp.append('0');
                        continue;
                    }
                    if(temp.length()==0||temp.charAt(temp.length()-1)=='0')
                    {
                        //if(temp.length()!=0
                        for(int j=0;j<s.charAt(i)-'0';j++)
                        {
                            temp.append('(');
                            cntr++;
                        }
                        temp.append(s.charAt(i));
                        continue;
                    }
                    if(temp.charAt(temp.length()-1)==s.charAt(i))
                    temp.append(s.charAt(i));
                    else if(temp.charAt(temp.length()-1)<s.charAt(i))
                    {
                        for(int j=0;j<s.charAt(i)-'0'-1;j++)
                        {
                            temp.append('(');
                            cntr++;
                        }
                        temp.append(s.charAt(i));
                    }
                    else
                    {
                        int ind=(temp.charAt(temp.length()-1)-'0')-(s.charAt(i)-'0');
                        for(int j=0;j<ind;j++)
                        {
                            temp.append(')');
                            cntr--;
                        }
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